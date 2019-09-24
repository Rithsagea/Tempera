package com.rithsagea.tempera.ui;

import java.util.Scanner;

import com.rithsagea.tempera.Area;
import com.rithsagea.tempera.DataManager;
import com.rithsagea.tempera.item.Item;
import com.rithsagea.tempera.item.ItemType;
import com.rithsagea.tempera.stat.CombatManager;
import com.rithsagea.tempera.stat.Job;
import com.rithsagea.tempera.stat.Monster;
import com.rithsagea.tempera.stat.Player;

public class Game {
	
	private Scanner scanner = new Scanner(System.in);
	private Player player;
	
	public Game() {
		System.out.print("What is your character name: ");
		String name = scanner.nextLine();
		Job job = getJob();
		
		player = new Player(name, job.getStats());
		
		System.out.format("\n-=-=- %s -=-=-\n%s\n", player.name, player.stats);
	}
	
	public int promptOption() {
		char c = ' ';
		int res = -1;
		while(res == -1) {
			System.out.println("\n-=-=- Options -=-=-");
			System.out.println("[R]est");
			System.out.println("[I]nventory");
			System.out.println("[S]earch");
			System.out.println("[E]xit");
			System.out.print("\nWhat would you like to do: ");
			try {
				c = scanner.nextLine().charAt(0);
				Character.toLowerCase(c);
				switch(c) {
					case 'r':
						res = 0;
						break;
					case 'i':
						res = 1;
						break;
					case 's':
						res = 2;
						break;
					case 'e':
						res = 3;
						break;
					default:
						System.out.println("\nThat is not a valid option. Please pick another one.\n");
				}
			} catch(StringIndexOutOfBoundsException e) {
				System.out.println("You cannot have an empty input");
			}
		}
		return res;
	}
	
	public Job getJob() {
		Job job = null;
		System.out.println("\n-=-=- Classes -=-=-");
		System.out.println("Warrior - Atk: 10  Def: 10  HP: 10");
		System.out.println("Assasin - Atk: 15  Def: 5  HP: 10");
		System.out.println("Paladin - Atk: 5  Def: 15  HP: 10");
		System.out.println("Mage - Atk: 20  Def: 5  HP: 5");
		while(job == null) {
			System.out.print("\nWhat class is your character: ");
			try {
				job = Job.valueOf(scanner.nextLine().toUpperCase());
			} catch(IllegalArgumentException e) {
				System.out.println("\nThat is not a valid class, please pick another one.");
			}
		}
		
		return job;
	}
	
	public void promptInventory() {
		System.out.println("Select an item: ");
		for(int x = 0; x < 20; x++) {
			
		}
	}
	
	public void run() {
		switch(promptOption()) {
		case 0:
			player.stats.health = player.stats.mhealth;
			System.out.format("%s has been fully rested. HP: %d/%d", player.name, player.stats.health, player.stats.mhealth);
			break;
		case 1:
			//also display player stats somewhere
			System.out.println("-=-=- Inventory -=-=-");
			System.out.format("Main Hand: %s\n", player.inventory[ItemType.MAINHAND.getSlot()]);
			System.out.format("Off Hand: %s\n", player.inventory[ItemType.OFFHAND.getSlot()]);
			System.out.format("Substance: %s\n\n", player.inventory[ItemType.SUBSTANCE.getSlot()]);
			
			for(int x = 0; x < 20; x++) {
				System.out.format("[%d]	%s\n", x + 1, player.inventory[x]);
			}
			
			System.out.print("\nWhich item would you like to interact with: ");
			int slot = 0;
			while(slot < 1 || slot > 20) {
				slot = scanner.nextInt();
				if(slot < 1 || slot > 20)
					System.out.println("That is not a valid slot.");
			}
			if(player.inventory[slot - 1] == null) {
				System.out.println("That slot is empty.");
			} else {
				while(true) {
					System.out.println("[E]quip [T]hrow away");
					System.out.format("What would you like to do with the %s:", player.inventory[slot-1]);
					try {
						char c = Character.toUpperCase(scanner.nextLine().charAt(0));
						switch(c) {
							case 'E':
								player.equipItem(slot - 1);
								break;
							case 'T':
								player.throwItem(slot - 1);
								break;
							default:
								System.out.println("That is not a valid option.");
						}
						break;
					} catch(StringIndexOutOfBoundsException e) {
						System.out.println("\n\nThere was an error parsing input");
					}
				}
			}
			//prompt player for what they want to do
			//(equip item, throw away item, sort items)
			break;
		case 2:
			System.out.println("\n-=-=- Areas -=-=-");
			System.out.println("Ceres");
			System.out.println("Nebula");
			System.out.println("Andromeda");
			Area area = null;
			while(area  == null) {
				System.out.print("\nWhich area would you like to explore: ");
				try {
					area = Area.valueOf(scanner.nextLine().toUpperCase());
				} catch(IllegalArgumentException e) {
					System.out.println("That is not a valid area.");
				}
			}
			System.out.format("You have went to %s\n\n", area);
			Monster monster = DataManager.getMonster(area);
			System.out.format("%s looks for a monster.\nRithsagea found a %s!\n\n", player, monster);
			
			System.out.format("-=-=- %s -=-=-\nRarity: %s\n%s\n\n", monster, monster.rarity, monster.stats);
			
			char c = ' ';
			while(c != 'R' && c != 'F') {
				System.out.print("Would you like to [r]un, or [f]ight: ");
				c = Character.toUpperCase(scanner.nextLine().charAt(0));
			}
			
			if(c == 'F') {
				CombatManager manager = new CombatManager(player, monster);
				Item item = manager.run();
				if(item == null) {
					System.out.println("\n\n\nThank you for playing Project Tempera");
					System.exit(0);
				} else {
					player.pickupItem(item);
				}
			} else {
				System.out.format("\nYou ran away from the %s\n", monster);
			}
			break;
		case 3:
			System.out.println("\n\n\n\nThank you for playing Project Tempera.");
			System.exit(0);
			//save data, close game
			break;
		default:
			System.out.println("There was an error parsing the input");
			break;
		}
	}
}
