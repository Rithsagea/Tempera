package tempera.resource;

public interface TemperaResource<T> {
	
	public String getName();
	public void loadResource();
	public T getResource();
	
}
