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

/*@Kaylene
* 06/02/2019
*battle is the actual combat portion of the game.  The Hero
*goes first, then the Monster. The user has the ability to chose
*the hero's attacks. If the monster dies the mosnter has a chance of dropping
*a potion
*/

public class Battle {
    private Scanner scan;
    private Hero theHero;
    private Monster theMonster;
    private Random rand;
    private IncreaseStatsItemFactory itemFactory;


    public Battle(Hero theHero, Monster theMonster){
        this.theHero = theHero;
        this.theMonster = theMonster;
        scan = new Scanner(System.in);
        rand = new Random();
        this.itemFactory = new IncreaseStatsItemFactory();
    }

    public void startBattle()
    {
        System.out.println("\n"+theHero.getName() + " battles " +
                                                theMonster.getName());
        System.out.println("---------------------------------------------");

        //do battle
        while (theHero.isAlive() && theMonster.isAlive()){
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

    //chance of monster dropping a potion after it diesS
    public void chanceToDropPotion(){
        int chanceToGenerate = rand.nextInt(101);
        if(chanceToGenerate >30){
            System.out.println("\n"+theMonster.getName()+" dropped a healing potion!");
            System.out.println(theHero.getName()+" picked up the potion.");

            theHero.pickUpItem(itemFactory.createItem(1));
        }
    }
    
    //lists battle choices for the user and gets user input
    public void battleChoices(){
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

    //lists attacks user can choose from that the hero can deal
    public void chooseGeneralOrSpecialAttack(int choice){
        if(choice == 1){
              listOfGeneralAttacks();
        }else if(choice == 2){
               listOfSpecialAttacks();
        }else{
            System.out.println("Invalid choice");
        }
    }
    
    ///sets the heros attack to user's selected special attack
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
    
    //sets the heros attack to the user selected general attack
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

    //displays general attacks to the user
    public void displayGeneralAttacks(){
        System.out.println("\nSelect a General Attack: ");
        System.out.println("1. Sword Attack");
        System.out.println("2. Cast Spell");
        System.out.println("3. Simple Attack");
    }
    
    //displays special attacks to the user
    public void displaySpecialAttacks(){
            System.out.println("\nSelect  Special Attack:");
            System.out.println("1. Crushing Blow");
            System.out.println("2. Surprise Attack");
            System.out.println("3. Increase Health Points");
    }

    //displays user battle choices to user
    public void displayBattleChoices(){
        System.out.println("1. Attack opponent");
        System.out.println("2. Special attack on Opponent");
        System.out.print("Choose an option: ");
    }

}
