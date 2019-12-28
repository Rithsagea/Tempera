package com.tempera.event;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Handler {
	
	protected Method eventMethod;
	protected Listener eventListener;
	protected EventPriority priority;
	
	public Handler(Method eventMethod, Listener eventListener, EventPriority priority) {
		this.eventMethod = eventMethod;
		this.eventListener = eventListener;
		this.priority = priority;
	}
	
	public void execute(Event event) {
		try {
			eventMethod.invoke(eventListener, event.getClass().cast(event));
		} catch (Exception e) {
			e.printStackTrace();
			//there was an error
			//do some handling later
		}
	}
}
