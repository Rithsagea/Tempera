package com.tempera.listeners;

import com.tempera.entities.BoxOfDeath;

import api.tempera.event.EventHandler;
import api.tempera.event.Listener;
import api.tempera.events.GameStartEvent;
import api.tempera.game.TemperaWindow;
import api.tempera.graphics.RenderEngine;
import api.tempera.physics.PhysicsEngine;

public class RenderListener implements Listener {
	
	private PhysicsEngine physicsEngine;
	private RenderEngine renderEngine;
	
	//check PlayerListener for a more in-depth description of what is happening
	@EventHandler
	public void onGameStart(GameStartEvent event) {
		TemperaWindow window = event.getWindow();
		
		//gets the game engines
		renderEngine = window.getRender();
		physicsEngine = window.getPhysics();
		
		//this creates an object with type BoxOfDeath
		//BoxOfDeath extends Entity, so we can pretty
		//much treat it like one
		BoxOfDeath deadlyEntity = new BoxOfDeath();
		
		//registers the box of death with the game engines.
		deadlyEntity.registerEntity(physicsEngine, renderEngine);
	}
}
