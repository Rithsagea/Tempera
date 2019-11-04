package com.tempera.game;

import java.awt.event.KeyEvent;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.tempera.entity.Player;
import com.tempera.keyboard.KeyboardData;
import com.tempera.util.MathUtils;
import com.tempera.vector.Vector;

public class GameWindow extends JFrame {

	private static final long serialVersionUID = -7296143310032123444L;
	private static Player player = new Player(new Vector(1080 / 2, 720 / 2, 0));
	
	public GameWindow() {
		super("Project Tempera");
		
		//TODO replace this with Sprite
		JPanel panel = new JPanel() {
			
			private ImageIcon image = new ImageIcon("src/resources/frog.png");
			
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Vector pos = player.getPosition();
				g.drawImage(image.getImage(), (int) pos.x, (int) pos.y, null);
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
	}
}
