package DungeonSource.Collectibles;
/*@Kaylene
* 06/02/2019
*Encapsualtion pillar, there can only be a single instance of this class
*It is one of the 4 pillars that must be collect to complete the game
*/
public class Encapsulation extends PillarsOfOO {

    private static Encapsulation uniqueInstance;

    private Encapsulation(){}

    public static Encapsulation getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Encapsulation();
        }
        return uniqueInstance;
    }

    public String toString(){
        return "Encapsulation Pillar";
    }
}
