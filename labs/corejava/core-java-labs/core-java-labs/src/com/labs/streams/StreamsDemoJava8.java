package com.labs.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class StreamsDemoJava8 {

	public static void main(String[] args) {
		Stream<String> streamEmpty = Stream.empty();

	
		Collection<String> collection = Arrays.asList("a", "b", "c");
		Stream<String> streamOfCollection = collection.stream();
		
		System.out.println(""+streamOfCollection.findFirst());
	}

}
