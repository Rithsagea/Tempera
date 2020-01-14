package tempera.listeners;

import java.awt.event.KeyEvent;

import tempera.entity.PhysicsObject;
import tempera.event.EventHandler;
import tempera.event.EventPriority;
import tempera.event.Listener;
import tempera.events.GameStartEvent;
import tempera.events.GameTickEvent;
import tempera.geometry.Point;
import tempera.graphics.Sprite;
import tempera.input.KeyboardData;

public class PlayerListener implements Listener {
	
	private final double accelerationRate = 5;
	
	public Sprite playerSprite;
	public PhysicsObject player;
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void onGameStart(GameStartEvent event) {
		playerSprite = event.getWindow().getPlayerSprite();
		player = new PhysicsObject(null, 1);
		player.friction = 0.9;
	}
	
	@EventHandler
	public void onGameTick(GameTickEvent event) {
		if(KeyboardData.isKeyPressed(KeyEvent.VK_UP)) 
			player.velocity.add(0, accelerationRate);
		if(KeyboardData.isKeyPressed(KeyEvent.VK_DOWN)) 
			player.velocity.add(0, -accelerationRate);
		if(KeyboardData.isKeyPressed(KeyEvent.VK_LEFT)) 
			player.velocity.add(-accelerationRate, 0);
		if(KeyboardData.isKeyPressed(KeyEvent.VK_RIGHT)) 
			player.velocity.add(accelerationRate, 0);
		
		
		player.updatePosition();
		
		Point position = player.position.clone();
		
		position.add(-playerSprite.getLength() / 2, playerSprite.getWidth() / 2);
		
		playerSprite.setX((int)position.getX());
		playerSprite.setY((int)position.getY());
	}
}
