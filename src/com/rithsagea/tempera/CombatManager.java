package com.rithsagea.tempera;

import com.rithsagea.tempera.stat.Monster;
import com.rithsagea.tempera.stat.Player;

public class CombatManager {
	
	public Player player;
	public Monster monster;
	
	public CombatManager(Player player, Monster monster) {
		this.player = player;
		this.monster = monster;
	}
	
	public boolean playerTurn() {
		monster.stats.health -= Math.max(0, player.stats.attack - monster.stats.defense);
		if(monster.stats.health <= 0)
			return true; //the monster died
		return false; //no one dies
	}
	
	public boolean monsterTurn() {
		player.stats.health -= Math.max(0, monster.stats.attack - player.stats.defense);
		if(player.stats.health <= 0)
			return true;
		return false;
	}
}
