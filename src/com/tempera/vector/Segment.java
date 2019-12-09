package com.tempera.vector;

public class Segment {
	protected Point A;
	protected Point B;
	
	/**
	 * Creates a line segment with endpoints
	 * A and B
	 * @param A	the point A in the line segment
	 * @param B the point B in the line segment
	 */
	public Segment(Point A, Point B) {
		this.A = A;
		this.B = B;
	}
	
	//Getters
	public Point getA() {
		return A;
	}
	
	public Point getB() {
		return B;
	}
	
	//Calculation
	//Note: This does extra calculation for polar stuff
	public double getSlope() {
		Vector vec = getVector();
		return vec.y / vec.x;
	}
	
	public Vector getVector() {
		return new Vector(A, B);
	}
	
	/**
	 * Checks if a line segment contains a point.
	 * Source: https://stackoverflow.com/a/328193
	 * 
	 * @param p	the point to check for
	 * @return	whether the line segment contains p
	 */
	public boolean containsPoint(Point p) {
		return (A.distanceSquaredFrom(p) + B.distanceFrom(p) == A.distanceSquaredFrom(B));
	}
	
	/**
	 * https://www.geeksforgeeks.org/check-if-two-given-line-segments-intersect/
	 * @param seg
	 * @return
	 */
	public boolean intersects(Segment seg) {
		int o1 = Point.orientation(A, B, seg.A);
		int o2 = Point.orientation(A, B, seg.B);
		int o3 = Point.orientation(seg.A, seg.B, A);
		int o4 = Point.orientation(seg.A, seg.B, B);
		
		if(o1 != o2 && o3 != o4)
			return true;
		
		return false;
	}
}
