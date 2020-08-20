package DungeonSource.Collectibles;
//Encapsualtion pillar, there can only be a single instance of this class
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
