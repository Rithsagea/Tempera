package com.tempera.audio;

import java.io.File;

import com.tempera.util.Deque;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Audio {
	public Clip clip;
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
			System.out.println("Error with audio.");
			ex.printStackTrace();
		}
	}
	
	
	//Clip controlling stuff
	/**
	 * Plays the audio from clip
	 * @param clip		the clip that is played
	 */
	public void playSound(Clip clip) {
		clip.start();
	}
	
	/**
	 * Stops the clip
	 * @param clip		the cllip that is stopped
	 */
	public void stop(Clip clip) {
		clip.stop();
	}
	
	/**
	 * Loops the clip through int start to int end until stopped
	 * @param start 	the second that the loop starts on
	 * @param end 		the second that the loop ends on
	 * @param clip		the clip that is being looped
	 */
	public void loop(double start,double end, Clip clip) {
		clip.setFramePosition(6500000);
		if (end == -1)
			clip.setLoopPoints((int)(start*1000000)/22,-1);
		else
			clip.setLoopPoints((int)(start*1000000)/22,((int)end*1000000)/22);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	/**
	 * Adjust the volume of the clip
	 * @param gain		set gain between 0.0 and 1.0 which corresponds with low to high
	 * @param clip		the clip that is being affected
	 */
	public void volumeControl(float gain, Clip clip) {
		FloatControl gainControl =  (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue((float) (Math.log(gain) / Math.log(10.0) * 20.0));
	}
	
	
	//Song queue methods
	/**
	 *Sets a clip to data stream from a .wav file and adds it to the top of queue
	 *@param file		the audio file that is added to queue
	 */
	public void queueAdd(String file) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/resources/"+file).getAbsoluteFile());
			queue.put(AudioSystem.getClip());
			queue.peak().open(audioInputStream);
		} catch(Exception ex) {
			System.out.println("Error with audio.");
			ex.printStackTrace();
		}
	}
	
	/**
	 * Removes the top of queue and returns it
	 */
	public Clip queuePoll() {
		return queue.poll();
	}
	
	/**
	 * checks to see if the song at the top of queue is playing
	 * @return		whether or not the song is playing or not
	 */
	public boolean queueIsPlaying() {
		if (queue.peak().isActive()) {
			return true;
		}
		return false;
	}
	
	/**
	 * gets the top of the queue
	 * @return		the top of the queue
	 */
	public Clip queueGetPeak() {
		return queue.peak();
	}
	
	/**
	 * gets the size of the queue
	 * @return		the size of the queue
	 */
	public int queueGetSize() {
		return queue.size();
	}
}
