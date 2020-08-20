package DungeonSource.Room;

/*ExitRoom has the ability to contain things like a normal room but
 * in this particular game it is empty
 */
public class ExitRoom extends Room {

	public ExitRoom(int chance, int numItemsAllowedInRoom, int numObstalcesAllowed,
			int numObstacleChoices, int numItemChoices, int numMonsterChoices) {
		
		super(chance, numItemsAllowedInRoom, numObstalcesAllowed, false,
			true, numObstacleChoices,numItemChoices, numMonsterChoices);
		
	}
}
