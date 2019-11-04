package com.tempera.graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Sprite {
	
	protected Image image;
	
	public Sprite(String filePath) {
		setImage(filePath);
	}
	
	/**
	 * Sets the image for this sprite
	 * @param filePath	The file which contains the image for this sprite
	 */
	public void setImage(String filePath) {
		Toolkit t = Toolkit.getDefaultToolkit();
		image = t.getImage(filePath);
	}
	
	/**
	 * Draws this sprite on a graphics object
	 * @param g	The graphics object to draw this sprite on
	 * @param x	The x coord of the top left corner
	 * @param y	The y coord of the top left corner
	 * @param w	The width for the sprite to be resized by
	 * @param l	The length for the sprite to be resized by
	 * 
	 * TODO make it not resize the image each time it gets drawn
	 */
	public void draw(Graphics g, int x, int y, int w, int l) {
		g.drawImage(image, x, y, w, l, null);
	}
}
