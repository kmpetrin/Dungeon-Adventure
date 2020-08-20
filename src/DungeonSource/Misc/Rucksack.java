package DungeonSource.Misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import DungeonSource.Collectibles.AttackSpeedPotion;
import DungeonSource.Collectibles.HealthPotion;
import DungeonSource.Collectibles.Item;
import DungeonSource.Collectibles.PillarsOfOO;
import DungeonSource.DungeonCharacters.Hero;
//Rucksack class that holds the items collected

public class Rucksack {
	/*
		private HashMap<String, ArrayList<Item>> items; //holds the items picked up
		private ArrayList<PillarsOfOO> pillarCollection; //holds the pillars picked up
	 */

	private HashMap<String, ArrayList<Item>> items;
	private ArrayList<PillarsOfOO> pillarCollection;
	
	public Rucksack(){
		items = new HashMap<String, ArrayList<Item>>();
		pillarCollection = new ArrayList<PillarsOfOO>();
	}
	
	//adds pillar to the pillar list
	public void addPillar(PillarsOfOO pillar){
		if(pillarCollection.size()<=4){
			pillarCollection.add(pillar);
		}
	}
	
	//adds item to the hashmap
	public void addItem(Item itemToAdd){
		String itemType = itemToAdd.getName();
		if(items.containsKey(itemType)){
			items.get(itemType).add(itemToAdd); 
		}else{
			items.put(itemType, new ArrayList<Item>());
			items.get(itemType).add(itemToAdd); 
		}
	}
	
	//allows the user to use the item and then deletes it when used
	public  void useItem(String itemType, Hero hero){
		ArrayList<Item> itemList;
		if(items.containsKey(itemType)){
			itemList = items.get(itemType);
			if(itemList.size() >= 1){
				itemList.get(itemList.size()-1).use(hero);
				itemList.remove(itemList.size()-1);
				if(itemList.size()==0){
					items.remove(itemType);
				}
			}
		}else{
			System.out.println("Item not found.");
		}
	}
	
	//counts the item based on type
	public int countItems(String itemType){
		if(items.containsKey(itemType)){
			return items.get(itemType).size();
		}else{
			return 0;
		}
	}
	//counts the number of pillars in the rucksack
	public int pillarCount(){
		return this.pillarCollection.size();
	}

	//visual representation of the items in the rucksack
	public void showItemsInRucksack(){
		Set<String> itemList= items.keySet();
		ArrayList<String> itemListArray = new ArrayList<String>(itemList);
		System.out.println("\n");
		System.out.println("******~Rucksack~******");
		if(itemListArray.size()==0){
			System.out.println("No Items to Show");
		}
		for(String s : itemListArray){
			System.out.println("-"+s+" x"+countItems(s));
			
		}
		System.out.println("---------------------");
		System.out.println("Number of Pillars: " +pillarCollection.size());
		System.out.println("**********************");
		System.out.println("\n");
	}
	
	
	
	
	
	
	
}
