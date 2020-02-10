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
		
		//this saves the game's physics and render engine
		physicsEngine = event.getWindow().getPhysics();
		renderEngine = event.getWindow().getRender();
		
		//creates a sprite with a size of 20x20
		//the first number (1) is the render level
		//all objects with higher render levels are drawn first
		
		//the second number (0) is the draw level
		//all objects with higher draw levels are drawn first if
		//they share the same render level
		Sprite sprite = new Sprite(1, 0, 20, 20, FileUtil.readImageFile("src/resources/frog.png"));
		
		//this creates a new entity
		//the bounding box (size of the hitbox) is defined
		//the weight is the next number
		//the sprite is what is displayed. the sprite's center
		//is drawn where the physicsobject's center is
		player = new Entity(new BoundingBox(new Point(250, 250), 20, 20), 10, sprite);
		player.friction = friction;
		
		//this sends the entity to the engines.
		//after this code is run, the physics engine
		//will have this entity's hitbox and weight, while
		//the render engine will begin to draw it
		player.registerEntity(physicsEngine, renderEngine);
		
		//this saves an instance of the keyboard data
		//the reason it's like this is because KeyboardData
		//is a singleton. (look it up if you want to know)
		keyboardData = KeyboardData.getInstance();
	}
	
	@EventHandler
	public void checkPlayerControls(GameTickEvent event) {
		//every time the game ticks once, this method is called
		//it checks if certain keys are held down, if they are
		//then the player's velocity is changed.
		
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
