package DungeonSource.Obstalces;

import java.util.Random;
/*@Kaylene
 *06/02/2019
 *Pit represents a pit that deals between 1-20 damage
 */
public class Pit extends Obstacle {

    Pit(){
        super(1,20, "a pit");
    }
    
    public String toString(){
        return "Pit. It deals "+getDamage()+" damage";
    }	
}
