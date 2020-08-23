package DungeonSource.Obstalces;
/*@Kaylene
 *06/02/2019
 *Posion arrows class that deals between 10-15 damage
 */
public class PoisonArrows extends Obstacle {
    
    PoisonArrows(){
        super(10,15, "poison arrows");
    }
	
    public String toString(){
        return "Poison arrows. They deal "+getDamage()+" damage";
    }
		

}
