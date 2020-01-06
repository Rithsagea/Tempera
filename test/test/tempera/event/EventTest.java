package test.tempera.event;

import tempera.event.EventBus;

public class EventTest {
	public static void main(String[] args) throws Exception {
		
		new EventTest().run();
	}
	
	private void run() throws Exception {
		EventBus.registerEvent(TestEvent.class);
		EventBus.registerEvent(TestEvent2.class);
		EventBus.registerListener(new TestListener());
		EventBus.registerListener(new TestListener2());
		EventBus.callEvent(new TestEvent(5));
		EventBus.callEvent(new TestEvent(6));
		EventBus.callEvent(new TestEvent2());
	}
}
