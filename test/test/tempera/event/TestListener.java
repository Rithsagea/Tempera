package test.tempera.event;

import tempera.event.EventHandler;
import tempera.event.Listener;

public class TestListener implements Listener {
	@EventHandler
	public void onEvent(TestEvent event) {
		System.out.println("Test Listener has fired");
	}
}
