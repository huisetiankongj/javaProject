package com.czx.collection.map.self;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class AbstractMap<K,V> implements Map<K,V>{
	
	public AbstractMap(){}

	public int size() {
		return entrySet().size();
	}

	public boolean isEmpty() {
		return size()==0;
	}

	public boolean containsKey(Object key) {
		Iterator<Map.Entry<K, V>> iterator = entrySet().iterator();
		if(key==null){
			while(iterator.hasNext()){
				Map.Entry<K,V> entry = iterator.next();
				if(entry.getKey()==null)
					return true;
			}
		}else{
			while(iterator.hasNext()){
				Map.Entry<K,V> entry = iterator.next();
				if(key.equals(entry.getKey()))
					return true;
			}
		}
			
		return false;
	}

	public boolean containsValue(Object value) {
		Iterator<Map.Entry<K, V>> iterator = entrySet().iterator();
		if(value==null){
			while(iterator.hasNext()){
				Map.Entry<K,V> entry = iterator.next();
				if(entry.getValue()==null)
					return true;
			}
		}else{
			while(iterator.hasNext()){
				Map.Entry<K,V> entry = iterator.next();
				if(value.equals(entry.getValue()))
					return true;
			}
		}
			
		return false;
	}

	public V get(Object key) {
		Iterator<Map.Entry<K, V>> iterator = entrySet().iterator();
		if(key==null){
			while(iterator.hasNext()){
				Map.Entry<K,V> entry = iterator.next();
				if(entry.getKey()==null)
					return entry.getValue();
			}
		}else{
			while(iterator.hasNext()){
				Map.Entry<K,V> entry = iterator.next();
				if(key.equals(entry.getValue()))
					return entry.getValue();
			}
		}
			
		return null;
	}

	public V put(K key, V value) {
		throw new RuntimeException("unSupport operation .");
	}

	public V remove(Object key) {
		Entry<K,V> correctEntry = null;
		Iterator<Map.Entry<K, V>> i = entrySet().iterator();
		if(key==null){
			while(i.hasNext()){
				Map.Entry<K,V> entry = i.next();
				if(entry.getKey()==null)
					correctEntry = entry;
			}
		}else{
			while(i.hasNext()){
				Map.Entry<K,V> entry = i.next();
				if(key.equals(entry.getValue()))
					correctEntry = entry;
			}
		}
		
		V oldValue = null;
		
		if(correctEntry!=null){
			 oldValue = correctEntry.getValue();
			 i.remove();
		}
		return oldValue;
	}

	public void putAll(Map<? extends K, ? extends V> m) {
		for(Map.Entry<? extends K, ? extends V> e : m.entrySet())
			put(e.getKey(), e.getValue());
	}

	public void clear() {
		entrySet().clear();
	}

	
	transient volatile Set<K> set = null;
	transient volatile Collections values = null;
	
	public Set<K> keySet() {
		return null;
	}

	public Collection<V> values() {
		return null;
	}

	public Set<com.czx.collection.map.self.Map.Entry<K, V>> entrySet() {
		return null;
	}

}
