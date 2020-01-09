package tempera.geometry;

import java.util.Arrays;
import java.util.List;

public class BoundingBox implements Cloneable {
	
	protected double length;
	protected double width;
	
	protected Point center;
	
	private double halfLength;
	private double halfWidth;
	
	public BoundingBox(Point center, double length, double width) {
		setLength(length);
		setWidth(width);
		
		this.center = center;
	}
	
	/**
	 * Creates a new bounding box with the
	 * top left point being (x, y), while 
	 * also defining the length and height
	 * @param x
	 * @param y
	 * @param length		the horizontal size of the bounding box
	 * @param width		the vertical size of the bounding box
	 */
	public BoundingBox(double x, double y, double length, double width) {
		this(null, length, width);
		
		center = new Point(x + halfLength, y - halfWidth);
	}
	
	//Convenience
	
	public BoundingBox clone() {
		return new BoundingBox(center.clone(), length, width);
	}
	
	public String toString() {
		return center.toString() + String.format(": <%f, %f>", length, width);
	}
	
	//Setters
	
	public BoundingBox setWidth(double width) {
		this.width = width;
		halfWidth = width / 2;
		
		return this;
	}
	
	public BoundingBox setLength(double length) {
		this.length = length;
		halfLength = length / 2;
		
		return this;
	}
	
	public BoundingBox setCenter(Point center) {
		this.center = center;
		
		return this;
	}
	
	//Getters
	
	public double getWidth() {
		return width;
	}
	
	public double getLength() {
		return length;
	}
	
	public Point getCenter() {
		return center;
	}
	
	public List<Point> getPoints() {
		double x = center.x;
		double y = center.y;
		
		double left = x - halfLength;
		double right = x + halfLength;
		
		double up = y + halfWidth;
		double down = y - halfWidth;
		
		return Arrays.asList(
				new Point(left, up),
				new Point(right, up),
				new Point(right, down),
				new Point(left, down));
	}
}
