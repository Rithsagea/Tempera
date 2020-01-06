package tempera.listeners;

import tempera.audio.Audio;
import tempera.event.EventHandler;
import tempera.event.Listener;
import tempera.events.GameStartEvent;
import tempera.events.GameTickEvent;

public class SoundListener implements Listener {
	
	private Audio audio = new Audio();
	
	@EventHandler
	public void onGameStart(GameStartEvent event) {
		audio.getSoundFile("songDemo.wav");
		audio.volumeControl((float).1,audio.clip);
		audio.playSound(audio.clip);
		audio.loop(0.5,-1,audio.clip);
		
		//add songs to queue
		audio.queueAddToBottom("songDemo.wav");
		audio.queueAddToBottom("songdemo2.wav");
		audio.volumeControl((float).3, audio.getPlayingSong());
		audio.playSound(audio.getPlayingSong());
	}
	
	@EventHandler
	public void onGameTick(GameTickEvent event) {
		//move to next song once head clip is not active
		if (audio.getQueuedSongs() > 0) {
			if (!audio.isPlaying()) {
				audio.queuePoll();
				audio.volumeControl((float).3, audio.getPlayingSong());
				audio.playSound(audio.getPlayingSong());
			}
		}
	}
}
