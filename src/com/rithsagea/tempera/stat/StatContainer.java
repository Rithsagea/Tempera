package com.rithsagea.tempera.stat;

public class StatContainer {
	public int attack;
	public int defense;
	public int mhealth;
	public int health;
	
	/**
	 * 
	 * @param attack		value
	 * @param defense	value
	 * @param health		value
	 */
	public StatContainer(int attack, int defense, int health) {
		this.attack = attack;
		this.defense = defense;
		this.mhealth = health;
		this.health = health;
	}
	
	public void add(StatContainer container) {
		this.attack += container.attack;
		this.defense += container.defense;
		this.health += container.health;
	}
	
	public void subtract(StatContainer container) {
		this.attack -= container.attack;
		this.defense -= container.defense;
		this.health -= container.health;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HP: ");
		builder.append(health);
		builder.append(" / ");
		builder.append(mhealth);
		builder.append("\nAtk: ");
		builder.append(attack);
		builder.append("\nDef: ");
		builder.append(defense);
		
		return builder.toString();
	}
}
