package com.learning.dataStructure.linkedList;

public class DuplicateLinkedList<E> {
	
	private Node<E> first = null;
	private Node<E> last = null;
	private int size = 0;
	
	
	private static class Node<E>{
		E data ;
		Node<E> next;
		Node<E> previous;
		
		public Node(E data, Node<E> next , Node<E> previous ) {
			this.data= data;
			this.next= next;
			this.previous= previous;
		}
	}
	
	public void add(E data){
		if(first == null){
			Node<E> first = new Node<>(data,null,null);
			this.first=first;
			this.last=first;
			size++;
		}
		else{
			Node<E> node = this.last;
			node.next = new Node<>(data,null,node);
			this.last= node.next;
			size++;
		}
	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}
	
	public E get(int i){
		if(i>size){
			throw new IllegalStateException();
		}
		else{
			int count = 0;
			Node<E> node = first;
			while(count <= size){
				if(count == i){
					return node.data;
				}
				else{
					node= node.next;
					count++;
				}
			}
		}
		return null;
	}

	public boolean remove(E Data) {
		
		if(Data == null){
			throw new NullPointerException();
		}
		Node<E> node = first;
		
		if(first != null && first.data.equals(Data)){
			first=first.next;
			size--;
			return true;
		}
		
		while(node.next != null && !node.next.data.equals(Data)){
			node= node.next;
		}
		if(node.next != null && Data.equals(node.next.data)){
			node.next = node.next.next;
			size--;
			return true;
		}
		return false;
		
	}
}
