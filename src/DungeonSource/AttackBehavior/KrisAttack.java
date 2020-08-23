package DungeonSource.AttackBehavior;

import DungeonSource.DungeonCharacters.DungeonCharacter;
/*@Kaylene
* 06/02/2019
*Kris attack, prints it's attack type and attempts to deal general attack damage
*/
public class KrisAttack extends GeneralAttack {

    public void attack(DungeonCharacter opponent, DungeonCharacter thisCharacter) {

        System.out.println(thisCharacter.getName() + 
                        " jabs his kris at " + opponent.getName() + ":");
        generalAttackDamage(opponent, thisCharacter);
    }

}
