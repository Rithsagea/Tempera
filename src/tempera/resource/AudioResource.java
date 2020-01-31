package tempera.resource;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioResource implements TemperaResource<Clip> {
	
	protected File file;
	protected Clip clip;
	protected String name;
	
	public AudioResource(File file, String name) {
		this.file = file;
		this.name = name;
	}
	
	public AudioResource(String path, String name) {
		this(new File(ResourceRegistry.getResourcePath() + path), name);
	}
	
	public AudioResource(File file) throws IOException {
		this(file, file.getCanonicalPath());
	}
	
	public AudioResource(String path) throws IOException {
		this(new File(ResourceRegistry.getResourcePath() + path));
	}

	public void loadResource() {
		synchronized(AudioSystem.class) {
			try {
				AudioInputStream ais = AudioSystem.getAudioInputStream(file);
				clip = AudioSystem.getClip();
				clip.open(ais);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public Clip getResource() {
		if(clip == null)
			loadResource();
		return clip;
	}
	
	public String getName() {
		return name;
	}
}
