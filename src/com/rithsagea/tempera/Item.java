package com.rithsagea.tempera;

public class Item {
	public StatContainer statBonus;
	public String name;
	public Rarity rarity;
	
	public Item(Rarity rarity, String name, StatContainer stats) {
		this.rarity = rarity;
		this.name = name;
		statBonus = stats;
	}
}
