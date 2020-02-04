package com.tempera.listeners;

import api.tempera.event.EventHandler;
import api.tempera.event.Listener;
import api.tempera.events.GameStartEvent;
import api.tempera.events.GameTickEvent;
import api.tempera.game.TemperaWindow;
import api.tempera.geometry.BoundingBox;
import api.tempera.graphics.RenderEngine;
import api.tempera.graphics.Sprite;
import api.tempera.physics.PhysicsEngine;
import api.tempera.physics.PhysicsObject;
import api.tempera.util.FileUtil;

public class RenderListener implements Listener {
	
	private PhysicsEngine physicsEngine;
	private RenderEngine renderEngine;
	
	private PhysicsObject box;
	
	private Sprite box1;
	private Sprite box2;
	
	@EventHandler
	public void onGameStart(GameStartEvent event) {
		TemperaWindow window = event.getWindow();
		renderEngine = window.getRender();
		physicsEngine = window.getPhysics();
		
		box1 = new Sprite(0, 0, 100, 100, FileUtil.readImageFile("src/resources/background1.png"));
		box2 = new Sprite(0, 0, 100, 100, FileUtil.readImageFile("src/resources/background2.png"));
		
		box = new PhysicsObject(new BoundingBox(100, 100), 10);
		box.friction = 0.9;
		
		box.position.setX(50);
		box.position.setY(50);
		
		box1.bind(box.position);
		box2.bind(box.position);
		
		renderEngine.addObject(box1);
		renderEngine.addObject(box2);
		
		physicsEngine.addObject(box);
		
		renderEngine.printObjects();
		
		System.out.println(event.getWindow().getCenter());
	}
	
	@EventHandler
	public void onGameTick(GameTickEvent event) {
		if(box.boundingBox.intersects(PlayerListener.getPlayer().boundingBox)) {
			box1.setHidden(true);
			box2.setHidden(false);
		} else {
			box1.setHidden(false);
			box2.setHidden(true);
		}
	}
}
