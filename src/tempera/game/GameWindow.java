package tempera.game;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import tempera.event.EventBus;
import tempera.events.GameStartEvent;
import tempera.events.GameTickEvent;
import tempera.graphics.Sprite;
import tempera.input.KeyboardData;
import tempera.input.MouseData;
import tempera.listeners.KeyboardListener;
import tempera.listeners.RenderListener;
import tempera.listeners.SoundListener;
import tempera.listeners.WindowListener;
import tempera.vector.Polygon;
import tempera.vector.Rectangle;

public class GameWindow extends JFrame {

	private static final long serialVersionUID = -7296143310032123444L;
	private final long accelerationRate = 300 / Main.frameRate;
	
	private final Sprite sprite = new Sprite(new Rectangle(0, 0, 100, 100), "src/resources/frog.png");
	private final Sprite hitbox = new Sprite(new Rectangle(300, 300, 100, 100), "src/resources/background1.png");
	private MouseData mouseData;
	private JLabel label;
	
	public GameWindow() {
		super("Project Tempera");
		
		registerListeners();
		EventBus.finalizeHandlers();
		EventBus.callEvent(new GameStartEvent(this));
	}
	
	public void registerListeners() {
		EventBus.registerListener(new WindowListener());
		EventBus.registerListener(new RenderListener());
		EventBus.registerListener(new SoundListener());
		EventBus.registerListener(new KeyboardListener());
	}
	
	public void tick() {
		EventBus.callEvent(new GameTickEvent(this));
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
	
	public Sprite getHitbox() {
		return hitbox;
	}
	
	public void setLabel(JLabel label) {
		this.label = label;
	}
	
	public void setMouseData(MouseData mouseData) {
		this.mouseData = mouseData;
	}
	
	public MouseData getMouseData() {
		return mouseData;
	}
}
