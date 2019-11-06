package com.tempera.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tempera.entity.Player;
import com.tempera.graphics.Sprite;
import com.tempera.keyboard.KeyboardData;
import com.tempera.vector.Vector;

public class GameWindow extends JFrame {

	private static final long serialVersionUID = -7296143310032123444L;
	private static final long accelerationRate = 3;
	
	private static final Player player = new Player(new Vector(540, 360));
	private static final Sprite sprite = new Sprite("src/resources/frog.png");
	private static JLabel label;
	
	public GameWindow() {
		super("Project Tempera");
		
		//TODO replace this with Sprite
		JPanel panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				sprite.draw(g);
			}
		};
		
		label = new JLabel("dummytext");
		
		pack();
		setSize(1080, 720);
		setVisible(true);
		
		addKeyListener(new KeyboardData());
		panel.add(label);
		add(panel);
	}
	
	public static void tick() {
		//movement
		//check keys
		if(KeyboardData.isKeyPressed(KeyEvent.VK_UP))
			player.velocity.add(0, -accelerationRate);
		if(KeyboardData.isKeyPressed(KeyEvent.VK_DOWN)) 
			player.velocity.add(0, accelerationRate);
		if(KeyboardData.isKeyPressed(KeyEvent.VK_LEFT))
			player.velocity.add(-accelerationRate, 0);
		if(KeyboardData.isKeyPressed(KeyEvent.VK_RIGHT)) 
			player.velocity.add(accelerationRate, 0);
		player.updatePosition();
		sprite.x = player.position.x;
		sprite.y = player.position.y;
		label.setText(String.format("<html>Position: %s<br/>Velocity: %s</html>", player.position, player.velocity));
	}
}
