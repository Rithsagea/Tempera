package tempera.events;

import tempera.event.Event;
import tempera.graphics.Sprite;

public class PhysicsCollideEvent extends Event {
	
	private Sprite a;
	private Sprite b;
	
	public PhysicsCollideEvent(Sprite a, Sprite b) {
		this.a = a;
		this.b = b;
	}
	
	public Sprite getA() {
		return a;
	}
	
	public Sprite getB() {
		return b;
	}
}
