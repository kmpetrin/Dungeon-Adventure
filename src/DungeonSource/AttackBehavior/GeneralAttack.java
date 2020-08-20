package DungeonSource.AttackBehavior;

import DungeonSource.DungeonCharacters.DungeonCharacter;


//abstract class that other basic attacks that need the generalAttackDamage
//method inherit from
public abstract class GeneralAttack implements DungeonCharacterAttack {

	public void generalAttackDamage(DungeonCharacter opponent, DungeonCharacter thisCharacter) {
		{
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
	}
	public abstract void attack(DungeonCharacter opponent, DungeonCharacter thisCharacter);

}
