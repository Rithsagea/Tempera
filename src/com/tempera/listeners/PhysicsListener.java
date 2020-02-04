package com.tempera.listeners;

import api.tempera.event.EventHandler;
import api.tempera.event.Listener;
import api.tempera.events.GameStartEvent;
import api.tempera.events.GameTickEvent;
import api.tempera.physics.PhysicsEngine;

public class PhysicsListener implements Listener {
	private PhysicsEngine engine;
	
	@EventHandler
	public void onGameStart(GameStartEvent event) {
		engine = event.getWindow().getPhysics();
	}
	
	@EventHandler
	public void onGameTick(GameTickEvent event) {
		engine.tick();
	}
}
