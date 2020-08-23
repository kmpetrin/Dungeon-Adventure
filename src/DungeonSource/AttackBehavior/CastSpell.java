package DungeonSource.AttackBehavior;

import DungeonSource.DungeonCharacters.DungeonCharacter;
/*@Kaylene
* 06/02/2019
*Cast Spell, prints it's attack type and attempts to deal general attack damage
*/
public class CastSpell extends GeneralAttack{

    public void attack(DungeonCharacter opponent,DungeonCharacter thisCharacter) {
        System.out.println(thisCharacter.getName() + " casts a spell of fireball at " +
                            opponent.getName() + ":");
        generalAttackDamage(opponent, thisCharacter);

    }

}
