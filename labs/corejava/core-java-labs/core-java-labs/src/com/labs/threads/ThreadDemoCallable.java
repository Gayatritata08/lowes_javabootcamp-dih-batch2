package com.labs.threads;

import java.util.concurrent.Callable;

public class ThreadDemoCallable implements Callable {

	@Override
	public Object call() throws Exception {
		for(int i=0;i<30;i++) {
			System.out.println(Thread.currentThread().getName() + i);
		}
		return "Thread Excution Statement;";
	}

}
	