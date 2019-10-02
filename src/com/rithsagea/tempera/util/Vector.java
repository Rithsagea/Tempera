package com.rithsagea.tempera.util;

public class Vector implements Cloneable {
	protected double x;
	protected double y;
	protected double z;
	
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
	
	//information about the vector
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	/**
	 * Gets the z coordinate of the vector
	 * @return The z coordinate of the vector
	 */
	public double getZ() {
		return z;
	}
	
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
	 * @return The resulting vector from the operation
	 */
	public Vector add(Vector vector) {
		Vector result = new Vector(vector.x + x, vector.y + y, vector.z + z);
		return result;
	}
	
	
}
