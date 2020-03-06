package api.tempera.math;

public class Vector {
	protected double x;
	protected double y;
	
	/**
	 * Creates a vector from two coordinates
	 * @param x the x coordinate of this vector
	 * @param y the y coordinate of this vector
	 */
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Creates a unit vector from an angle
	 * @param angle the angle of this vector
	 */
	public Vector(double angle) {
		x = Math.cos(angle);
		y = Math.sin(angle);
	}
	
	/**
	 * Returns the x coordinate of this vector
	 * @return the x coordinate of this vector
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Sets the x coordinate of this vector
	 * @param x the x coordinate of this vector
	 * @return this vector
	 */
	public Vector setX(double x) {
		this.x = x;
		return this;
	}
	
	/**
	 * Gets the y coordinate of this vector
	 * @return the y coordinate of this vector
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Sets the y coordinate of this vector
	 * @param y the y coordinate of this vector
	 * @return this vector
	 */
	public Vector setY(double y) {
		this.y = y;
		return this;
	}
	
	/**
	 * Gets the magnitude of this vector
	 * @return the magnitude of this vector
	 */
	public double getMagnitude() {
		return x * x + y * y;
	}
	
	/**
	 * Sets the magnitude of this vector
	 * @param magnitude the magnitude of this vector
	 * @return this vector
	 */
	public Vector setMagnitude(double magnitude) {
		double angle = getAngle();
		
		x = Math.cos(angle) * magnitude;
		y = Math.sin(angle) * magnitude;
		
		return this;
	}
	
	/**
	 * Gets the angle of this vector
	 * @return the angle of this vector
	 */
	public double getAngle() {
		return Math.atan2(y, x);
	}
	
	/**
	 * Sets the angle of this vector
	 * @param angle the angle of this vector
	 * @return this vector
	 */
	public Vector setAngle(double angle) {
		double magnitude = getMagnitude();
		
		x = Math.cos(angle) * magnitude;
		y = Math.sin(angle) * magnitude;
		
		return this;
	}
	
}
