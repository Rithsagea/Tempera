package test.tempera.audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import tempera.audio.AudioClip;
import tempera.audio.AudioPlayer;

public class AudioTest {
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
		AudioClip clip1 = new AudioClip(new File("src/resources/songDemo.wav"));
		AudioClip clip2 = new AudioClip(new File("src/resources/soundDemo.wav"));
		AudioClip clip3 = new AudioClip(new File("src/resources/songdemo2.wav"));
		
		
		AudioPlayer player1 = new AudioPlayer();
		player1.play(clip1);
		
		AudioPlayer player2 = new AudioPlayer();
		
		Thread.sleep(3000);
		player2.play(clip1);
	}
}
