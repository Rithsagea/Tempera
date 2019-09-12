package com.rithsagea.tempera.stat;

public class Monster {
	public StatContainer stats;
	public String name;
	public MonsterRarity rarity;
	
	public Monster(String name, MonsterRarity rarity, StatContainer stats) {
		this.name = name;
		this.rarity = rarity;
		this.stats = stats;
	}
}
