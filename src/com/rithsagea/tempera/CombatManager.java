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
}
