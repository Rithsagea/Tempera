package com.tempera.entity;

import com.tempera.vector.Vector;

public class Player {
	
	private Vector position;
	private Vector velocity;
	
	public Player(Vector position) {
		this.position = position;
		this.velocity = new Vector(0, 0, 0);
	}
	
	public void setVelocity(Vector vector) {
		velocity = vector;
	}
	
	public Vector getVelocity() {
		return velocity;
	}
	
	//change this later
	public double getAcceleration() {
		return 2;
	}
	
	public void updatePosition() {
		position.add(velocity);
	}
	
	public Vector getPosition() {
		return position;
	}
}
