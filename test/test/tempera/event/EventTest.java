package test.tempera.event;

import tempera.event.ListenerRegistry;

public class EventTest {
	public static void main(String[] args) throws Exception {
		
		new EventTest().run();
	}
	
	private void run() throws Exception {
		ListenerRegistry.registerEvent(new TestEvent());
		
		TestListener listener = new TestListener();
		ListenerRegistry.registerListener(listener);
		
		ListenerRegistry.finalizeListeners();
		
		new TestEvent();
	}
}
