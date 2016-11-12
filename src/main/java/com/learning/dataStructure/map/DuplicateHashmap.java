package com.learning.dataStructure.map;

import java.util.Map;
import java.util.Objects;

public class DuplicateHashmap<K,V> implements DuplicateMap<K,V>{
	
	private Node<K,V>[] table;
	int[] arr = new int[10];
	private static final int DEFAULT_CAPACITY = 16;
	private int size;
	private int modSize;
	
	@SuppressWarnings("unchecked")
	public DuplicateHashmap() {
		size=DEFAULT_CAPACITY;
		modSize=0;
		table = new Node[size];
	}

	@Override
	public void put(K key, V value) {
		ensureCapacity();
		int i,n = table.length;
		int hash = hash(key);
		Node<K,V> node = table[i = (n - 1) & hash];
		Node<K,V> newNode = null;
		if(node==null){
			newNode = new Node<K, V>(key, value, hash, null);
			modSize++;
		}
		else{
			newNode=node;
			while(node.next!=null){
				//update
				if(key.equals(node.key) && hash == node.hash){
					node.value = value;
					return;
				}
				else{
					node=node.next;
				}
			}
			//insert
			if(node.next== null){
				node.next=new Node<K, V>(key, value, hash, null);
				modSize++;
			}
		}
		table[i]=newNode;
	}
	
	private void ensureCapacity() {
		
		
	}

	@Override
	public V get(K key) {
		int hash = hash(key);
		int i,n = table.length;
		Node<K,V> node = table[i = (n - 1) & hash];
		if(node!=null){
		Node<K,V> newNode = node;
		if(newNode.next==null){
			if(key.equals(newNode.key) && hash == hash(key)){
				return newNode.value;
			}
		}
		else{
			while(newNode.next!=null) {
				if(key.equals(newNode.key) && hash == hash(key)){
					return newNode.value;
				}
				
			}
		}
		}
		
		return null;
	}

	@Override
	public void remove(K key) {
		
		int hash = hash(key);
		int i,n = table.length;
		Node<K,V> node = table[i = (n - 1) & hash];
		Node<K,V> newNode = node;
		Node<K,V> previousNode = null;
		if(newNode.next==null){
			if(key.equals(newNode.key) && hash == hash(key)){
				table[i]=null;
				return;
			}
		}
		else{
			//first node
			if(newNode.key == key && hash == hash(newNode.hash)){
				table[i]=newNode.next;
			}
			//rest all
			while(newNode.next!=null) {
				if(key.equals(newNode.next.key) && hash == hash(newNode.next.hash)){
					newNode.next= newNode.next.next;
					break ;
				}
				newNode= newNode.next;
			}
		}
	}

	@Override
	public boolean contains(K key) {
		int hash = hash(key);
		int i,n = table.length;
		Node<K,V> node = table[i = (n - 1) & hash];
		Node<K,V> newNode = node;
		if(newNode.next==null){
			if(key.equals(newNode.key) && hash == hash(key)){
				return true;
			}
		}
		else{
			while(newNode.next!=null) {
				if(key.equals(newNode.key) && hash == hash(key)){
					return true;
				}
				
			}
		}
		
		return false;
	}

	@Override
	public boolean isEmpty() {
		return modSize==0?true:false;
	}

	
	
	
	static class Node<K,V>{
		K key;
		V value;
		int hash;
		Node<K,V> next;
		
		public Node() {
			// TODO Auto-generated constructor stub
		}
		
		public Node(K key , V value , int hash , Node<K,V> next) {
			this.hash=hash;
			this.key=key;
			this.value=value;
			this.next=next;
		}
		
		public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                    Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
	}
	
	 public final int hash(Object key) {
	        int h;
	        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}
	
}
