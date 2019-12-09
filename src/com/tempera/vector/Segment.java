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
	
	public Vector getVector() {
		return new Vector(A, B);
	}
	
	public Point getA() {
		return A.clone();
	}
	
	public Point getB() {
		return B.clone();
	}
}
