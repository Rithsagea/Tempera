package tempera.events;

import tempera.event.Event;
import tempera.input.MouseData;

public class MousePressEvent extends Event {
	
	private final MouseData mouseData;
	
	public MousePressEvent(MouseData mouseData) {
		this.mouseData = mouseData;
	}
	
	public MouseData getMouseData() {
		return mouseData;
	}
}
