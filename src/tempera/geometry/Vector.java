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
	
	public double getX() {
		return Math.cos(angle) * magnitude;
	}
	
	public double getY() {
		return Math.sin(angle) * magnitude;
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
	
	//Compat
	
	public Vector add(Vector vec) {
		return add(new Point(vec));
	}
	
	public Vector add(double x, double y) {
		return add(new Point(x, y));
	}
	
	public Vector add(Point p) {
		magnitude = p.getMagnitude();
		angle = Math.atan2(getY() + p.getY(), getX() + p.getX());
		return this;
	}
	
	public Vector subtract(Vector vec) {
		return subtract(new Point(vec));
	}
	
	public Vector subtract(double x, double y) {
		return subtract(new Point(x, y));
	}
	
	public Vector subtract(Point p) {
		magnitude = p.getMagnitude();
		angle = Math.atan2(getY() - p.getY(), getX() - p.getX());
		return this;
	}
	
	//Macros
	
	public Vector inverse() {
		return this.clone().setMagnitude(-magnitude);
	}
	
	public Vector unit() {
		return this.clone().setMagnitude(1);
	}
	
	public Vector addAngle(double angle) {
		angle += angle;
		return this;
	}
}
