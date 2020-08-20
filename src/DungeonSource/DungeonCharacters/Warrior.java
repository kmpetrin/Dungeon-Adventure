package DungeonSource.DungeonCharacters;


import DungeonSource.AttackBehavior.SwordAttack;



/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */



//it's a warrior
public class Warrior extends Hero
{

    Warrior()
	{

		super("Warrior", 125, 4, .8, 35, 60, .2);
		setAttack(new SwordAttack());

    }//end constructor

}//end Hero class