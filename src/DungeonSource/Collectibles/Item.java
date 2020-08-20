package DungeonSource.Collectibles;

import DungeonSource.DungeonCharacters.Hero;
//item interface for items that the hero can use
public interface Item{

	public void use(Hero hero);
	
	//returns item name, used for satchel classification
	public String getName();
}
