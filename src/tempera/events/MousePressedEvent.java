package tempera.events;

import tempera.event.Event;
import tempera.game.GameWindow;

public class MousePressedEvent extends Event {
	
	protected GameWindow window;
	
	public MousePressedEvent(GameWindow window) {
		this.window = window;
	}
	
	public GameWindow getWindow() {
		return window;
	}
}
