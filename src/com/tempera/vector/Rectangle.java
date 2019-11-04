package com.tempera.vector;

import com.tempera.util.MathUtils;

public class Rectangle {
	
	public double x;
	public double y;
	public double width;
	public double length;
	
	public Rectangle(double x, double y, double width, double length) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.length = length;
	}
	
	/**
	 * Checks whether 2 rectangles are intersecting
	 * 
	 * TODO try to optimize the large amount of addition being done 
	 * 		a lot of the compares only have to be done once
	 */
	public boolean isIntersecting(Rectangle r) {
		return (MathUtils.between(x + width, r.x, r.x + r.width)
				|| MathUtils.between(x, r.x, r.x + r.width))
				&& (MathUtils.between(y + length, r.y, r.y + r.length)
				|| MathUtils.between(y, r.y, r.y + r.length)); 
	}
}
