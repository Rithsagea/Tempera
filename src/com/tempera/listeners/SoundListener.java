package com.tempera.listeners;

import java.io.File;

import api.tempera.audio.AudioClip;
import api.tempera.audio.AudioPlayer;
import api.tempera.event.EventHandler;
import api.tempera.event.Listener;
import api.tempera.events.GameStartEvent;

public class SoundListener implements Listener {
	private AudioPlayer player = new AudioPlayer();
	
	private AudioClip clip;
	
	@EventHandler
	public void onGameStart(GameStartEvent event) throws Exception {
		
		//creates an audio clip from the file provided
		clip = new AudioClip(new File("src/resources/songDemo.wav"));
		
		//plays the audio clip
		player.play(clip);
	}
}
