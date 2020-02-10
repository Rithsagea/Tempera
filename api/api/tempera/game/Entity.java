package api.tempera.game;

import api.tempera.geometry.BoundingBox;
import api.tempera.graphics.RenderEngine;
import api.tempera.graphics.Sprite;
import api.tempera.physics.PhysicsEngine;
import api.tempera.physics.PhysicsObject;

public class Entity extends PhysicsObject {
	
	private Sprite sprite;
	
	private RenderEngine render;
	
	public Entity(BoundingBox boundingBox, double weight, Sprite sprite) {
		super(boundingBox, weight);
		setSprite(sprite);
	}
	
	public void registerEntity(PhysicsEngine physEngine, RenderEngine rendEngine) {
		render = rendEngine;
		
		physEngine.addObject(this);
		rendEngine.addObject(sprite);
	}
	
	public void setSprite(Sprite sprite) {
		if(render != null) render.removeObject(this.sprite);
		
		this.sprite = sprite;
		
		if(sprite != null) {
			sprite.bind(position);
			if(render != null)  render.addObject(sprite);
		}
	}
}
