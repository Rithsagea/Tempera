package com.rithsagea.tempera.registry;

import java.util.HashMap;

import com.rithsagea.tempera.stat.Monster;

public class MonsterRegistry {
	
	private static final HashMap<String, Monster> registry = new HashMap<String, Monster>();
	
	public static void registerMonster(Monster monster) {
		registry.put(monster.name.toUpperCase(), monster);
	}
	
	public static void registerMonsters(Monster... monsters) {
		for(Monster monster : monsters) {
			registry.put(monster.name.toUpperCase(), monster);
		}
	}
	
	public static Monster getMonster(String name) {
		return registry.get(name);
	}
}
