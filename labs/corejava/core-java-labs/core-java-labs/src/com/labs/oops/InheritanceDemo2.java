package com.labs.oops;

class Parent {

	public Parent(int i) {
		System.out.println("Defult parent Constructor"+i);
	}

}

class Child extends Parent{
	public Child(int i) {
		super(100);
		System.out.println("Defulat child Constructor" + i);
	}
}

public class InheritanceDemo2 {

	public static void main(String[] args) {
		Child c = new Child(30);

	}

}
