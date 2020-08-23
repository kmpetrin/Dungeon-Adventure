package DungeonSource.DungeonCharacters;

import DungeonSource.AttackBehavior.BladeAttack;

 /* @Kaylene
  *06/02/2020
  *Skeletons have blade attacks
 */
public class Skeleton extends Monster
{

    Skeleton() {
        super("Sargath the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50);
        setAttack(new BladeAttack());
    }//end constructor

}//end class Skeleton