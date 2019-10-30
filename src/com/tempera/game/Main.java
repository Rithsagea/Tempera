package com.tempera.game;

public class Main {
	
	private static GameWindow window;
	
	public static void main(String[] args) {
		window = new GameWindow();
		long nextTick = System.currentTimeMillis();
		while(true) {
			if(nextTick < System.currentTimeMillis()) {
				GameWindow.tick();
				nextTick = System.currentTimeMillis() + 1000 / 50;
			}
			window.repaint();
		}
	}
}
