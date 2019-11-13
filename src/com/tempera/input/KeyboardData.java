package com.tempera.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class KeyboardData implements KeyListener {
	
	private static final HashMap<Integer, Boolean> keyData = new HashMap<Integer, Boolean>();
	
	@Override
	public void keyTyped(KeyEvent e) { }
	
	@Override
	public void keyPressed(KeyEvent e) {
		keyData.put(e.getKeyCode(), true);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		keyData.put(e.getKeyCode(), false);
	}
	
	public static boolean isKeyPressed(int keyCode) {
		if(keyData.containsKey(keyCode))
			return keyData.get(keyCode);
		return false;
	}
}
