package com.tempera;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
	
	private static GameWindow window;
	private static Timer timer;
	public static final int frameRate = 30;
	
	public static void main(String[] args) {
		window = new GameWindow();
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				window.tick();
				window.repaint();
			}
		}, 0, 1000 / frameRate);
	}
}
