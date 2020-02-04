package api.tempera.util;

import java.util.ArrayList;
import java.util.List;

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
	 * Removes the top element of the deque and returns it
	 * @return	the top element of the deque
	 */
	public T poll() {
		T element = head.element;
		head = head.child;
		return element;
	}
	
	/**
	 * Gets the top element of the deque
	 * @return	the top element of the deque
	 */
	public T peek() {
		return head.element;
	}
	
	/**
	 * Gets the bottom element of the deque
	 * @return	the bottom element of the deque
	 */
	public T peekLast() {
		return tail.element;
	}
	
	/**
	 * Removes the bottom element of the deque and returns it
	 * @return	the bottom element of the deque
	 */
	public T pollLast() {
		T element = tail.element;
		tail = tail.parent;
		return element;
	}
	
	/**
	 * Gets all the elements from top to bottom as an array
	 * @return	an array with all elements in the deque
	 */
	public List<T> toArray() {
		List<T> array = new ArrayList<T>(size());
		
		for(Node node = head; node != null; node = node.child) {
			array.add(node.element);
		}
		
		return array;
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
