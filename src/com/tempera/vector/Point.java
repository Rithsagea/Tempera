package com.tempera.vector;

/**
 * @author	Rithsagea
 * @version	alpha.-1
 * @since	2019-11-22
 */
public class Point implements Cloneable {
	
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
	 * Finds the distance squared from this point to another.
	 * Use this instead of distanceFrom if the square
	 * root isn't needed (it saves computations)
	 * @param pt	the point to compare this point to 
	 * @return		the distance squared between this point and pt
	 */
	public double distanceSquaredFrom(Point pt) {
		double xDist = pt.x - x;
		double yDist = pt.y - y;
		
		xDist *= xDist;
		yDist *= yDist;
		
		return xDist + yDist;
	}
	
	/**
	 * Finds the distance squared from this point to another.
	 * Use this instead of distanceFrom if the square
	 * root isn't needed (it saves computations)
	 * @param x		the x coordinate to compare this point to
	 * @param y		the y coordinate to compare this point to 
	 * @return		the distance squared between this point and pt
	 */
	public double distanceSquaredFrom(double x, double y) {
		double xDist = this.x - x;
		double yDist = this.y - y;
		
		xDist *= xDist;
		yDist *= yDist;
		
		return xDist + yDist;
	}
	
	/**
	 * Finds the distance between this point and another. Don't
	 * use this if you are going to square the return value, as
	 * square roots are pretty expensive.
	 * @param point	the point to compare this point to
	 * @return		the distance between this point and pt
	 */
	public double distanceFrom(Point point) {
		return Math.sqrt(distanceSquaredFrom(point));
	}
	
	/**
	 * Finds the distance between this point and (x, y). Don't
	 * use this if you are going to square the return value, as
	 * square roots are pretty expensive
	 * @param x		the x coordinate to compare this point to
	 * @param y		the y coordinate to compare this point to
	 * @return		the distance from this point to (x, y)
	 */
	public double distanceFrom(double x, double y) {
		return Math.sqrt(distanceSquaredFrom(x, y));
	}
	
	//Setters
	/**
	 * 
	 * @param x		the value to set the point's x coordinate to.
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * 
	 * @param y		the value to set the point's y coordinate to.
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	//Getters
	/**
	 * 
	 * @return		this point's x coordinate
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * 
	 * @return		this point's y coordinate
	 */
	public double getY() {
		return y;
	}
	
	//Calculations
}
