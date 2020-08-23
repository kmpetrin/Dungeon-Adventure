package DungeonSource.Obstalces;
/*@Kaylene
 *06/02/2019
 *obstacle factory that creates obstacles, based on input
 */
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
