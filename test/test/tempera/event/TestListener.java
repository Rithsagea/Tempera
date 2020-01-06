package test.tempera.event;

import tempera.event.EventHandler;
import tempera.event.EventPriority;
import tempera.event.Listener;

public class TestListener implements Listener {
	@EventHandler
	public void onEvent(TestEvent event) {
		System.out.println("Test Listener has fired. Value: " + event.getVal());
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onSecondEvent(TestEvent2 event) {
		System.out.println("Listener 1");
	}
}
