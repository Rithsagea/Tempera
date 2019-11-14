package com.tempera.vector;

/**
 * @author	Rithsagea
 * @version	alpha.-1
 * @since	2019-10-22
 */
public class Vector implements Cloneable {
	
	public double x;
	public double y;
	
	public double theta;
	public double radius;
	
	/**
	 * Create a vector with double values
	 * @param x	An double that represents the vector's x coordinate
	 * @param y An double that represents the vector's y coordinate
	 * @param z An double that represents the vector's z coordinate
	 */
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Create a vector with integer values
	 * @param x	An integer that represents the vector's x coordinate
	 * @param y An integer that represents the vector's y coordinate
	 * @param z An integer that represents the vector's z coordinate
	 */
	public Vector(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector clone() {
		return new Vector(x, y);
	}
	
	public String toString() {
		return String.format("(%.4f, %.4f)", x, y);
	}
	
	//information about the vector
	public double magnitude() {
		return radius;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getTheta() {
		return theta;
	}
	
	//setting values
	public void setX(double x) {
		this.x = x;
		calculatePolar();
	}
	
	public void setY(double y) {
		this.y = y;
		calculatePolar();
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
		calculateCartesian();
	}
	
	public void setRadians(double theta) {
		this.theta = theta;
		calculateCartesian();
	}
	
	public void setDegrees(double theta) {
		setRadians(Math.toRadians(theta));
	}
	
	//combined setting values (faster)
	public void setCartesian(double x, double y) {
		this.x = x;
		this.y = y;
		calculatePolar();
	}
	
	public void setPolar(double radius, double theta) {
		this.radius = radius;
		this.theta = theta;
		calculateCartesian();
	}
	
	//basic operations
	//TODO should these be immutable?
	/**
	 * Adds a vector to this vector
	 * @param vector The object that is being added to this vector
	 * @return This vector
	 */
	public Vector add(Vector vector) {
		x += vector.x;
		y += vector.y;
		return this;
	}
	
	/**
	 * 
	 * @param x	The x value to increment the vector by
	 * @param y	The y value to increment the vector by
	 * @return	This vector
	 */
	public Vector add(double x, double y) {
		this.x += x;
		this.y += y;
		return this;
	}
	
	/**
	 * Subtracts a vector from this vector
	 * @param vector The object that is being subtracted from this vector
	 * @return This vector
	 */
	public Vector subtract(Vector vector) {
		x -= vector.x;
		y -= vector.y;
		return this;
	}
	
	/**
	 * Multiplies the vector by a scalar
	 * @param scalar	The scalar to multiply the vector by
	 * @return	This vector
	 */
	public Vector multiply (double scalar) {
		x *= scalar;
		y *= scalar;
		return this;
	}
	
	//fancy rectangular polar stuff
	/**
	 * Calculates Polar coordinates based on the stored Cartesian coordinates
	 */
	public void calculatePolar() {
		radius = magnitude();
		theta = Math.atan2(y, x);
	}

	/**
	 * Calculates Cartesian coordinates based on the stored Polar coordinates
	 */
	public void calculateCartesian() {
		if(Double.isNaN(theta))
			theta = 0;
		x = Math.cos(theta) * radius;
		y = Math.sin(theta) * radius;
	}
	
	/**
	 * 
	 * @param theta	The value to add to theta in radians
	 * @return		This vector
	 */
	public Vector rotateRadians(double theta) {
		setRadians(this.theta + theta);
		return this;
	}
	
	/**
	 * 
	 * @param theta The value to add to theta in degrees
	 * @return		This vector
	 */
	public Vector rotateDegrees(double theta) {
		return rotateRadians(Math.toRadians(theta));
	}
	
	/**
	 * 
	 * @param r	The value to add the the radius
	 * @return	This vector
	 */
	public Vector addRadius(double r) {
		setRadius(radius + r);
		return this;
	}
}
