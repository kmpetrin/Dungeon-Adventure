package DungeonSource.DungeonCharacters;

import DungeonSource.AttackBehavior.ClubAttack;

public class Giant extends Monster {
	
	Giant()
		{
			super("Tiny the Giant", 260, 2, .6, .1, 30, 50, 30, 50);
			setAttack(new ClubAttack());

	    }//end constructor
}
