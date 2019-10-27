package com.tempera.util;

import java.util.Random;

public class WeightedList<T> {
	
	private class Node {
		 public T element;
		 public int weight;
		 public Node child;
		 
		 public Node(T element, int weight) {
			 this.element = element;
			 this.weight = weight;
			 this.child = null;
		 }
	}
	
	private final Node root = new Node(null, 0);
	private Node top = root;
	private Random rand = new Random();
	
	protected int totalWeight = 0;
	protected int elements = 0;
	
	public void put(T element, int weight) {
		totalWeight += weight;
		elements++;
		Node node = new Node(element, weight);
		top.child = node;
		top = node;
	}
	
	public T getElement() {
		int value = rand.nextInt(totalWeight) + 1;
		Node temp = root;
		
		while(temp.child != null) {
			temp = temp.child;
			value -= temp.weight;
			if(value <= 0)
				return temp.element;
		}
		throw new NullPointerException("overflow");
	}
}
