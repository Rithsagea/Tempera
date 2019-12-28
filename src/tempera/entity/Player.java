package tempera.entity;

import tempera.vector.Vector;

public class Player extends PhysicsObject {
	public Player(Vector position) {
		this.position = position.clone();
		this.friction = 0.9;
	}
}
