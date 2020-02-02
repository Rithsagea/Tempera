package tempera.audio;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class AudioPlayer {
	
	private SourceDataLine line;
	private Thread thread;
	
	public void play(AudioClip clip) throws LineUnavailableException {
		line = AudioSystem.getSourceDataLine(clip.getFormat());
		line.open(clip.getFormat());
		line.start();
		thread = new Thread() {
			public void run() {
				line.write(clip.getData(), 0, clip.getLengthInBytes());
				line.drain();
			}
			
			public void interrupt() {
				line.stop();
			}
		};
		
		thread.start();
	}
	
	public void stop() {
		thread.interrupt();
	}
}
