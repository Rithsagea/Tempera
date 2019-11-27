package com.tempera.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.tempera.vector.Rectangle;

public class Sprite extends Rectangle implements RenderedObject {
	
	protected Image image;
	protected double angleOffset;
	
	protected int imageHeight;
	protected int imageWidth;
	
	public Sprite(String filePath) {
		super(0, 0, 0, 0, 0);
		setImage(filePath);
	}
	
	public void setOffset(double offset) {
		angleOffset = offset;
	}
	
	/**
	 * Sets the image for this sprite
	 * @param filePath	The file which contains the image for this sprite
	 */
	public void setImage(String filePath) {
		try {
			image = ImageIO.read(new File(filePath));
		} catch (IOException e) {
			System.out.println(filePath + " could not be found.");
		}
		imageWidth = image.getWidth(null);
		imageHeight = image.getHeight(null);
		
		width = imageWidth;
		height = imageHeight;
//		System.out.format("(%.2f, %.2f)\n", width, height);
	}
	
	/**
	 * Draws this sprite on a graphics object
	 * 
	 * TODO make it not resize the image each time it gets drawn
	 */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		AffineTransform rotation = new AffineTransform();
		AffineTransform translation = new AffineTransform();
		AffineTransform position = new AffineTransform();
		
		position.translate(x, y);
		rotation.scale(width / imageWidth, height / imageHeight);
		rotation.rotate(angle + angleOffset);
		
		translation.concatenate(rotation);
		translation.translate(-width / 2, -height / 2);
		
		position.concatenate(translation);
		
		
		g2d.setTransform(position);
		g2d.drawImage(image, 0, 0, null);
		g2d.drawRect(0, 0, (int)width, (int)height);	//change back
		
		position.setToIdentity();
		g2d.setTransform(position);
	}
}
