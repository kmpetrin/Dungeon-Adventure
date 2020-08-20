package DungeonSource.DungeonCharacters;

import DungeonSource.AttackBehavior.KrisAttack;



/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

//it's a gremlin
public class Gremlin extends Monster
{

    Gremlin()
	{
		super("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40);
		setAttack(new KrisAttack());
    }//end constructor



}//end class Gremlin