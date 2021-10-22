// TODO Resolve about async
//package com.nekose.sampleproject.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.lang.reflect.Method;
//import java.util.concurrent.Executor;
//
//@Slf4j
//@Configuration
//@EnableAsync
//public class AsyncConfig implements AsyncConfigurer {
//    private AsyncExceptionHandler asyncExceptionHandler = new AsyncExceptionHandler();
//
//    @Bean(name = "asyncExecutor")
//    @Override
//    public Executor getAsyncExecutor() {
//        var executor = new ThreadPoolTaskExecutor();
//        executor.setMaxPoolSize(10);
//        executor.setThreadNamePrefix("asyncExecutor-");
//        executor.setWaitForTasksToCompleteOnShutdown(true);
//        executor.initialize();
//        return executor;
//    }
//
//    public static class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
//        @Override
//        public void handleUncaughtException(Throwable ex, Method method, Object... params) {
//            log.error("asynchronous exception : {} : {}", method.getDeclaringClass().getSimpleName(), method.getName(), ex);
//        }
//
//    }
//}
