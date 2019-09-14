package com.rithsagea.tempera.registry;

import java.util.HashMap;

public class BaseRegistry<T> {
	private HashMap<String, T> registry = new HashMap<String, T>();
	
	void registerValue(String key, T value) {
		registry.put(key, value);
	}
	
	T getValue(String key) {
		return registry.get(key);
	}
}
