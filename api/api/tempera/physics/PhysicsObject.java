package api.tempera.physics;

import api.tempera.geometry.BoundingBox;
import api.tempera.geometry.Point;
import api.tempera.geometry.Vector;

public class PhysicsObject {
	
	public Point position;
	public Vector velocity = new Vector(0, 0);
	public final BoundingBox boundingBox;
	public double friction; //coefficient that's multiplied to the velocity. slows down the physics object over time.
	
	public double weight;
	
	public PhysicsObject(BoundingBox boundingBox, double weight) {
		this.boundingBox = boundingBox;
		this.weight = weight;
		
		position = boundingBox.getCenter();
	}
	
	/**
	 * causes the object to move based on it's velocity
	 */
	public void updatePosition() {
		velocity.multiply(friction); //applies friction
		position.add(velocity);
	}
	
	public void onCollide(PhysicsObject obj) {
		//do nothing
	}
}
