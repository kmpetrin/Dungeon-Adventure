package DungeonSource.Collectibles;
/*@Kaylene
* 06/02/2019
*Polymorhpism pillar, there can only be on instance of this pillar
*It is one of the 4 pillars that must be collect to complete the game
*/
public class Polymorphism extends PillarsOfOO {

    private static Polymorphism uniqueInstance;
    private Polymorphism(){}

    public static Polymorphism getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Polymorphism();
        }
        return uniqueInstance;
    }

    public String toString(){
        return "Polymorphism Pillar";
    }
}
