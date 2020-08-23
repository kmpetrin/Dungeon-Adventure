package DungeonSource.Collectibles;
import DungeonSource.DungeonCharacters.DungeonCharacter;
/*@Kaylene
* 06/02/2019
*abstract item factory for creating items
*/
public abstract class ItemFactory {
	
    public Item selectItem(int selection){
            return createItem(selection);
    }
    public abstract Item createItem(int selection);
}
