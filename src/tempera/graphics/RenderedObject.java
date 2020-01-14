package tempera.graphics;

import java.awt.Graphics2D;

public interface RenderedObject {
	public int getRenderLevel();
	public int getDrawLevel();
	public void draw(Graphics2D g2d);
}
