package com.czx.collection.map.simulation;

public interface ZXMap<K,V> {

	V get(K k);
	
	V put(K k ,V v);
	
	interface Entry<K,V>{
		K getKey();
		V getValue();
	}
}
