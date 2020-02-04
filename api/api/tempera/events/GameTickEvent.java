package api.tempera.events;

import api.tempera.event.Event;
import api.tempera.game.TemperaWindow;

public class GameTickEvent extends Event {
	
	private TemperaWindow window;
	
	public GameTickEvent(TemperaWindow window) {
		this.window = window;
	}
	
	public TemperaWindow getWindow() {
		return window;
	}
}
