package DungeonSource.DungeonCharacters;

import DungeonSource.AttackBehavior.KrisAttack;

public class Troll extends Monster {

	Troll(){
		
			super("Jarkhi the Troll", 100, 3, .8, .3, 30, 50, 30, 50);
			setAttack(new KrisAttack());

	    }
	
}
