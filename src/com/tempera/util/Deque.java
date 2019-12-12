package com.tempera.util;

import java.util.Stack;

public class Deque<T> {
	
	private class Node {
		public T element;
		public Node parent;
		public Node child;
		
		public Node(T element, Node parent, Node child) {
			this.element = element;
			this.parent = parent;
			this.child = child;
		}
	}
	
	private Node head = null;
	private Node tail = null;
	
	/**
	 * Adds an element to the top of the queue
	 * @param element	the element to add
	 */
	public void put(T element) {
		Node node = new Node(element, null, head);
		if(head != null) head.parent = node;
		head = node;
		if(tail == null) tail = head;
	}
	
	/**
	 * Adds an element to the bottom of the queue
	 * @param element	the element to add
	 */
	public void putLast(T element) {
		Node node = new Node(element, tail, null);
		if(tail != null) tail.child = node;
		tail = node;
		if(head == null) head = tail;
	}
	
	/**
	 * Gets the size of the deque
	 * @return	the size of the deque
	 */
	public int size() {
		Node node = head;
		int size;
		for(size = 1; node.child != null; node = node.child, size++);
		return size;
	}
}
