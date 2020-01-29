package tempera.resource;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageResource implements TemperaResource<BufferedImage> {
	
	protected File file;
	protected BufferedImage image;
	protected String name;
	
	public ImageResource(File file, String name) {
		this.file = file;
		this.name = name;
		
		loadResource();
	}
	
	public ImageResource(String path, String name) {
		this(new File(path), name);
	}
	
	public ImageResource(File file) throws IOException {
		this(file, file.getCanonicalPath());
	}
	
	public ImageResource(String path) throws IOException {
		this(new File(path));
	}

	public void loadResource() {
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getResource() {
		if(image == null)
			loadResource();
		return image;
	}
	
	public String getName() {
		return name;
	}
}
