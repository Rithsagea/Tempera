package test.tempera.resource;

import java.io.IOException;

import javax.sound.sampled.Clip;

import tempera.resource.AudioResource;
import tempera.resource.ImageResource;
import tempera.resource.ResourceRegistry;

public class ResourceTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		ResourceRegistry registry = new ResourceRegistry("src/resources/");
		ImageResource sans = new ImageResource("sans.png", "sans");
		ImageResource bg1 = new ImageResource("background1.png", "bg1");
		ImageResource bg2 = new ImageResource("background2.png", "bg2");
		
		AudioResource sd1 = new AudioResource("songDemo.wav", "song1");
		AudioResource sd2 = new AudioResource("songdemo2.wav", "song2");
		
		registry.registerResource(sans);
		registry.registerResource(bg1);
		registry.registerResource(bg2);
		
		registry.registerResource(sd1);
		registry.registerResource(sd2);
		
		registry.printResources();
		
		Clip clip = sd1.getResource();
		
		while(true) {
			Thread.sleep(1000);
			clip.start();
		}
	}
}
