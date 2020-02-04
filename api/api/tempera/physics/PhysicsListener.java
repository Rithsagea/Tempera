package api.tempera.physics;

import api.tempera.event.EventHandler;
import api.tempera.event.EventPriority;
import api.tempera.event.Listener;
import api.tempera.events.GameStartEvent;
import api.tempera.events.GameTickEvent;

public class PhysicsListener implements Listener {
	private PhysicsEngine engine;
	
	@EventHandler
	public void onGameStart(GameStartEvent event) {
		engine = event.getWindow().getPhysics();
	}
	
	@EventHandler(priority = EventPriority.LOW)
	public void onGameTick(GameTickEvent event) {
		engine.tick();
	}
}
