package com.zzc;

import java.util.concurrent.CountDownLatch;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 * 
 */
public class ProviderApp {
	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(1);
		
		//加载配置文件
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{"provider.xml"});
		//启动容器
		appContext.start();
		
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
