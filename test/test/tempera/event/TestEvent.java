package test.tempera.event;

import api.tempera.event.Event;

public class TestEvent extends Event {
	private int val;
	
	public TestEvent(int val) {
		this.val = val;
	}
	
	public int getVal()  {
		return val;
	}
}
