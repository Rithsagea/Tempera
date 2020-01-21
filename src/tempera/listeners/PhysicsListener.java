package tempera.listeners;

import tempera.event.EventHandler;
import tempera.event.Listener;
import tempera.events.GameTickEvent;
import tempera.physics.PhysicsEngine;

public class PhysicsListener implements Listener {
	public static PhysicsEngine engine = new PhysicsEngine();
	
	@EventHandler
	public void onGameTick(GameTickEvent event) {
		engine.tick();
	}
}
