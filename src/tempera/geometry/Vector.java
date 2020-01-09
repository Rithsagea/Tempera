package tempera.geometry;

public class Vector implements Cloneable {
	protected double magnitude;
	protected double angle;
	
	public Vector(double magnitude, double angle) {
		this.magnitude = magnitude;
		this.angle = angle;
	}
	
	public Vector() {
		this(0, 0);
	}
	
	public Vector(Point p) {
		angle = Math.atan2(p.y, p.x);
		magnitude = Math.sqrt(p.y * p.y + p.x * p.x);
	}
	
	//Convenience
	
	public Vector clone() {
		return new Vector(magnitude, angle);
	}
	
	public String toString() {
		return String.format("[%f, %f rad]", magnitude, angle);
	}
	
	//Getters
	
	public double getMagnitude() {
		return magnitude;
	}
	
	public double getAngle() {
		return angle;
	}
	
	//Setters
	
	public Vector setMagnitude(double magnitude) {
		this.magnitude = magnitude;
		return this;
	}
	
	public Vector setAngle(double angle) {
		this.angle = angle;
		return this;
	}
	
	//Processing
	
	public Vector multiply(double scalar) {
		magnitude *= scalar;
		return this;
	}
	
	public Vector divide(double scalar) {
		magnitude /= scalar;
		return this;
	}
	
	//Macros
	
	public Vector inverse() {
		return this.clone().setMagnitude(-magnitude);
	}
	
	public Vector unit() {
		return this.clone().setMagnitude(1);
	}
}
