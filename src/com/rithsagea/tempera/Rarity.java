package com.rithsagea.tempera;

public enum Rarity {
	LEGENDARY(1),
	EPIC(2),
	RARE(8),
	COMMON(64);
	
	private int weight = 0;
	
	Rarity(int weight) {
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
}
