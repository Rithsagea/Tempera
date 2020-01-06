package test.tempera.event;

import tempera.event.EventHandler;
import tempera.event.Listener;

public class TestListener2 implements Listener {
	@EventHandler
	public void onEvent(TestEvent2 event) {
		System.out.println("The second event has fired the second listener");
	}
}
