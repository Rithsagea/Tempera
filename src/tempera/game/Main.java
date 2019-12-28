package tempera.game;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
	
	private static GameWindow window;
	private static Timer timer;
	public static int frameRate = 60;
	
	public static void main(String[] args) {
		window = new GameWindow();
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				GameWindow.tick();
				window.repaint();
			}
		}, 0, 1000 / 30);
	}
}
