package tempera.audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioClip {
	
	private byte[] data;
	
	public AudioClip(File audioFile) throws UnsupportedAudioFileException, IOException {
		AudioInputStream ais = AudioSystem.getAudioInputStream(audioFile);
		int bytesPerFrame = ais.getFormat().getFrameSize();
		long bytesTotal = bytesPerFrame * ais.getFrameLength();
		System.out.println(bytesTotal);
	}
}
