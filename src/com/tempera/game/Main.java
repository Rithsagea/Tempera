package com.tempera.game;

public class Main {
	
	private final static GameWindow window = new GameWindow();
	
	public static void main(String[] args) {
		while(true) {
			try {
				Thread.sleep(1000 / 20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			window.runTick();
		}
	}
}
