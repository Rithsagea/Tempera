package api.tempera.audio;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class AudioPlayer {
	
	private SourceDataLine line;
	private Thread thread;
	
	/**
	 * Plays an audio clip.
	 * @param clip	the audio clip to be played
	 * @throws LineUnavailableException	if there aren't any audio lines available to play audio.
	 */
	public void play(AudioClip clip) throws LineUnavailableException {
		if(thread != null)
			if(!thread.isInterrupted())
				throw new RuntimeException("This audio player is currently playing another audio clip");
		
		line = AudioSystem.getSourceDataLine(clip.getFormat());
		line.open(clip.getFormat());
		line.start();
		//creates a new thread that will play the audio clip until it is finished.
		//if the thread is interrupted, then it will cease playing audio
		thread = new Thread() {
			public void run() {
				line.write(clip.getData(), 0, clip.getLengthInBytes());
				line.drain();
				interrupt();
			}
			
			public void interrupt() {
				if(line.isOpen())
					line.close();
			}
		};
		
		thread.start();
	}
	
	/**
	 * Stops the audio clip that is currently being played (if there is one)
	 */
	public void stop() {
		if(thread != null)
			thread.interrupt();
	}
}
