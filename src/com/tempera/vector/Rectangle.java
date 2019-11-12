package com.tempera.vector;

public class Rectangle {
	
	public double x;
	public double y;
	public double height;
	public double width;
	public double angle;	//pull test
	
	public Rectangle(double x, double y, double width, double height, double angle) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.angle = angle;
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
		if(y < r.y + r.height && r.y > y + height) {
			System.out.println("above");
			return false;
		}
		//check if rectangle is left of other left edge of rectangle
		if(x > r.x + r.width && r.x > x + width) {
			System.out.println("left");
			return false;
		}
		return true;
	}
}
