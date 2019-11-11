package com.tempera.entity;

import com.tempera.vector.Vector;

public class PhysicsObject {
	
	public Vector position;
	public Vector velocity = new Vector(0, 0);
	public double friction; //coefficient that's multiplied to the velocity. slows down the physics object over time.
	
	/**
	 * causes the object to move based on it's velocity
	 */
	public void updatePosition() {
		velocity.multiply(friction); //applies friction
		position.add(velocity);
	}
}
