package DungeonSource.AttackBehavior;

import DungeonSource.DungeonCharacters.DungeonCharacter;

public class KrisAttack extends GeneralAttack {

	public void attack(DungeonCharacter opponent, DungeonCharacter thisCharacter) {

		System.out.println(thisCharacter.getName() + 
				" jabs his kris at " + opponent.getName() + ":");
		generalAttackDamage(opponent, thisCharacter);
	}

}
