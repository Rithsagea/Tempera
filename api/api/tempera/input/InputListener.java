package api.tempera.input;

import api.tempera.event.EventHandler;
import api.tempera.event.EventPriority;
import api.tempera.event.Listener;
import api.tempera.events.GameStartEvent;
import api.tempera.game.TemperaWindow;

public class InputListener implements Listener {
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onGameStart(GameStartEvent event) {
		TemperaWindow window = event.getWindow();
		
		window.addKeyListener(KeyboardData.getInstance());
		window.addMouseListener(MouseData.getInstance());
		window.addMouseMotionListener(MouseData.getInstance());
	}
}
