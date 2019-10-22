package com.tempera.game;

import javax.swing.JFrame;

public class GameWindow {
	
	public JFrame frame;
	
	public GameWindow() {
		frame = new JFrame("Project Tempera");
		
		frame.setSize(1080, 720);
		frame.setVisible(true);
		frame.setLayout(null);
	}
	
	public void runTick() {
		frame.repaint();
	}
}
