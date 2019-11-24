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
		calculatePolar();
	}
	
	//Object Methods
	public Vector clone() {
		return new Vector(x, y);
	}
	
	public String toString() {
		return String.format("(%.4f, %.4f)", x, y);
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
	
	public void addAngle(double angle) {	//pretty much duplicate code but shhh
		calculatePolar();
		this.angle += angle;
		calculateComponent();
	}
	
	public void setMagnitude(double magnitude) {
		calculatePolar();
		this.radius = magnitude;
		calculateComponent();
	}
	
	//Calculation
	public void calculatePolar() {
		radius = Math.sqrt(x * x + y * y);	//will remove sqrt later if necessary
		angle = Math.atan2(y, x);
	}
	
	public void calculateComponent() {
		x = radius * Math.cos(angle);
		y = radius * Math.sin(angle);
	}
	
	//Operators
	public void add(Vector vector) {
		x += vector.x;
		y += vector.y;
	}
	
	public void add(double x, double y) {
		this.x += x;
		this.y += y;
	}
	
	public void subtract(Vector vector) {
		x -= vector.x;
		y -= vector.y;
	}
	
	public void subtract(double x, double y) {
		this.x -= x;
		this.y -= y;
	}
	
	public void multiply(double scalar) {
		x *= scalar;
		y *= scalar;
	}
	
	public void divide(double scalar) {
		x /= scalar;
		y /= scalar;
	}
}
