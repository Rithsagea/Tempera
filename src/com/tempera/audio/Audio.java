package com.tempera.audio;

import java.io.File;

import com.tempera.util.Deque;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Audio {
	Clip clip;
	Deque<Clip> queue = new Deque<Clip>();
	
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
	
	
	//Clip controlling stuff
	/**
	 * Plays the audio from clip
	 */
	public void playSound() {
		clip.start();
	}
	
	/**
	 * Stops the current clip
	 */
	public void stop() {
		clip.stop();
	}
	
	/**
	 * Loops the clip through int start to int end until stopped
	 * @param start 	the second that the loop starts on
	 * @param end 		the second that the loop ends on
	 */
	public void loop(double start,double end) {
		clip.setFramePosition(6500000);
		if (end == -1)
			clip.setLoopPoints((int)(start*1000000)/22,-1);
		else
			clip.setLoopPoints((int)(start*1000000)/22,((int)end*1000000)/22);
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
	
	//Song queue methods
	/**
	 * Add the clip from getSoundFile to the queue list
	 */
	public void add() {
		queue.put(clip);
	}
	
	/**
	 * Removes the top of queue and returns it
	 */
	public Clip poll() {
		return queue.poll();
	}
	
	/**
	 * checks to see if the song at the top of queue is playing
	 * @return		whether or not the song is playing or not
	 */
	public boolean checkPlaying() {
		if (queue.peak().isActive()) {
			return true;
		}
		return false;
	}
	
	/**
	 * gets the top of the queue
	 * @return		the top of the queue
	 */
	public Clip getPeak() {
		return queue.peak();
	}
}
