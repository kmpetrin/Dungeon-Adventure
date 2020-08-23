package DungeonSource.Room;

/*@Kaylene
 *06/02/2019
 *Normal room that will contain monster, items, or obstacles if they are generated 
 */
public class NormalRoom  extends Room{
	
    public NormalRoom(int chance, int numItemsAllowedInRoom, int numObstalcesAllowed,
                            int numObstacleChoices, int numItemChoices, int numMonsterChoices) {
        super(chance, numItemsAllowedInRoom, numObstalcesAllowed, false,
                false, numObstacleChoices,numItemChoices, numMonsterChoices);

     }
	

}
