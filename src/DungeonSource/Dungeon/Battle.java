package DungeonSource.Dungeon;
import java.util.Random;
import java.util.Scanner;

import DungeonSource.AttackBehavior.CastSpell;
import DungeonSource.AttackBehavior.CrushingBlow;
import DungeonSource.AttackBehavior.IncreaseHealthPoints;
import DungeonSource.AttackBehavior.SimpleAttack;
import DungeonSource.AttackBehavior.SurpriseAttack;
import DungeonSource.AttackBehavior.SwordAttack;
import DungeonSource.Collectibles.HealthPotion;
import DungeonSource.Collectibles.IncreaseStatsItemFactory;
import DungeonSource.DungeonCharacters.DungeonCharacter;
import DungeonSource.DungeonCharacters.Hero;
import DungeonSource.DungeonCharacters.HeroFactory;
import DungeonSource.DungeonCharacters.Monster;
import DungeonSource.DungeonCharacters.MonsterFactory;


public class Battle {
	private Scanner scan;
    private Hero theHero;
	private Monster theMonster;
	private Random rand;
	private IncreaseStatsItemFactory itemFactory;

/*-------------------------------------------------------------------
chooseHero allows the user to select a hero, creates that hero, and
returns it.  It utilizes a polymorphic reference (Hero) to accomplish
this task
---------------------------------------------------------------------*/
public Battle(Hero theHero, Monster theMonster){
	this.theHero = theHero;
	this.theMonster = theMonster;
	scan = new Scanner(System.in);
	rand = new Random();
	this.itemFactory = new IncreaseStatsItemFactory();
}
/*-------------------------------------------------------------------
playAgain allows gets choice from user to play another game.  It returns
true if the user chooses to continue, false otherwise.
---------------------------------------------------------------------*/



/*-------------------------------------------------------------------
battle is the actual combat portion of the game.  It requires a Hero
and a Monster to be passed in.  Battle occurs in rounds.  The Hero
goes first, then the Monster.  At the conclusion of each round, the
user has the option of quitting.
---------------------------------------------------------------------*/
	public void startBattle()
	{
	
		System.out.println("\n"+theHero.getName() + " battles " +
							theMonster.getName());
		System.out.println("---------------------------------------------");

		//do battle
		while (theHero.isAlive() && theMonster.isAlive())
		{
		    //hero goes first
			battleChoices();

			//monster's turn (provided it's still alive!)
			if (theMonster.isAlive())
			    theMonster.attack(theHero);

			//let the player bail out if desired


		}//end battle loop

		if (!theMonster.isAlive()){
		    System.out.println(theHero.getName() + " was victorious!");
			chanceToDropPotion();
		}
		else if (!theHero.isAlive()){
			System.out.println(theHero.getName() + " was defeated :-(");
		}
	}//end battle method

public void chanceToDropPotion(){
	
	int chanceToGenerate = rand.nextInt(101);
	if(chanceToGenerate >30){
		System.out.println("\n"+theMonster.getName()+" dropped a healing potion!");
		System.out.println(theHero.getName()+" picked up the potion.");

		theHero.pickUpItem(itemFactory.createItem(1));
	}
}
public void battleChoices()
{
	theHero.calculateNumOfTurns(theMonster);	
	System.out.println("Number of turns this round is: " + theHero.getNumTurns());
	int choice;
	do{
	   displayBattleChoices();
	   choice = scan.nextInt();
	   chooseGeneralOrSpecialAttack(choice);
	   theHero.attack(theMonster);
	   theHero.decrementNumTurns();
	   if (theHero.getNumTurns() > 0)
		    System.out.println("Number of turns remaining is: " + theHero.getNumTurns());
	} while(theHero.getNumTurns() > 0 && theMonster.isAlive());
}//end battleChoices


public void chooseGeneralOrSpecialAttack(int choice){

	   if(choice == 1){
		 listOfGeneralAttacks();
	   }else if(choice == 2){
		  listOfSpecialAttacks();
	   }else{
		   System.out.println("Invalid choice");
	   }
}

public void listOfSpecialAttacks(){
	displaySpecialAttacks();
	int choice = scan.nextInt();
	if(choice == 1){
		theHero.setAttack(new CrushingBlow());
	}else if(choice == 2){
		theHero.setAttack(new SurpriseAttack());
	}else if(choice == 3){
		theHero.setAttack(new IncreaseHealthPoints());
	}else{
		System.out.println("Invalid choice selecting Surprise Attack");
		theHero.setAttack(new SurpriseAttack());
	}
}
public void listOfGeneralAttacks(){
	displayGeneralAttacks();
	int choice = scan.nextInt();
	if(choice == 1){
		theHero.setAttack(new SwordAttack());
	}else if(choice == 2){
		theHero.setAttack(new CastSpell());
	}else if(choice == 3){
		theHero.setAttack(new SimpleAttack());
	}else{
		System.out.println("Invalid choice selecting Simple Attack");
		theHero.setAttack(new SimpleAttack());
	}
}

	public void displayGeneralAttacks(){
		System.out.println("\nSelect a General Attack: ");
		System.out.println("1. Sword Attack");
		System.out.println("2. Cast Spell");
		System.out.println("3. Simple Attack");
	}
	public void displaySpecialAttacks(){
		System.out.println("\nSelect  Special Attack:");
		System.out.println("1. Crushing Blow");
		System.out.println("2. Surprise Attack");
		System.out.println("3. Increase Health Points");
	}
	
	public void displayBattleChoices(){
		System.out.println("1. Attack opponent");
	    System.out.println("2. Special attack on Opponent");
	    System.out.print("Choose an option: ");
	}
	
	public void displayHeroChoices(){
		System.out.println("Choose a hero:\n" +
			       "1. Warrior\n" +
				   "2. Sorceress\n" +
				   "3. Thief");
	}

}
