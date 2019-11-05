package com.tempera.vector;

public class Rectangle {
	
	public double x;
	public double y;
	public double width;
	public double length;
	
	public Rectangle(double x, double y, double length, double width) {
		this.x = x;
		this.y = y;
		this.length = length;
		this.width = width;
	}
	
	/**
	 * Checks whether 2 rectangles are intersecting
	 * 
	 * TODO try to optimize the large amount of addition being done 
	 * 		a lot of the compares only have to be done once
	 */
	public boolean isIntersecting(Rectangle r) {
		//taken from geeksforgeeks
		
		//check if rectangle is above top edge of other rectangle
		if(y < r.y + r.width && r.y > y + width) {
			System.out.println("above");
			return false;
		}
		//check if rectangle is left of other left edge of rectangle
		if(x > r.x + r.length && r.x > x + length) {
			System.out.println("left");
			return false;
		}
		return true;
	}
}
