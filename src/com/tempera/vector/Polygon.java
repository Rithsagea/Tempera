package com.tempera.vector;

import com.tempera.util.MathUtils;

public interface Polygon {
	
	/**
	 * Gets all the points of this polygon
	 * in clockwise order.
	 * @return	an array containing all the points of this polygon
	 */
	public Point[] getPoints();
	
	/**
	 * Checks if the projections of polygons p1 and p2 intersect
	 * on the axis
	 * @param p1	the first polygon
	 * @param p2	the second polygon
	 * @param axis	the axis to compare to
	 * @return		whether the projections intersect
	 */
	public static boolean checkAxis(Polygon p1, Polygon p2, Segment axis) {
		//variables to compare at the end
		double minProj1 = Double.POSITIVE_INFINITY;
		double maxProj1 = Double.NEGATIVE_INFINITY;
		
		double minProj2 = Double.POSITIVE_INFINITY;
		double maxProj2 = Double.NEGATIVE_INFINITY;
		
		//temporary storage variables
		double proj = 0;
		
		//stuff to analyze with
		Point[] points1 = p1.getPoints();
		Point[] points2 = p2.getPoints();
		
		Point offset = axis.A;
		Vector vec = axis.getVector().unitVector();
		
		for(Point p : points1) {
			p.x -= offset.x;
			p.y -= offset.y;
		}
		
		for(Point p : points2) {
			p.x -= offset.x;
			p.y -= offset.y;
		}
		
		for(Point p : points1) {
			proj = vec.dotProduct(new Vector(p));
			if(proj < minProj1) minProj1 = proj;
			if(proj > maxProj1) maxProj1 = proj;
		}
		
		for(Point p : points2) {
			proj = vec.dotProduct(new Vector(p));
			if(proj < minProj2) minProj2 = proj;
			if(proj > maxProj2) maxProj2 = proj;
		}
		
		return MathUtils.rangeIntercept(minProj1, maxProj1, minProj2, maxProj2);
	}
	
	public static boolean isIntersecting(Polygon p1, Polygon p2) {
		
		Point[] shape1 = p1.getPoints();
		Point[] shape2 = p2.getPoints();
		
		//Loops through all the segments in rect1
		Segment axis = new Segment(null, shape1[shape1.length - 1]);
		for(int x = 0; x < shape1.length; x++) {
			axis.A = axis.B;
			axis.B = shape1[x];
			if(!checkAxis(p1, p2, axis)) return false;
		}
		
		//Loops through all the segments in rect2
		axis.B = shape2[shape2.length - 1];
		for(int x = 0; x < shape2.length; x++) {
			axis.A = axis.B;
			axis.B = shape2[x];
			if(!checkAxis(p1, p2, axis)) return false;
		}
		
		return true;
	}
}
