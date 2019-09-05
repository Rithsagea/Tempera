package com.rithsagea.tempera;

public class Player {
	
	public StatContainer stats = new StatContainer(0, 0, 0);
	public Item heldItem = null;
	
	public Player(StatContainer stats) {
		this.stats = stats;
	}
	
	public void attack(Monster monster) {
		stats.health -= Math.max(0, monster.stats.attack - stats.defense);
		monster.stats.health -= Math.max(0,  stats.attack - monster.stats.defense);
	}
	
	public void equipItem(Item item) {
		stats.subtract(item.statBonus);
		heldItem = item;
		stats.add(item.statBonus);
	}
}
