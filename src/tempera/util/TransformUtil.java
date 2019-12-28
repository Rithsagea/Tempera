package tempera.util;

import java.awt.geom.AffineTransform;

import tempera.vector.Rectangle;

public class TransformUtil {
	public static AffineTransform getTransformation(Rectangle rect, double angle) {
		AffineTransform position = new AffineTransform();
		AffineTransform rotation = new AffineTransform();
		AffineTransform translation = new AffineTransform();
		
		rotation.rotate(angle);
		
		translation.concatenate(rotation);
		translation.translate(-rect.width / 2, -rect.height / 2);
		
		position.translate(rect.x, rect.y);
		position.concatenate(translation);
		
		return position;
	}
}
