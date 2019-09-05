package com.rithsagea.tempera;

public class Main {
	//LEGENDARY
	static final Item TYRFING = new Item(Rarity.LEGENDARY, "Tyrfing", new StatContainer(20, 10, 0));
	static final Item EXCALIBUR = new Item(Rarity.LEGENDARY, "Excalibur", new StatContainer(30, 0, 0));
	static final Item KUSANAGI = new Item(Rarity.LEGENDARY, "Kusanagi", new StatContainer(20, 5, 5));
	
	static final Item AEGIS = new Item(Rarity.LEGENDARY, "Aegis", new StatContainer(0, 30, 0));
	
	static final Item PHILOSTONE = new Item(Rarity.LEGENDARY, "Philosopher's Stone", new StatContainer(0, 20, 20));
	
	//EPIC
	static final Item DURENDAL = new Item(Rarity.EPIC, "Durendal", new StatContainer(15, 5, 0));
	static final Item MORALTA = new Item(Rarity.EPIC, "Moralta", new StatContainer(20, 0, 0));
	static final Item GOUJIAN = new Item(Rarity.EPIC, "Goujian", new StatContainer(15, 0, 5));
	
	static final Item EITR = new Item(Rarity.EPIC, "Eitr", new StatContainer(0, 15, 5));
	static final Item ADAMANT = new Item(Rarity.EPIC, "Adamant", new StatContainer(0, 20, 0));
	
	//RARE
	static final Item DAMSTEELSWORD = new Item(Rarity.RARE, "Damascus Steel Sword", new StatContainer(5, 5, 0));
	static final Item RUNEDBLADE = new Item(Rarity.RARE, "Runed Blade", new StatContainer(5, 0, 5));
	
	static final Item COBALTSHIELD = new Item(Rarity.RARE, "Cobalt Shield", new StatContainer(0, 5, 5));
	static final Item PERMAFROSTSHIELD = new Item(Rarity.RARE, "Permafrost Shield", new StatContainer(0, 10, 0));
	
	static final Item PINECONEBOW = new Item(Rarity.RARE, "Pinecone Bow", new StatContainer(5, 5, 0));
	static final Item VINEBOW = new Item(Rarity.RARE, "Vine Bow", new StatContainer(5, 0, 5));
	static final Item GLASSBOW = new Item(Rarity.RARE, "Glass Bow", new StatContainer(10, 0, 0));
	
	//COMMON
	static final Item MAGMA = new Item(Rarity.COMMON, "Magma", new StatContainer(5, 0, 0));
	static final Item CRYSTAL = new Item(Rarity.COMMON, "Crystal", new StatContainer(0, 5, 0));
	static final Item HONEY = new Item(Rarity.COMMON, "Honey", new StatContainer(0, 0, 5));
	
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
