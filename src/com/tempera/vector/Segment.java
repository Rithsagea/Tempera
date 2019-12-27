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
	
	public String toString() {
		return String.format("%s -> %s", A, B);
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
	
/*
(x1, y1)
(x2, y2)

m = slope

y - y1 = m(x - x1)

y - y1 = mx - mx1

x intercept is when y = 0

0 - y1 = mx - mx1
mx = mx1 - y1
x = x1 - (y1 / m)
*/
	/**
	 * Gets the x-intercept of this segment as if it
	 * where a line.
	 * @return	the x-intercept of this segment
	 */
	public double getIntercept() {
		return A.x - A.y / getSlope();
	}
	
	public double getLength() {
		return A.distanceFrom(B);
	}
	
	public double getLengthSquared() {
		return A.distanceSquaredFrom(B);
	}
	
	public Vector getVector() {
		return new Vector(A, B);
	}
	
	/**
	 * Checks if a line segment contains a point.
	 * Source: https://stackoverflow.com/a/328193
	 * 
	 * replace with dot product if slow
	 * 
	 * @param p	the point to check for
	 * @return	whether the line segment contains p
	 */
	public boolean containsPoint(Point p) {
		return (A.distanceSquaredFrom(p) + B.distanceFrom(p) == A.distanceSquaredFrom(B));
	}
	
	/**
	 * Checks if the point r lies on segment pq
	 * @param p	the point p
	 * @param q	the point q
	 * @param r	the point r
	 * @return	whether r lies on pq
	 */
	public static boolean onSegment(Point p, Point q, Point r) {
		if (r.x <= Math.max(p.x, q.x) && r.x >= Math.min(p.x, q.x) && 
			r.y <= Math.max(p.y, q.y) && r.y >= Math.min(p.y, q.y))
			return true;
		
		return false;
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
		
		if(o1 == 0 && onSegment(A, B, seg.A)) return true;
		if(o2 == 0 && onSegment(A, B, seg.B)) return true;
		if(o3 == 0 && onSegment(seg.A, seg.B, A)) return true;
		if(o4 == 0 && onSegment(seg.A, seg.B, B)) return true;
		
		return false;
	}
}
