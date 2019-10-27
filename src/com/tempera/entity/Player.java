package com.tempera.entity;

import com.tempera.vector.Vector;

public class Player {
	
	private Vector position;
	private Vector velocity;
	
	public Player(Vector position) {
		this.position = position;
		this.velocity = new Vector(0, 0, 0);
	}
	
	public void addMomentum(Vector vector) {
		velocity.add(vector);
	}
}
