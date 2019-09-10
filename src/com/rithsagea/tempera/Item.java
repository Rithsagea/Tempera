package com.rithsagea.tempera;

public class Item {
	public StatContainer statBonus;
	public String name;
	public Rarity rarity;
	public ItemType type;
	
	public Item(Rarity rarity, ItemType type, String name, StatContainer stats) {
		this.rarity = rarity;
		this.name = name;
		this.type = type;
		statBonus = stats;
	}
}
