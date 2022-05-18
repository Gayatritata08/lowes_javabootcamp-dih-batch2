package com.labs.loops;

public class switchDemo {

	public static void main(String[] args) {
		int number = 3;

		switch (number) {
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		case 3:
			System.out.println("Three");
			break;
		default:
			System.out.println("not on the list");
		}
		System.out.println("End of switch");
        int a = 1;
        while (a <= 5) {
            System.out.println(a);
            a++;
        }
       
        System.out.println("End of while");
        int i=0;
        do {
            System.out.println(i);
            i++;
        } while (i < 5);
 
        System.out.println("End of do while");
        for(i=1;i<10;i++){
            if(i==5){
                System.out.println("break");
                break;
            }
            System.out.println(i);
        }
           
        for( i=1;i<=10;i++){
            if(i==5){
                continue;
                // will skip to the rest statement
            }
            System.out.println(i);
        }

	}

}
