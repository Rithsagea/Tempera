package tempera.listeners;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import tempera.event.EventHandler;
import tempera.event.Listener;
import tempera.events.GameStartEvent;
import tempera.game.GameWindow;
import tempera.graphics.Sprite;
import tempera.input.KeyboardData;
import tempera.input.MouseData;

public class WindowListener implements Listener {
	
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
		player.friction = 0.9;
		
		//TODO Make it so that this thing
		//draws a list of sprites
		@SuppressWarnings("serial")
		JPanel panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				hitbox.draw(g);
				player.draw(g);
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
}
