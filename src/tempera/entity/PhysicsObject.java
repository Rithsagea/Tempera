package tempera.entity;

import tempera.vector.Polygon;
import tempera.vector.Vector;

public class PhysicsObject {
	
	public Vector position = new Vector(0, 0);
	public Vector velocity = new Vector(0, 0);
	public final Polygon boundingBox;
	public double friction; //coefficient that's multiplied to the velocity. slows down the physics object over time.
	
	public PhysicsObject(Polygon boundingBox) {
		this.boundingBox = boundingBox;
	}
	
	/**
	 * causes the object to move based on it's velocity
	 */
	public void updatePosition() {
		velocity.multiply(friction); //applies friction
		position.add(velocity);
	}
}
