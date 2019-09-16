package com.rithsagea.tempera.item;

import com.rithsagea.tempera.Rarity;
import com.rithsagea.tempera.stat.StatContainer;

public class Item implements Comparable<Item>{
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
	
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Item o) {
		if(o.rarity.ordinal() > rarity.ordinal()) //other object has higher rarity
			return 1; //current object is less than other object
		if(o.rarity.ordinal() < rarity.ordinal())
			return -1;
		
		return name.compareTo(o.name);
	}
}
