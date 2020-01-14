package tempera.util;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FileUtil {
	public static Image readImageFile(String path) {
		Image image = null;
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.err.println("The image at " + path + " does not exist");
		}
		
		return image;
	}
}
