package com.rithsagea.tempera;

public class Item {
	public StatContainer statBonus;
	public String name;
	
	public Item(String name, StatContainer stats) {
		this.name = name;
		statBonus = stats;
	}
}
