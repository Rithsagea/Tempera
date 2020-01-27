package tempera.events;

import tempera.event.Event;
import tempera.physics.PhysicsObject;

public class PhysicsCollideEvent extends Event {
	private PhysicsObject objectA;
	private PhysicsObject objectB;
	
	public PhysicsCollideEvent(PhysicsObject objectA, PhysicsObject objectB) {
		this.objectA = objectA;
		this.objectB = objectB;
		
		objectA.onCollide(this);
		objectB.onCollide(this);
	}
	
	public PhysicsObject getObjectA() {
		return objectA;
	}
	
	public PhysicsObject getObjectB() {
		return objectB;
	}
}
