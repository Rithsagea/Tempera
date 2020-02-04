package com.tempera.listeners;

import api.tempera.audio.Audio;
import api.tempera.event.EventHandler;
import api.tempera.event.Listener;
import api.tempera.events.GameStartEvent;
import api.tempera.events.GameTickEvent;

public class SoundListener implements Listener {
	
	private Audio audio = new Audio();
	
	@EventHandler
	public void onGameStart(GameStartEvent event) {
		
		//add songs to queue
		audio.queueAddToBottom("songDemo.wav");
		audio.queueAddToBottom("songdemo2.wav");
		audio.volumeControl((float).3, audio.getPlayingSong());
		audio.playSound(audio.getPlayingSong());
	}
	
	@EventHandler
	public void onGameTick(GameTickEvent event) {
		//move to next song once head clip is not active
		if (audio.getQueuedSongs() > 1) {
			if (!audio.isPlaying()) {
				audio.queuePoll();
				audio.volumeControl((float).3, audio.getPlayingSong());
				audio.playSound(audio.getPlayingSong());
			}
		}
	}
}
