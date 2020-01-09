package tempera.geometry;

public class Vector {
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
	
	public String toString() {
		return String.format("[%f, %f]", magnitude, angle);
	}
	
	public double getMagnitude() {
		return magnitude;
	}
	
	public double getAngle() {
		return angle;
	}
	
	public Vector setMagnitude(double magnitude) {
		this.magnitude = magnitude;
		return this;
	}
	
	public Vector setAngle(double angle) {
		this.angle = angle;
		return this;
	}
	
	public Vector multiply(double scalar) {
		magnitude *= scalar;
		return this;
	}
	
	public Vector divide(double scalar) {
		magnitude /= scalar;
		return this;
	}
}
