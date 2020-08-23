package DungeonSource.AttackBehavior;

import DungeonSource.DungeonCharacters.DungeonCharacter;
/*@Kaylene
* 06/02/2019
*Abstract class for dungeon character attacks
*/
public interface DungeonCharacterAttack {
	public void attack(DungeonCharacter opponent, DungeonCharacter thisCharacter);
}
