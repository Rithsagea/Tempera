package api.tempera.events;

import java.awt.Graphics2D;

import api.tempera.event.Event;

public class GameRenderEvent extends Event {
	
	private Graphics2D graphics;
	
	public GameRenderEvent(Graphics2D g) {
		this.graphics = g;
	}
	
	public Graphics2D getGraphics() {
		return graphics;
	}
}
