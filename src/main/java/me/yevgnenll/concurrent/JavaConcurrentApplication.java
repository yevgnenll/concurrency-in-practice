package me.yevgnenll.concurrent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import me.yevgnenll.concurrent.threadpool.TimingThreadPool;

@SpringBootApplication
public class JavaConcurrentApplication {

    public static void main(String[] args) {
        TimingThreadPool timingThreadPool = new TimingThreadPool();
        timingThreadPool.execute(() -> {



        });
        SpringApplication.run(JavaConcurrentApplication.class, args);
    }

}
