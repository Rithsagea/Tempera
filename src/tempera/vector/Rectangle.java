package tempera.vector;

public class Rectangle implements Polygon {
	
	public double x;
	public double y;
	public double height;
	public double width;
	
	public double angle;
	
	/**
	 * 
	 * @param x			the x coordinate of the top left corner
	 * @param y			the y coordinate of the top left corner
	 * @param width		the width of the rectangle
	 * @param height	the height of the rectangle
	 */
	public Rectangle(double x, double y, double width, double height) {
		this.x = x + width / 2;
		this.y = y - width / 2;
		
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Gets the center of this rectangle
	 * @return	the center of this rectangle
	 */
	public Point getCenter() {
		return new Point(x, y);
	}
	
	public Point[] getPoints() {
		double hh = height / 2;
		double hw = width / 2;
		
		return new Point[] {
				new Point(x - hw, y - hh),
				new Point(x - hw, y + hh),
				new Point(x + hw, y + hh),
				new Point(x + hw, y - hh)
		};
	}
}