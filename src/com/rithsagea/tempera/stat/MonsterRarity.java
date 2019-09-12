package com.rithsagea.tempera.stat;

public enum MonsterRarity {
	LEGENDARY(1),
	EPIC(4),
	RARE(20),
	UNCOMMON(50),
	COMMON(100);
	
	private int weight;
	
	MonsterRarity(int weight) {
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
}
