package tempera.listeners;

import java.awt.event.KeyEvent;

import tempera.event.EventHandler;
import tempera.event.EventPriority;
import tempera.event.Listener;
import tempera.events.GameStartEvent;
import tempera.events.GameTickEvent;
import tempera.game.Entity;
import tempera.geometry.BoundingBox;
import tempera.geometry.Point;
import tempera.graphics.Sprite;
import tempera.input.KeyboardData;
import tempera.physics.PhysicsObject;
import tempera.util.FileUtil;

public class PlayerListener implements Listener {
	
	private final double accelerationRate = 5;
	
	public static Entity player;
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void initializePlayer(GameStartEvent event) {
		Sprite sprite = new Sprite(1, 0, 20, 20, FileUtil.readImageFile("src/resources/frog.png"));
		player = new Entity(new BoundingBox(new Point(250, 250), 20, 20), 10);
		player.setSprite(sprite);
		player.friction = 0.9;
		
		player.registerEntity(PhysicsListener.engine, RenderListener.engine);
	}
	
	@EventHandler
	public void checkPlayerControls(GameTickEvent event) {
		if(KeyboardData.isKeyPressed(KeyEvent.VK_UP)) 
			player.velocity.add(0, accelerationRate);
		if(KeyboardData.isKeyPressed(KeyEvent.VK_DOWN)) 
			player.velocity.add(0, -accelerationRate);
		if(KeyboardData.isKeyPressed(KeyEvent.VK_LEFT)) 
			player.velocity.add(-accelerationRate, 0);
		if(KeyboardData.isKeyPressed(KeyEvent.VK_RIGHT)) 
			player.velocity.add(accelerationRate, 0);
	}
	
	public static PhysicsObject getPlayer() {
		return player;
	}
}
