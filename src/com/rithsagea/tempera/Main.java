package com.rithsagea.tempera;

import com.rithsagea.tempera.ui.Game;

public class Main {
	
	public static void main(String args[]) {
		//Initialization
		DataManager.registerItems();
		DataManager.registerMonsters();
		DataManager.registerLoot();
		DataManager.registerSpawns();
		
		//Debug Message
//		System.out.println("-=-=- Items -=-=-");
//		ItemRegistry.printItems();
//		
//		System.out.println("\n-=-=- Monsters -=-=-");
//		MonsterRegistry.printMonsters();

 		//For testing weights
//		int rarities[] = {0, 0, 0, 0, 0};
//
//		for(int x = 0; x < 100; x++) {
//			Monster monster = DataManager.getMonster(Area.ANDROMEDA);
//			Item item = DataManager.getLoot(monster.rarity);
//			rarities[item.rarity.ordinal()]++;
//			System.out.format("[%s] %s		[%s] %s\n", monster.rarity, monster, item.rarity, item);
//			
//		}
//		System.out.println();
//		for(int x = 0; x < 5; x++) {
//			System.out.format("You have found %d %s\n", rarities[x], Rarity.values()[x]);
//		}
		
		//Testing Combat
//		Monster monster = DataManager.getMonster(Area.NEBULA);
//		Player player = new Player("Rithsagea", new StatContainer(10, 10, 10));
//		
//		CombatManager manager = new CombatManager(player, monster);
//		manager.run();
		
		Game window = new Game();
		
	}
}
