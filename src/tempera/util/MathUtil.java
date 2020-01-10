package tempera.util;

public class MathUtil {
	//TODO make overloading for the following functions
	//converting ints to doubles might be bad
	
	/**
	 * Returns the value passed into this function if it is
	 * between lowerBound and upperBound.
	 * 
	 * If it is outside of the bounds, it returns one of the
	 * bounds.
	 * 
	 * @param value			the value to clamp
	 * @param lowerBound	the lower bound of the value
	 * @param upperBound	the upper bound of the value
	 * @return				the clamped value
	 */
	public static double clamp(double value, double lowerBound, double upperBound) {
		if(value < lowerBound) return lowerBound;
		if(value > upperBound) return upperBound;
		return value;
	}
	
	/**
	 * Checks if the value is between two bounds
	 * 
	 * @param value			the value to check
	 * @param lowerBound	the lower bound of the value
	 * @param upperBound	the upper bound of the value
	 * @return				whether the value is within the bounds
	 */
	public static boolean between(double value, double lowerBound, double upperBound) {
		return value > lowerBound && value < upperBound; //change for inclusive exclusive
	}
	
	/**
	 * Checks if two ranges intersect each other
	 * @param min1	the lower bound for the first range
	 * @param max1	the upper bound for the first range
	 * @param min2	the lower bound for the second range
	 * @param max2	the upper bound for the second range
	 * @return		whether the two ranges intersect
	 */
	public static boolean rangeIntercept(double min1, double max1, double min2, double max2) {
		return Math.max(Math.min(min1, max1), Math.min(min2, max2)) <= Math.min(Math.max(min1, max1), Math.max(min2, max2));
	}
}
