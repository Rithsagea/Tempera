package tempera.listeners;

import tempera.event.EventHandler;
import tempera.event.EventPriority;
import tempera.event.Listener;
import tempera.events.GameStartEvent;

public class ResourceListener implements Listener {
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onGameStart(GameStartEvent event) {
		
	}
}
