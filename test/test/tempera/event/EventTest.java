package test.tempera.event;

import tempera.event.ListenerRegistry;

public class EventTest {
	public static void main(String[] args) throws Exception {
		
		new EventTest().run();
	}
	
	private void run() throws Exception {
		ListenerRegistry.registerEvent(TestEvent.class);
		
		TestListener listener = new TestListener();
		ListenerRegistry.registerListener(listener);
		
		ListenerRegistry.finalizeListeners();
		
		new TestEvent();
	}
}
