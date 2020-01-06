package tempera.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tempera.audio.Audio;
import tempera.event.EventBus;
import tempera.events.MousePressedEvent;
import tempera.graphics.Sprite;
import tempera.input.KeyboardData;
import tempera.input.MouseData;
import tempera.listeners.KeyboardListener;
import tempera.vector.Polygon;
import tempera.vector.Rectangle;

public class GameWindow extends JFrame {

	private static final long serialVersionUID = -7296143310032123444L;
	private final long accelerationRate = 300 / Main.frameRate;
	
	private final Sprite sprite = new Sprite(new Rectangle(0, 0, 100, 100), "src/resources/frog.png");
	private final Sprite hitbox = new Sprite(new Rectangle(300, 300, 100, 100), "src/resources/background1.png");
	private JLabel label;
	
	private Audio soundDemo = new Audio();
	private MouseData mouseData;
	
	private GameWindow instance;
	
	public GameWindow() {
		super("Project Tempera");
		instance = this;
		mouseData = new MouseData(instance);
		
//		soundDemo.getSoundFile("songDemo.wav");
//		soundDemo.volumeControl((float).1,soundDemo.clip);
//		soundDemo.playSound(soundDemo.clip);
//		soundDemo.loop(0.5,-1,soundDemo.clip)
		
		//add songs to queue
//		soundDemo.queueAddToBottom("songDemo.wav");
//		soundDemo.queueAddToBottom("songdemo2.wav");
//		soundDemo.volumeControl((float).3, soundDemo.getPlayingSong());
//		soundDemo.playSound(soundDemo.getPlayingSong());
		
		sprite.setOffset(Math.PI / 2);
		sprite.friction = 0.9;
		
		//TODO Make it so that this thing
		//draws a list of sprites
		JPanel panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				hitbox.draw(g);
				sprite.draw(g);
			}
		};
		
		label = new JLabel("dummytext");
		label.setForeground(Color.white);
		
		pack();
		setSize(1080, 740);
		setVisible(true);
		
		addKeyListener(new KeyboardData());
		panel.addMouseMotionListener(mouseData);
		panel.addMouseListener(mouseData);
		panel.add(label);
		add(panel);
		
		EventBus.registerEvent(MousePressedEvent.class);
		EventBus.registerListener(new KeyboardListener());
	}
	
	public void tick() {
		//move to next song once head clip is not active
//		if (soundDemo.getQueuedSongs() > 0) {
//			if (!soundDemo.isPlaying()) {
//				soundDemo.queuePoll();
//				soundDemo.volumeControl((float).3, soundDemo.getPlayingSong());
//				soundDemo.playSound(soundDemo.getPlayingSong());
//			}
//		}
		//movement
//		moveAcceleration();
		moveCardinal();
		
		label.setText(String.format("<html>Position: %s<br/>Velocity: %s<br/>Magnitude: %f<br/>Angle: %f<br/>Intersecting: %b</html>",
				sprite.position,
				sprite.velocity,
				sprite.velocity.getMagnitude(),
				Math.toDegrees(sprite.velocity.getAngle()),
				Polygon.isIntersecting(sprite.boundingBox, hitbox.boundingBox)
				));
		sprite.updatePosition();
	}
	
	public void moveAcceleration() {
		if(KeyboardData.isKeyPressed(KeyEvent.VK_LEFT))
			sprite.velocity.addAngle(-1);
		if(KeyboardData.isKeyPressed(KeyEvent.VK_RIGHT))
			sprite.velocity.addAngle(1);
		if(KeyboardData.isKeyPressed(KeyEvent.VK_UP))
			sprite.velocity.addAngle(1);
	}
	
	public void moveCardinal() {
		if(KeyboardData.isKeyPressed(KeyEvent.VK_UP)) 
			sprite.velocity.add(0, -accelerationRate);
		if(KeyboardData.isKeyPressed(KeyEvent.VK_DOWN)) 
			sprite.velocity.add(0, accelerationRate);
		if(KeyboardData.isKeyPressed(KeyEvent.VK_LEFT)) 
			sprite.velocity.add(-accelerationRate, 0);
		if(KeyboardData.isKeyPressed(KeyEvent.VK_RIGHT)) 
			sprite.velocity.add(accelerationRate, 0);
	}
	
	public Sprite getPlayer() {
		return sprite;
	}
	
	public MouseData getMouseData() {
		return mouseData;
	}
}
