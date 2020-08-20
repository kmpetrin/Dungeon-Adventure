package DungeonSource.DungeonCharacters;

import DungeonSource.AttackBehavior.BladeAttack;



/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */
//it's a skeleton
public class Skeleton extends Monster
{

	Skeleton()
	{
		super("Sargath the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50);
		setAttack(new BladeAttack());

    }//end constructor




}//end class Skeleton