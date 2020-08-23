package DungeonSource.AttackBehavior;

import DungeonSource.DungeonCharacters.DungeonCharacter;
        
/*@Kaylene
* 06/02/2019
*Increases the health points of a Hero, Monsters cannot have this attack.
*Increasing health points is randomly generated between min and max
*This "attack" counts as a turn in battle and does not do any damage to the monster
*/
public class IncreaseHealthPoints implements DungeonCharacterAttack, HeroAttack{
    public final int MIN_ADD = 25;
    public final int MAX_ADD = 50;

    public void attack(DungeonCharacter opponent, DungeonCharacter thisCharacter) {
        int hPoints;
        hPoints = (int)(Math.random() * (MAX_ADD - MIN_ADD+ 1)) + MIN_ADD;
        thisCharacter.addHealthPoints(hPoints);
        System.out.println(thisCharacter.getName() + " added [" + hPoints + "] health points.\n"
                                                + "Total health points remaining are: "
                                                + thisCharacter.getHealthPoints());
        System.out.println();
    }
}
