package com.tempera.entity;

import com.tempera.vector.Vector;

public class Player extends PhysicsObject {
	public Player(Vector position) {
		this.position = position.clone();
		this.friction = 0.8;
	}
}
