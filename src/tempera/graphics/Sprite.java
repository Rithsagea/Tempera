package tempera.graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite implements RenderedObject {
	
	private int renderLevel;
	private int drawLevel;
	
	private Image image;
	private Image display;
	
	private int width;
	private int length;
	
	private int x;
	private int y;
	
	public boolean isHidden = false;
	
	public Sprite(int renderLevel, int drawLevel, Image image) {
		this.renderLevel = renderLevel;
		this.drawLevel = drawLevel;
		
		this.image = image;
		
		length = image.getWidth(null);
		width = image.getHeight(null);
		
		display = image;
	}
	
	public Sprite(Image image) {
		this(0, 0, image);
	}
	
	public Sprite(int renderLevel, int drawLevel, int length, int width, Image image) {
		this(renderLevel, drawLevel, image);
		
		resizeImage(length, width);
	}
	
	public String toString() {
		return String.format("(%d, %d) %d x %d", x, y, width, length);
	}
	
	public void resizeImage(int length, int width) {
		this.length = length;
		this.width = width;
		
		display = image.getScaledInstance(length, width, 0);
	}
	
	/**
	 * Sets the image for this sprite
	 * 
	 * @param filePath	The file which contains the image for this sprite
	 */
	public void setImage(String filePath) {
		try {
			image = ImageIO.read(new File(filePath));
		} catch (IOException e) {
			System.out.println(filePath + " could not be found.");
		}
		
		length = image.getWidth(null);
		width = image.getHeight(null);
		
		display = image;
	}
	
	//Getters for dimensions
	public int getLength() {
		return length;
	}
	
	public int getWidth() {
		return width;
	}
	
	//Setters and Getters for the center
	public int getX() {
		return x - length / 2;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y + width / 2;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setHidden(boolean hidden) {
		isHidden = hidden;
	}
	
	/**
	 * Draws this sprite on a graphics object
	 * 
	 * TODO make it not resize the image each time it gets drawn
	 */
	public void draw(Graphics2D g2d) {
		if(isHidden)
			return;
		AffineTransform original = g2d.getTransform();
		
		AffineTransform position = new AffineTransform();
		
		position.concatenate(original);
		position.translate(getX(), -getY());
		
		g2d.setTransform(position);
		
		g2d.drawImage(display, 0, 0, null);
		g2d.setTransform(original);
//		g2d.drawRect(0, 0, (int)width, (int)height);	//change back
//		transformation.setToIdentity();
//		g2d.setTransform(transformation);
	}
	
	//TODO add something for these
	@Override
	public int getRenderLevel() {
		return renderLevel;
	}

	@Override
	public int getDrawLevel() {
		return drawLevel;
	}
}
