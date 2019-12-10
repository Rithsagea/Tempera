package com.tempera.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tempera.audio.Audio;
import com.tempera.entity.Player;
import com.tempera.graphics.Sprite;
import com.tempera.input.KeyboardData;
import com.tempera.input.MouseData;
import com.tempera.vector.Point;
import com.tempera.vector.Segment;
import com.tempera.vector.Vector;

public class GameWindow extends JFrame {

	private static final long serialVersionUID = -7296143310032123444L;
	private static final long accelerationRate = 300 / Main.frameRate;
	
	private static final Player player = new Player(new Vector(540, 360));
	private static final Sprite sprite = new Sprite("src/resources/frog.png");
	private static final Sprite hitbox = new Sprite("src/resources/background1.png");
	private static final Sprite backdrop = new Sprite("src/resources/dungeon.png");
	private static JLabel label;
	
	private static MouseData mouse = new MouseData();
	private static KeyboardData keyboard = new KeyboardData();
	private static Audio soundDemo = new Audio();
	
	public GameWindow() {
		super("Project Tempera");
		soundDemo.getSoundFile("songDemo.wav");
		soundDemo.volumeControl((float).1);
		soundDemo.playSound();
		soundDemo.loop(23000,-1);
		hitbox.resizeImage(100, 100);
		
		hitbox.x = 300;
		hitbox.y = 300;
		
		backdrop.resizeImage(1080, 720);
		
		backdrop.x = backdrop.width / 2;
		backdrop.y = backdrop.height / 2;
		
		sprite.setOffset(Math.PI / 2);
		
		//TODO replace this with Sprite
		JPanel panel = new JPanel() {
			private static final long serialVersionUID = -6064113046027500937L;

			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				backdrop.draw(g);
				hitbox.draw(g);
				sprite.draw(g);
				
				//Draw intersecting things
				Segment[] intersects = sprite.getIntersectingSegments(hitbox);
				
				for(int x = 0; x < intersects.length; x++) {
					Point A = intersects[x].getA();
					Point B = intersects[x].getB();
					
					g.setColor(Color.RED);
					g.drawLine((int)A.getX(), (int)A.getY(),
							   (int)B.getX(), (int)B.getY());
				}
			}
		};
		
		label = new JLabel("dummytext");
		label.setForeground(Color.white);
		
		pack();
		setSize(1080, 740);
		setVisible(true);
		
		addKeyListener(keyboard);
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
				//play sound demo
				soundDemo.getSoundFile("soundDemo.wav");
				soundDemo.volumeControl((float).1);
				soundDemo.playSound();
			}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
		});
		panel.add(label);
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
		
		//TODO move rectangle code to physics object
		if(sprite.isIntersecting(hitbox)) {
			//viscosity here
			Segment[] segments = sprite.getIntersectingSegments(hitbox);
			for(int x = 0; x < segments.length; x++) {
				Vector vec = new Vector(segments[x].getA(), segments[x].getB());
				vec = vec.addAngle(Math.toRadians(-90))
						.projection(player.velocity)
						.addAngle(Math.toRadians(180));
//				System.out.println("Hitbox: " + hitbox.getCenter());
//				System.out.println("Player: " + player.position);
//				System.out.println("Distance: " + player.position.distanceFrom(hitbox.getCenter()));
//				vec.setMagnitude(player.position.distanceFrom(hitbox.getCenter()));
				if(segments[x].getLength() == hitbox.width) { //hit top / bottom
					vec.setMagnitude(
							hitbox.height / 2 +
							hitbox.x - 
							player.position.getX());
				} else { //hit left / right
					vec.setMagnitude(
							hitbox.width / 2 +
							hitbox.y -
							player.position.getY());
				}
				System.out.println("Vec: " + vec);
				System.out.println("Vel: " + player.velocity);
				player.velocity.add(vec);
			}
//			player.velocity.multiply(-5);
			player.updatePosition();
			sprite.x = player.position.getX();
			sprite.y = player.position.getY();
		}
		
		label.setText(String.format("<html>Position: %s<br/>Velocity: %s<br/>Magnitude: %f<br/>Angle: %f<br/>TouchingBox: %b</html>",
				player.position,
				player.velocity,
				player.velocity.getMagnitude(),
				Math.toDegrees(player.velocity.getAngle()),
				sprite.isIntersecting(hitbox)));
		player.updatePosition();
	}
	
	public static void moveAcceleration() {
		if(KeyboardData.isKeyPressed(KeyEvent.VK_LEFT))
			player.velocity.addAngle(-1);
		if(KeyboardData.isKeyPressed(KeyEvent.VK_RIGHT))
			player.velocity.addAngle(1);
		if(KeyboardData.isKeyPressed(KeyEvent.VK_UP))
			player.velocity.addAngle(1);
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
	}
}
