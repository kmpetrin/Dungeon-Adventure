package DungeonSource.Collectibles;
//polymorhpism pillar, there can only be on instance of this pillar
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
