package tempera.event;

import java.util.HashSet;
import java.util.Set;

public class EventBus {
	
	private static Set<Class<?>> registeredEvents = new HashSet<>();
	private static Set<RegisteredListener> registeredListeners = new HashSet<>();
	
	//Registering and unregistering things
	
	public static void registerEvent(Class<?> eventClass) {
		if(registeredEvents.contains(eventClass))
			throw new RuntimeException("The event " + eventClass + " has already been registered.");
		registeredEvents.add(eventClass);
	}
	
	public static void unregisterEvent(Class<?> eventClass) {
		if(!registeredEvents.contains(eventClass))
			throw new RuntimeException("The event " + eventClass + " has not been registered yet");
		registeredEvents.remove(eventClass);
	}
	
	public static void registerListener(Listener listener) {
		registeredListeners.add(new RegisteredListener(listener));
	}
	
	public static boolean unregisterListener(Listener listener) {
		for(RegisteredListener registeredListener : registeredListeners) {
			if(registeredListener.listener == listener) {
				registeredListeners.remove(registeredListener);
				return true;
			}
		}
		
		return false;
	}
	
	//Starting events
	
	public void callEvent(Event event) {
		if(!registeredEvents.contains(event.getClass()))
			throw new RuntimeException("The event " + event.getClass() + " has not been registered");
		
		for(RegisteredListener registeredListener : registeredListeners) {
			registeredListener.executeEvent(event);
		}
	}
}
