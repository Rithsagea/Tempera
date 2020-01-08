package tempera.geometry;

public class Point {
	protected double x;
	protected double y;
	
	public Point(int x, int y) {
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
	
	public String toString() {
		return String.format("(%f, %f)", x, y);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public Point setX(double x) {
		this.x = x;
		return this;
	}
	
	public Point setY(double y) {
		this.y = y;
		return this;
	}
}
