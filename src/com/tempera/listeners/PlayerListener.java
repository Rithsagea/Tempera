package com.tempera.listeners;

import java.awt.event.KeyEvent;

import api.tempera.event.EventHandler;
import api.tempera.event.EventPriority;
import api.tempera.event.Listener;
import api.tempera.events.GameStartEvent;
import api.tempera.events.GameTickEvent;
import api.tempera.game.Entity;
import api.tempera.geometry.BoundingBox;
import api.tempera.geometry.Point;
import api.tempera.graphics.RenderEngine;
import api.tempera.graphics.Sprite;
import api.tempera.input.KeyboardData;
import api.tempera.physics.PhysicsEngine;
import api.tempera.physics.PhysicsObject;
import api.tempera.util.FileUtil;

public class PlayerListener implements Listener {
	
	private static final double accelerationRate = 5;
	private static final double friction = 0.9;
	
	public static Entity player;
	
	private PhysicsEngine physicsEngine;
	private RenderEngine renderEngine;
	
	private KeyboardData keyboardData;
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void initializePlayer(GameStartEvent event) {
		
		physicsEngine = event.getWindow().getPhysics();
		renderEngine = event.getWindow().getRender();
		
		player = new Entity(new BoundingBox(new Point(250, 250), 20, 20), 10, new Sprite(1, 0, 20, 20, FileUtil.readImageFile("src/resources/frog.png")));
		player.friction = friction;
		
		player.registerEntity(physicsEngine, renderEngine);
		
		keyboardData = KeyboardData.getInstance();
	}
	
	@EventHandler
	public void checkPlayerControls(GameTickEvent event) {
		if(keyboardData.isKeyPressed(KeyEvent.VK_UP)) 
			player.velocity.add(0, accelerationRate);
		if(keyboardData.isKeyPressed(KeyEvent.VK_DOWN)) 
			player.velocity.add(0, -accelerationRate);
		if(keyboardData.isKeyPressed(KeyEvent.VK_LEFT)) 
			player.velocity.add(-accelerationRate, 0);
		if(keyboardData.isKeyPressed(KeyEvent.VK_RIGHT)) 
			player.velocity.add(accelerationRate, 0);
	}
	
	public static PhysicsObject getPlayer() {
		return player;
	}
}
