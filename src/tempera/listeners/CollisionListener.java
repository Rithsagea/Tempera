package tempera.listeners;

import tempera.event.EventHandler;
import tempera.event.Listener;
import tempera.events.PhysicsCollideEvent;
import tempera.geometry.Point;
import tempera.geometry.Vector;
import tempera.physics.PhysicsObject;

public class CollisionListener implements Listener {
	@EventHandler
	public void onCollide(PhysicsCollideEvent event) {
		PhysicsObject A = event.getObjectA();
		PhysicsObject B = event.getObjectB();
		
		double[] edgesA = A.boundingBox.getEdges();
		double[] edgesB = B.boundingBox.getEdges();
		
		Point centerA = A.boundingBox.getCenter();
		Point centerB = B.boundingBox.getCenter();
		
		//Calculate movement change for object A
		
		double horizontalVel = Math.min(centerA.getX() - edgesB[0], edgesB[1] - centerA.getX());
		double verticalVel = Math.min(centerA.getY() - edgesB[2], edgesB[3] - centerA.getY());
		
		System.out.println(horizontalVel);
		System.out.println(verticalVel);
		
		//Calculate movement change for object B
		
		double force = A.weight * A.velocity.getMagnitude()
				+ B.weight * B.velocity.getMagnitude() / 2;
		
		
		Vector direction = new Vector(A.position, B.position);
		
		if(A.weight != 0)
			A.velocity.add(direction.inverse().setMagnitude(force / A.weight));
		if(B.weight != 0)
			B.velocity.add(direction.setMagnitude(force / B.weight));
		
//		System.out.println(force);
	}
}
