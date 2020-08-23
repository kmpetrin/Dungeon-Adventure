package DungeonSource.AttackBehavior;

import DungeonSource.DungeonCharacters.DungeonCharacter;
/*@Kaylene
* 06/02/2019
*Blade attack, prints it's attack type and attempts to deal general attack damage
*/
public class BladeAttack extends GeneralAttack {
 
    public void attack(DungeonCharacter opponent, DungeonCharacter thisCharacter) {
        System.out.println(thisCharacter.getName() + " slices his rusty blade at " +
                        opponent.getName() + ":");
        generalAttackDamage(opponent, thisCharacter);
    }

}
