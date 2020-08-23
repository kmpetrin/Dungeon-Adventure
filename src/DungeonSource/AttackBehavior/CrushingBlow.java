package DungeonSource.AttackBehavior;

import DungeonSource.DungeonCharacters.DungeonCharacter;
/*@Kaylene
* 06/02/2019
*Special attack that deals a large amount of damage, hero specific attack, monsters cannot use
*The hero has a random chance of dealing a cruhsing blow and dealing heavy damage, otherwise they miss
*/
public class CrushingBlow implements DungeonCharacterAttack, HeroAttack {

    public void attack(DungeonCharacter opponent, DungeonCharacter thisCharacter) {
            if (Math.random() <= .4)
            {
                    int blowPoints = (int)(Math.random() * 76) + 100;
                    System.out.println(thisCharacter.getName()+ " lands a CRUSHING BLOW for " + blowPoints
                                                            + " damage!");
                    opponent.takeOpponentDamage(blowPoints);
            }//end blow succeeded
            else
            {
                    System.out.println(thisCharacter.getName() + " failed to land a crushing blow");
                    System.out.println();
            }//blow failed
    }
	
} 

