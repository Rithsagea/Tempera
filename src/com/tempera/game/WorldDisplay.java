package com.tempera.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.tempera.entity.Player;
import com.tempera.vector.Vector;

public class WorldDisplay extends JPanel {
	
	public class Keyboard extends KeyAdapter {
		
		private static final int KEYBIND_LEFT = KeyEvent.VK_LEFT;
		private static final int KEYBIND_RIGHT = KeyEvent.VK_RIGHT;
		
		@Override
		public void keyPressed(KeyEvent event) {
			Vector velocity = new Vector(0, 0, 0);
			switch(event.getKeyCode()) {
			case KEYBIND_LEFT:
				velocity.add(-1, 0, 0);
				break;
			case KEYBIND_RIGHT:
				velocity.add(1, 0, 0);
				break;
			default:
				break;
			}
		}
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -958588972270744073L;
	private static Player player = new Player(new Vector(1080 / 2, 0, 720 / 2));
	
	private ImageIcon icon;
	
	public WorldDisplay() {
		setBackground(Color.black);
		setFocusable(true);
		icon = new ImageIcon("src/resources/sans.png");
	}
	
	public void tick() {
		player.updatePosition();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Vector pos = player.getPosition();
		g2d.drawImage(icon.getImage(), (int) pos.getX(), (int) pos.getY(), this);
	}
}
