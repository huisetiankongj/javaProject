package com.czx.collection.map.jdk;

public class HashMapTest {
	public static void main(String[] args) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("czx", "123");
		System.out.println(map.toString());
	}
}
