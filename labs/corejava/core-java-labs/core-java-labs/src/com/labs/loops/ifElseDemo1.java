package com.labs.loops;
public class ifElseDemo1 {

	public static void main(String[] args) {
		
		int score =76;
		
		if(score > 90)
			System.out.println("Grade is A");
		else if(score < 90 && score > 80)
			System.out.println("Grade is B");
		else if(score  < 80 && score > 75)
			System.out.println("Grade is C");
		else if(score  < 70 && score > 45)
			System.out.println("Grade is D");
		else 
			System.out.println("Grade is E");

	}

}
