package DungeonSource.DungeonCharacters;

import DungeonSource.AttackBehavior.SimpleAttack;

public class Assassin extends Hero {
	Assassin(){
		super("Assassin", 60, 8, .9, 10, 40, .7);
		setAttack(new SimpleAttack());
	}
}
