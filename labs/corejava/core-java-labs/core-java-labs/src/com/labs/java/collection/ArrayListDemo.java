package com.labs.java.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class ArrayListDemo {

	public static void main(String[] args) {
		// for arrays
		int[] a = { 1, 2, 3 };

		for (int num : a)
			System.out.println(num);

		// for arraylist

		ArrayList<Integer> arrList = new ArrayList<Integer>();
		arrList.add(100);
		arrList.add(200);
		arrList.add(300);
		arrList.add(500);

		arrList.add(600);

		// remove element
		arrList.remove(0);
		/*
		 * for(Object arrobj:arrList) System.out.println(arrobj);
		 */

		// update element

		arrList.set(2, 50);

		for (Object arrobj : arrList)
			System.out.println(arrobj);

		// arrList.remove(arrList);

		ArrayList<Integer> arrList1 = new ArrayList<Integer>();

		// another way
		List<Integer> arrList2 = new ArrayList<Integer>();

		// Vector is therad safe and sychronized
		// arraylist is not synchronised and not thread safe

		// another way

		List<Integer> arrList3 = new Vector<Integer>();
		arrList.add(100);
		arrList.add(200);
		arrList.add(300);
		arrList.add(500);

		arrList.add(600);

		// remove element
		arrList.remove(0);
		/*
		 * for(Object arrobj:arrList) System.out.println(arrobj);
		 */

		// update element

		arrList.set(2, 50);
		arrList.get(50);

		// Using generics we can give the specific type
		for (Integer arrobj : arrList)
			System.out.println(arrobj);

		// arrList.remove(arrList);

		// Iterator
		System.out.println("// Iterator-----------");
		Iterator itr = arrList.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());

		System.out.println("// List Iterator-----------");
		ListIterator<Integer> listItr = arrList.listIterator();
		while (itr.hasNext())
			System.out.println(listItr.next());
		System.out.println(listItr.next());
		System.out.println(listItr.next());

		System.out.println("// List Iterator previous -----------");
		listItr.hasPrevious();
		System.out.println(listItr.next());

	}

}
