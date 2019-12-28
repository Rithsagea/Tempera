package tempera.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import tempera.events.MousePressedEvent;
import tempera.game.GameWindow;

public class MouseData implements MouseMotionListener, MouseListener {

	private int mouseX = 0;
	private int mouseY = 0;
	private final GameWindow instance;
	
	public MouseData(GameWindow instance) {
		this.instance = instance;
	}
	
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
		new MousePressedEvent(instance);
		
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
