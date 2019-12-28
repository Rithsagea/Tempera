package tempera.vector;

/**
 * @author	Rithsagea
 * @version	alpha.-1
 * @since	2019-11-22
 */
public class Vector extends Point implements Cloneable {
	
	protected double angle;
	protected double radius;
	
	/**
	 * Create a vector with double values
	 * @param x	An double that represents the vector's x coordinate
	 * @param y An double that represents the vector's y coordinate
	 * @param z An double that represents the vector's z coordinate
	 */
	public Vector(double x, double y) {
		super(x, y);
		this.x = x;
		this.y = y;
		calculatePolar();
	}
	
	/**
	 * Creates a vector from point p
	 * @param p	the point p
	 */
	public Vector(Point p) {
		super(p.x, p.y);
		calculatePolar();
	}
	
	/**
	 * Creates a vector from point A
	 * to point B
	 * @param A	the point A
	 * @param B	the point B
	 */
	public Vector(Point A, Point B) {
		this(B.x - A.x, B.y - A.y);
	}
	
	//Object Methods
	public Vector clone() {
		return new Vector(x, y);
	}
	
	public String toString() {
		return String.format("(%.4f, %.4f)", x, y);
	}
	
	//Getters
	/**
	 * Gets the angle of this vector
	 * @return	the angle of this vector
	 */
	public double getAngle() {
		return angle;
	}
	
	/**
	 * Gets the magnitude of this vector
	 * @return	the magnitude of this vector
	 */
	public double getMagnitude() {
		return radius;
	}
	
	//Setters
	/**
	 * Sets the angle of this vector
	 * @param angle	the angle in radians to set this vector to
	 * @return	this vector
	 */
	public Vector setAngle(double angle) {
		calculatePolar();
		this.angle = angle;
		calculateComponent();
		return this;
	}
	
	public Vector addAngle(double angle) {	//pretty much duplicate code but shhh
		calculatePolar();
		this.angle += angle;
		calculateComponent();
		return this;
	}
	
	/**
	 * Sets the magnitude of this vector
	 * @param magnitude	the magnitude to set this vector to
	 * @return this vector
	 */
	public Vector setMagnitude(double magnitude) {
		calculatePolar();
		this.radius = magnitude;
		calculateComponent();
		return this;
	}
	
	//Calculation
	/**
	 * Updates the polar form of this vector
	 */
	public void calculatePolar() {
		radius = Math.sqrt(x * x + y * y);	//will remove sqrt later if necessary
		angle = Math.atan2(y, x);
	}
	
	/**
	 * Updates the component form of this vector
	 */
	public void calculateComponent() {
		x = radius * Math.cos(angle);
		y = radius * Math.sin(angle);
	}
	
	//Operators
	/**
	 * Adds another vector to this one
	 * @param vector	the vector to add
	 */
	public void add(Vector vector) {
		x += vector.x;
		y += vector.y;
	}
	
	/**
	 * Adds another vector to this one
	 * @param x	the x value to add
	 * @param y	the y value to add
	 * @return	this vector
	 */
	public Vector add(double x, double y) {
		this.x += x;
		this.y += y;
		
		return this;
	}
	
	/**
	 * Subtracts this vector by another
	 * @param vector	the vector to subtract
	 */
	public void subtract(Vector vector) {
		x -= vector.x;
		y -= vector.y;
	}
	
	/**
	 * Subtracts this vector by another
	 * @param x	the x value to subtract
	 * @param y	the y value to subtract
	 */
	public void subtract(double x, double y) {
		this.x -= x;
		this.y -= y;
	}
	
	/**
	 * Multiplies the x and y coordinate by the scalar
	 * @param scalar	the scalar to multiply the coordinates by
	 * @return	this vector
	 */
	public Vector multiply(double scalar) {
		x *= scalar;
		y *= scalar;
		return this;
	}
	
	/**
	 * Divides the x and y coordinate by the scalar
	 * @param scalar	the scalar to divide the coordinates by
	 */
	public void divide(double scalar) {
		x /= scalar;
		y /= scalar;
	}
	
	/**
	 * Gets the dot product between this vector and vec
	 * @param vec	the vector to compare to this one
	 * @return	the dot product between this vector and vec
	 */
	public double dotProduct(Vector vec) {
		return x * vec.x + y * vec.y;
	}
	
	/**
	 * Find the projection of vec onto this vector
	 * @param vec	the vector to compare to this one
	 * @return		the projection of vec onto this
	 */
	public Vector projection(Vector vec) {
		return clone()
				.multiply(
					dotProduct(vec) /
					(x * x + y * y));
	}
	
	public Vector unitVector() {
		return this.clone().setMagnitude(1);
	}
	
	public Vector rotate(double angle, Vector vector) {
		x -= vector.x;
		y -= vector.y;
		
		addAngle(angle);
		
		x += vector.x;
		y += vector.y;
		
		return this;
	}
}
