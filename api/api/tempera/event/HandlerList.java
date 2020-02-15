package api.tempera.event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//you shouldn't need to use this

public class HandlerList {
	protected List<Handler> handlers = new ArrayList<Handler>();
	
	public Iterator<Handler> getIterator() {
		return handlers.iterator();
	}
	
	public boolean containsHandler(Handler handler) {
		return handlers.contains(handler);
	}
	
	public void removeHandler(Handler handler) {
		handlers.remove(handler);
	}
	
	public void addHandler(Handler handler) {
		handlers.add(handler);
	}
	
	public void sortHandlers() {
		Collections.sort(handlers);
	}
}
