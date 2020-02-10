package com.tempera;

import com.tempera.listeners.PlayerListener;
import com.tempera.listeners.RenderListener;
import com.tempera.listeners.ResourceListener;
import com.tempera.listeners.SoundListener;

import api.tempera.event.EventBus;
import api.tempera.game.TemperaWindow;

//Note to self: figure out whether serial is important or not

@SuppressWarnings("serial")
public class GameWindow extends TemperaWindow {
	
	//Register Listeners
	//Listeners are pretty much things that
	//"listen" to events. Methods in a listener
	//with "@EventHandler" before them are called
	//handlers, whenever the event in the parameter
	//is called, that method will be called.
	//
	//Make sure to register listeners here, or they
	//will do literally nothing
	public void registerListeners() {
		EventBus.registerListener(new ResourceListener());
		EventBus.registerListener(new RenderListener());
		EventBus.registerListener(new PlayerListener());
		EventBus.registerListener(new SoundListener());
	}
}
