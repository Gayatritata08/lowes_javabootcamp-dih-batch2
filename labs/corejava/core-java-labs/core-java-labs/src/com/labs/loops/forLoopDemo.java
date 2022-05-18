package com.labs.loops;

public class forLoopDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int j =5;
		for(int i=0;i<10;i++) {
			System.out.println(j + "*" + (i+1) + "=" + (j*(i+1)));
		}
		
		for(int i=0; i<10;i++) {
			for(j=0;j<10;j++) {
				System.out.println(i + "*" + (j+1) +"="+ (i*(j+1)));
			}
		}
		
		//Triagle Pyramid
		for(int i=1; i<=10;i++) {
		
			for(j=1;j<i;j++) {
				System.out.print(j +" " );
			}
			System.out.println(" ");
		}
	
	
	}

}
