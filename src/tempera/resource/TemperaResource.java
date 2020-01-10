package tempera.resource;

import java.io.File;

public interface TemperaResource<T> {
	
	public void loadResource();
	public T getResource();
	public boolean createResource(File file, T obj);
	
}
