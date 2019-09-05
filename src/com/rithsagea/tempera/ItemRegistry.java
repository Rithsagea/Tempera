package com.rithsagea.tempera;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemRegistry {
	private static List<Item> registry = new ArrayList<Item>();
	
	private static Item[] items;
	
	private static int totalWeight;
	private static int length;
	
	private static Random rand;
	
	public static void registerItem(Item item) {
		registry.add(item);
	}
	
	public static void registerItems(Item... item) {
		for(Item obj : item) {
			registry.add(obj);
		}
	}
	
	public static void init() {
		rand = new Random(System.currentTimeMillis());
		length = registry.size();
		items = new Item[length];
		items = registry.toArray(items);
		for(Item item : items) {
			totalWeight += item.rarity.getWeight();
		}
	}
	
	public static Item getItem() {
		int total = rand.nextInt(totalWeight);
		for(int x = 0; x < length; x++) {
			total -= items[x].rarity.getWeight();
			if(total <= 0)
				return items[x];
		}
		return null;
	}
	
	public static void printItems() {
		for(Item item : items) {
			System.out.println(item.name);
		}
	}
	
	public static void rollTest(int rolls) {
		System.out.println("\n\nBegin Roll\n------------------------------------------");
		Item item;
		int cost = 0;
		
		for(int x = 0; x < rolls; x++) {
			item = ItemRegistry.getItem();
			cost += item.rarity.getCost();
			System.out.println(ItemRegistry.getItem().name);
		}
		
		System.out.format("\nTotal Coins: %d", cost);
	}
}
