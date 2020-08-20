package DungeonSource.DungeonCharacters;

import java.util.Scanner;

import DungeonSource.AttackBehavior.DungeonCharacterAttack;
import DungeonSource.Collectibles.Item;
import DungeonSource.Collectibles.PillarsOfOO;
import DungeonSource.Misc.Rucksack;


//REFACTORED//
/**
 * Title: Hero.java
 *
 * Description: Abstract base class for a hierarchy of heroes.  It is derived
 *  from DungeonCharacter.  
 *
 *  class variables (all are directly accessible from derived classes):
 *    chanceToBlock -- a hero has a chance to block an opponents attack
 *    numTurns -- if a hero is faster than opponent, their is a possibility
 *                for more than one attack per round of battle
 *
 *  class methods (all are public):
 *  

 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */


public abstract class Hero extends DungeonCharacter 
{
	private double chanceToBlock;
	private int numTurns;
	private Rucksack rucksack;
	

//-----------------------------------------------------------------
//calls base constructor and gets name of hero from user
  Hero(String name, int healthPoints, int attackSpeed,
				     double chanceAttackWillLand, int damageMin, int damageMax,
					 double chanceToBlock)
  {
	  
	super(name, healthPoints, attackSpeed, chanceAttackWillLand, damageMin, damageMax);
	this.chanceToBlock = chanceToBlock;
	rucksack = new Rucksack();
	
  }


/*-------------------------------------------------------
defend determines if hero blocks attack

Receives: nothing
Returns: true if attack is blocked, false otherwise

This method calls: Math.random()

---------------------------------------------------------*/
  public boolean defend()
  {
		return Math.random() <= chanceToBlock;

  }//end defend method

//checks to see if hero can defend attack if not damageTaken is sent to super
  //subtractHealthPoints
public void takeOpponentDamage(int damageTaken)
	{
		if (defend())
		{
			System.out.println(getName() + " BLOCKED the attack!");
		}
		else
		{
			subtractHealthPoints(damageTaken);
		}


	}//end method


	//increment number of turns
	public void incrementNumTurns(){
		this.numTurns++;
	}
	//decrements number of turns
	public void decrementNumTurns(){
		this.numTurns--;
	}
	//gets the hero's number of turns
	public int getNumTurns(){
		return this.numTurns;
	}
	
	//calculates number of turns during the round
	public void calculateNumOfTurns(DungeonCharacter opponent){
		numTurns = getAttackSpeed()/opponent.getAttackSpeed();
		if (numTurns == 0)
			numTurns++;
	}
	//allows the hero to pick up an item and add it to the rucksack
	public void pickUpItem(Item item){
		rucksack.addItem(item);
	}
	
	//allows the user to pick up pillars and add it to the rucksack
	public void pickUpPillarOfOO(PillarsOfOO pillar){
		rucksack.addPillar(pillar);
	}
	//allows the user to use a selected item
	public void useItem(String itemType){
		rucksack.useItem(itemType, this);
	}
	//displays the number of pillars collected
	public int displayNumOfPillars(){
		return rucksack.pillarCount();
	}
	//displays the number of items in the rucksack
	public int displayNumOfItemType(String item){
		return rucksack.countItems(item);
	}
	//displays the rucksack
	public void displayEntireRucksack(){
		rucksack.showItemsInRucksack();
	}
	//sets heros chance to block
	public void setChanceToBlock(int chanceToBlock) {
		if(chanceToBlock <0) {
			throw new IllegalArgumentException();
		}
		this.chanceToBlock = chanceToBlock;
	}

}//end Hero class