package tempera.audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

import sun.audio.AudioData;

public class AudioClip {
	
	private AudioData audioData;
	
	private AudioFormat format;
	private int frames;
	private int frameSize;
	private int bytes;
	private float frameRate;
	private byte[] data;
	
	public AudioClip(File audioFile) throws UnsupportedAudioFileException, IOException {
		AudioInputStream ais = AudioSystem.getAudioInputStream(audioFile);
		AudioFileFormat aff = AudioSystem.getAudioFileFormat(audioFile);
		
		format = ais.getFormat();
		frames = aff.getFrameLength();
		frameSize = format.getFrameSize();
		frameRate = format.getFrameRate();
		bytes = frames * frameSize;
		
		data = new byte[bytes];
		ais.read(data);
	}
	
	public void play() throws LineUnavailableException {
		SourceDataLine line = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
		line = (SourceDataLine) AudioSystem.getLine(info);
		line.open(format);
		
		line.start();
		line.write(data,  0, bytes);
		line.drain();
		line.close();
	}
}
