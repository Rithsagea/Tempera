package api.tempera.event;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//this is an annotation
//it tells the system which
//methods are handlers

@Retention(RetentionPolicy.RUNTIME)
public @interface EventHandler {
	//this denotes the priority of the handler
	//handlers with higher priorities will be
	//run first
	EventPriority priority() default EventPriority.NORMAL;
}
