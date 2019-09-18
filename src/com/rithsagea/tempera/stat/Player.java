package com.rithsagea.tempera.stat;

import com.rithsagea.tempera.item.Item;
import com.rithsagea.tempera.item.ItemType;

public class Player {
	public int coins = 0;
	public StatContainer stats = new StatContainer(0, 0, 0);
	public final Item[] inventory = new Item[23];
	public String name;
	
	public Player(String name, StatContainer stats) {
		this.name = name;
		this.stats = stats;
	}
	
	public void attack(Monster monster) {
		stats.health -= Math.max(0, monster.stats.attack - stats.defense);
		monster.stats.health -= Math.max(0,  stats.attack - monster.stats.defense);
	}
	
	/**
	 * 
	 * @param item	The item to pickup
	 * @return		Whether the player can pickup the item (inventory full or not)
	 */
	public boolean pickupItem(Item item) {
		for(int x = 0; x < 20; x++) {
			if(inventory[x] == null) {
				inventory[x] = item;
				return true;
			}
		}
		return false;
	}
	
	public void equipItem(int slot) {
		if(inventory[slot] == null)
			return;
		ItemType type = inventory[slot].type;
		Item oldItem = inventory[type.getSlot()];
		stats.subtract(oldItem.statBonus);
		inventory[type.getSlot()] = inventory[slot];
		stats.add(inventory[slot].statBonus);
		inventory[slot] = oldItem;
	}
	
	public void throwItem(int slot) {
		inventory[slot] = null;
	}
	
	public String toString() {
		return name;
	}
}
