package DungeonSource.AttackBehavior;

import DungeonSource.DungeonCharacters.DungeonCharacter;

public class SimpleAttack extends GeneralAttack {

	//for characters who have no special attack and just preform attack damage
	public void attack(DungeonCharacter opponent, DungeonCharacter thisCharacter) {
		generalAttackDamage(opponent, thisCharacter);
		
	}

}
