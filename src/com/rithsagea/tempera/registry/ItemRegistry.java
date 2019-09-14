package com.rithsagea.tempera.registry;

import java.util.HashMap;

import com.rithsagea.tempera.item.Item;

public class ItemRegistry {
	
	private static final HashMap<String, Item> registry = new HashMap<String, Item>();
	
	public static void registerItem(Item item) {
		registry.put(item.name.toUpperCase(), item);
	}
	
	public static void registerItems(Item... items) {
		for(Item item : items) {
			registry.put(item.name.toUpperCase(), item);
		}
	}
	
	public static Item getItem(String name) {
		return registry.get(name);
	}
}
