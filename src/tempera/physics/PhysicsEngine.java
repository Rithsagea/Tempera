package tempera.physics;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;
import tempera.event.EventBus;
import tempera.events.PhysicsCollideEvent;
import tempera.util.ListUtil;

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
