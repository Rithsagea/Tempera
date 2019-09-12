package com.rithsagea.tempera.stat;

public class Monster {
	public StatContainer stats;
	public String name;
	
	public Monster(String name, StatContainer stats) {
		this.name = name;
		this.stats = stats;
	}
}
