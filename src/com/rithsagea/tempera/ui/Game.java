package com.rithsagea.tempera.ui;

import java.util.Scanner;

import com.rithsagea.tempera.item.ItemType;
import com.rithsagea.tempera.stat.Job;
import com.rithsagea.tempera.stat.Player;

public class Game {
	
	private Scanner scanner = new Scanner(System.in);
	private Player player;
	
	public Game() {
		System.out.print("What is your character name: ");
		String name = scanner.nextLine();
		Job job = getJob();
		
		player = new Player(name, job.getStats());
		
		System.out.format("\n-=-=- %s -=-=-\n%s", player.name, player.stats);
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
			System.out.print("What would you like to do: ");
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
					System.out.println("\n\n\n\nThank you for playing Project Tempera.");
					break;
				default:
					System.out.println("\nThat is not a valid option. Please pick another one.\n");
			}
		}
		return res;
	}
	
	public Job getJob() {
		Job job = null;
		while(job == null) {
			System.out.println("\n-=-=- Classes -=-=-");
			System.out.println("Warrior - Atk: 10  Def: 10  HP: 10");
			System.out.println("Assasin - Atk: 15  Def: 5  HP: 10");
			System.out.println("Paladin - Atk: 5  Def: 15  HP: 10");
			System.out.println("Mage - Atk: 20  Def: 5  HP: 5");
			System.out.print("What class is your character: ");
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
			if(player.inventory[slot] == null) {
				System.out.println("That slot is empty.");
			} else {
				System.out.format("You have interacted with slot %d\n", slot);
			}
			//prompt player for what they want to do
			//(equip item, throw away item, sort items)
			break;
		case 2:
			System.out.println("-=-=- Areas -=-=-");
			System.out.println("Ceres");
			System.out.println("Nebula");
			System.out.println("Andromeda");
			System.out.print("\nWhich area would you like to explore: ");
			//do some prompt loop here
			//prompt area and run combat 
			break;
		case 3:
			//save data, close game
			break;
		}
	}
}
