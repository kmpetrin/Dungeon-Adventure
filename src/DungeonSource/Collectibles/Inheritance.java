package DungeonSource.Collectibles;
/*@Kaylene
* 06/02/2019
*Inheritance pillar, only one inheritance pillar can be created
*It is one of the 4 pillars that must be collect to complete the game
*/
public class Inheritance extends PillarsOfOO {
	
    private static Inheritance uniqueInstance;

    private Inheritance(){}

    public static Inheritance getInstance(){
        if(uniqueInstance == null){
                uniqueInstance = new Inheritance();
        }
        return uniqueInstance;
    }

    public String toString(){
            return "Inheritance Pillar";
    }
}
