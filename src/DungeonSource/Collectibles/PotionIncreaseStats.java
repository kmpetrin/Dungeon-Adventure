package DungeonSource.Collectibles;

import java.util.Random;

import DungeonSource.DungeonCharacters.Hero;

//abstract class for potions that increase stats
public abstract class PotionIncreaseStats implements Item {
	private int statIncrease; //number that the potion increases stats by
	private Random rand;
	private int lowestStatInt; //lowest the stat will be increased by
	private int highestStatInt;//highest the stat will be increased by
	private String name; //name of the potion
	
	PotionIncreaseStats(int lowestStatInt, int highestStatInt, String name){
		rand = new Random();
		setLowestStatInt(lowestStatInt);
		setHighestStatInt(highestStatInt);
		generateStatIncrease();
		this.name = name;
	}
	
	//generates the number the potion will increase the stat by
	public void generateStatIncrease(){
		this.statIncrease = rand.nextInt(highestStatInt-lowestStatInt) + lowestStatInt;
	}
	//subclasses implement a drink method
	public abstract void drink(Hero hero);
	//sets the lowest stat number
	public void setLowestStatInt(int lowestStatInt){
		if(lowestStatInt<0){
			throw new IllegalArgumentException("Damage must be positive");
		}
		this.lowestStatInt = lowestStatInt;
	}
	//sets the highest stat number
	public void setHighestStatInt(int highestStatInt){
		if(highestStatInt<0){
			throw new IllegalArgumentException("Damage must be positive");
		}
		this.highestStatInt = highestStatInt;
	}
	
	//gets the number of the stat
	public int getStatIncrease(){
		return this.statIncrease;
	}
	//gets the name of the potion
	public String getName(){
		return this.name;
	}
	
}
