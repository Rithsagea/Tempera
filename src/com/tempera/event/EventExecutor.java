package com.tempera.event;

public interface EventExecutor {
	public void execute(Listener listener, Event event);
}
