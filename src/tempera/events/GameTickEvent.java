package tempera.events;

import tempera.event.Event;
import tempera.game.GameWindow;

public class GameTickEvent extends Event {
	
	private GameWindow window;
	
	public GameTickEvent(GameWindow window) {
		this.window = window;
	}
	
	public GameWindow getWindow() {
		return window;
	}
}
