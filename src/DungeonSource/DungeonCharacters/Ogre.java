package DungeonSource.DungeonCharacters;

import DungeonSource.AttackBehavior.ClubAttack;


/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */
//it's an ogre
public class Ogre extends Monster
{

    Ogre()
	{
		super("Oscar the Ogre", 200, 2, .6, .1, 30, 50, 30, 50);
		setAttack(new ClubAttack());

    }//end constructor




}//end Monster class