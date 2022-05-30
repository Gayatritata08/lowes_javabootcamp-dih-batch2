package com.labs.threads;

public class imlementsRunnableEx implements Runnable{

	@Override
	public void run() {
		
		System.out.println("We are in run method");
		System.out.println(Thread.currentThread().getName());
		for(int i=0;i<30;i++) {
			System.out.println(Thread.currentThread().getName()+ "- " +i);
			
		}
		
	}

}
