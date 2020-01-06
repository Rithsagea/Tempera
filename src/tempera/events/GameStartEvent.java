package tempera.events;

import tempera.event.Event;
import tempera.game.GameWindow;

public class GameStartEvent extends Event {
	
	private GameWindow window;
	
	public GameStartEvent(GameWindow window) {
		this.window = window;
	}
	
	public GameWindow getWindow() {
		return window;
	}
}
