package com.learning.dataStructure.map;

public interface DuplicateMap<K,V> {
	
	void put(K key, V value);
	V get(K key);
	void remove(K key);
	boolean contains(K key);
	boolean isEmpty();
	int hash(K k);
	
}

