package com.labs.threads;

class ThreadDemo1 extends Thread {

	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("We are in run menthod");
		
		for(int i=0;i<50;i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}

}

public class ExtendTread {

	public static void main(String[] args) throws InterruptedException {

		System.out.println(Thread.currentThread().getName());
		ThreadDemo1 td = new ThreadDemo1();
		td.start();//Runnable
		td.setName("Thread - 1");		
		td.join(100000);
		td.sleep(300);
		
		ThreadDemo1 td2 = new ThreadDemo1();
		td2.start();	
		td2.setName("Thread - 2");
		td2.setPriority(1);
		td2.join(100000);
		td2.sleep(30);
	
		ThreadDemo1 td3 = new ThreadDemo1();
		td3.start();		
		//td3.setName("Thread - 3");
		td3.setPriority(5);
		td3.setName("Thread - 3");
		td2.join(100000);
		td2.sleep(300000);
	}

}
