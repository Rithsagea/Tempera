package tempera.listeners;

import tempera.event.EventHandler;
import tempera.event.Listener;
import tempera.events.PhysicsCollideEvent;
import tempera.geometry.Vector;
import tempera.physics.PhysicsObject;

public class CollisionListener implements Listener {
	@EventHandler
	public void onCollide(PhysicsCollideEvent event) {
		PhysicsObject A = event.getObjectA();
		PhysicsObject B = event.getObjectB();
		
		double force = A.weight * A.velocity.getMagnitude()
				+ B.weight * B.velocity.getMagnitude() / 2;
		
		Vector direction = new Vector(A.position, B.position).unit();
		
		if(A.weight != 0)
			A.velocity.add(direction.inverse().setMagnitude(force / A.weight));
		if(B.weight != 0)
			B.velocity.add(direction.setMagnitude(force / B.weight));
		
//		System.out.println(force);
	}
}
