package com.rithsagea.tempera.stat;

import java.util.Scanner;

import com.rithsagea.tempera.DataManager;
import com.rithsagea.tempera.item.Item;

public class CombatManager {
	
	public Player player;
	public Monster monster;
	
	public CombatManager(Player player, Monster monster) {
		this.player = player;
		this.monster = monster;
		
		printStatus();
	}
	
	public Item run() {
		while(playerTurn() == false) {
			if(monsterTurn() == true) {
				System.out.println("\n\nYou died!");
				return null;
			}
		}
		Item item = DataManager.getLoot(monster.rarity);
		System.out.format("\n\n%s obtained %s", player, item);
		return item;
	}
	
	public boolean playerTurn() {
		int damage = Math.max(1, player.stats.attack - monster.stats.defense);
		monster.stats.health -= damage;
		System.out.format("\n%s attacks the %s, dealing %d damage\n\n", player, monster, damage);
		printStatus();
		if(monster.stats.health <= 0)
			return true; //the monster died
		return false; //no one dies
	}
	
	public boolean monsterTurn() {
		int damage = Math.max(1, monster.stats.attack - player.stats.defense);
		player.stats.health -= damage;
		System.out.format("\nThe %s attacks %s, dealing %d damage\n\n", monster, player, damage);
		printStatus();
		if(player.stats.health <= 0)
			return true;
		return false;
	}
	
	public void printStatus() {
		System.out.format("-=-=- %s -=-=-\n%s", monster, monster.stats);
		System.out.format("\n\n-=-=- %s -=-=-\n%s\n", player, player.stats);
	}
}
