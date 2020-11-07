package dev.be.goodgid.service;


import static dev.be.goodgid.common.Constants.SUCCESS_CODE;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import dev.be.goodgid.entity.RequestDto;
import dev.be.goodgid.entity.ResponseDto;
import dev.be.goodgid.entity.SimpleResult;
import dev.be.goodgid.service.common.AbstractFutureProcessService;
import dev.be.goodgid.service.common.RequestCommand;
import dev.be.goodgid.util.ReturnCodeUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReconcileService
        extends AbstractFutureProcessService<RequestDto, ResponseDto<?>> {

    private final ThreadPoolTaskExecutor reconcileExecutor;

    public void reconcile(List<RequestDto> requestDtoList, int maxPoolSize) {
        xxxProcess(requestDtoList, maxPoolSize);
    }

    private void xxxProcess(List<RequestDto> requestDtoList, int maxPoolSize) {

        SimpleResult result = process(new RequestCommand<>() {

            @Override
            public ResponseDto<?> process(RequestDto requestDto) {
                ResponseDto<?> response = ResponseDto.builder()
                                                     .returnCode(SUCCESS_CODE)
                                                     .build();
                try {
                    // To do Something
                    // ex) request API
                } catch (Exception e) {
                    log.error("Unknown error.", e);
                }
                return response;
            }

            @Override
            public boolean isSuccess(Object result) {
                boolean isSuccess = false;
                if (result != null) {
                    ResponseDto<?> response = (ResponseDto<?>) result;
                    if (StringUtils.equals(response.getReturnCode(), ReturnCodeUtils.getSuccessCode())) {
                        isSuccess = true;
                    }
                }
                return isSuccess;
            }
        }, reconcileExecutor, requestDtoList, maxPoolSize);

        System.out.println("====================");
        System.out.println(result);
        System.out.println("====================");
    }
}

