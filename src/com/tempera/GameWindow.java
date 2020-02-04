package com.tempera;

import com.tempera.listeners.CollisionListener;
import com.tempera.listeners.InputListener;
import com.tempera.listeners.PhysicsListener;
import com.tempera.listeners.PlayerListener;
import com.tempera.listeners.RenderListener;
import com.tempera.listeners.SoundListener;

import api.tempera.event.EventBus;
import api.tempera.game.TemperaWindow;

public class GameWindow extends TemperaWindow {

	private static final long serialVersionUID = 1L;
	
	public void registerListeners() {
		EventBus.registerListener(new RenderListener());
		EventBus.registerListener(new InputListener());
		EventBus.registerListener(new PlayerListener());
		EventBus.registerListener(new SoundListener());
		EventBus.registerListener(new CollisionListener());
		EventBus.registerListener(new PhysicsListener());
	}
}
