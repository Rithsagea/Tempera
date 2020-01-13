package tempera.listeners;

import tempera.event.EventHandler;
import tempera.event.Listener;
import tempera.events.PhysicsCollideEvent;
import tempera.graphics.Sprite;

public class CollisionListener implements Listener {
	@EventHandler
	public void onCollide(PhysicsCollideEvent event) {
		Sprite a = event.getA();
		Sprite b = event.getB();
		
		double aForce = a.weight * a.velocity.getMagnitude();
		double bForce = b.weight * b.velocity.getMagnitude();
		
		double totalForce = 0;
		
		if(Double.isFinite(aForce))
			totalForce += aForce;
		if(Double.isFinite(bForce))
			totalForce += bForce;
		
		a.velocity.setMagnitude(totalForce / 2);
		b.velocity.setMagnitude(totalForce / 2);
	}
}
