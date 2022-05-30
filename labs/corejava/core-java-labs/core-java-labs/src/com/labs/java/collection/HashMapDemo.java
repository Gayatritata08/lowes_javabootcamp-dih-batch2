package com.labs.java.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("F", "Banana");
		map.put("F1", "Manago");
		map.put("F2", "Apple");
		map.put("F3", "PineApple");
		map.put("F4", "Avacado");

		// Set entrySet = map.entrySet();

		for (Map.Entry<String, String> m : map.entrySet()) {
			System.out.println(m.getKey()+ " " +m.getValue());

		}

	}

}
