package tempera.listeners;

import tempera.event.EventHandler;
import tempera.event.Listener;
import tempera.events.PhysicsCollideEvent;

public class CollisionListener implements Listener {
	@EventHandler
	public void onCollide(PhysicsCollideEvent event) {
		System.out.println(event.getObjectA());
		System.out.println(event.getObjectB());
	}
}
