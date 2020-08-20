package DungeonSource.Room;

/*EntranceRoom has the ability to contain things like a normal room but
 * in this particular game it is empty
 */
public class EntranceRoom extends Room {

	public EntranceRoom(int chance, int numItemsAllowedInRoom, int numObstalcesAllowed,
			int numObstacleChoices, int numItemChoices, int numMonsterChoices) {
		
		super(chance, numItemsAllowedInRoom, numObstalcesAllowed, true,
			false, numObstacleChoices,numItemChoices, numMonsterChoices);
		
	}
}
