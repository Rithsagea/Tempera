package com.tempera.game;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.tempera.keyboard.KeyboardData;
import com.tempera.vector.Rectangle;

public class GameWindow extends JFrame {

	private static final long serialVersionUID = -7296143310032123444L;
	private static Rectangle rect1 = new Rectangle(540, 360, 100, 100);
	private static Rectangle rect2 = new Rectangle(560, 380, 400, 50);
	
	public GameWindow() {
		super("Project Tempera");
		
		//TODO replace this with Sprite
		JPanel panel = new JPanel() {
			
			private ImageIcon image1 = new ImageIcon("src/resources/background1.png");
			private ImageIcon image2 = new ImageIcon("src/resources/background2.png");
			
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(image1.getImage(), (int)rect1.x, (int)rect1.y, (int)rect1.length, (int)rect1.width, null);
				g.drawImage(image2.getImage(), (int)rect2.x, (int)rect2.y, (int)rect2.length, (int)rect2.width, null);
				System.out.println(rect1.isIntersecting(rect2));
			}
		};
		
		pack();
		setSize(1080, 720);
		setVisible(true);
		
		addKeyListener(new KeyboardData());
		add(panel);
	}
	
	public static void tick() {
		/*
		Vector velocity = player.getVelocity();
		
		//movement
		//check keys
		if(KeyboardData.isKeyPressed(KeyEvent.VK_UP))
			velocity.y = (Math.min(velocity.y * player.getAcceleration(), -0.5));
		if(KeyboardData.isKeyPressed(KeyEvent.VK_DOWN)) 
			velocity.y = (Math.max(velocity.y * player.getAcceleration(), 0.5));
		if(KeyboardData.isKeyPressed(KeyEvent.VK_LEFT))
			velocity.x = (Math.min(velocity.x * player.getAcceleration(), -0.5));
		if(KeyboardData.isKeyPressed(KeyEvent.VK_RIGHT)) 
			velocity.x = (Math.max(velocity.x * player.getAcceleration(), 0.5));
		//add friction (remember, negative)
		velocity.x = (velocity.x * 0.90);
		velocity.y = (velocity.y * 0.90);
		//cap velocity here
		velocity.y = (MathUtils.clamp(velocity.y, -5, 5));
		velocity.x = (MathUtils.clamp(velocity.x, -5, 5));
		
		player.updatePosition();
		*/
	}
}
