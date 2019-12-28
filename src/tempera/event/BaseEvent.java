package tempera.event;

import java.util.HashSet;
import java.util.Set;

public class BaseEvent implements Event {
	
	private static Set<Handler> handlers = new HashSet<Handler>();
	
	public BaseEvent() {
		
	}
	
	public void executeEvent() {
		for(Handler handler : handlers) {
			handler.execute(this);
		}
	}
	
	@Override
	public void addHandler(Handler handler) {
		handlers.add(handler);
	}
}
