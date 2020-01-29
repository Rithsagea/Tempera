package test.tempera.resource;

import java.io.IOException;

import tempera.resource.AudioResource;
import tempera.resource.ImageResource;
import tempera.resource.ResourceRegistry;

public class ResourceTest {
	public static void main(String[] args) throws IOException {
		
		ResourceRegistry registry = new ResourceRegistry();
		ImageResource sans = new ImageResource("src/resources/sans.png");
		ImageResource bg1 = new ImageResource("src/resources/background1.png");
		ImageResource bg2 = new ImageResource("src/resources/background2.png");
		
		AudioResource sd1 = new AudioResource("src/resources/songDemo.wav");
		AudioResource sd2 = new AudioResource("src/resources/songdemo2.wav");
		
		registry.registerResource(sans);
		registry.registerResource(bg1);
		registry.registerResource(bg2);
		
		registry.registerResource(sd1);
		registry.registerResource(sd2);
		
		registry.printResources();
	}
}
