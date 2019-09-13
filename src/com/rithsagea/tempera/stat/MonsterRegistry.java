package com.rithsagea.tempera.stat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonsterRegistry {
	private static List<Monster> registry = new ArrayList<Monster>();
	
	private static Monster[] monsters;
	private static int length;
	private static int totalWeight;
	
	private static Random rand;
	
	public static void registerMonster(Monster monster) {
		registry.add(monster);
	}
	
	public static void registerMonsters(Monster... monster) {
		for(Monster obj : monster) {
			registry.add(obj);
		}
	}
	
	public static void init() {
		rand = new Random(System.currentTimeMillis());
		length = registry.size();
		monsters = new Monster[length];
		monsters = registry.toArray(monsters);
		for(Monster m : monsters) {
			totalWeight += m.rarity.getWeight();
		}
	}
	
	public static Monster getMonster() {
		int total = rand.nextInt(totalWeight);
		for(int x = 0; x < length; x++) {
			total -= monsters[x].rarity.getWeight();
			if(total <= 0)
				return monsters[x];
		}
		return null;
	}
	
	public static void printMonsters() {
		for(int x = 0; x < length; x++) {
			System.out.println(monsters[x].name);
		}
	}
	
	public static void rollTest(int rolls) {
		System.out.println("\n\n-=-=- Monster Roll Test -=-=-\n");
		Monster monster;
		
		for(int x = 0; x < rolls; x++) {
			monster = MonsterRegistry.getMonster();
			System.out.format("[%s] %s\n", monster.rarity.name(), monster.name);
		}
	}
}
