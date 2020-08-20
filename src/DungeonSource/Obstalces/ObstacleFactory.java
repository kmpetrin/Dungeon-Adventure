package DungeonSource.Obstalces;
//obstacles factory that creates obstacles
public class ObstacleFactory {

	public Obstacle createObstacle(int choice){
		if(choice == 1){
			return new Pit();
		}if(choice == 2){
			return new PoisonArrows();
		}
		else{

			return defaultObstacle();
		}
	}
	
	public Obstacle defaultObstacle(){
		return new Pit();
	}
}
