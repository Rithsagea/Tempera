package tempera.event;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashSet;
import java.util.Set;

public class ListenerRegistry {
	private static Set<Listener> listeners = new HashSet<Listener>();
	private static Set<Event> events = new HashSet<Event>();
	
	public static void registerEvent(Event event) {
		if(!events.add(event)) {
			//error handling
		}
	}
	
	public static void registerListener(Listener listener) {
		if(!listeners.add(listener)) {
			//say something about how the
			//listener has already been
			//registered
		}
	}
	
	public static void finalizeListeners() {
		Method[] methods;
		Parameter[] params;
		EventHandler annotation;
		//loop through all existing listeners
		for(Listener listener : listeners) {
			methods = listener.getClass().getDeclaredMethods();
			//loop through all the methods in the listeners
			for(Method method : methods) {
				annotation = method.getAnnotation(EventHandler.class);
				if(annotation != null) {
					params = method.getParameters();
					if(params.length == 1) {
						Class<?> clazz = params[0].getType();
						for(Event event : events) {
							if(event.getClass().equals(clazz)) {
								try {
									event.addHandler(new Handler(method, listener, annotation.priority()));
								} catch(Exception e) { //something happened, not sure why but it happened
									e.printStackTrace();
								}
							}
						}
					} else {
						//too many params
						//throw some error
					}
				}
			}
		}
	}
}
