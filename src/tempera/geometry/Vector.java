package tempera.geometry;

public class Vector extends Point implements Cloneable {
	
	public Vector(double x, double y) {
		super(x, y);
	}
	
	public Vector(Point p) {
		this(p.x, p.y);
	} 
	
	//Convenience
	
	public Vector(Point p1, Point p2) {
		super(p2.x - p1.x, p2.y - p1.y);
	}

	public Vector clone() {
		return new Vector(x, y);
	}
	
	public String toString() {
		return String.format("<%f, %f>", x, y);
	}
	
	//Getters
	
	public double getMagnitudeSquared() {
		return x * x + y * y;
	}
	
	public double getMagnitude() {
		return Math.sqrt(getMagnitudeSquared());
	}
	
	public double getAngle() {
		return Math.atan2(y, x);
	}
	
	//Setters
	
	public Vector setMagnitude(double magnitude) {
		double angle = getAngle();
		x = Math.cos(angle) * magnitude;
		y = Math.sin(angle) * magnitude;
		
		return this;
	}
	
	public Vector setAngle(double angle) {
		double magnitude = getMagnitude();
		x = Math.cos(angle) * magnitude;
		y = Math.sin(angle) * magnitude;
		
		return this;
	}
	
	//Processing
	
	public Vector multiply(double scalar) {
		setMagnitude(getMagnitude() * scalar);
		return this;
	}
	
	public Vector divide(double scalar) {
		setMagnitude(getMagnitude() / scalar);
		return this;
	}
	
	public double dot(Vector vec) {
		return x * vec.x + y * vec.y;
	}
	
	//Macros
	
	public Vector inverse() {
		return this.clone().setMagnitude(-getMagnitude());
	}
	
	public Vector unit() {
		return this.clone().setMagnitude(1);
	}
}
