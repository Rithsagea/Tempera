package com.tempera.audio;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Audio {
	Clip clip;
	/**
	 * Sets clip to data stream from a .wav file
	 * @param file	the file that clip is set to
	 */
	public void getSoundFile(String file) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/resources/"+file).getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
		} catch(Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}
	
	/**
	 * Plays the audio from data stream in clip
	 */
	public void playSound() {
		clip.start();
	}
	
	/**
	 * Stops the current clip from the last sound file
	 */
	public void stop() {
		clip.stop();
	}
	
	/**
	 * Loops the clip through int start to int end until stopped
	 * @param start 	the frame that the loop starts on
	 * @param end 		the frame that the loop ends on
	 */
	public void loop(int start,int end) {
		clip.setLoopPoints(start,end);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	/**
	 * Adjust the volume of the current clip since the last sound file
	 * @param gain		set gain between 0.0 and 1.0 which corresponds with low to high
	 */
	public void volumeControl(float gain) {
		FloatControl gainControl =  (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue((float) (Math.log(gain) / Math.log(10.0) * 20.0));
	}
}
