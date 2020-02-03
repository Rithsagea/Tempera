package tempera.resource;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class ImageRegistry {
	private static ImageRegistry instance = new ImageRegistry();
	
	public static ImageRegistry getInstance() {
		return instance;
	}
	
	private Map<String, BufferedImage> imageResources;
	
	private ImageRegistry() {
		imageResources = new HashMap<>();
	}
	
	public BufferedImage getResource(String key) {
		return imageResources.get(key);
	}
	
	public void registerResource(String key, BufferedImage image) {
		if(imageResources.containsKey(key)) throw new RuntimeException("Resource " + key + " has already been registered");
		imageResources.put(key, image);
	}
	
	public void registerResource(String key, BufferedImage image, boolean override) {
		if(override)	imageResources.put(key, image);
		else			registerResource(key, image);
	}
}
