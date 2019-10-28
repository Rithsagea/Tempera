package com.tempera.game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.tempera.entity.Player;
import com.tempera.vector.Vector;

public class GameWindow extends JFrame implements KeyListener {

	private static final long serialVersionUID = -7296143310032123444L;
	private static Player player = new Player(new Vector(1080 / 2, 720 / 2, 0));
	
	
	public GameWindow() {
		super("Project Tempera");
		
		JPanel panel = new JPanel() {
			
			private ImageIcon image = new ImageIcon("src/resources/sans.png");
			
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Vector pos = player.getPosition();
				g.drawImage(image.getImage(), (int) pos.getX(), (int) pos.getY(), null);
			}
		};
		
		pack();
		setSize(1080, 720);
		setVisible(true);
		
		addKeyListener(this);
		add(panel);
	}
	
	@Override
	public void keyTyped(KeyEvent e) { }

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_D) player.getPosition().add(5, 0, 0);
		if(key == KeyEvent.VK_A) player.getPosition().add(-5, 0, 0);
		if(key == KeyEvent.VK_W) player.getPosition().add(0, 5, 0);
		if(key == KeyEvent.VK_S) player.getPosition().add(0, -5, 0);
	}

	@Override
	public void keyReleased(KeyEvent e) { }

}
