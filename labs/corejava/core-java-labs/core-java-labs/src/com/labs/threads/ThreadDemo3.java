package com.labs.threads;

public class ThreadDemo3 {

	public static void main(String[] args) {

		imlementsRunnableEx ex = new imlementsRunnableEx();
         
		//ex.run() It will not create sperate therad using this .so need to pass instace in thread.
		
		//1 st approach
        
		Thread t1 = new Thread(ex);
		t1.setName("Thread - 1");
		t1.start();
		
		//2 nd approach
		Thread t2 =new Thread(new imlementsRunnableEx());
		t2.setName("Thread - 2");
		t2.start();

		
		Thread t3 =new Thread(new imlementsRunnableEx());
		t3.setName("Thread - 3");
		t3.start();
		
		
		//3 rd approach
		Thread t4 =new Thread(new Runnable() {
			
			@Override
			public void run() {
		
				System.out.println("We are in run method");
				System.out.println(Thread.currentThread().getName());
				for(int i=0;i<30;i++) {
					System.out.println(Thread.currentThread().getName()+ "- " +i);
					
				}
			}
		});
		
		t4.setName("Thread - 4" );

		t4.start();
	}
	
	

}
