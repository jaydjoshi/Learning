package com.learning.dataStructure.tree;

import java.util.LinkedList;

/**
 * 
 * @author jdhirendrajoshi
 *  			1
 *  		2		3
 *  	4      5  6		7
 *  7		8		9		10
 *  
 *  
 *  prints -> 1 2 3 6 5 4 7 8 9 10
 */
public class BinaryTree {
	
	public static void main(String args[]){
		
		
		Node seven = new Node(null, 7, null);
		Node four = new Node(null, 4, null);
		Node five = new Node(null, 5, null);
		Node six = new Node(null, 6, null);
		
		Node three = new Node(six, 3, seven);
		Node two = new Node(four, 2, five);
		
		Node one = new Node(two, 1, three);
		
		
		LinkedList<Node> queue = new LinkedList<>();
		
		queue.add(one);
		int counter=1;
		Node node = null;
		while(!queue.isEmpty()){
			
			if( counter % 2 == 0){
				node = queue.poll();
				if(node != null){
					System.out.println(node.data);
					if(node.left!=null && node.right != null){
						queue.add(node.left);
						queue.add(node.right);
					}
				}
			}
			else if(counter % 2 != 0){
				//node = queue.poll();
				node=queue.removeLast();
				if(node != null){
					System.out.println(node.data);
					if(node.left!=null && node.right != null){
						queue.add(node.left);
						queue.add(node.right);
					}
				}
			}
			counter++;
		}
	}
}

class Node{
	Node left;
	Node right;
	int data;
	
	public Node(Node left, int data, Node right) {
		this.data=data;
		this.left=left;
		this.right=right;
	}
}
