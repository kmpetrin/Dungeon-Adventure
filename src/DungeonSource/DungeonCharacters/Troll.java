package DungeonSource.DungeonCharacters;
import DungeonSource.AttackBehavior.KrisAttack;
 /* @Kaylene
  *06/02/2020
  *Trolls jave kriss attacks
 */
public class Troll extends Monster {

    Troll(){
        super("Jarkhi the Troll", 100, 3, .8, .3, 30, 50, 30, 50);
        setAttack(new KrisAttack());
     }
	
}
