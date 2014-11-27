package com.zzc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzc.service.HelloService;

/**
 * Hello world!
 * 
 */
public class ClientApp {
	public static void main(String[] args) {
		//启动spring容器
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{"client.xml"});
		appContext.start();
		
		
		Thread t1 = new Thread(new TestClient(appContext));
//		Thread t2 = new Thread(new TestClient(appContext));
		t1.start();
//		t2.start();
		
		//关闭spring容器
		appContext.stop();
	}
}

class TestClient implements Runnable{
	private ClassPathXmlApplicationContext appContext;
	
	public TestClient(ClassPathXmlApplicationContext appContext){
		this.appContext = appContext;
	}
	
	@Override
	public void run() {
		int i = 0;
		while(true){
			//调用
			HelloService helloService = (HelloService)appContext.getBean("helloService");
			String ret = helloService.sayHello("郑大超"+i);
			System.out.println(ret);
			try {
				Thread.sleep(1000*5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
	}
	
}