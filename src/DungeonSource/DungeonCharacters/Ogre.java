package DungeonSource.DungeonCharacters;

import DungeonSource.AttackBehavior.ClubAttack;

 /* @Kaylene
  *06/02/2020
  *Ogres have club attacks
 */
public class Ogre extends Monster
{
    Ogre(){
        super("Oscar the Ogre", 200, 2, .6, .1, 30, 50, 30, 50);
        setAttack(new ClubAttack());
    }//end constructor
}//end Monster class