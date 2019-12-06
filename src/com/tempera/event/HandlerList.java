package com.tempera.event;

import java.util.Set;

public class HandlerList {
	public Set<RegisteredListener> handlers;
	
	public void registerListener(RegisteredListener listener) {
		handlers.add(listener);
	}
	
	public void fireListeners(Event event) {
		for(RegisteredListener listener : handlers) {
			listener.callEvent(event);
		}
	}
}
