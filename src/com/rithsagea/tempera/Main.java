package com.rithsagea.tempera;

import com.rithsagea.tempera.item.Item;
import com.rithsagea.tempera.registry.ItemRegistry;
import com.rithsagea.tempera.registry.MonsterRegistry;
import com.rithsagea.tempera.stat.CombatManager;
import com.rithsagea.tempera.stat.Monster;
import com.rithsagea.tempera.stat.Player;
import com.rithsagea.tempera.stat.StatContainer;

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
		
		int rarities[] = {0, 0, 0, 0, 0};
		
		for(int x = 0; x < 100; x++) {
			Monster monster = DataManager.getMonster(Area.ANDROMEDA);
			Item item = DataManager.getLoot(monster.rarity);
			rarities[item.rarity.ordinal()]++;
			System.out.format("[%s] %s		[%s] %s\n", monster.rarity, monster, item.rarity, item);
			
		}
		System.out.println();
		for(int x = 0; x < 5; x++) {
			System.out.format("You have found %d %s\n", rarities[x], Rarity.values()[x]);
		}
		
		System.out.print("\n\n\n\n");
		
		Monster monster = DataManager.getMonster(Area.NEBULA);
		Player player = new Player("Rithsagea", new StatContainer(10, 10, 10));
		
		CombatManager manager = new CombatManager(player, monster);
		manager.run();
	}
}
