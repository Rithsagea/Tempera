package test.tempera.audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.UnsupportedAudioFileException;

import tempera.audio.AudioClip;

public class AudioTest {
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException {
		AudioClip clip = new AudioClip(new File("src/resources/songDemo.wav"));
		System.out.println(Integer.MAX_VALUE);
	}
}
