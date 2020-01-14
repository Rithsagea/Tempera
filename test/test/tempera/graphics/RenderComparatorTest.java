package test.tempera.graphics;

import java.util.Random;

import tempera.graphics.RenderEngine;

public class RenderComparatorTest {
	public static void main(String[] args) {
		RenderEngine engine = new RenderEngine();
		
		Random rand = new Random();
		
		for(int x = 0; x < 1000; x++) {
			engine.addObject(new TestRender(rand.nextInt(10), rand.nextInt(128)));
		}
		
		engine.printObjects();
	}
}
