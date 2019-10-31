package com.tempera.game;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.glass.events.KeyEvent;
import com.tempera.entity.Player;
import com.tempera.keyboard.KeyboardData;
import com.tempera.util.MathUtils;
import com.tempera.vector.Vector;

public class GameWindow extends JFrame {

	private static final long serialVersionUID = -7296143310032123444L;
	private static Player player = new Player(new Vector(1080 / 2, 720 / 2, 0));
	
	public GameWindow() {
		super("Project Tempera");
		
		JPanel panel = new JPanel() {
			
			private ImageIcon image = new ImageIcon("src/resources/frog.png");
			
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
		
		addKeyListener(new KeyboardData());
		add(panel);
	}
	
	public static void tick() {
		Vector velocity = player.getVelocity();
		
		//movement
		//check keys
		if(KeyboardData.isKeyPressed(KeyEvent.VK_UP))
			velocity.setY(Math.min(velocity.getY() * player.getAcceleration(), -0.5));
		if(KeyboardData.isKeyPressed(KeyEvent.VK_DOWN)) 
			velocity.setY(Math.max(velocity.getY() * player.getAcceleration(), 0.5));
		if(KeyboardData.isKeyPressed(KeyEvent.VK_LEFT))
			velocity.setX(Math.min(velocity.getX() * player.getAcceleration(), -0.5));
		if(KeyboardData.isKeyPressed(KeyEvent.VK_RIGHT)) 
			velocity.setX(Math.max(velocity.getX() * player.getAcceleration(), 0.5));
		//add friction (remember, negative)
		velocity.setX(velocity.getX() * 0.90);
		velocity.setY(velocity.getY() * 0.90);
		//cap velocity here
		velocity.setY(MathUtils.clamp(velocity.getY(), -5, 5));
		velocity.setX(MathUtils.clamp(velocity.getX(), -5, 5));
		
		player.updatePosition();
	}
}
