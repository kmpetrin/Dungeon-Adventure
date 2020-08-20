package DungeonSource.DungeonCharacters;

import DungeonSource.AttackBehavior.CastSpell;




/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */


//it's a sorceress
public class Sorceress extends Hero
{

//-----------------------------------------------------------------
    Sorceress()
	{
    	super("Sorceress", 75, 5, .7, 25, 50, .3);
    	setAttack(new CastSpell());
    }//end constructor



}//end class