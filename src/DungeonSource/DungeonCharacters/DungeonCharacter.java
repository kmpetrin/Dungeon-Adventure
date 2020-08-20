package DungeonSource.DungeonCharacters;

import DungeonSource.AttackBehavior.DungeonCharacterAttack;
import DungeonSource.AttackBehavior.HeroAttack;

//REFACTORED COMMENTS//

/**
 * Title: DungeonCharacter.java
 *
 * Description: Abstract Base class for inheritance hierarchy for a
 *              role playing game
 *
 *  class variables (all will be directly accessible from derived classes):
 *    name (name of character)
 *    healthPoints (points of damage a character can take before killed)
 *    attackSpeed (how fast the character can attack)
 *    chanceAttackWillLand (chance an attack will strike the opponent)
 *    damageMin, damageMax (range of damage the character can inflict on
 *     opponent)
 *     attackSytle (holds the type of attack being used)
 *
 *  class methods (all are directly accessible by derived classes)
	 
 *
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */
//REFACTORED//
public abstract class DungeonCharacter implements Comparable
{

	private String name;
	private int healthPoints;
	private int attackSpeed;
	private double chanceAttackWillLand;
	private int damageMin, damageMax;
	private DungeonCharacterAttack attackStyle;

	public int compareTo(Object o)
	{
		return 1;
	}

//-----------------------------------------------------------------
//explicit constructor to initialize instance variables -- it is called
// by derived classes
	DungeonCharacter(String name, int healthPoints, int attackSpeed,
				     double chanceAttackWillLand, int damageMin, int damageMax)
	{

		this.name = name;
		this.healthPoints = healthPoints;
		this.attackSpeed = attackSpeed;
		this.chanceAttackWillLand = chanceAttackWillLand;
		this.damageMin = damageMin;
		this.damageMax = damageMax;
		

	}//end constructor

//-----------------------------------------------------------------
	public String getName()
	{
		return name;
	}//end getName

//-----------------------------------------------------------------
	public int getHealthPoints()
	{
		return healthPoints;
	}//end getHealthPoints
//-----------------------------------------------------------------
	public int getAttackSpeed()
	{
		return attackSpeed;
	}//end getAttackSpeed


/*-------------------------------------------------------
addHealthPoints is used to increment the healthPoints a dungeon character has

Receives: number of health points to add
Returns: nothing

This method calls: nothing

---------------------------------------------------------*/
	public void addHealthPoints(int healthPoints)
	{
		if (healthPoints <=0)
			System.out.println("Health points amount must be positive.");
		else
		{
			this.healthPoints += healthPoints;
			//System.out.println("Remaining Health Points: " + healthPoints);

		}
	}//end addHitPoints method

/*-------------------------------------------------------
subtractHealthPoints is used to decrement the healthpoints a dungeon character has.

Receives: number of health points to subtract
Returns: nothing

This method calls: nothing
---------------------------------------------------------*/
	public void subtractHealthPoints(int damageTaken)
	{
		if (damageTaken <0)
			System.out.println("Damage taken amount must be positive.");
		else if (damageTaken >0)
		{
			this.healthPoints -= damageTaken;
			if (this.healthPoints < 0)
				this.healthPoints = 0;
				displayHealthDamage(damageTaken);
		}//end else if

		if (this.healthPoints == 0)
			displayDeath();


	}//end method
	
	//used by subtractHealthPoints to display damage to health
		public void displayHealthDamage(int damageTaken){
			System.out.println(getName() + " has taken damage! " + getName()
					+" experienced <" + damageTaken+ "> damage");
			System.out.println(getName() + " now has " +
					getHealthPoints() + " health points remaining.");
			System.out.println();	
		}
		//used by subtractHealthPoints to show if character has been killed
		public void displayDeath(){
			System.out.println(name + " has been killed :-(");
		}
	
//Subclasses take damage differently and must implement this method differently
	public abstract void takeOpponentDamage(int healthPoints);
/*-------------------------------------------------------
isAlive is used to see if a character is still alive by checking health points

Receives: nothing
Returns: true is hero is alive, false otherwise

This method calls: nothing
This method is called by: unknown (intended for external use)
---------------------------------------------------------*/
    public boolean isAlive()
	{
	  return (this.healthPoints > 0);
	}//end isAlive method



	public int getDamageMin() {
		return this.damageMin;
	}

	public int getDamageMax() {
		return this.damageMax;
	}

	public void setName(String name){
		if(name == null){
			throw new IllegalArgumentException("Name cannot be null");
		}
		this.name = name;
	}
	
	public double getChanceAttackWillLand(){
		return this.chanceAttackWillLand;
	}
	
	
//-----------------------------------------------------------------
//calls the attack method in attackStyle reference
public void attack(DungeonCharacter opponent){
	attackStyle.attack(opponent, this); 
}

//sets attackStyle based on whatever is passed in, 
//Monsters cannot have HeroAttack type attacks
public void setAttack(DungeonCharacterAttack attack){
	if(attack instanceof HeroAttack && this instanceof Monster)
		throw new IllegalArgumentException("This attack style is for heroes only!");
	this.attackStyle = attack;
}

public void setAttackSpeed(int attackSpeed){
	this.attackSpeed = attackSpeed;
}

public void setAttackWillLand(double chance) {
	if(chance>1.0 || chance <=0) {
		throw new IllegalArgumentException("Must be between 0 and 1.0");
	}
	this.chanceAttackWillLand = chance;
}
	}//end class Character