package test.tempera.util;

import com.tempera.util.Deque;

public class DequeTest {
	public static void main(String[] args) {
		Deque<Integer> deque = new Deque<Integer>();
		
		for(int x = 0; x < 10; x++) {
//			System.out.println(x);
			deque.put(x);
//			deque.putLast(x);
		}
		System.out.println();
		for(int x : deque.toArray()) {
			System.out.println(x);
		}
	}
}
