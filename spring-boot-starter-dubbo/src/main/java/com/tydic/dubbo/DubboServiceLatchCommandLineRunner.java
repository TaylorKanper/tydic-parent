package com.tydic.dubbo;

import org.springframework.boot.CommandLineRunner;

import java.util.concurrent.CountDownLatch;

public class DubboServiceLatchCommandLineRunner implements CommandLineRunner {


    public DubboServiceLatchCommandLineRunner() {}


    public void run(String... args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
    }


}