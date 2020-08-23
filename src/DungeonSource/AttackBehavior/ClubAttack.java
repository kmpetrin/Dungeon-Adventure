package DungeonSource.AttackBehavior;
import DungeonSource.DungeonCharacters.DungeonCharacter;
/*@Kaylene
* 06/02/2019
*Club attack, prints it's attack type and attempts to deal general attack damage
*/
public class ClubAttack extends GeneralAttack {

    public void attack(DungeonCharacter opponent,DungeonCharacter playerCharacter) {
        System.out.println(playerCharacter.getName() + " slowly swings a club toward's " +
                opponent.getName() + ":");
        generalAttackDamage(opponent, playerCharacter);

    }

}
