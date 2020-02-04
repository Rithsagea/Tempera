package test.tempera.geometry;

import api.tempera.geometry.Vector;

public class NegativeMagnitudeTest {
	public static void main(String[] args) {
		Vector vec = new Vector(5, 4);
		
		System.out.println(vec);
		
		vec = vec.inverse();
		
		System.out.println(vec);
	}
}
