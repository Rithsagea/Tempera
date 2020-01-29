package tempera.listeners;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import tempera.event.EventHandler;
import tempera.event.EventPriority;
import tempera.event.Listener;
import tempera.events.GameRenderEvent;
import tempera.events.GameStartEvent;
import tempera.events.GameTickEvent;
import tempera.game.GameWindow;
import tempera.geometry.BoundingBox;
import tempera.geometry.Point;
import tempera.graphics.RenderEngine;
import tempera.graphics.Sprite;
import tempera.physics.PhysicsEngine;
import tempera.physics.PhysicsObject;
import tempera.util.FileUtil;

public class RenderListener implements Listener {
	
	private PhysicsEngine physicsEngine = new PhysicsEngine();
	private RenderEngine renderEngine = new RenderEngine();
	
	private Point camera = new Point(0, 0);
	private PhysicsObject box;
	
	private Sprite box1;
	private Sprite box2;
	
	@EventHandler(priority = EventPriority.LOW)
	public void onGameStart(GameStartEvent event) {
		GameWindow window = event.getWindow();
		
		physicsEngine = window.getPhysics();
		renderEngine = window.getRender();
		
		renderEngine.setOffset(camera, window);
		
		box1 = new Sprite(0, 0, 100, 100, FileUtil.readImageFile("src/resources/background1.png"));
		box2 = new Sprite(0, 0, 100, 100, FileUtil.readImageFile("src/resources/background2.png"));
		
		box = new PhysicsObject(new BoundingBox(100, 100), 10);
		box.friction = 0.9;
		
		box.position.setX(50);
		box.position.setY(50);
		
		box1.bind(box.position);
		box2.bind(box.position);
		
		renderEngine.addObject(box1);
		renderEngine.addObject(box2);
		
		physicsEngine.addObject(box);
		
		renderEngine.printObjects();
		
		System.out.println(event.getWindow().getCenter());
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onGameRender(GameRenderEvent event) {
		renderEngine.renderObjects(event.getGraphics());
	}
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void drawCenter(GameRenderEvent event) {
		Graphics2D g2d = event.getGraphics();
		g2d.setColor(Color.GREEN);
		g2d.draw(new Ellipse2D.Double(-5, -5, 10, 10));
	}
	
	@EventHandler
	public void onGameTick(GameTickEvent event) {
		
		if(box.boundingBox.intersects(PlayerListener.getPlayer().boundingBox)) {
			box1.setHidden(true);
			box2.setHidden(false);
		} else {
			box1.setHidden(false);
			box2.setHidden(true);
		}
	}
	
	public Point getCamera() {
		return camera;
	}
}
