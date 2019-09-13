package com.rithsagea.tempera.item;

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
		rand = new Random(new Random(System.currentTimeMillis()).nextInt());
		length = registry.size();
		items = new Item[length];
		items = registry.toArray(items);
		for(Item item : items) {
			totalWeight += item.rarity.getWeight();
		}
	}
	
	public static Item getItem() {
		int total = rand.nextInt(totalWeight + 1);
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
		System.out.println("\n\n-=-=- Item Roll Test -=-=-\n");
		Item item;
		int cost = 0;
		
		for(int x = 0; x < rolls; x++) {
			item = ItemRegistry.getItem();
			cost += item.rarity.getCost();
			System.out.format("[%s] %s\n", item.rarity.name(), item.name);
		}
		
		System.out.format("\nTotal Coins: %d", cost);
	}
}
