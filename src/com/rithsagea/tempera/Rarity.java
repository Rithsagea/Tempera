package com.rithsagea.tempera;

public enum Rarity {
	LEGENDARY(1, 1000),
	EPIC(2, 500),
	RARE(4, 250),
	UNCOMMON(8, 50),
	COMMON(16, 10);
	
	private int weight = 0;
	private int cost = 0;
	
	Rarity(int weight, int cost) {
		this.weight = weight;
		this.cost = cost;
	}
	
	public int getCost() {
		return cost;
	}
	
	public int getWeight() {
		return weight;
	}
}
