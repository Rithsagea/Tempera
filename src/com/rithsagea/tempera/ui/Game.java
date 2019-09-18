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
