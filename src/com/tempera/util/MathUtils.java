package com.tempera.util;

public class MathUtils {
	public static double clamp(double value, double lowerBound, double upperBound) {
		if(value < lowerBound) return lowerBound;
		if(value > upperBound) return upperBound;
		return value;
	}
}
