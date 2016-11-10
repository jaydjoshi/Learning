package com.learning.dataStructure.hashMap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImpl<K,V> implements HashMapInterface<K,V>,Serializable,Cloneable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -650081872794205995L;
	private final int DEFAULT_SIZE=16;
	private int size=0;
	//private HashMapImpl<K, V> map = null;
	EntryImpl[] map = null;
	
	
	public HashMapImpl() {
		// TODO Auto-generated constructor stub
		size=DEFAULT_SIZE;
		map = new EntryImpl[this.size];
	}
	
	public HashMapImpl(int size) {
		// TODO Auto-generated constructor stub
		this.size = size;
		map = new EntryImpl[this.size];
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		
		EntryImpl<K, V> entry = new EntryImpl<>(key,value,null,0);
		/*entry.hash= 0;
		entry.key= key;
		entry.value=value;
		entry.next=null;*/
		
		if(map[entry.hash] != null){
			EntryImpl<K, V> list = new EntryImpl<K, V>(key,value,null,0);
			list = map[entry.hash];
			if(list.next==null)
				list.next=entry;
			else{
				while(list.next != null){
					list = list.next;
				}
				list.next=entry;
			}
			
		}
		else{
			entry.next=null;
			map[entry.hash]=entry;
			//map[];
		}
		
		return value;
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty(HashMapImpl hashmap) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsKey(K key) {
		// TODO Auto-generated method stub
		return false;
	}
	
	static class EntryImpl<K,V>{
		private K key;
		private V value;
		private EntryImpl<K,V> next; 
		private int hash;
		
		public EntryImpl(K key,V value,EntryImpl<K,V> next,int hash) {
			// TODO Auto-generated constructor stub
			this.key= key;
			this.value=value;
			this.next=next;
			this.hash= hash;
		}

		/**
		 * @return the key
		 */
		public Object getKey() {
			return key;
		}

		/**
		 * @param key the key to set
		 */
		public void setKey(K key) {
			this.key = key;
		}

		/**
		 * @return the value
		 */
		public Object getValue() {
			return value;
		}

		/**
		 * @param value the value to set
		 */
		public void setValue(V value) {
			this.value = value;
		}

		/**
		 * @return the next
		 */
		public EntryImpl getNext() {
			return next;
		}

		/**
		 * @param next the next to set
		 */
		public void setNext(EntryImpl next) {
			this.next = next;
		}

		/**
		 * @return the hash
		 */
		public int getHash() {
			return hash;
		}

		/**
		 * @param hash the hash to set
		 */
		public void setHash(int hash) {
			this.hash = hash;
		}
		
		
		
	}
	
	

}


interface HashMapInterface<K,V>{
	public V put(K key, V value);
	public V get(K key);
	public boolean isEmpty(HashMapImpl<K,V> hashmap);
	public boolean containsKey(K key);
}

