package com.labs.java8;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FunctionalInterfaceDemo {

	public static void main(String[] args) {

		// Take argument with out return
		Consumer<String> consumer = message -> System.out.println(message);
		consumer.accept("Hello Consumer");

		// BiConsumer take argument but no return

		BiConsumer<String, String> biconsumer = (msg1, msg2) -> System.out.println(msg1 + " " + msg2);
		biconsumer.accept("Consumer", "Lamda ");

//		// supplier
//		Suplier<List> suuplier = () -> Arrays.asList("Spring","Hibernate","Java8");
//		Supplier.

		// Functional

		// Predicate -> take arguments and return value
		Predicate<Integer> pred = (age) -> age > 20;
		System.out.println(pred.test(30));

	}

}
