package tempera.physics;

import java.util.ArrayList;
import java.util.List;

public class PhysicsEngine {
	private final List<PhysicsObject> physicsObjects = new ArrayList<PhysicsObject>();
	
	public void addObject(PhysicsObject obj) {
		physicsObjects.add(obj);
	}
	
	public void removeObject(PhysicsObject obj) {
		physicsObjects.remove(obj);
	}
	
	public void tick() {
		//check collisions and move things forward here
	}
}
