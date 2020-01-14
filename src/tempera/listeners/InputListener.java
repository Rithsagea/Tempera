package tempera.listeners;

import tempera.event.EventHandler;
import tempera.event.EventPriority;
import tempera.event.Listener;
import tempera.events.GameStartEvent;
import tempera.events.MousePressEvent;
import tempera.game.GameWindow;
import tempera.input.KeyboardData;
import tempera.input.MouseData;

public class InputListener implements Listener {
	
	private MouseData mouseData;
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onGameStart(GameStartEvent event) {
		GameWindow window = event.getWindow();
		
		mouseData = new MouseData();
		
		window.addKeyListener(new KeyboardData());
		
		window.addMouseListener(mouseData);
		window.addMouseMotionListener(mouseData);
	}
	
	@EventHandler
	public void onMousePress(MousePressEvent event) {
		System.out.println("A mouse button has been pressed yeet");
	}
}
