package com.tempera.listeners;

import api.tempera.event.EventHandler;
import api.tempera.event.Listener;
import api.tempera.events.PhysicsCollideEvent;
import api.tempera.physics.PhysicsObject;

public class CollisionListener implements Listener {
	@EventHandler
	public void onCollide(PhysicsCollideEvent event) {
		PhysicsObject A = event.getObjectA();
		PhysicsObject B = event.getObjectB();
		
		double[] edgesA = A.boundingBox.getEdges();
		double[] edgesB = B.boundingBox.getEdges();
		
		//halve velocity, because it sounds like a good idea
		
		A.velocity.divide(2);
		B.velocity.divide(2);
		
		//Make objects not be stuck together
		
		double weightSum = A.weight + B.weight;
		
		double horizontalDiff = (Math.min(edgesA[1] - edgesB[0], edgesB[1] - edgesA[0]) + 1) / weightSum;
		double verticalDiff = (Math.min(edgesA[3] - edgesB[2], edgesB[3] - edgesA[2]) + 1) / weightSum;
		
		if(horizontalDiff < verticalDiff) {	//the collision is horizontal
			//velocity
			double horizontalForce = A.weight * A.velocity.getX()
									+B.weight * B.velocity.getX();
			horizontalForce /= 2;
			
			if(A.position.getX() < B.position.getX())
				horizontalDiff *= -1;
			
			A.position.add(horizontalDiff * A.weight, 0);
			B.position.add(-horizontalDiff * B.weight, 0);
			A.velocity.add(horizontalForce / A.weight, 0);
			B.velocity.add(-horizontalForce / B.weight, 0);
			
//			System.out.println("H: " + horizontalForce);
		} else { //the collision is vertical
			double verticalForce = A.weight * A.velocity.getY()
					+B.weight * B.velocity.getY();
			
			verticalForce /= 2;
			
			if(A.position.getY() < B.position.getY())
				verticalDiff *= -1;
			
			A.position.add(0, verticalDiff * A.weight);
			B.position.add(0, -verticalDiff * B.weight);
			A.velocity.add(0, verticalForce / A.weight);
			B.velocity.add(0, -verticalForce / B.weight);
			
//			System.out.println("V: " + verticalForce);
		}
	}
}
