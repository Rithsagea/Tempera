package com.tempera.listeners;

import java.io.File;

import api.tempera.audio.AudioClip;
import api.tempera.audio.AudioPlayer;
import api.tempera.event.EventHandler;
import api.tempera.event.EventPriority;
import api.tempera.event.Listener;
import api.tempera.events.GameStartEvent;
import api.tempera.events.MousePressEvent;
import api.tempera.game.TemperaWindow;
import api.tempera.input.KeyboardData;
import api.tempera.input.MouseData;

public class InputListener implements Listener {
	
	private MouseData mouseData;
	private AudioPlayer player;
	private AudioClip clickAudio;
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onGameStart(GameStartEvent event) {
		TemperaWindow window = event.getWindow();
		player = new AudioPlayer();
		try {
			clickAudio = new AudioClip(new File("src/resources/songdemo2.wav"));
		} catch (Exception e){
			e.printStackTrace();
		}
		
		mouseData = new MouseData();
		
		window.addKeyListener(new KeyboardData());
		
		window.addMouseListener(mouseData);
		window.addMouseMotionListener(mouseData);
	}
	
	@EventHandler
	public void onMousePress(MousePressEvent event) {
		System.out.println("A mouse button has been pressed yeet");
	}
}
