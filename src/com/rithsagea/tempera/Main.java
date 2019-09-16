package com.rithsagea.tempera;

import com.rithsagea.tempera.registry.ItemRegistry;
import com.rithsagea.tempera.registry.MonsterRegistry;

public class Main {
	
	public static void main(String args[]) {
		DataManager.registerItems();
		DataManager.registerMonsters();
		
		
		
		System.out.println("-=-=- Items -=-=-");
		ItemRegistry.printItems();
		
		System.out.println("\n-=-=- Monsters -=-=-");
		MonsterRegistry.printMonsters();
		
		DataManager.rollLootTest(Rarity.COMMON);
		DataManager.rollLootTest(Rarity.UNCOMMON);
		DataManager.rollLootTest(Rarity.RARE);
		DataManager.rollLootTest(Rarity.EPIC);
		DataManager.rollLootTest(Rarity.LEGENDARY);
		
		/*
		ItemRegistry.rollTest(20);
		MonsterRegistry.rollTest(20);
		
		*/
	}
}
