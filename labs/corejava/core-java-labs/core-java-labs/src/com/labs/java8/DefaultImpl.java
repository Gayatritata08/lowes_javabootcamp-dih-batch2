package com.labs.java8;

public class DefaultImpl implements DefaultDemo {

	public static void main(String[] args) {
		
		DefaultDemo.staticPrint();
		
		 DefaultImpl dliObj1 = new  DefaultImpl();
		 dliObj1.defaultPrint();
		 
		 DefaultImpl dliObj2 = new  DefaultImpl();
		 dliObj2.defaultPrint();
		
		 System.out.println(DefaultDemo.message);
			
			//not allowed
			//DefaultDemo.message="Hello";

	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

}
