package com.tempera;

import com.tempera.listeners.PlayerListener;
import com.tempera.listeners.RenderListener;
import com.tempera.listeners.ResourceListener;
import com.tempera.listeners.SoundListener;

import api.tempera.event.EventBus;
import api.tempera.game.TemperaWindow;

public class GameWindow extends TemperaWindow {

	private static final long serialVersionUID = 1L;
	
	public void registerListeners() {
		EventBus.registerListener(new ResourceListener());
		EventBus.registerListener(new RenderListener());
		EventBus.registerListener(new PlayerListener());
		EventBus.registerListener(new SoundListener());
	}
}
