package api.tempera.graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import api.tempera.game.TemperaWindow;
import api.tempera.geometry.Point;

public class RenderEngine {
	private List<RenderedObject> renderedObjects = new ArrayList<RenderedObject>();
	private Comparator<RenderedObject> comparator = new RenderedObjectComparator();
	private AffineTransform transformation;
	private Point camera = new Point(0, 0);
	
	public void addObject(RenderedObject obj) {
		renderedObjects.add(obj);
	}
	
	public void removeObject(RenderedObject obj) {
		renderedObjects.remove(obj);
	}
	
	public void clearObjects() {
		renderedObjects.clear();
	}
	
	public void renderObjects(Graphics2D g2d) {
		g2d.setTransform(transformation);
		
		Collections.sort(renderedObjects, comparator);
		for(RenderedObject obj : renderedObjects) {
			obj.draw(g2d);
		}
	}
	
	//Setup
	//TODO add a zoom factor
	public void updateOffset(TemperaWindow window) {
		Point center = window.getCenter();
		
		transformation = new AffineTransform();
		
		//Move origin to center of the screen
		//Eventually make it so that it can be
		//in other places (camera here)
		transformation.translate(center.getX() + camera.getX(), center.getY() - camera.getY());
	}
	
	//Debug
	public void printObjects() {
		Collections.sort(renderedObjects, comparator);
		for(RenderedObject obj : renderedObjects) {
			System.out.println("" + obj.getRenderLevel() + ": " + obj.getDrawLevel() + " - " + obj);
		}
	}
	
	public Point getCamera() {
		return camera;
	}
}
