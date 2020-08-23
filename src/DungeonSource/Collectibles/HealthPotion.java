package DungeonSource.Collectibles;

import DungeonSource.DungeonCharacters.Hero;

/*@Kaylene
* 06/02/2019
*Class that increases the DungeonCharacters health points if used by 5-15 pts
*/

public class HealthPotion extends PotionIncreaseStats {

    HealthPotion(){
        super(5,15, "Health Potion");
    }
    
    //displays the name and how much it increases the health points by
    public String toString(){
        return "Health Potion. It increases health by " +getStatIncrease()+" points";
    }

    //hero drinks the potion and there health is increased byt getStatIncrease()
    public void drink(Hero hero){
        hero.addHealthPoints(getStatIncrease());
        System.out.println(hero.getName()+" has added "+ getStatIncrease() +" health points");
        System.out.println("Total health points " + hero.getHealthPoints());
    }
    
    //calls the drink method
    public void use(Hero hero) {
        drink(hero);
    }
		
}
