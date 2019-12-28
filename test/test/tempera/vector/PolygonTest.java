package test.tempera.vector;

import tempera.vector.Point;
import tempera.vector.Polygon;
import tempera.vector.Rectangle;

public class PolygonTest {
	public static void main(String[] args) {
		Rectangle rect1 = new Rectangle(0, 0, 400, 400);
		Rectangle rect2 = new Rectangle(300000, -300000, 100, 100);
		
		System.out.println("Rectangle 1");
		for(Point p : rect1.getPoints()) {
			System.out.println(p);
		}
		
		System.out.println("Rectangle 2");
		for(Point p : rect2.getPoints()) {
			System.out.println(p);
		}
		
		System.out.println("Intersection");
		
		System.out.println(Polygon.isIntersecting(rect1, rect2));
	}
}
