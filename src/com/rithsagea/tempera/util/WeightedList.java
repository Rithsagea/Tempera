package com.rithsagea.tempera.util;

import java.util.Random;

public class WeightedList<T> {
	
	private class Node<K> {
		 public K element;
		 public int weight;
		 public Node<K> child;
		 
		 public Node(K element, int weight) {
			 this.element = element;
			 this.weight = weight;
			 this.child = null;
		 }
	}
	
	private final Node<T> root = new Node<T>(null, 0);
	private Node<T> top = root;
	private Random rand = new Random();
	
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
		int value = rand.nextInt(totalWeight) + 1;
		Node<T> temp = root;
		
		while(temp.child != null) {
			temp = temp.child;
			value -= temp.weight;
			if(value <= 0)
				return temp.element;
		}
		throw new NullPointerException("overflow");
	}
}
