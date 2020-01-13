package tempera.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import tempera.entity.PhysicsObject;
import tempera.geometry.BoundingBox;
import tempera.geometry.Point;

public class Sprite extends PhysicsObject implements RenderedObject {
	
	public Image image;
	public double angleOffset;
	
	public int imageHeight;
	public int imageWidth;
	
	public Sprite(BoundingBox hitbox, String filePath) {
		super(hitbox, Double.POSITIVE_INFINITY);
		setImage(filePath);
		resizeImage();
	}
	
	public Sprite(String filePath) {
		super(new BoundingBox(0, 0, 0, 0), Double.POSITIVE_INFINITY);
		setImage(filePath);
		
		boundingBox.setLength(imageWidth);
		boundingBox.setWidth(imageHeight);
	}
	
	/**
	 * Sets the image for this sprite
	 * 
	 * TODO add arguments for resizing the image
	 * TODO save the image in a form that doesn't require resizing
	 * @param filePath	The file which contains the image for this sprite
	 */
	public void setImage(String filePath) {
		try {
			image = ImageIO.read(new File(filePath));
		} catch (IOException e) {
			System.out.println(filePath + " could not be found.");
		}
		imageWidth = image.getWidth(null);
		imageHeight = image.getHeight(null);
		
//		System.out.format("(%.2f, %.2f)\n", width, height);
	}
	
	public void resizeImage() {
		image = image
				.getScaledInstance(
						(int)boundingBox.getLength(),
						(int)boundingBox.getWidth(),
						0);
	}
	
	/**
	 * Draws this sprite on a graphics object
	 * 
	 * TODO make it not resize the image each time it gets drawn
	 */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;

//		AffineTransform transformation = TransformUtil.getTransformation(boundingBox, angleOffset + boundingBox.angle);
		
//		g2d.setTransform(transformation);
		Point topLeft = boundingBox.getPoints()[0];
		g2d.drawImage(image, (int)topLeft.getX(), (int)topLeft.getY(), null);
//		g2d.drawRect(0, 0, (int)width, (int)height);	//change back
//		transformation.setToIdentity();
//		g2d.setTransform(transformation);
	}

	public void setOffset(double angleOffset) {
		this.angleOffset = angleOffset;
	}
	
	@Override
	public void updatePosition() {
		velocity.multiply(friction); //applies friction
		position.add(velocity);
		
		boundingBox.getCenter().setX(position.getX()).setY(position.getY());
	}
}
