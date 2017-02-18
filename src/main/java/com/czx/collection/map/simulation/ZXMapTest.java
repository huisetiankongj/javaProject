package com.czx.collection.map.simulation;

public class ZXMapTest {

	public static void main(String[] args) {
		ZXMap<String, Object> map = new ZXHashMap<String, Object>();
		map.put("a", "gggg");
		map.put("q", "sssss");
		map.put("czx", "woefjwo");
		for(int i=0;i<20;i++){
			map.put("a"+i, "k"+i);
		}
		System.out.println(map.get("a"));
		System.out.println(map.get("q"));
		System.out.println(map.get("czx"));
		for(int i=0;i<20;i++){
			System.out.println(map.get("a"+i));
		}
	}
}
