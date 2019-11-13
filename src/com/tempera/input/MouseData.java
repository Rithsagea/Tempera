package com.tempera.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseData implements MouseMotionListener {

	private static int mouseX = 0;
	private static int mouseY = 0;
	
	@Override
	public void mouseDragged(MouseEvent e) { }

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}
	
	public static int getX() {
		return mouseX;
	}
	
	public static int getY() {
		return mouseY;
	}

}
