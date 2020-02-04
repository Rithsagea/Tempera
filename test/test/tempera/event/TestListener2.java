package test.tempera.event;

import api.tempera.event.EventHandler;
import api.tempera.event.EventPriority;
import api.tempera.event.Listener;

public class TestListener2 implements Listener {
	@EventHandler(priority = EventPriority.LOWEST)
	public void onEvent(TestEvent2 event) {
		System.out.println("Listener 2");
	}
}
