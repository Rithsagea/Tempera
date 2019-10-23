package com.tempera.game;

import javax.swing.JFrame;

public class GameWindow {
	
	private JFrame frame;
	private WorldDisplay worldDisplay;
	
	public GameWindow() {
		frame = new JFrame("Project Tempera");
		worldDisplay = new WorldDisplay();
		
		frame.setSize(1080, 720);
		frame.setVisible(true);
		frame.setLayout(null);
	}
	
	public void runTick() {
		worldDisplay.tick();
		frame.repaint();
	}
}
