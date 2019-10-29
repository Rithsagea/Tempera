package com.tempera.game;

public class Main {
	
	private static GameWindow window;
	
	public static void main(String[] args) {
		window = new GameWindow();
		long time = System.currentTimeMillis();
		while(true) {
			if(time + 10000 > System.currentTimeMillis()) {
				GameWindow.tick();
				time = System.currentTimeMillis();
			}
			window.repaint();
		}
	}
}
