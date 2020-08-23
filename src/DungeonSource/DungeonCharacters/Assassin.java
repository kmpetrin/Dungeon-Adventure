package DungeonSource.DungeonCharacters;
import DungeonSource.AttackBehavior.SimpleAttack;

 /* @Kaylene
  *06/02/2020
  *Assassins have a simple attack but high attack speed
 */
public class Assassin extends Hero {
    Assassin(){
        super("Assassin", 60, 8, .9, 10, 40, .7);
        setAttack(new SimpleAttack());
    }
}
