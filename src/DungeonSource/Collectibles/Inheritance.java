package DungeonSource.Collectibles;
//inheritance pillar, only one inheritance pillar can be created
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
