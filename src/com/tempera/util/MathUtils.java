package com.tempera.util;

public class MathUtils {
	//TODO make overloading for the following functions
	//converting ints to doubles might be bad
	
	public static double clamp(double value, double lowerBound, double upperBound) {
		if(value < lowerBound) return lowerBound;
		if(value > upperBound) return upperBound;
		return value;
	}
	
	public static boolean between(double value, double lowerBound, double upperBound) {
		return value > lowerBound && value < upperBound; //change for inclusive exclusive
	}
}
