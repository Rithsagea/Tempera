package com.rithsagea.tempera.item;

import com.rithsagea.tempera.Rarity;
import com.rithsagea.tempera.stat.StatContainer;

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
