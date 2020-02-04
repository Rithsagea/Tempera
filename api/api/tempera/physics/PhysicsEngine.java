package api.tempera.physics;

import java.util.ArrayList;
import java.util.List;

import api.tempera.event.EventBus;
import api.tempera.events.PhysicsCollideEvent;
import api.tempera.util.ListUtil;
import javafx.util.Pair;

public class PhysicsEngine {
	private final List<PhysicsObject> physicsObjects = new ArrayList<PhysicsObject>();
	
	public void addObject(PhysicsObject obj) {
		physicsObjects.add(obj);
	}
	
	public void removeObject(PhysicsObject obj) {
		physicsObjects.remove(obj);
	}
	
	public void tick() {
		
		for(PhysicsObject obj: physicsObjects) {
			obj.updatePosition();
		}
		
		for(Pair<?, ?> pair : ListUtil.getPairs(physicsObjects)) {
			PhysicsObject A = (PhysicsObject) pair.getKey();
			PhysicsObject B = (PhysicsObject) pair.getValue();
			
			if(A.boundingBox.intersects(B.boundingBox))
				EventBus.callEvent(new PhysicsCollideEvent(A, B));
		}
	}
}
