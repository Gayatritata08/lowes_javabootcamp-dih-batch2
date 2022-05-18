package com.labs.loops;



class Book1 {
public String title;
public String author;
public int price;


public Book1(String title, String author, int price) {
	
	this.title = title;
	this.author = author;
	this.price = price;
	
}


public void printBookInfo() {
	System.out.println("Title : " + title 
			+ " author  " + author
			+ " price "  +price
			);
}
}

public class Demo6 {
	
	public static void main(String[] args) {
		Book1 bookObj1 = new Book1("Title 1", "Author 1", 100);
		bookObj1.printBookInfo();
		
		Book1 bookObj2 = new Book1("Title 2", "Author 2", 200);
		bookObj2.printBookInfo();
	}

}
