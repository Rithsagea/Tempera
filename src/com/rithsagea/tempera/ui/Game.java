package com.rithsagea.tempera.ui;

import java.util.Scanner;

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
		System.out.println(promptOption());
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
}
