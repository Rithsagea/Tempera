package tempera.listeners;

import java.awt.event.KeyEvent;

import tempera.event.EventHandler;
import tempera.event.EventPriority;
import tempera.event.Listener;
import tempera.events.GameStartEvent;
import tempera.events.GameTickEvent;
import tempera.geometry.BoundingBox;
import tempera.geometry.Point;
import tempera.graphics.Sprite;
import tempera.input.KeyboardData;
import tempera.physics.PhysicsObject;

public class PlayerListener implements Listener {
	
	private final double accelerationRate = 5;
	
	public Sprite playerSprite;
	public static PhysicsObject player;
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void initializePlayer(GameStartEvent event) {
		playerSprite = event.getWindow().getPlayerSprite();
		player = new PhysicsObject(new BoundingBox(new Point(0, 0), 20, 20), 10);
		player.friction = 0.9;
		
		PhysicsListener.engine.addObject(player);
		
		playerSprite.bind(player.position);
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
