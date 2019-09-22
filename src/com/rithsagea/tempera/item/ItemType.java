package com.rithsagea.tempera.item;

public enum ItemType {
	MAINHAND(21),
	OFFHAND(22),
	SUBSTANCE(20);
	
	private int slot;
	
	ItemType(int slot) {
		this.slot = slot;
	}
	
	public int getSlot() {
		return slot;
	}
}
