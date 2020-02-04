package api.tempera.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class WeightedList<T> {
	//TODO compare this with dartboard algorithm
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
	
	/**
	 * Add an element to the WeightedList
	 * @param element	The element to add to the weighted list
	 * @param weight	The weight of the given element
	 */
	public void put(T element, int weight) {
		totalWeight += weight;
		elements++;
		Node node = new Node(element, weight);
		top.child = node;
		top = node;
	}
	
	/**
	 * Rolls an element from the weighted list
	 * @return	A randomly chosen element from the weighted list
	 */
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
	
	/**
	 * Gets all elements of the weighted list
	 * 
	 * TODO test this
	 * @return	a HashMap containing all elements and their corresponding weights
	 */
	public Map<T, Integer> getElements() {
		Node temp = root;
		Map<T, Integer> elements = new HashMap<T, Integer>();
		
		do {
			temp = temp.child;
			elements.put(temp.element, temp.weight);
		} while(temp.child != null);
		
		return elements;
	}
}
