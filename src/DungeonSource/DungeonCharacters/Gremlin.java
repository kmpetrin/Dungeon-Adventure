package DungeonSource.DungeonCharacters;

import DungeonSource.AttackBehavior.KrisAttack;

 /* @Kaylene
  *06/02/2020
  *Gremlins have kris attacks
 */
public class Gremlin extends Monster
{
    Gremlin(){
        super("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40);
        setAttack(new KrisAttack());
    }//end constructor



}//end class Gremlin