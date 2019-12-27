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
import com.tempera.vector.Polygon;
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
//		soundDemo.getSoundFile("songDemo.wav");
//		soundDemo.volumeControl((float).1,soundDemo.clip);
//		soundDemo.playSound(soundDemo.clip);
//		soundDemo.loop(0.5,-1,soundDemo.clip)
		
		//add songs to queue
		soundDemo.queueAddToBottom("songDemo.wav");
		soundDemo.queueAddToBottom("songdemo2.wav");
		soundDemo.volumeControl((float).3, soundDemo.getPlayingSong());
		soundDemo.playSound(soundDemo.getPlayingSong());
		
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
				soundDemo.volumeControl((float).2,soundDemo.clip);
				soundDemo.playSound(soundDemo.clip);
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
		//move to next song once head clip is not active
		if (soundDemo.getQueuedSongs() > 0) {
			if (!soundDemo.isPlaying()) {
				soundDemo.queuePoll();
				soundDemo.volumeControl((float).3, soundDemo.getPlayingSong());
				soundDemo.playSound(soundDemo.getPlayingSong());
			}
		}
		//movement
//		moveAcceleration();
		moveCardinal();
		player.velocity.calculatePolar();
		
		sprite.angle = player.velocity.getAngle();
		
		sprite.x = player.position.getX();
		sprite.y = player.position.getY();
		
		label.setText(String.format("<html>Position: %s<br/>Velocity: %s<br/>Magnitude: %f<br/>Angle: %f<br/>Intersecting: %b</html>",
				player.position,
				player.velocity,
				player.velocity.getMagnitude(),
				Math.toDegrees(player.velocity.getAngle()),
				Polygon.isIntersecting(sprite, hitbox)
				));
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
