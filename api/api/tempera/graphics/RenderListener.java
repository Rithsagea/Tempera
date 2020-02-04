package api.tempera.graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import api.tempera.event.EventHandler;
import api.tempera.event.EventPriority;
import api.tempera.event.Listener;
import api.tempera.events.GameRenderEvent;
import api.tempera.events.GameStartEvent;
import api.tempera.game.TemperaWindow;

public class RenderListener implements Listener {
	
	private RenderEngine renderEngine;
	
	@EventHandler(priority = EventPriority.LOW)
	public void onGameStart(GameStartEvent event) {
		TemperaWindow window = event.getWindow();
		
		renderEngine = window.getRender();
		
		renderEngine.updateOffset(window);
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onGameRender(GameRenderEvent event) {
		renderEngine.renderObjects(event.getGraphics());
	}
	
	//Debug
	@EventHandler(priority = EventPriority.LOWEST)
	public void drawCenter(GameRenderEvent event) {
		Graphics2D g2d = event.getGraphics();
		g2d.setColor(Color.GREEN);
		g2d.draw(new Ellipse2D.Double(-5, -5, 10, 10));
	}
}
