package tempera.geometry;

import java.util.Arrays;
import java.util.List;

public class BoundingBox implements Cloneable {
	
	protected double length;
	protected double width;
	
	protected Point center;
	
	private double halfLength;
	private double halfWidth;
	
	/**
	 * Creates a new bounding box with a point defined
	 * as it's center, and it's length and width
	 * @param center	the center of the rectangle
	 * @param length	the horizontal size of the bounding box
	 * @param width		the vertical size of the bounding box
	 */
	public BoundingBox(Point center, double length, double width) {
		setLength(length);
		setWidth(width);
		
		this.center = center;
	}
	
	/**
	 * Creates a new bounding box with the
	 * top left point being (x, y), while 
	 * also defining the length and height
	 * @param x			the x coordinate of the top left corner
	 * @param y			the y coordinate of the top left corner
	 * @param length	the horizontal size of the bounding box
	 * @param width		the vertical size of the bounding box
	 */
	public BoundingBox(double x, double y, double length, double width) {
		this(null, length, width);
		
		center = new Point(x + halfLength, y - halfWidth);
	}
	
	public BoundingBox(Point A, Point B) {
		this(new Point((A.x + B.x) / 2 , (A.y + B.y) / 2),
				Math.abs(A.x - B.x),
				Math.abs(A.y - B.y));
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
	
	/**
	 * Gets all the edges of this rectangle
	 * in the form of min-x, max-x, min-y, max-y
	 * @return
	 */
	public double[] getEdges() {
		
		double x = center.x;
		double y = center.y;
		
		return new double[] {
				x - halfLength,
				x + halfLength,
				y - halfWidth,
				y + halfWidth
		};
	}
	
	public Point[] getPoints() {
		
		double[] edges = getEdges();
		
		return new Point[] {
				new Point(edges[0], edges[3]),
				new Point(edges[1], edges[3]),
				new Point(edges[1], edges[2]),
				new Point(edges[0], edges[2])
		};
	}
	
	//Processing
	
	public boolean intersects(BoundingBox box) {
		double[] edges1 = getEdges();
		double[] edges2 = box.getEdges();
		
		//check sideways
		
		
		return true;
	}
}
