package com.rithsagea.tempera.stat;

import com.rithsagea.tempera.Rarity;

public class Monster implements Comparable<Monster> {
	public StatContainer stats;
	public String name;
	public Rarity rarity;
	
	public Monster(String name, Rarity rarity, StatContainer stats) {
		this.name = name;
		this.rarity = rarity;
		this.stats = stats;
	}
	
	public String toString() {
		return name;
	}
	
	@Override
	public int compareTo(Monster o) {
		if(o.rarity.ordinal() > rarity.ordinal()) //other object has higher rarity
			return 1; //current object is less than other object
		if(o.rarity.ordinal() < rarity.ordinal())
			return -1;
		
		return name.compareTo(o.name);
	}
}
