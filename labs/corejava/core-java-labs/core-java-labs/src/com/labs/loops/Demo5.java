package com.labs.loops;


class Book{
	
	public String title;
	public String author;
	public int price;
	
	
	public void printBookInfo() {
		System.out.println("Title : " + title 
				+ " author  " + author
				+ " price "  +price
				);
	}
}

public class Demo5 {

	
public static void main(String args[]){
	
	Book bookObj = new Book();
	bookObj.title = "Java 2 Edditions";
	bookObj.author="Mark Smith";
	bookObj.price=1000;
	bookObj.printBookInfo();
	
	Book bookObj1 = new Book();
	bookObj1.title = "Java 2 Edditions -2 ";
	bookObj1.author="Mark Smith - 1";
	bookObj1.price=2000;
	bookObj1.printBookInfo();
	
	
	
}

}
