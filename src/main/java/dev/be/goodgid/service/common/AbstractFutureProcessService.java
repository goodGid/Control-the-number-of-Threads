package dev.be.goodgid.service.common;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import dev.be.goodgid.entity.SimpleResult;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractFutureProcessService<T, R> {

    protected SimpleResult process(final RequestCommand<T, R> command,
                                   ThreadPoolTaskExecutor taskExecutor,
                                   List<T> items,
                                   int maxPoolSize) {

        int transactionSize = items.size();
        SimpleResult result = new SimpleResult(transactionSize);
        if (transactionSize <= 0) {
            return result;
        }

        final List<T> requests = Collections.synchronizedList(items);

        int index = 0;
        while (index < transactionSize) {
            Collection<Future<R>> futures = new LinkedList<>();
            int currentProcessCnt = 0;
            while (currentProcessCnt < maxPoolSize) {
                if (index >= transactionSize) {
                    break;
                }

                final T request = requests.get(index++);

                futures.add(taskExecutor.submit(() -> command.process(request)));
                currentProcessCnt++;
            }

            // Check result
            for (Future<R> future : futures) {
                try {
                    if (command.isSuccess(future.get())) {
                        result.getSuccessCnt().incrementAndGet();
                    } else {
                        result.getExceptionCnt().incrementAndGet();
                    }
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                    throw new RuntimeException(e);
                }
            }
        }
        return result;
    }
}
