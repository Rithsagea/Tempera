package api.tempera.resource;

public class ResourceManager {
	private static String resourceFolder = "";
	
	public static void setResourceFolder(String resourceFolder) {
		ResourceManager.resourceFolder = resourceFolder;
	}
	
	public static String getResourceFolder() {
		return resourceFolder;
	}
}
