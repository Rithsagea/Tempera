package com.tempera.keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class KeyboardData implements KeyListener {
	
	private static final HashMap<Integer, Boolean> keyData = new HashMap<Integer, Boolean>();
	
	public KeyboardData() {
		keyData.put(KeyEvent.VK_RIGHT, false);
		keyData.put(KeyEvent.VK_LEFT, false);
		keyData.put(KeyEvent.VK_UP, false);
		keyData.put(KeyEvent.VK_DOWN, false);
	}
	
	@Override
	public void keyTyped(KeyEvent e) { }
	
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		keyData.put(e.getKeyCode(), true);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		keyData.put(e.getKeyCode(), false);
	}
	
	public static boolean isKeyPressed(int keyCode) {
		return keyData.get(keyCode);
	}
}
