package tempera.listeners;

import tempera.event.EventHandler;
import tempera.event.Listener;
import tempera.events.MousePressedEvent;
import tempera.game.GameWindow;
import tempera.geometry.Vector;
import tempera.input.MouseData;

public class KeyboardListener implements Listener {
	
	@EventHandler
	public void onMousePress(MousePressedEvent event) {
		GameWindow window = event.getWindow();
		MouseData mouseData = window.getMouseData();
		
		Vector vector = new Vector(mouseData.getX(), mouseData.getY());
		vector.subtract(window.getPlayer().position);
		vector.setMagnitude(100);
		window.getPlayer().velocity.add(vector);
	}
}
