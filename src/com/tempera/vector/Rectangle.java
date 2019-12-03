package com.tempera.vector;

public class Rectangle {
	//TODO https://gamedevelopment.tutsplus.com/tutorials/collision-detection-using-the-separating-axis-theorem--gamedev-169
	//use this for collision
	public double x;
	public double y;
	public double height;
	public double width;
	/**
	 * The rectangles rotation based on the top left point in radians
	 */
	public double angle;
	
	public Rectangle(double x, double y, double width, double height, double angle) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.angle = angle;
	}
	
	/**
	 * Checks whether 2 rectangles are intersecting
	 * 
	 * TODO optimize this god awful abomination
	 */
	public boolean isIntersecting(Rectangle r) {
		//get points of both rectangles
		double hw = width / 2;
		double hh = height / 2;
		Vector[] points = new Vector[] {
				new Vector(hw, hh),
				new Vector(-hw, hh),
				new Vector(-hw, -hh),
				new Vector(hw, -hh)};
		for (int i = 0; i < 4; i++) {
			points[i].addAngle(angle);
			points[i].add(x, y);	//starts polygon at origin, rotates, and back to x,y
		}
		hw = r.width / 2;
		hh = r.height / 2;
		Vector[] rpoints = new Vector[] {
				new Vector(hw, hh),
				new Vector(-hw, hh),
				new Vector(-hw, -hh),
				new Vector(hw, -hh)};
		for (int i = 0; i < 4; i++) {
			rpoints[i].addAngle(r.angle);
			rpoints[i].add(r.x, r.y);
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
		boolean result;
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