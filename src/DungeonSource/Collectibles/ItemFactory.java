package DungeonSource.Collectibles;

import DungeonSource.DungeonCharacters.DungeonCharacter;
//abstract item factory for creating items
public abstract class ItemFactory {
	
	public Item selectItem(int selection){
		return createItem(selection);
		
	}
	public abstract Item createItem(int selection);


}
