package tempera.game;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tempera.event.EventBus;
import tempera.events.GameRenderEvent;
import tempera.events.GameStartEvent;
import tempera.events.GameTickEvent;
import tempera.geometry.Point;
import tempera.graphics.RenderEngine;
import tempera.listeners.CollisionListener;
import tempera.listeners.InputListener;
import tempera.listeners.PhysicsListener;
import tempera.listeners.PlayerListener;
import tempera.listeners.RenderListener;
import tempera.listeners.SoundListener;
import tempera.physics.PhysicsEngine;

public class GameWindow extends JFrame {

	private static final long serialVersionUID = -7296143310032123444L;
	
	private JPanel renderPanel;
	private PhysicsEngine physicsEngine = new PhysicsEngine();
	private RenderEngine renderEngine = new RenderEngine();
	
	@SuppressWarnings("serial")
	public GameWindow() {
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
	
	public void registerListeners() {
		EventBus.registerListener(new RenderListener());
		EventBus.registerListener(new InputListener());
		EventBus.registerListener(new PlayerListener());
		EventBus.registerListener(new SoundListener());
		EventBus.registerListener(new CollisionListener());
		EventBus.registerListener(new PhysicsListener());
	}
	
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
