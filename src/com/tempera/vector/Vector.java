package com.tempera.vector;

/**
 * @author	Rithsagea
 * @version	alpha.-1
 * @since	2019-10-22
 */
public class Vector implements Cloneable {
	
	public double x;
	public double y;
	public double z;
	
	/**
	 * Create a vector with double values
	 * @param x	An double that represents the vector's x coordinate
	 * @param y An double that represents the vector's y coordinate
	 * @param z An double that represents the vector's z coordinate
	 */
	public Vector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Create a vector with integer values
	 * @param x	An integer that represents the vector's x coordinate
	 * @param y An integer that represents the vector's y coordinate
	 * @param z An integer that represents the vector's z coordinate
	 */
	public Vector(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector clone() {
		return new Vector(x, y, z);
	}
	
	public String toString() {
		return String.format("(%f, %f, %f)", x, y, z);
	}
	
	//information about the vector
	
	/**
	 * Gets the magnitude of the vector
	 * @return	The magnitude of the vector
	 */
	public double magnitude() {
		return Math.sqrt(x * x + y * y + z * z);
	}
	
	//basic operations
	
	/**
	 * Adds a vector to this vector
	 * @param vector The object that is being added to this vector
	 * @return This vector
	 */
	public Vector add(Vector vector) {
		x += vector.x;
		y += vector.y;
		z += vector.z;
		return this;
	}
	
	/**
	 * 
	 * @param x	The x value to increment the vector by
	 * @param y	The y value to increment the vector by
	 * @param z	The z value to increment the vector by
	 * @return	This vector
	 */
	public Vector add(double x, double y, double z) {
		this.x += x;
		this.y += y;
		this.z += z;
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
		z -= vector.z;
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
		z *= scalar;
		return this;
	}
}
