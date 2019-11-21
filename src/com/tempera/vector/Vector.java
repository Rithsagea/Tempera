package com.tempera.vector;

/**
 * @author	Rithsagea
 * @version	alpha.-1
 * @since	2019-10-22
 */
public class Vector extends Point implements Cloneable {
	
	protected double angle;
	protected double radius;
	
	/**
	 * Create a vector with double values
	 * @param x	An double that represents the vector's x coordinate
	 * @param y An double that represents the vector's y coordinate
	 * @param z An double that represents the vector's z coordinate
	 */
	public Vector(double x, double y) {
		super(x, y);
		this.x = x;
		this.y = y;
	}
	
	//Object Methods
	public Vector clone() {
		return new Vector(x, y);
	}
	
	//Information
	public double getAngle() {
		return angle;
	}
	
	public double getMagnitude() {
		return radius;
	}
	
	//Calculation
	public void calculatePolar() {
		radius = x * x + y * y;
		angle = Math.atan2(y, x);
	}
	
	public void calculateComponent() {
		x = radius * Math.cos(angle);
		y = radius * Math.sin(angle);
	}
	
}
