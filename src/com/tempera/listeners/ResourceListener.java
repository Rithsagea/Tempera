package com.tempera.listeners;

import api.tempera.event.EventHandler;
import api.tempera.event.EventPriority;
import api.tempera.event.Listener;
import api.tempera.events.GameStartEvent;
import api.tempera.resource.ResourceManager;

public class ResourceListener implements Listener {
	
	//IGNORE THIS
	//does literally nothing, as I have not finished
	//writing the api behind this
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onGameStart(GameStartEvent event) {
		ResourceManager.setResourceFolder("src/resources/");
	}
}
