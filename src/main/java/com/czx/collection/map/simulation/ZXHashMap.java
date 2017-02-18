package com.czx.collection.map.simulation;

public class ZXHashMap<K, V> implements ZXMap<K, V> {

	
	private ZXHashEntry<K, V>[] table = null;
	
	private static final int DEFAULT_CAPACITY = 16;
	private static final float DEFAULT_LOADFACTOR = 0.75f;
	
	private int capacity;
	private float loadFactor;
	
	public ZXHashMap() {
		this(DEFAULT_CAPACITY,DEFAULT_LOADFACTOR);
	}

	public ZXHashMap(int capacity, float loadFactor) {
		this.capacity = capacity;
		this.loadFactor = loadFactor;
		
		table = new ZXHashEntry[capacity];
	}

	public V get(K k) {
		Entry<K, V> entry = getEntry(k);
		return entry.getValue();
		
	}

	public V put(K k, V v) {
		
		int hashcode = k.hashCode();
		int index = hashcode%(capacity-1);
		
		
		if(table[index]!=null){
			ZXHashEntry<K,V> newEntry = new ZXHashEntry<K,V>(k,v,table[index]);
			table[index] = newEntry;
		}else{
			ZXHashEntry<K,V> newEntry = new ZXHashEntry<K,V>(k,v,null);
			table[index] = newEntry;
		}
		return v;
	}
	public Entry<K, V> getEntry(K key) {
		int hashcode = key.hashCode();
		int index = hashcode%(capacity-1);
		for(ZXHashEntry<K,V> e = table[index];e!=null;e = (ZXHashEntry<K, V>) e.next){
			Object k;
			if((k = e.k) == key || (key != null && key.equals(k)))
			 return e;
		}
		return null;
	}

	class ZXHashEntry<K, V> implements Entry<K, V>{
		K k;
		V v;
		Entry<K, V> next;
		
		public ZXHashEntry(K k, V v,
				com.czx.collection.map.simulation.ZXMap.Entry<K, V> next) {
			this.k = k;
			this.v = v;
			this.next = next;
		}

		public K getKey() {
			return this.k;
		}

		public V getValue() {
			return this.v;
		}
	}
}
