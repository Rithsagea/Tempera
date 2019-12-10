package com.tempera.vector;

import java.util.ArrayList;
import java.util.List;

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
	
	public Point getCenter() {
		return new Point(x, y);
	}
	
	/**
	 * Gets the end-points of this rectangle from top left clockwise
	 * @return	the end-points of this rectangle
	 */
	public Point[] getPoints() {
		double hw = width / 2;
		double hh = height / 2;
		
		return new Point[] {
			new Point(x - hw, y - hh),
			new Point(x + hw, y - hh),
			new Point(x + hw, y + hh),
			new Point(x - hw, y + hh)
		};
	}
	
	/**
	 * Get the line segments that make up this rectangle from top segment clockwise
	 * @return	all the segments of this rectangle in order
	 */
	public Segment[] getSegments() {
		Point[] points = getPoints();
		return new Segment[] {
			new Segment(points[0], points[1]),
			new Segment(points[1], points[2]),
			new Segment(points[2], points[3]),
			new Segment(points[3], points[0])
		};
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
			points[i]
				.addAngle(angle)
				.add(x, y);	//starts polygon at origin, rotates, and back to x,y
		}
		
		hw = r.width / 2;
		hh = r.height / 2;
		Vector[] rpoints = new Vector[] {
				new Vector(hw, hh),
				new Vector(-hw, hh),
				new Vector(-hw, -hh),
				new Vector(hw, -hh)};
		for (int i = 0; i < 4; i++) {
			rpoints[i]
				.addAngle(r.angle)
				.add(r.x, r.y);
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
	
	public Segment[] getIntersectingSegments(Rectangle r) {
		Segment[] sides = getSegments();
		Segment[] rsides = r.getSegments();
		List<Segment> intersects = new ArrayList<Segment>();
		
		for(int j = 0; j < rsides.length; j++) { //loop through all segments in this rect
			for(int i = 0; i < sides.length; i++) { //loop through all segs in r
				if(sides[i].intersects(rsides[j])) { //check if the 2 segs intersect
					intersects.add(rsides[j]); //if they do, add them to the list
					break;					  //well if it intersects, doesn't matter for the rest
				}
			}
		}
		Segment[] re = new Segment[intersects.size()];
		intersects.toArray(re);
		return re;
	}
}