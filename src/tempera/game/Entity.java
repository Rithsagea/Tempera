package tempera.game;

import tempera.geometry.BoundingBox;
import tempera.graphics.RenderEngine;
import tempera.graphics.Sprite;
import tempera.physics.PhysicsEngine;
import tempera.physics.PhysicsObject;

public class Entity extends PhysicsObject {
	
	private Sprite sprite;
	
	public Entity(BoundingBox boundingBox, double weight) {
		super(boundingBox, weight);
	}
	
	public void registerPhysics(PhysicsEngine engine) {
		engine.addObject(this);
	}
	
	public void registerGraphics(RenderEngine engine) {
		engine.addObject(sprite);
	}
	
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
		sprite.bind(position);
	}
}
