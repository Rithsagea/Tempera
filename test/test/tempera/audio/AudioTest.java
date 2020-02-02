package test.tempera.audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import tempera.audio.AudioClip;

public class AudioTest {
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		AudioClip clip = new AudioClip(new File("src/resources/songDemo.wav"));
		clip.play();
		System.out.println(Integer.MAX_VALUE);
	}
}
