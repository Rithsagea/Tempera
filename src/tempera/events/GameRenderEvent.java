package tempera.events;

import java.awt.Graphics;

import tempera.event.Event;

public class GameRenderEvent extends Event {
	
	private Graphics graphics;
	
	public GameRenderEvent(Graphics graphics) {
		this.graphics = graphics;
	}
	
	public Graphics getGraphics() {
		return graphics;
	}
}
