package com.tempera.vector;

public class Rectangle {
	
	public double x;
	public double y;
	public double height;
	public double width;
	public double angle;
	
	public Rectangle(double x, double y, double width, double height, double angle) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.angle = Math.toRadians(angle);	//assuming angle is input in degrees
	}
	
	/**
	 * Checks whether 2 rectangles are intersecting
	 * 
	 * TODO optimize this god awful abomination
	 */
	public boolean isIntersecting(Rectangle r) {
		//get points of both rectangles
		Vector[] points = new Vector[] {new Vector(x, y), new Vector(x + width, y), new Vector(x + width, y + height), new Vector(x, y + height)};
		for (int i = 1; i < 4; i++) {
			points[i] = points[i].subtract(new Vector(x, y)).rotateRadians(angle).add(new Vector(x, y));
		}
		
		Vector[] rpoints = new Vector[] {new Vector(r.x, r.y), new Vector(r.x + r.width, r.y), new Vector(r.x + r.width, r.y + r.height), new Vector(r.x, r.y + r.height)};
		for (int i = 1; i < 4; i++) {
			rpoints[i] = rpoints[i].subtract(new Vector(r.x,r.y)).rotateRadians(r.angle).add(new Vector(r.x, r.y));
		}
		
		//check if vertices of either rectangle are in the other one
		if (isOverlapping(points, rpoints)) {
			return true;
		}
		
		if (isOverlapping(rpoints, points)) {
			return true;
		}
		
		return false;
	}
	
	/*
	 * to make life easier, taken from
	 * https://web.archive.org/web/20161108113341/https://www.ecse.rpi.edu/Homepages/wrf/Research/Short_Notes/pnpoly.html
	 */
	private boolean isOverlapping(Vector[] points, Vector[] rpoints) {
		int i;
		int j;
		boolean result = false;
		for (int n = 0; n < 4; n++) {
			result = false;
			for (i = 0, j = points.length - 1; i < points.length; j = i++) {
				if ((points[i].y > rpoints[n].y) != (points[j].y > rpoints[n].y) &&
						(rpoints[n].x < (points[j].x - points[i].x) * (rpoints[n].y - points[i].y) / (points[j].y - points[i].y) + points[i].x)) {
					result = !result;
				}
			}
			if (result == true) {
				return true;	//ends early so it doesn't have to check the rest
			}
		}
		return false;
	}
}