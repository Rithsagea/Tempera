package com.tempera.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.tempera.util.TransformUtil;
import com.tempera.vector.Rectangle;

public class Sprite extends Rectangle implements RenderedObject {
	
	protected Image image;
	protected double angleOffset;
	
	public int imageHeight;
	public int imageWidth;
	
	public Sprite(String filePath) {
		super(0, 0, 0, 0);
		setImage(filePath);
	}
	
	public void setOffset(double offset) {
		angleOffset = offset;
	}
	
	/**
	 * Sets the image for this sprite
	 * 
	 * TODO add arguments for resizing the image
	 * TODO save the image in a form that doesn't require resizing
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
	
	public void resizeImage(int scaledWidth, int scaledHeight) {
		width = scaledWidth;
		height = scaledHeight;
		image = image.getScaledInstance(scaledWidth, scaledHeight, 0);
	}
	
	/**
	 * Draws this sprite on a graphics object
	 * 
	 * TODO make it not resize the image each time it gets drawn
	 */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;

		AffineTransform transformation = TransformUtil.getTransformation(this, angleOffset + angle);
		
		g2d.setTransform(transformation);
		g2d.drawImage(image, 0, 0, null);
//		g2d.drawRect(0, 0, (int)width, (int)height);	//change back
		transformation.setToIdentity();
		g2d.setTransform(transformation);
	}
}
