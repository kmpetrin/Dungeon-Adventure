package DungeonSource.AttackBehavior;

import DungeonSource.DungeonCharacters.DungeonCharacter;

public class BladeAttack extends GeneralAttack {
 
	public void attack(DungeonCharacter opponent, DungeonCharacter thisCharacter) {
		System.out.println(thisCharacter.getName() + " slices his rusty blade at " +
				opponent.getName() + ":");
		generalAttackDamage(opponent, thisCharacter);
	}

}
