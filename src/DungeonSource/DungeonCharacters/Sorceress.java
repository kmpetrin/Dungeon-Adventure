package DungeonSource.DungeonCharacters;

import DungeonSource.AttackBehavior.CastSpell;

 /* @Kaylene
  *06/02/2020
  *Sorceress has cast spell attack
 */

public class Sorceress extends Hero
{

    Sorceress(){
    	super("Sorceress", 75, 5, .7, 25, 50, .3);
    	setAttack(new CastSpell());
    }//end constructor

}//end class