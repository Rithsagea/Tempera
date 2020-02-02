package tempera.audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioClip {
	
	private AudioFormat format;
	private int frames;
	private int frameSize;
	private int bytes;
	private byte[] data;
	
	public AudioClip(File audioFile) throws UnsupportedAudioFileException, IOException {
		AudioInputStream ais = AudioSystem.getAudioInputStream(audioFile);
		AudioFileFormat aff = AudioSystem.getAudioFileFormat(audioFile);
		
		format = ais.getFormat();
		frames = aff.getFrameLength();
		frameSize = format.getFrameSize();
		bytes = frames * frameSize;
		
		data = new byte[bytes];
		ais.read(data);
	}
	
	public byte[] getData() {
		return data;
	}
	
	public AudioFormat getFormat() {
		return format;
	}
	
	public int getLengthInBytes() {
		return bytes;
	}
}
