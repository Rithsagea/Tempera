package test.tempera.event;

import tempera.event.EventHandler;
import tempera.event.EventPriority;
import tempera.event.Listener;

public class TestListener2 implements Listener {
	@EventHandler(priority = EventPriority.LOWEST)
	public void onEvent(TestEvent2 event) {
		System.out.println("Listener 2");
	}
}
