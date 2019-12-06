package com.tempera.event;

public class RegisteredListener {
	
	private Listener listener;
	private EventExecutor executor;
	
	public RegisteredListener(Listener listener, EventExecutor executor) {
		this.listener = listener;
		this.executor = executor;
	}
	
	public void callEvent(Event event) {
		executor.execute(listener, event);
	}
}
