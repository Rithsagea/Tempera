package tempera.event;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EventBus {
	
	private Map<Class<?>, HandlerList> registeredEvents = new HashMap<Class<?>, HandlerList>();
	private Set<Listener> registeredListeners = new HashSet<Listener>();
	
	public void registerEvent(Class<?> eventClass) {
		if(registeredEvents.containsKey(eventClass))
			throw new RuntimeException("The event " + eventClass + " has already been registered.");
		registeredEvents.put(eventClass, new HandlerList());
	}
	
	public void unregisterEvent(Class<?> eventClass) {
		if(!registeredEvents.containsKey(eventClass))
			throw new RuntimeException("The event " + eventClass + " has not been registered yet");
		registeredEvents.remove(eventClass);
	}
	
	public void registerListener(Listener listener) {
		registeredListeners.add(listener);
	}
	
	public void unregisterListener(Listener listener) {
		registeredListeners.remove(listener);
	}
}
