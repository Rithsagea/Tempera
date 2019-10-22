package com.rithsagea.tempera.stat;

public enum Job {
	WARRIOR(10, 10, 10),
	ASSASIN(15, 5, 10),
	PALADIN(5, 15, 10),
	MAGE(20, 5, 5);
	
	private int attack;
	private int defense;
	private int health;
	
	Job(int attack, int defense, int health) {
		this.attack = attack;
		this.defense = defense;
		this.health = health;
	}
	
	public StatContainer getStats() {
		return new StatContainer(attack, defense, health);
	}
}
