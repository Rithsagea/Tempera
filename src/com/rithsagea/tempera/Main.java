package com.rithsagea.tempera;

import com.rithsagea.tempera.registry.ItemRegistry;
import com.rithsagea.tempera.registry.MonsterRegistry;

public class Main {
	
	public static void main(String args[]) {
		//Initialization
		DataManager.registerItems();
		DataManager.registerMonsters();
		DataManager.registerLoot();
		DataManager.registerSpawns();
		
		System.out.println("-=-=- Items -=-=-");
		ItemRegistry.printItems();
		
		System.out.println("\n-=-=- Monsters -=-=-");
		MonsterRegistry.printMonsters();
		
		//Random tests I can delete later
		DataManager.rollLootTest(Rarity.COMMON);
		DataManager.rollLootTest(Rarity.UNCOMMON);
		DataManager.rollLootTest(Rarity.RARE);
		DataManager.rollLootTest(Rarity.EPIC);
		DataManager.rollLootTest(Rarity.LEGENDARY);
		
		DataManager.rollSpawnTest(Area.CERES);
		DataManager.rollSpawnTest(Area.NEBULA);
		DataManager.rollSpawnTest(Area.ANDROMEDA);
	}
}
