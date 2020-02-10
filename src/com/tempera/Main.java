package com.tempera;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
	
	private static GameWindow window;
	private static Timer timer;
	public static final int frameRate = 30;
	
	public static void main(String[] args) {
		
		//This part defines the window 
		window = new GameWindow();
		
		//Creates a timer to make the game tick regularly
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				window.tick();		//causes the game to tick once
				window.repaint();	//redraws the game
			}
		}, 0, 1000 / frameRate);
	}
}
