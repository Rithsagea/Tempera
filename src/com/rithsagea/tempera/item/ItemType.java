package com.rithsagea.tempera.item;

public enum ItemType {
	MAINHAND(1),
	OFFHAND(2),
	SUBSTANCE(0);
	
	private int slot;
	
	ItemType(int slot) {
		this.slot = slot;
	}
	
	public int getSlot() {
		return slot;
	}
}
