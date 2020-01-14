package test.tempera.graphics;

import java.awt.Graphics2D;

import tempera.graphics.RenderedObject;

public class TestRender implements RenderedObject {
	
	private int renderLevel;
	private int drawLevel;
	
	public TestRender(int renderLevel, int drawLevel) {
		this.renderLevel = renderLevel;
		this.drawLevel = drawLevel;
	}
	
	public int getRenderLevel() {
		return renderLevel;
	}
	
	public int getDrawLevel() {
		return drawLevel;
	}
	
	public void draw(Graphics2D g2d) {
		//do nothing
	}
}
