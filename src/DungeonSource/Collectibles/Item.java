package DungeonSource.Collectibles;
import DungeonSource.DungeonCharacters.Hero;
/*@Kaylene
* 06/02/2019
*Item interface for items that the hero can use
*/
public interface Item{
    
    //hero uses item and stats are increased
    public void use(Hero hero);

    //returns item name, used for satchel classification
    public String getName();
}
