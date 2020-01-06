package tempera.event;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

public class RegisteredListener {
	
	private final Map<Class<?>, HandlerList> handlers = new HashMap<>();
	private final Listener listener; //this will be used somewhere, I think. Remove it in the future if it isn't necessary
	
	public RegisteredListener(Listener listener) {
		this.listener = listener;
		
		Method[] methods = listener.getClass().getDeclaredMethods();
		Parameter[] parameters;
		EventHandler annotation;
		
		//Loop through all methods in the listener
		for(Method method : methods) {
			annotation = method.getAnnotation(EventHandler.class);
			if(annotation != null) {
				//register the method as a handler if it contains
				//an EventHandler annotation
				parameters = method.getParameters();
				
				//check for incorrectly written handlers
				if(parameters.length == 1) {
					Class<?> eventClass = parameters[0].getType();
					if(!Event.class.isAssignableFrom(eventClass)) //if the handler doesn't actually provide an event, complain
						throw new RuntimeException("The handler " + method + " provides a broken event");
					
					//create a handler list if the event
					//has not been registered yet
					if(!handlers.containsKey(eventClass))
						handlers.put(eventClass, new HandlerList());
					
					//register the handler
					handlers.get(eventClass).addHandler(new Handler(method, listener, annotation.priority()));
					
				} else {
					if(parameters.length > 1)
						throw new RuntimeException("There are too many parameters for the handler " + method);
					else
						throw new RuntimeException("There is not a defined event for the handler " + method);
				}
			}
		}
	}
	
	public void executeEvent(Event event) {
		Class<?> eventClass = event.getClass();
		HandlerList handlerList = handlers.get(eventClass);
		if(handlerList != null)
			for(Handler handler : handlerList.handlers)
				handler.execute(event);
	}
}
