package test.tempera.resource;

import java.awt.image.BufferedImage;

import tempera.resource.ImageResource;
import tempera.resource.TemperaResource;

public class ResourceTest {
	public static void main(String[] args) {
		TemperaResource<BufferedImage> resource = new ImageResource("resources/sans.png");
		
		resource.loadResource();
		
		BufferedImage image = resource.getResource();
		
		System.out.println(image.getWidth());
		System.out.println(image.getHeight());
		
		
	}
}
