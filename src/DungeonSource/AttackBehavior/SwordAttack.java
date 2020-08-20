package DungeonSource.AttackBehavior;

import DungeonSource.DungeonCharacters.DungeonCharacter;

public class SwordAttack extends GeneralAttack {

	public void attack(DungeonCharacter opponent,DungeonCharacter thisCharacter) {
		System.out.println(thisCharacter.getName() + " swings a mighty sword at " +
				opponent.getName()+ ":");
		generalAttackDamage(opponent, thisCharacter);
	}
}