package test.tempera.geometry;

import tempera.geometry.BoundingBox;
import tempera.geometry.Point;
import tempera.geometry.Vector;

public class BoundingBoxTest {
	public static void main(String[] args) {
		BoundingBox box = new BoundingBox(0, 10, 10, 10);
		Vector shift = new Vector(new Point(-5, -5));
		
		System.out.println("Original");
		for(Point p : box.getPoints())
			System.out.println(p);
		
		box = box.clone();
		
		System.out.println("Cloned");
		for(Point p : box.getPoints())
			System.out.println(p);
		
		box.getCenter().shift(shift);
		System.out.println("Shifted " + shift);
		
		for(Point p : box.getPoints())
			System.out.println(p);
		
	}
}
