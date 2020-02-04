package api.tempera.events;

import api.tempera.event.Event;
import api.tempera.game.TemperaWindow;

public class GameStartEvent extends Event {
	
	private TemperaWindow window;
	
	public GameStartEvent(TemperaWindow window) {
		this.window = window;
	}
	
	public TemperaWindow getWindow() {
		return window;
	}
}
