package com.tydic.start;

import java.util.concurrent.CountDownLatch;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		final ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-base.xml");
		ac.start();
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				ac.close();
			}
		});
		CountDownLatch countDownLatch = new CountDownLatch(1);
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
