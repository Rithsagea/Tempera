package com.tempera.util;

public class MathUtils {
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
}
