package api.tempera.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import api.tempera.event.EventBus;
import api.tempera.events.MousePressEvent;

public class MouseData implements MouseMotionListener, MouseListener {

	private int mouseX = 0;
	private int mouseY = 0;
	
	@Override
	public void mouseDragged(MouseEvent e) { }

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}
	
	@Override
	public void mousePressed(MouseEvent e) {
		EventBus.callEvent(new MousePressEvent(this));
		
		//play sound demo
//		soundDemo.getSoundFile("soundDemo.wav");
//		soundDemo.volumeControl((float).2,soundDemo.clip);
//		soundDemo.playSound(soundDemo.clip);
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	
	public int getX() {
		return mouseX;
	}
	
	public int getY() {
		return mouseY;
	}

}
