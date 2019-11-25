package com.tempera.vector;

public class RectangleTest {

	public static void main(String[] args) 
	{
		Rectangle rect1 = new Rectangle(0, 0, 2, 2, 0);
		Rectangle rect2 = new Rectangle(1, 0, 2, 2, 0.785);
		
		System.out.println(rect1.isIntersecting(rect2));

	}
}
