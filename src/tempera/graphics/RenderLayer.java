package tempera.graphics;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class RenderLayer {
	protected List<RenderedObject> objects = new ArrayList<RenderedObject>();
	
	public void drawObjects(Graphics g) {
		for(RenderedObject object : objects) {
			object.draw(g);
		}
	}
}
