package test.tempera.event;

import tempera.event.EventBus;

public class EventTest {
	public static void main(String[] args) throws Exception {
		
		new EventTest().run();
	}
	
	private void run() throws Exception {
		TestListener listener1 = new TestListener();
		TestListener2 listener2 = new TestListener2();
		
		EventBus.registerListener(listener2);
		EventBus.registerListener(listener1);

		EventBus.finalizeHandlers();
		
//		EventBus.callEvent(new TestEvent(5));
//		EventBus.callEvent(new TestEvent(6));
		EventBus.callEvent(new TestEvent2());
		
//		EventBus.unregisterListener(listener2);
//		EventBus.callEvent(new TestEvent2());
		
	}
}
