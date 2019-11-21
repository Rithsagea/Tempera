package com.tempera.vector;

public class Point {
	
	protected double x;
	protected double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	//Object Methods
	public Point clone() {
		return new Point(x, y);
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point point = (Point)obj;
			return (point.x == x) && (point.y == y);
		}
		return false;
	}
	
	//Information
	/**
	 * 
	 * @param pt	the point to compare this point to 
	 * @return		the distance between this point and {@code pt}
	 */
	public double distanceSquaredFrom(Point pt) {
		double xDist = pt.x - x;
		double yDist = pt.y - y;
		
		xDist *= xDist;
		yDist *= yDist;
		
		return xDist + yDist;
	}
	
	public double distanceFrom(Point point) {
		return Math.sqrt(distanceSquaredFrom(point));
	}
	
	//Setters
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	//Getters
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
}
