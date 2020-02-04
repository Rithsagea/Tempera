package api.tempera.game;

import api.tempera.geometry.BoundingBox;
import api.tempera.graphics.RenderEngine;
import api.tempera.graphics.Sprite;
import api.tempera.physics.PhysicsEngine;
import api.tempera.physics.PhysicsObject;

public class Entity extends PhysicsObject {
	
	private Sprite sprite;
	
	public Entity(BoundingBox boundingBox, double weight) {
		super(boundingBox, weight);
	}
	
	public void registerEntity(PhysicsEngine physEngine, RenderEngine rendEngine) {
		physEngine.addObject(this);
		rendEngine.addObject(sprite);
	}
	
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
		sprite.bind(position);
	}
}
