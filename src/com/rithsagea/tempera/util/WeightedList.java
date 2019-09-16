package com.rithsagea.tempera.util;

import java.util.Random;

public class WeightedList<T> {
	
	private class Node<T> {
		 public T element;
		 public int weight;
		 public Node<T> child;
		 
		 public Node(T element, int weight) {
			 this.element = element;
			 this.weight = weight;
			 this.child = null;
		 }
	}
	
	private final Node<T> root = new Node<T>(null, 0);
	private Node<T> top = root;
	private Random rand = new Random(System.currentTimeMillis());
	
	protected int totalWeight = 0;
	protected int elements = 0;
	
	public void put(T element, int weight) {
		totalWeight += weight;
		elements++;
		Node<T> node = new Node<T>(element, weight);
		top.child = node;
		top = node;
	}
	
	public T getElement() {
		int value = rand.nextInt(totalWeight);
		Node<T> temp = root;
		
		while(temp.child != null) {
			value -= temp.weight;
			temp = temp.child;
			if(value <= 0)
				return temp.element;
		}
		
		return temp.element;
	}
}
