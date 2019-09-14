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
	private Random rand;
	
	protected int totalWeight;
	protected int elements;
	
	public void put(T element, int weight) {
		Node<T> node = new Node<T>(element, weight);
		top.child = node;
		top = node;
	}
	
	public void init() {
		rand = new Random(System.currentTimeMillis());
		totalWeight = 0;
		Node<T> temp = root;
		
		while(temp != null) {
			elements++;
			totalWeight += temp.weight;
			temp = temp.child;
		}
	}
	
	public T getElement() {
		int value = rand.nextInt(totalWeight);
		Node<T> temp = root;
		
		while(temp != null) {
			value -= temp.weight;
			temp = temp.child;
			if(value <= 0)
				return temp.element;
		}
		
		return null;
	}
}
