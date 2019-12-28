package test.tempera.event;

import com.tempera.event.EventHandler;
import com.tempera.event.Listener;

public class TestListener implements Listener {
	@EventHandler
	public void onEvent(TestEvent event) {
		System.out.println("Test Listener has fired");
	}
}
