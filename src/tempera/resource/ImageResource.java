package tempera.resource;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageResource implements TemperaResource<BufferedImage> {
	
	protected File file;
	protected BufferedImage image;
	
	public ImageResource(File file) {
		this.file = file;
	}
	
	public ImageResource(String path) {
		this(new File(path));
	}

	@Override
	public void loadResource() {
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public File getFile() {
		return file;
	}
	
	public BufferedImage getResource() {
		if(image == null)
			loadResource();
		return image;
	}
}
