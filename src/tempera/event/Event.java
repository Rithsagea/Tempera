package tempera.event;

import java.util.HashSet;
import java.util.Set;

public class Event {
	private static Set<Handler> handlers = new HashSet<Handler>();
	
	public static void addHandler(Handler handler) {
		handlers.add(handler);
	}
	
	public void executeEvent() {
		for(Handler handler : handlers) {
			handler.execute(this);
		}
	}
}
