package dev.be.goodgid.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class ThreadPoolConfig {

    /***
     * Spring ThreadPoolTaskExecutor에서 CorePoolSize과 MaxPoolSize 개념 알아보기
     * ref : https://goodgid.github.io/What-is-the-difference-between-Corepoolsize-and-Maxpoolsize-in-the-Spring-ThreadPoolTaskExecutor/
     */
    @Bean(name = "reconcileExecutor", destroyMethod = "shutdown")
    public ThreadPoolTaskExecutor reconcileExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(200);
        executor.setMaxPoolSize(200);
        return executor;
    }

}

