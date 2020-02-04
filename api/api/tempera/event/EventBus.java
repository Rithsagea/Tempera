package api.tempera.event;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EventBus {
	
	private static Set<Listener> registeredListeners = new HashSet<>();
	
	private static Map<Class<?>, HandlerList> registeredHandlers = new HashMap<>();
	
	public static void registerListener(Listener listener) {
		if(registeredListeners.contains(listener))
			throw new RuntimeException("The listener " + listener + " has already been registered");
		
		registeredListeners.add(listener);
		registerHandlers(listener);
	}
	
	public static boolean unregisterListener(Listener listener) {
		if(!registeredListeners.contains(listener))
			throw new RuntimeException("The listener " + listener + " has not yet been registered");
		
		Iterator<Handler> iter;
		Handler handler;
		
		for(HandlerList handlers : registeredHandlers.values()) {
			iter = handlers.getIterator();
			
			while(iter.hasNext()) {
				handler = iter.next();			
				if(handler.eventListener == listener && handlers.containsHandler(handler)) {
					iter.remove();
//					handlers.removeHandler(handler);
				}
			}
		}
		
		registeredListeners.remove(listener);
		
		return false;
	}
	
	public static void registerHandlers(Listener listener) {
		Method[] methods = listener.getClass().getDeclaredMethods();
		
		for(Method method : methods) {
			EventHandler annotation = method.getAnnotation(EventHandler.class);
			
			if(annotation != null) {
				Parameter[] parameters = method.getParameters();
				
				if(parameters.length > 1)
					throw new RuntimeException("There are too many parameters for the handler " + method);
				else if(parameters.length == 0)
					throw new RuntimeException("There is not a defined event for the handler " + method);
				
				Class<?> eventClass = parameters[0].getType();
				
				if(!Event.class.isAssignableFrom(eventClass))
					throw new RuntimeException("The handler " + method + " provides a broken event");
				
				if(!registeredHandlers.containsKey(eventClass))
					registeredHandlers.put(eventClass, new HandlerList());
				
				registeredHandlers.get(eventClass).addHandler(new Handler(method, listener, annotation.priority()));
			}
		}
	}
	
	public static void finalizeHandlers() {
		for(HandlerList handlers : registeredHandlers.values()) {
			handlers.sortHandlers();
		}
	}
	
	//Calling events
	
	public static void callEvent(Event event) {
		if(!registeredHandlers.containsKey(event.getClass())) {
//			System.err.println("The event " + event.getClass() + " is not currently being used by any listeners");
			return;
		}
		
		HandlerList handlers = registeredHandlers.get(event.getClass());
		
		for(Handler handler : handlers.handlers) {
			handler.execute(event);
		}
	}
}
