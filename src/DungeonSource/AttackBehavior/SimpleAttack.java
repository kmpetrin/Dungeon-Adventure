package DungeonSource.AttackBehavior;

import DungeonSource.DungeonCharacters.DungeonCharacter;
/*@Kaylene
* 06/02/2019
*simple attack, prints it's attack type and attempts to deal general attack damage
*/
public class SimpleAttack extends GeneralAttack {

    //for characters who have no special attack and just preform attack damage
    public void attack(DungeonCharacter opponent, DungeonCharacter thisCharacter) {
            generalAttackDamage(opponent, thisCharacter);
    }

}
