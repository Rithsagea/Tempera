package api.tempera.geometry;

public class Point implements Cloneable {
	
	protected double x;
	protected double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Point() {
		this(0, 0);
	}
	
	//Convenience
	
	public Point clone() {
		return new Point(x, y);
	}
	
	public String toString() {
		return String.format("(%f, %f)", x, y);
	}
	
	//Getters
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	//Setters
	
	public Point setX(double x) {
		this.x = x;
		return this;
	}
	
	public Point setY(double y) {
		this.y = y;
		return this;
	}
	
	//Processing
	
	public Point add(double x, double y) {
		this.x += x;
		this.y += y;
		
		return this;
	}
	
	public Point add(Point p) {
		x += p.x;
		y += p.y;
		
		return this;
	}
	
	public Point subtract(double x, double y) {
		this.x -= x;
		this.y -= y;
		
		return this;
	}
	
	public Point subtract(Point p) {
		x -= p.x;
		y -= p.y;
		
		return this;
	}
}
