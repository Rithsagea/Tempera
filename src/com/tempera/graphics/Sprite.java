package com.tempera.graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.tempera.vector.Rectangle;

public class Sprite extends Rectangle {
	
	protected Image image;
	
	public Sprite(String filePath) {
		super(0, 0, 0, 0, 0);
		setImage(filePath);
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
		width = image.getWidth(null);
		height = image.getHeight(null);
		System.out.format("(%.2f, %.2f)", width, height);
	}
	
	/**
	 * Draws this sprite on a graphics object
	 * 
	 * TODO make it not resize the image each time it gets drawn
	 */
	public void draw(Graphics g) {
		g.drawImage(image, (int)x, (int)y, (int)width, (int)height, null);
	}
}
