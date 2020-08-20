package DungeonSource.AttackBehavior;

import DungeonSource.DungeonCharacters.DungeonCharacter;

public class CastSpell extends GeneralAttack{

	public void attack(DungeonCharacter opponent,DungeonCharacter thisCharacter) {
		System.out.println(thisCharacter.getName() + " casts a spell of fireball at " +
				opponent.getName() + ":");
		generalAttackDamage(opponent, thisCharacter);

	}

}
