package tempera.event;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashSet;
import java.util.Set;

public class ListenerRegistry {
	private static Set<Listener> listeners = new HashSet<Listener>();
	private static Set<Class<?>> events = new HashSet<Class<?>>();
	
	public static void registerEvent(Class<?> clazz) {
		if(!events.add(clazz)) {
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
						for(Class<?> event : events) {
							if(event.equals(clazz)) {
								try {
									Method eventMethod = event.getMethod("addHandler", Handler.class);
									Handler handler = new Handler(method, listener, annotation.priority());
									eventMethod.invoke(null, handler);
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
