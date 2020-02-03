package tempera.listeners;

import java.io.File;

import tempera.audio.AudioClip;
import tempera.audio.AudioPlayer;
import tempera.event.EventHandler;
import tempera.event.EventPriority;
import tempera.event.Listener;
import tempera.events.GameStartEvent;
import tempera.events.MousePressEvent;
import tempera.game.GameWindow;
import tempera.input.KeyboardData;
import tempera.input.MouseData;

public class InputListener implements Listener {
	
	private MouseData mouseData;
	private AudioPlayer player;
	private AudioClip clickAudio;
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onGameStart(GameStartEvent event) {
		GameWindow window = event.getWindow();
		player = new AudioPlayer();
		try {
			clickAudio = new AudioClip(new File("src/resources/songdemo2.wav"));
		} catch (Exception e){
			e.printStackTrace();
		}
		
		mouseData = new MouseData();
		
		window.addKeyListener(new KeyboardData());
		
		window.addMouseListener(mouseData);
		window.addMouseMotionListener(mouseData);
	}
	
	@EventHandler
	public void onMousePress(MousePressEvent event) {
		System.out.println("A mouse button has been pressed yeet");
	}
}
