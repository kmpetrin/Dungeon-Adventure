package DungeonSource.DungeonCharacters;

import DungeonSource.AttackBehavior.CastSpell;

public class Cleric extends Hero {
    Cleric()
	{
    	super("Cleric", 80, 5, .6, 25, 50, .4);
    	setAttack(new CastSpell());
    }//end constructor


}
