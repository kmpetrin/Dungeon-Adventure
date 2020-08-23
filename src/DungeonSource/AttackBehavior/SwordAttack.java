package DungeonSource.AttackBehavior;

import DungeonSource.DungeonCharacters.DungeonCharacter;
/*@Kaylene
* 06/02/2019
*Sword attack, prints it's attack type and attempts to deal general attack damage
*/
public class SwordAttack extends GeneralAttack {

    public void attack(DungeonCharacter opponent,DungeonCharacter thisCharacter) {
        System.out.println(thisCharacter.getName() + " swings a mighty sword at " +
                        opponent.getName()+ ":");
        generalAttackDamage(opponent, thisCharacter);
    }
}