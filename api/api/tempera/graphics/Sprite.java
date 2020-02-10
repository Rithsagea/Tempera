package api.tempera.graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import api.tempera.geometry.Point;

public class Sprite implements RenderedObject {
	
	private int renderLevel;
	private int drawLevel;
	
	private Image image;
	private Image display;
	
	private int width;
	private int length;
	
	private int halfLength;
	private int halfWidth;
	
	private Point center;
	
	public boolean isHidden = false;
	
	public Sprite(int renderLevel, int drawLevel, Image image) {
		this.renderLevel = renderLevel;
		this.drawLevel = drawLevel;
		
		this.image = image;
		
		length = image.getWidth(null);
		width = image.getHeight(null);
		
		halfLength = length / 2;
		halfWidth = width / 2;
		
		center = new Point();
		
		display = image;
	}
	
	public Sprite(Image image) {
		this(0, 0, image);
	}
	
	public Sprite(int renderLevel, int drawLevel, int length, int width, Image image) {
		this(renderLevel, drawLevel, image);
		
		resizeImage(length, width);
	}
	
	public Sprite() {
		this.renderLevel = 0;
		this.drawLevel = 0;
		
		length = 0;
		width = 0;
		
		halfLength = 0;
		halfWidth = 0;
		center = new Point();
		display = null;
	}

	public String toString() {
		return String.format("(%f, %f) %d x %d", center.getX(), center.getY(), width, length);
	}
	
	public void resizeImage(int length, int width) {
		this.length = length;
		this.width = width;
		
		halfLength = length / 2;
		halfWidth = width / 2;
		
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
		return (int) center.getX();
	}
	
	public void setX(int x) {
		center.setX(x);
	}
	
	public int getY() {
		return (int) center.getY();
	}
	
	public void setY(int y) {
		center.setY(y);
	}
	
	public void setHidden(boolean hidden) {
		isHidden = hidden;
	}
	
	public void bind(Point center) {
		this.center = center;
	}
	
	/**
	 * Draws this sprite on a graphics object
	 */
	public void draw(Graphics2D g2d) {
		if(isHidden)
			return;
		AffineTransform original = g2d.getTransform();
		
		AffineTransform position = new AffineTransform();
		
		position.concatenate(original);
		position.translate(center.getX() - halfLength, -center.getY() - halfWidth);
		
		g2d.setTransform(position);
		
		g2d.drawImage(display, 0, 0, null);
		g2d.setTransform(original);
	}
	
	@Override
	public int getRenderLevel() {
		return renderLevel;
	}

	@Override
	public int getDrawLevel() {
		return drawLevel;
	}
}
