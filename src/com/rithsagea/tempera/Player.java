package com.rithsagea.tempera;

public class Player {
	
	public StatContainer stats = new StatContainer(0, 0, 0);
	public Item heldItem = null;
	
	public Player(StatContainer stats) {
		this.stats = stats;
	}	
}
