package DungeonSource.AttackBehavior;

import DungeonSource.DungeonCharacters.DungeonCharacter;
import DungeonSource.DungeonCharacters.Hero;
//attack that gives player another turn, Hero specific attack monsters cannot use
public class SurpriseAttack implements DungeonCharacterAttack, HeroAttack {

	public void attack(DungeonCharacter opponent, DungeonCharacter thisCharacter) {
			if(thisCharacter instanceof Hero){
				Hero hero = (Hero)thisCharacter;
			
			double surprise = Math.random();
			if (surprise <= .4)
			{
				System.out.println("Surprise attack was successful!\n" +
									thisCharacter.getName() + " gets an additional turn.");
				hero.incrementNumTurns();
				preformGeneralAttack(opponent, hero);
			}//end surprise
			else if (surprise >= .9)
			{
				System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
									" blocked your attack!");
			}
			else
				preformGeneralAttack(opponent, hero);
		}
	}
	
	
	private void preformGeneralAttack(DungeonCharacter opponent, Hero hero){
		hero.setAttack(new SimpleAttack());
		hero.attack(opponent);
	}
 
	}


