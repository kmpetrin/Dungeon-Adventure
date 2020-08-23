package DungeonSource.Room;

/*@Kaylene
 *06/02/2019
 *ExitRoom has the ability to contain things like a normal room but
 * in current settings leave all exit rooms empty
 */
public class ExitRoom extends Room {

    public ExitRoom(int chance, int numItemsAllowedInRoom, int numObstalcesAllowed,
                    int numObstacleChoices, int numItemChoices, int numMonsterChoices) {

        super(chance, numItemsAllowedInRoom, numObstalcesAllowed, false,
                true, numObstacleChoices,numItemChoices, numMonsterChoices);

    }
}
