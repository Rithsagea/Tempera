package api.tempera.events;

import api.tempera.event.Event;
import api.tempera.input.MouseData;

public class MousePressEvent extends Event {
	
	private final MouseData mouseData;
	
	public MousePressEvent(MouseData mouseData) {
		this.mouseData = mouseData;
	}
	
	public MouseData getMouseData() {
		return mouseData;
	}
}
