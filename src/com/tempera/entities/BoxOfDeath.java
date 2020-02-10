package com.tempera.entities;

import api.tempera.game.Entity;
import api.tempera.geometry.BoundingBox;
import api.tempera.graphics.Sprite;
import api.tempera.physics.PhysicsObject;
import api.tempera.util.FileUtil;

public class BoxOfDeath extends Entity {
	public BoxOfDeath() {
		super(
				//this sets the size of the entity's hitbox
				new BoundingBox(100, 100),
				
				//this sets the entity's weight
				10,
				
				//this sets the display for the entity
				new Sprite(0, 0, 100, 100, FileUtil.readImageFile("src/resources/background1.png")));
	}
	
	
	//this is just an example of what can be done
	//with entities
	public void onCollide(PhysicsObject obj) {
		//this checks whether the object is an entity, if it is, it makes it disappear
		if(obj instanceof Entity) {
			
			//this casts the PhysicsObject to an Entity
			((Entity) obj)
			//this creates an empty sprite and sets the
			//entity's sprite to be the new object.
			//this can be literally anything
			.setSprite(new Sprite());
			
			//if you create your own type of sprite, you
			//can also cast the physics object to that
			//sprite
		}
	}
}
