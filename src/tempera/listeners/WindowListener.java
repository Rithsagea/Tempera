package tempera.listeners;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import tempera.event.EventBus;
import tempera.event.EventHandler;
import tempera.event.Listener;
import tempera.events.GameRenderEvent;
import tempera.events.GameStartEvent;
import tempera.game.GameWindow;
import tempera.graphics.Sprite;
import tempera.input.KeyboardData;
import tempera.input.MouseData;

public class WindowListener implements Listener {
	
	private static List<Sprite> sprites = new ArrayList<Sprite>();
	
	@EventHandler
	public void onGameStart(GameStartEvent event) {
		GameWindow window = event.getWindow();
		
		Sprite player = window.getPlayer();
		Sprite hitbox = window.getHitbox();
		
		MouseData mouseData = new MouseData(window);
		window.setMouseData(mouseData);
		
		JLabel label = new JLabel("dummytext");
		label.setForeground(Color.white);
		window.setLabel(label);
		
		player.setOffset(Math.PI / 2);
		player.weight = 60; // weight in kilograms
		player.friction = 0.9;
		
		sprites.add(player);
		sprites.add(hitbox);
		
		//TODO Make it so that this thing
		//draws a list of sprites
		@SuppressWarnings("serial")
		JPanel panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				EventBus.callEvent(new GameRenderEvent(g));
			}
		};
		
		panel.addMouseMotionListener(mouseData);
		panel.addMouseListener(mouseData);
		panel.add(label);
		window.add(panel);
		
		window.addKeyListener(new KeyboardData());
		
		window.pack();
		window.setSize(1080, 720);
		window.setVisible(true);
	}
	
	public static List<Sprite> getSprites() {
		return sprites;
	}
}
