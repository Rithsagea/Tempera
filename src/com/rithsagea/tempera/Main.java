package com.rithsagea.tempera;

import com.rithsagea.tempera.item.ItemRegistry;
import com.rithsagea.tempera.stat.MonsterRegistry;

public class Main {
	
	public static void main(String args[]) {
		DataManager.registerItems();
		DataManager.registerMonsters();
		System.out.println("-=-=- Items -=-=-");
		ItemRegistry.printItems();
		
		System.out.println("-=-=- Monsters -=-=-");
		MonsterRegistry.printMonsters();
		
		/*
		System.out.println("\n\nBegin Roll\n------------------------------------------");
		Item item;
		int cost = 0;
		
		for(int x = 0; x < 100; x++) {
			item = ItemRegistry.getItem();
			cost += item.rarity.getCost();
			System.out.println(ItemRegistry.getItem().name);
		}
		
		System.out.format("\nTotal Coins: %d", cost);
		*/
	}
}
