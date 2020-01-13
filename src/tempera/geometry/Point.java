package tempera.geometry;

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
	
	public Point(Vector vec) {
		x = vec.magnitude * Math.cos(vec.angle);
		y = vec.magnitude * Math.sin(vec.angle);
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
	
	public Point add(Point p) {
		x += p.x;
		y += p.y;
		
		return this;
	}
	
	public Point subtract(Point p) {
		x -= p.x;
		y -= p.y;
		
		return this;
	}
	
	public Point shift(Vector v) {
		Point shift = new Point(v);
		
		return add(shift);
	}
	
	//Compat
	
	public Point add(Vector vec) {
		return add(new Point(vec));
	}
	
	public Point subtract(Vector vec) {
		return subtract(new Point(vec));
	}
	
	public double getMagnitude() {
		return Math.sqrt(x * x + y * y);
	}
}
