package DungeonSource.DungeonCharacters;
import DungeonSource.AttackBehavior.SwordAttack;


 /* @Kaylene
  *06/02/2020
  *Warriors have sword attacks
 */

public class Warrior extends Hero
{
    Warrior(){

        super("Warrior", 125, 4, .8, 35, 60, .2);
        setAttack(new SwordAttack());
    }//end constructor

}//end Hero class