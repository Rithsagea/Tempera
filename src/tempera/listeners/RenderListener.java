package tempera.listeners;

import tempera.event.EventHandler;
import tempera.event.EventPriority;
import tempera.event.Listener;
import tempera.events.GameRenderEvent;
import tempera.events.GameStartEvent;
import tempera.game.GameWindow;
import tempera.geometry.Point;
import tempera.graphics.RenderEngine;
import tempera.graphics.Sprite;
import tempera.util.FileUtil;

public class RenderListener implements Listener {
	
	private RenderEngine engine = new RenderEngine();
	private Point camera = new Point(0, 0);
	
	@EventHandler(priority = EventPriority.LOW)
	public void onGameStart(GameStartEvent event) {
		GameWindow window = event.getWindow();
		
		engine.setOffset(camera, window);
		
		Sprite box1 = new Sprite(FileUtil.readImageFile("src/resources/background1.png"));
		Sprite box2 = new Sprite(FileUtil.readImageFile("src/resources/background2.png"));
		
		Sprite sprite = new Sprite(1, 0, FileUtil.readImageFile("src/resources/frog.png"));
		
		box1.setX(0);
		box1.setY(0);
		
		box2.setX(200);
		box2.setY(200);
		
		sprite.setX(-sprite.getLength() / 2);
		sprite.setY(sprite.getWidth() / 2);
		
		engine.addObject(box1);
		engine.addObject(box2);
		engine.addObject(sprite);
		
		engine.printObjects();
		
		window.setPlayerSprite(sprite);
		
		System.out.println(event.getWindow().getCenter());
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onGameRender(GameRenderEvent event) {
		engine.renderObjects(event.getGraphics());
	}
	
	public Point getCamera() {
		return camera;
	}
}
