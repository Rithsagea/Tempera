package com.tempera.game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tempera.entity.Player;
import com.tempera.graphics.Sprite;
import com.tempera.input.KeyboardData;
import com.tempera.input.MouseData;
import com.tempera.vector.Vector;

public class GameWindow extends JFrame {

	private static final long serialVersionUID = -7296143310032123444L;
	private static final long accelerationRate = 3;
	
	private static final Player player = new Player(new Vector(540, 360));
	private static final Sprite sprite = new Sprite("src/resources/frog.png");
	private static final Sprite hitbox = new Sprite("src/resources/background1.png");
	private static JLabel label;
	
	private static MouseData mouse = new MouseData();
	private static KeyboardData keyboard = new KeyboardData();
	
	public GameWindow() {
		super("Project Tempera");
		
		hitbox.x = 752/2;
		hitbox.y = 407/2;
		
		sprite.setOffset(Math.PI / 2);
		
		//TODO replace this with Sprite
		JPanel panel = new JPanel() {
			private static final long serialVersionUID = -6064113046027500937L;

			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				hitbox.draw(g);
				sprite.draw(g);
			}
		};
		
		label = new JLabel("dummytext");
		
		pack();
		setSize(1080, 720);
		setVisible(true);
		
		addKeyListener(keyboard);
		panel.add(label);
		panel.addMouseMotionListener(mouse);
		//TODO add some event handler for keyboard and mouse
		panel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {
				//TODO this is so bad. Make readable
				Vector vector = new Vector(MouseData.getX(), MouseData.getY());
				vector.subtract(player.position);
				vector.calculatePolar();
				vector.setMagnitude(100);
				player.velocity.add(vector);
			}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
		});
		add(panel);
	}
	
	public static void tick() {
		//movement
//		moveAcceleration();
		moveCardinal();
		player.velocity.calculatePolar();
		
		sprite.angle = player.velocity.getAngle();
		
		sprite.x = player.position.getX();
		sprite.y = player.position.getY();
		
		label.setText(String.format("<html>Position: %s<br/>Velocity: %s<br/>Magnitude: %f<br/>Angle: %f<br/>TouchingBox: %b</html>",
				player.position,
				player.velocity,
				player.velocity.getMagnitude(),
				Math.toDegrees(player.velocity.getAngle()),
				sprite.isIntersecting(hitbox)));
	}
	
	public static void moveAcceleration() {
		if(KeyboardData.isKeyPressed(KeyEvent.VK_LEFT))
			player.velocity.addAngle(-1);
		if(KeyboardData.isKeyPressed(KeyEvent.VK_RIGHT))
			player.velocity.addAngle(1);
		if(KeyboardData.isKeyPressed(KeyEvent.VK_UP))
			player.velocity.addAngle(1);
		player.updatePosition();
	}
	
	public static void moveCardinal() {
		if(KeyboardData.isKeyPressed(KeyEvent.VK_UP))
			player.velocity.add(0, -accelerationRate);
		if(KeyboardData.isKeyPressed(KeyEvent.VK_DOWN)) 
			player.velocity.add(0, accelerationRate);
		if(KeyboardData.isKeyPressed(KeyEvent.VK_LEFT))
			player.velocity.add(-accelerationRate, 0);
		if(KeyboardData.isKeyPressed(KeyEvent.VK_RIGHT)) 
			player.velocity.add(accelerationRate, 0);
		player.updatePosition();
	}
}
