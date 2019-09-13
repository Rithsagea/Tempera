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
		
		ItemRegistry.rollTest(20);
		MonsterRegistry.rollTest(20);
	}
}
