package DungeonSource.Collectibles;

/*@Kaylene
* 06/02/2019
*Abstraction pillar, only one can be abstraction pillar can be created
*It is one of the 4 pillars that must be collect to complete the game
*/
public class Abstraction extends PillarsOfOO {
	
    private static Abstraction uniqueInstance;

    private Abstraction(){}

    public static Abstraction getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Abstraction();
        }
        return uniqueInstance;
    }

    public String toString(){
        return "Abstraction Pillar";
    }
}
