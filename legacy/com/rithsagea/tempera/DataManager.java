package com.rithsagea.tempera;

import com.rithsagea.tempera.item.Item;
import com.rithsagea.tempera.item.ItemType;
import com.rithsagea.tempera.registry.ItemRegistry;
import com.rithsagea.tempera.registry.MonsterRegistry;
import com.rithsagea.tempera.stat.Monster;
import com.rithsagea.tempera.stat.StatContainer;

import tempera.util.WeightedList;

public class DataManager {
	//Items
	//LEGENDARY
	static final Item TYRFING = new Item(Rarity.LEGENDARY, ItemType.MAINHAND, "Tyrfing", new StatContainer(20, 10, 0));
	static final Item EXCALIBUR = new Item(Rarity.LEGENDARY, ItemType.MAINHAND, "Excalibur", new StatContainer(30, 0, 0));
	static final Item KUSANAGI = new Item(Rarity.LEGENDARY, ItemType.MAINHAND, "Kusanagi", new StatContainer(20, 5, 5));
	
	static final Item AEGIS = new Item(Rarity.LEGENDARY, ItemType.OFFHAND, "Aegis", new StatContainer(0, 30, 0));
	
	static final Item PHILOSTONE = new Item(Rarity.LEGENDARY, ItemType.SUBSTANCE, "Philosopher's Stone", new StatContainer(0, 20, 20));
	
	//EPIC
	static final Item DURENDAL = new Item(Rarity.EPIC, ItemType.MAINHAND, "Durendal", new StatContainer(15, 5, 0));
	static final Item MORALTA = new Item(Rarity.EPIC, ItemType.MAINHAND, "Moralta", new StatContainer(20, 0, 0));
	static final Item GOUJIAN = new Item(Rarity.EPIC, ItemType.MAINHAND, "Goujian", new StatContainer(15, 0, 5));
	
	static final Item EITR = new Item(Rarity.EPIC, ItemType.SUBSTANCE, "Eitr", new StatContainer(0, 15, 5));
	static final Item ADAMANT = new Item(Rarity.EPIC, ItemType.SUBSTANCE, "Adamant", new StatContainer(0, 20, 0));
	
	//RARE
	static final Item DAMSTEELSWORD = new Item(Rarity.RARE, ItemType.MAINHAND, "Damascus Steel Sword", new StatContainer(5, 5, 0));
	static final Item RUNEDBLADE = new Item(Rarity.RARE, ItemType.MAINHAND, "Runed Blade", new StatContainer(5, 0, 5));
	
	static final Item COBALTSHIELD = new Item(Rarity.RARE, ItemType.OFFHAND, "Cobalt Shield", new StatContainer(0, 5, 5));
	static final Item PERMAFROSTSHIELD = new Item(Rarity.RARE, ItemType.OFFHAND, "Permafrost Shield", new StatContainer(0, 10, 0));
	
	static final Item PINECONEBOW = new Item(Rarity.RARE, ItemType.MAINHAND, "Pinecone Bow", new StatContainer(5, 5, 0));
	static final Item VINEBOW = new Item(Rarity.RARE, ItemType.MAINHAND, "Vine Bow", new StatContainer(5, 0, 5));
	static final Item GLASSBOW = new Item(Rarity.RARE, ItemType.MAINHAND, "Glass Bow", new StatContainer(10, 0, 0));
	
	//COMMON
	static final Item MAGMA = new Item(Rarity.COMMON, ItemType.SUBSTANCE, "Magma", new StatContainer(5, 0, 0));
	static final Item CRYSTAL = new Item(Rarity.COMMON, ItemType.SUBSTANCE, "Crystal", new StatContainer(0, 5, 0));
	static final Item HONEY = new Item(Rarity.COMMON, ItemType.SUBSTANCE, "Honey", new StatContainer(0, 0, 5));
	
	//Monsters
	//5 - 50 base
	static final Monster HYDRA = new Monster("Hydra", Rarity.LEGENDARY, new StatContainer(20, 10, 20));
	static final Monster OROCHI = new Monster("Orochi", Rarity.LEGENDARY, new StatContainer(20, 10, 20));
	static final Monster LEVIATHAN = new Monster("Leviathan", Rarity.LEGENDARY, new StatContainer(15, 15, 20));
	static final Monster PHOENIX = new Monster("Phoenix", Rarity.LEGENDARY, new StatContainer(30, 5, 15));
	static final Monster YATAGARASU =  new Monster("Yatagarasu", Rarity.LEGENDARY, new StatContainer(30, 5, 15));
	
	//4 - 40 base
	static final Monster DIREWOLF = new Monster("Direwolf", Rarity.EPIC, new StatContainer(20, 5, 25));
	static final Monster BASILISK = new Monster("Basilisk", Rarity.EPIC, new StatContainer(20, 10, 10));
	static final Monster VAMPIRE = new Monster("Vampire", Rarity.EPIC, new StatContainer(5, 15, 20));
	static final Monster SHOGGOTH = new Monster("Shoggoth", Rarity.EPIC, new StatContainer(10, 10, 20));
	static final Monster KAPPA = new Monster("Kappa", Rarity.EPIC, new StatContainer(5, 15, 20));
	
	//3 - 30 base
	static final Monster ORC = new Monster("Orc", Rarity.RARE, new StatContainer(10, 5, 15));
	static final Monster GOBLIN = new Monster("Goblin", Rarity.RARE, new StatContainer(10, 5, 15));
	static final Monster MANDRAKE = new Monster("Mandrake", Rarity.RARE, new StatContainer(25, 0, 5));
	static final Monster GOLEM = new Monster("Golem", Rarity.RARE, new StatContainer(5, 10, 15)); //not from lotr
	
	//2 - 20 base
	static final Monster ZOMBIE = new Monster("Zombie", Rarity.UNCOMMON, new StatContainer(5, 0, 15));
	static final Monster SKELETON = new Monster("Skeleton", Rarity.UNCOMMON, new StatContainer(5, 0, 15));
	
	//1 - 10 base
	static final Monster SLIME = new Monster("Slime", Rarity.COMMON, new StatContainer(0, 0, 10));
	static final Monster SNAKE = new Monster("Snake", Rarity.COMMON, new StatContainer(2, 0, 8)); //it's not poisonous
	static final Monster RAT = new Monster("Rat", Rarity.COMMON, new StatContainer(1, 0, 9));
	static final Monster SPIDER = new Monster("Spider", Rarity.COMMON, new StatContainer(1, 0, 9));
	static final Monster CRAB = new Monster("Crab", Rarity.COMMON, new StatContainer(1, 2, 7));
	
	static final WeightedList<Item> LEGENDARYDROPS = new WeightedList<Item>();
	static final WeightedList<Item> EPICDROPS = new WeightedList<Item>();
	static final WeightedList<Item> RAREDROPS = new WeightedList<Item>();
	static final WeightedList<Item> UNCOMMONDROPS = new WeightedList<Item>();
	static final WeightedList<Item> COMMONDROPS = new WeightedList<Item>();
	
	static final WeightedList<Monster> CERES = new WeightedList<Monster>(); //Beginner area
	static final WeightedList<Monster> NEBULA = new WeightedList<Monster>(); //Midgame
	static final WeightedList<Monster> ANDROMEDA = new WeightedList<Monster>(); //Endgame
	
	public static void registerItems() {
		//LEGENDARY
		ItemRegistry.registerItems(
				TYRFING,
				EXCALIBUR,
				KUSANAGI,
				AEGIS,
				PHILOSTONE);
		//EPIC
		ItemRegistry.registerItems(
				DURENDAL,
				MORALTA,
				GOUJIAN,
				EITR,
				ADAMANT);
		//RARE
		ItemRegistry.registerItems(
				DAMSTEELSWORD,
				RUNEDBLADE,
				COBALTSHIELD,
				PERMAFROSTSHIELD,
				PINECONEBOW,
				VINEBOW,
				GLASSBOW);
		//COMMON
		ItemRegistry.registerItems(
				MAGMA,
				CRYSTAL,
				HONEY);
	}
	
	public static void registerMonsters() {
		//LEGENDARY
		MonsterRegistry.registerMonsters(
				HYDRA,
				OROCHI,
				LEVIATHAN,
				PHOENIX,
				YATAGARASU);
		
		//EPIC
		MonsterRegistry.registerMonsters(
				DIREWOLF,
				BASILISK,
				VAMPIRE,
				SHOGGOTH,
				KAPPA);
		
		//RARE
		MonsterRegistry.registerMonsters(
				ORC,
				GOBLIN,
				MANDRAKE,
				GOLEM);
		
		//UNCOMMON
		MonsterRegistry.registerMonsters(
				ZOMBIE,
				SKELETON);
		
		//COMMON
		MonsterRegistry.registerMonsters(
				SLIME,
				SNAKE,
				RAT,
				SPIDER,
				CRAB);
	}
	
	public static void registerLoot() {
		LEGENDARYDROPS.put(AEGIS, 1);
		LEGENDARYDROPS.put(EXCALIBUR, 1);
		LEGENDARYDROPS.put(KUSANAGI, 1);
		LEGENDARYDROPS.put(PHILOSTONE, 1);
		LEGENDARYDROPS.put(TYRFING, 1);
		
		LEGENDARYDROPS.put(ADAMANT, 2);
		LEGENDARYDROPS.put(DURENDAL, 2);
		LEGENDARYDROPS.put(EITR, 2);
		LEGENDARYDROPS.put(GOUJIAN, 2);
		LEGENDARYDROPS.put(MORALTA, 2);
		
		
		EPICDROPS.put(ADAMANT, 1);
		EPICDROPS.put(DURENDAL, 1);
		EPICDROPS.put(EITR, 1);
		EPICDROPS.put(GOUJIAN, 1);
		EPICDROPS.put(MORALTA, 1);
		
		EPICDROPS.put(COBALTSHIELD, 4);
		EPICDROPS.put(DAMSTEELSWORD, 4);
		EPICDROPS.put(GLASSBOW, 4);
		EPICDROPS.put(PERMAFROSTSHIELD, 4);
		EPICDROPS.put(PINECONEBOW, 4);
		EPICDROPS.put(RUNEDBLADE, 4);
		EPICDROPS.put(VINEBOW, 4);
		
		
		RAREDROPS.put(COBALTSHIELD, 1);
		RAREDROPS.put(DAMSTEELSWORD, 1);
		RAREDROPS.put(GLASSBOW, 1);
		RAREDROPS.put(PERMAFROSTSHIELD, 1);
		RAREDROPS.put(PINECONEBOW, 1);
		RAREDROPS.put(RUNEDBLADE, 1);
		RAREDROPS.put(VINEBOW, 1);
		
		RAREDROPS.put(CRYSTAL, 4);
		RAREDROPS.put(HONEY, 4);
		RAREDROPS.put(MAGMA, 4);
		
		UNCOMMONDROPS.put(COBALTSHIELD, 1);
		UNCOMMONDROPS.put(DAMSTEELSWORD, 1);
		UNCOMMONDROPS.put(GLASSBOW, 1);
		UNCOMMONDROPS.put(PERMAFROSTSHIELD, 1);
		UNCOMMONDROPS.put(PINECONEBOW, 1);
		UNCOMMONDROPS.put(RUNEDBLADE, 1);
		UNCOMMONDROPS.put(VINEBOW, 1);
		
		UNCOMMONDROPS.put(CRYSTAL, 8);
		UNCOMMONDROPS.put(HONEY, 8);
		UNCOMMONDROPS.put(MAGMA, 8);
		
		COMMONDROPS.put(CRYSTAL, 1);
		COMMONDROPS.put(HONEY, 1);
		COMMONDROPS.put(MAGMA, 1);
	}
	
	public static Item getLoot(Rarity rarity) {
		switch(rarity) {
			case COMMON: return COMMONDROPS.getElement();
			case UNCOMMON: return UNCOMMONDROPS.getElement();
			case RARE: return RAREDROPS.getElement();
			case EPIC: return EPICDROPS.getElement();
			case LEGENDARY: return LEGENDARYDROPS.getElement();
		}
		return null;
	}
	
	public static void rollLootTest(Rarity rarity) {
		Item item;
		System.out.format("\n-=-=- Roll Test [%s] -=-=-\n", rarity.toString());
		
		for(int x = 0; x < 20; x++) {
			item = getLoot(rarity);
			System.out.format("[%s] %s\n", item.rarity, item);
		}
	}
	
	public static void registerSpawns() {
		CERES.put(CRAB, 15);
		CERES.put(RAT, 15);
		CERES.put(SLIME, 15);
		CERES.put(SNAKE, 15);
		CERES.put(SPIDER, 15);
		
		CERES.put(SKELETON, 7);
		CERES.put(ZOMBIE, 7);
		
		
		NEBULA.put(ORC, 8);
		NEBULA.put(MANDRAKE, 8);
		NEBULA.put(GOLEM, 8);
		NEBULA.put(GOBLIN, 8);
		NEBULA.put(DIREWOLF, 1);
		
		
		ANDROMEDA.put(VAMPIRE, 12);
		ANDROMEDA.put(SHOGGOTH, 12);
		ANDROMEDA.put(KAPPA, 12);
		ANDROMEDA.put(BASILISK, 12);
		
		ANDROMEDA.put(YATAGARASU, 1);
		ANDROMEDA.put(PHOENIX, 1);
		ANDROMEDA.put(OROCHI, 1);
		ANDROMEDA.put(LEVIATHAN, 1);
		ANDROMEDA.put(HYDRA, 1);
	}
	
	public static Monster getMonster(Area area) {
		switch(area) {
			case CERES: return CERES.getElement();
			case NEBULA: return NEBULA.getElement();
			case ANDROMEDA: return ANDROMEDA.getElement();
		}
		return null;
	}
	
	public static void rollSpawnTest(Area area) {
		Monster monster;
		System.out.format("\n-=-=- Roll Test [%s] -=-=-\n", area);
		
		for(int x = 0; x < 20; x++) {
			monster = getMonster(area);
			System.out.format("[%s] %s\n", monster.rarity, monster);
		}
	}
}
