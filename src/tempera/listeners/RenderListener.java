package tempera.listeners;

import java.awt.Graphics;

import tempera.event.EventHandler;
import tempera.event.Listener;
import tempera.events.GameRenderEvent;
import tempera.graphics.Sprite;

public class RenderListener implements Listener {
	@EventHandler
	public void onRender(GameRenderEvent event) {
		Graphics graphics = event.getGraphics();
		for(Sprite sprite : WindowListener.getSprites())
			sprite.draw(graphics);
	}
}
