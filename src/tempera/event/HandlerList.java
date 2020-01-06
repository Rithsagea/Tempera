package tempera.event;

import java.util.HashSet;
import java.util.Set;

public class HandlerList {
	protected Set<Handler> handlers = new HashSet<Handler>();
	
	/**
	 * Removes all handlers that come from the
	 * given listener
	 * @param listener	the listener to unregister
	 */
	public void removeHandler(Handler handler) {
		handlers.remove(handler);
	}
	
	public void addHandler(Handler handler) {
		handlers.add(handler);
	}
}
