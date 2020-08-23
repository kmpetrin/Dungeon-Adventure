package DungeonSource.DungeonCharacters;

import DungeonSource.AttackBehavior.SimpleAttack;

 /* @Kaylene
  *06/02/2020
  *Thiefs have simple attacks but high attack speeds
 */
public class Thief extends Hero
{
    Thief(){
        super("Thief", 75, 6, .8, 20, 40, .5);
        setAttack(new SimpleAttack());
    }//end constructor
}