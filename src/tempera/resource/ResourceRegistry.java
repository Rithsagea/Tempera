package tempera.resource;

import java.util.HashMap;
import java.util.Map;

public class ResourceRegistry {
	private Map<String, TemperaResource<?>> registeredResources = new HashMap<String, TemperaResource<?>>();
	private static String resourcePath;
	
	public ResourceRegistry(String resourcePath) {
		ResourceRegistry.resourcePath = resourcePath;
	}
	
	public boolean registerResource(TemperaResource<?> resource) {
		if(registeredResources.containsKey(resource.getName()))
			return false;
		
		registeredResources.put(resource.getName(), resource);
		
		return true;
	}
	
	public void registerResources(TemperaResource<?>... resources) {
		for(TemperaResource<?> resource : resources) {
			registerResource(resource);
		}
	}
	
	public TemperaResource<?> getResource(String name) {
		return registeredResources.get(name);
	}
	
	public void printResources() {
		for(String name : registeredResources.keySet())
			System.out.println(name);
	}
	
	public static String getResourcePath() {
		return resourcePath;
	}
}
