package DungeonSource.AttackBehavior;

import DungeonSource.DungeonCharacters.DungeonCharacter;

public class ClubAttack extends GeneralAttack {

	public void attack(DungeonCharacter opponent,DungeonCharacter playerCharacter) {
		System.out.println(playerCharacter.getName() + " slowly swings a club toward's " +
			opponent.getName() + ":");
		generalAttackDamage(opponent, playerCharacter);

	}

}
