package com.tempera.vector;

/**
 * @author	Rithsagea
 * @version	alpha.-1
 * @since	2019-11-22
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
	
	//Getters
	public double getAngle() {
		return angle;
	}
	
	public double getMagnitude() {
		return radius;
	}
	
	//Setters
	public void setAngle(double angle) {
		calculatePolar();
		this.angle = angle;
		calculateComponent();
	}
	
	public void setMagnitude(double magnitude) {
		calculatePolar();
		this.radius = magnitude;
		calculateComponent();
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
