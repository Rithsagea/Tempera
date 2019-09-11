package com.rithsagea.tempera;

public class Main {
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
	static final Monster HYDRA = new Monster("Hydra", new StatContainer(20, 10, 20));
	static final Monster OROCHI = new Monster("Orochi", new StatContainer(20, 10, 20));
	
	//4 - 40 base
	static final Monster DIREWOLF = new Monster("Direwolf", new StatContainer(20, 5, 25));
	static final Monster BASILISK = new Monster("Basilisk", new StatContainer(20, 10, 10));
	
	//3 - 30 base
	static final Monster ORC = new Monster("Orc", new StatContainer(10, 5, 15));
	
	//2 - 20 base
	static final Monster ZOMBIE = new Monster("Zombie", new StatContainer(5, 0, 15));
	static final Monster SKELETON = new Monster("Skeleton", new StatContainer(5, 0, 15));
	
	//1 - 10 base
	static final Monster SLIME = new Monster("Slime", new StatContainer(0, 0, 10));
	
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
		
		ItemRegistry.init();
	}
	
	public static void main(String args[]) {
		registerItems();
		ItemRegistry.printItems();
		
		System.out.println("\n\nBegin Roll\n------------------------------------------");
		Item item;
		int cost = 0;
		
		for(int x = 0; x < 100; x++) {
			item = ItemRegistry.getItem();
			cost += item.rarity.getCost();
			System.out.println(ItemRegistry.getItem().name);
		}
		
		System.out.format("\nTotal Coins: %d", cost);
	}
}
