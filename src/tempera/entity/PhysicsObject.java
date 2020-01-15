package tempera.entity;

import tempera.geometry.BoundingBox;
import tempera.geometry.Vector;
import tempera.geometry.Point;

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
}
