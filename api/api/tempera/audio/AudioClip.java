package api.tempera.audio;

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
	
	/**
	 * Creates an audio clip from a file.
	 * @param audioFile	The file where the audio is stored
	 */
	public AudioClip(File audioFile){
		AudioInputStream ais = null;
		AudioFileFormat aff = null;
		
		try {
			ais = AudioSystem.getAudioInputStream(audioFile);
			aff = AudioSystem.getAudioFileFormat(audioFile);
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		format = ais.getFormat();
		frames = aff.getFrameLength();
		frameSize = format.getFrameSize();
		bytes = frames * frameSize;
		
		data = new byte[bytes];
		try {
			ais.read(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the audio data in a byte array
	 * @return	the audio data in a byte array
	 */
	public byte[] getData() {
		return data;
	}
	
	/**
	 * Gets the format of the audio
	 * @return	the format of the audio
	 */
	public AudioFormat getFormat() {
		return format;
	}
	
	/**
	 * Gets the length of the audio clip in bytes
	 * @return	the length of the audio clip in bytes
	 */
	public int getLengthInBytes() {
		return bytes;
	}
}
