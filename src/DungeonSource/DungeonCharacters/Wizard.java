package DungeonSource.DungeonCharacters;

import DungeonSource.AttackBehavior.CastSpell;
 /* @Kaylene
  *06/02/2020
  *Wizards contain cast spell attack
 */
public class Wizard extends Hero {
    Wizard(){
        super("Wizard", 105, 6, .8, 25, 50, .3);
        setAttack(new CastSpell());
    }//end constructor


}
