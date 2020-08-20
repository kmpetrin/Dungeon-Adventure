package DungeonSource.DungeonCharacters;

import DungeonSource.AttackBehavior.SimpleAttack;




/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */
//it's a thief
public class Thief extends Hero
{

    Thief()
	{
		super("Thief", 75, 6, .8, 20, 40, .5);
		setAttack(new SimpleAttack());



    }//end constructor


}