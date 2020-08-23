package DungeonSource.AttackBehavior;

import DungeonSource.DungeonCharacters.DungeonCharacter;

/*@Kaylene
* 06/02/2019
*Abstract class that other basic attacks that need the generalAttackDamage
*method inherit from. Chance the character will land a general attack is randomly
*generated and based upon the character's chance of landing an attack on its opponent.
*If attack is successful, opponents health points decrease by damage dealt
*/
public abstract class GeneralAttack implements DungeonCharacterAttack {

    public void generalAttackDamage(DungeonCharacter opponent, DungeonCharacter thisCharacter) {
        boolean canAttack;
        int damage;
        canAttack = Math.random() <= thisCharacter.getChanceAttackWillLand();
        if (canAttack)
        {
            damage = (int)(Math.random() * (thisCharacter.getDamageMax() - thisCharacter.getDamageMin() + 1))
                                    + thisCharacter.getDamageMin() ;
            opponent.takeOpponentDamage(damage);
            System.out.println();
        }//end if can attack
        else
        {
            System.out.println(thisCharacter.getName() + "'s attack on " + opponent.getName() +
                                                    " failed!");
            System.out.println();
        }//end else

    }//end attack method
    
    public abstract void attack(DungeonCharacter opponent, DungeonCharacter thisCharacter);

}
