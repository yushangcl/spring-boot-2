package com.whh.spring.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import static java.lang.Thread.sleep;

/**
 * WebAsyncTask 异步任务
 * @author huahui.wu
 * @date 2018/6/25 09:54
 * @description
 */
@RestController
public class WebAsyncController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebAsyncController.class);

    private final static String ERROR_MESSAGE = "Task error";
    private final static String TIME_MESSAGE = "Task timeout";


    @GetMapping("/completion")
    public WebAsyncTask<String> asyncTaskCompletion() {
        // 打印处理线程名
        LOGGER.debug(String.format("请求处理线程：%s", Thread.currentThread().getName()));

        // 模拟开启一个异步任务，超时时间为10s
        WebAsyncTask<String> asyncTask = new WebAsyncTask<>(10 * 1000L, () -> {
            LOGGER.debug(String.format("异步工作线程：%s", Thread.currentThread().getName()));
            // 任务处理时间5s，不超时
            sleep(5 * 1000L);
            return ERROR_MESSAGE;
        });

        // 任务执行完成时调用该方法，无论执行发生异常或者超时，该方法都会执行
        asyncTask.onCompletion(() -> LOGGER.debug("任务执行完成"));

        //异步执行，所以刚开始执行一个异步任务的时候，该方法会继续执行
        LOGGER.debug("继续处理其他事情");
        return asyncTask;
    }

    @GetMapping("/exception")
    public WebAsyncTask<String> asyncTaskCompletionException() {
        // 打印处理线程名
        LOGGER.debug(String.format("请求处理线程：%s", Thread.currentThread().getName()));

        // 模拟开启一个异步任务，超时时间为10s
        WebAsyncTask<String> asyncTask = new WebAsyncTask<>(10 * 1000L, () -> {
            LOGGER.debug(String.format("异步工作线程：%s", Thread.currentThread().getName()));
            // 任务处理时间5s，不超时
            sleep(5 * 1000L);
            throw new Exception(ERROR_MESSAGE);
        });

        // 任务执行完成时调用该方法，无论执行发生异常或者超时，该方法都会执行
        asyncTask.onCompletion(() -> LOGGER.debug("任务执行完成"));
        asyncTask.onError(() -> {
            LOGGER.debug("任务执行异常");
            return ERROR_MESSAGE;
        });

        //异步执行，所以刚开始执行一个异步任务的时候，该方法会继续执行
        LOGGER.debug("继续处理其他事情");
        return asyncTask;
    }


    @GetMapping("/timeout")
    public WebAsyncTask<String> asyncTaskCompletionTimeOut() {
        // 打印处理线程名
        LOGGER.debug(String.format("请求处理线程：%s", Thread.currentThread().getName()));

        // 模拟开启一个异步任务，超时时间为10s
        WebAsyncTask<String> asyncTask = new WebAsyncTask<>(10 * 1000L, () -> {
            LOGGER.debug(String.format("异步工作线程：%s", Thread.currentThread().getName()));
            // 任务处理时间15s
            // java.lang.InterruptedException: sleep interrupted  主线程强行打断子线程的sleep,因此抛出异常
            Thread.sleep(15 * 1000L);
            return ERROR_MESSAGE;
        });

        // 任务执行完成时调用该方法，无论执行发生异常或者超时，该方法都会执行
        asyncTask.onCompletion(() -> LOGGER.debug("任务执行完成"));
        asyncTask.onTimeout(() -> {
            LOGGER.debug("任务执行超时");
            return TIME_MESSAGE;
        });

        //异步执行，所以刚开始执行一个异步任务的时候，该方法会继续执行
        LOGGER.debug("继续处理其他事情");
        return asyncTask;
    }

}
