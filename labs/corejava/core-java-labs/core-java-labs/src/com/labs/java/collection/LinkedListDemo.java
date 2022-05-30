package com.labs.java.collection;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		
		LinkedList<String> countriesLinkedList = new LinkedList<>();
		countriesLinkedList.add("India");
		countriesLinkedList.add("China");
		countriesLinkedList.add("USA");
		countriesLinkedList.add("UK");
		countriesLinkedList.add("India");
		
		System.out.println("\nLinkedList Output..");
		
		for(String str:countriesLinkedList)
		System.out.println(str);
		
		countriesLinkedList.add("Japan");
		countriesLinkedList.add("Tokio");
		countriesLinkedList.add("Germany");
		countriesLinkedList.add("Srilanka");
		
		
		Iterator<String> itr = countriesLinkedList.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		
		

	}

}
