package com.labs.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDemo {

	public static void main(String args[]) throws InterruptedException, ExecutionException {
		System.out.println("Hello Thread");

		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getPriority());
		System.out.println(Thread.currentThread().getState().name());

		System.out.println(Thread.currentThread().isDaemon());

		ThreadDemoCallable tdc = new ThreadDemoCallable();

		ExecutorService exs = Executors.newFixedThreadPool(5);
		ExecutorService exs1 = Executors.newCachedThreadPool();
		ExecutorService exs2 = Executors.newSingleThreadExecutor();
		ExecutorService exs3 = Executors.newCachedThreadPool();

		// 1 st approach
		Future<String> fts = exs.submit(tdc);
		System.out.println("fts responce");
		System.out.println(fts.get());
//		while(fts.isDone()) {
//			String response = fts.get();
//			System.out.println(response);
//		}

		// approach 2
		Future<String> fts1 = exs.submit(new ThreadDemoCallable());
		System.out.println("fts1 responce");
		System.out.println(fts1.get());
		
		
		Future<String> fts2 = exs.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				for(int i=0;i<30;i++) {
					System.out.println(Thread.currentThread().getName() + i);
				}
				return "Thread Excution Statement;";
			}
		});
		System.out.println("fts2 responce");
		System.out.println(fts2.get());
		
//	@Override
//		public String call()  {
//			for(int i=0;i<30;i++) {
//				System.out.println(Thread.currentThread().getName() + i);
//			}
//			return "Thread Excution Statement;";
//		}
//	}
           
	}
}
