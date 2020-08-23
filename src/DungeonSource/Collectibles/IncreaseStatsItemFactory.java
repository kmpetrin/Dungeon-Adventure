package DungeonSource.Collectibles;

import DungeonSource.DungeonCharacters.DungeonCharacter;
import DungeonSource.DungeonCharacters.Gremlin;
import DungeonSource.DungeonCharacters.Ogre;
import DungeonSource.DungeonCharacters.Skeleton;

/*@Kaylene
* 06/02/2019
*A factory the creates items that increase stats based on input
*/
public class IncreaseStatsItemFactory extends ItemFactory {

    public Item createItem(int selection) {
        if(selection == 1){
            return new HealthPotion();
        }
        else if(selection == 2){
            return new AttackSpeedPotion();
        }else{
            return defaultItem();
        }
    }

    public Item defaultItem(){
        return new HealthPotion();
    }

}
