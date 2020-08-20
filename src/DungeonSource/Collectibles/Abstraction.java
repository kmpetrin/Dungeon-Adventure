package DungeonSource.Collectibles;
//abstraction pillar, only one can be abstraction pillar can be created
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
