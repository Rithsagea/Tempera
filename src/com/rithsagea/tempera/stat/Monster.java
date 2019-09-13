package com.rithsagea.tempera.stat;

import com.rithsagea.tempera.Rarity;

public class Monster {
	public StatContainer stats;
	public String name;
	public Rarity rarity;
	
	public Monster(String name, Rarity rarity, StatContainer stats) {
		this.name = name;
		this.rarity = rarity;
		this.stats = stats;
	}
}
