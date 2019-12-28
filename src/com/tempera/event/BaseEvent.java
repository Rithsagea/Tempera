package com.tempera.event;

import java.util.HashSet;
import java.util.Set;

public class BaseEvent implements Event {
	
	private static Set<Handler> handlers = new HashSet<Handler>();
	
	public BaseEvent() {
		for(Handler handler : handlers) {
			handler.execute(this);
		}
	}
	
	@Override
	public void addHandler(Handler handler) {
		handlers.add(handler);
	}
}
