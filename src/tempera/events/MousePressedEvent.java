package tempera.events;

import tempera.event.BaseEvent;
import tempera.game.GameWindow;

public class MousePressedEvent extends BaseEvent {
	
	protected GameWindow window;
	
	public MousePressedEvent() {
		
	}
	
	public MousePressedEvent(GameWindow window) {
		this.window = window;
		executeEvent();
	}
	
	public GameWindow getWindow() {
		return window;
	}
}
