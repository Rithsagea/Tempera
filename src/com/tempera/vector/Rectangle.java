package com.tempera.vector;

import java.awt.Polygon;
import java.awt.geom.Area;

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
		double[] xPoints = new double[] {x, 
				x + height * Math.cos(angle - Math.PI / 4), 
				x + height * (Math.cos(angle) - Math.cos(angle - Math.PI / 2)), 
				x + height * Math.cos(angle)};
		double[] yPoints = new double[] {y, 
				y + height * Math.sin(angle - Math.PI / 4), 
				y + height * (Math.sin(angle) - Math.sin(angle - Math.PI / 2)),
				y + height * Math.sin(angle)};
		double[] rxPoints = new double[] {r.x, 
				r.x + r.height * Math.cos(r.angle - Math.PI / 4), 
				r.x + r.height * (Math.cos(r.angle) - Math.cos(r.angle - Math.PI / 2)), 
				r.x + r.height * Math.cos(r.angle)};
		double[] ryPoints = new double[] {y, 
				r.y + r.height * Math.sin(r.angle - Math.PI / 4), 
				r.y + r.height * (Math.sin(r.angle) - Math.sin(r.angle - Math.PI / 2)),
				r.y + r.height * Math.sin(r.angle)};
		
		//check if vertices of other rectangle are in this one
		for (int i = 0; i < 4; i++)
		{
			if (contains(rxPoints[i], ryPoints[i], xPoints, yPoints))
			{
				return true;
			}
		}
		
		//check if vertices of this rectangle are in the other one
		for (int i = 0; i < 4; i++)
		{
			if (contains(xPoints[i], yPoints[i], rxPoints, ryPoints))
			{
				return true;
			}
		}
		
		return false;
	}
	
	/*
	 * to make life easier, taken from
	 * https://web.archive.org/web/20161108113341/https://www.ecse.rpi.edu/Homepages/wrf/Research/Short_Notes/pnpoly.html
	 */
	private boolean contains(double x, double y, double[] xPoints, double[] yPoints) {
		int i;
		int j;
		boolean result = false;
		for (i = 0, j = 3; i < 4; j = i++) {
			if ((yPoints[i] > y) != (yPoints[j] > y) &&
					(x < (xPoints[j] - xPoints[i]) * (y - yPoints[i]) / (yPoints[j] - yPoints[i]) + xPoints[i])) {
				result = !result;
			}
		}
		return result;
	}
}