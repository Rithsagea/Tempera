package com.rithsagea.test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel {
	
	private ImageIcon icon;
	private Point mouse;
	
	public Board() {
		setBackground(Color.black);
		setFocusable(true);
		icon = new ImageIcon("src/resources/sans.png");
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		mouse = getMousePosition();
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(icon.getImage(), mouse.x, mouse.y, this);
	}
}
