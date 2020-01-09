package test.tempera.geometry;

import tempera.geometry.Point;
import tempera.geometry.Vector;

public class CoordinateConversionTest {
	public static void main(String[] args) {
		Point p = new Point(3, 4);
		
		Vector v = new Vector(p);
		
		System.out.println(p);
		System.out.println(v);
		System.out.println(new Point(v));
		System.out.println(new Vector(new Point(new Vector(new Point(v)))));
	}
}
