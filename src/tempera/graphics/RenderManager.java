package tempera.graphics;

import java.util.HashMap;

public class RenderManager {
	protected HashMap<RenderLevel, RenderLayer> renders;
	
	public RenderManager() {
		renders = new HashMap<RenderLevel, RenderLayer>();
		for(RenderLevel level : RenderLevel.values()) {
			renders.put(level, new RenderLayer());
		}
	}
}
