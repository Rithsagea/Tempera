package api.tempera.game;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.tempera.listeners.CollisionListener;
import com.tempera.listeners.InputListener;
import com.tempera.listeners.PhysicsListener;
import com.tempera.listeners.PlayerListener;
import com.tempera.listeners.RenderListener;
import com.tempera.listeners.SoundListener;

import api.tempera.event.EventBus;
import api.tempera.events.GameRenderEvent;
import api.tempera.events.GameStartEvent;
import api.tempera.events.GameTickEvent;
import api.tempera.geometry.Point;
import api.tempera.graphics.RenderEngine;
import api.tempera.physics.PhysicsEngine;

public class TemperaWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel renderPanel;
	private PhysicsEngine physicsEngine = new PhysicsEngine();
	private RenderEngine renderEngine = new RenderEngine();
	
	@SuppressWarnings("serial")
	public TemperaWindow() {
		super("Project Tempera");
		
		renderPanel = new JPanel() {
			public void paint(Graphics g) {
				EventBus.callEvent(new GameRenderEvent((Graphics2D)g));
			}
		};
		
		setContentPane(renderPanel);
		setSize(1080, 720);
		
		registerListeners();
		EventBus.finalizeHandlers();
		EventBus.callEvent(new GameStartEvent(this));
		
		setVisible(true);
	}
	
	public void registerListeners() { }
	
	public void tick() {
		//not used (yet)
		EventBus.callEvent(new GameTickEvent(this));
	}
	
	public Point getCenter() {
		return new Point(this.getWidth() / 2, this.getHeight() / 2);
	}
	
	public PhysicsEngine getPhysics() {
		return physicsEngine;
	}
	
	public RenderEngine getRender() {
		return renderEngine;
	}
}
