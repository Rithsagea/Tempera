package tempera.listeners;

import tempera.event.EventHandler;
import tempera.event.Listener;
import tempera.events.GameStartEvent;
import tempera.events.GameTickEvent;
import tempera.physics.PhysicsEngine;

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
