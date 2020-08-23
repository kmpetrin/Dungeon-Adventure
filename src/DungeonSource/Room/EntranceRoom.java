package DungeonSource.Room;

/*@Kaylene
 *06/02/2019
 *EntranceRoom has the ability to contain things like a normal room but
 * current settings leave them empty
 */
public class EntranceRoom extends Room {

    public EntranceRoom(int chance, int numItemsAllowedInRoom, int numObstalcesAllowed,
                    int numObstacleChoices, int numItemChoices, int numMonsterChoices) {
        super(chance, numItemsAllowedInRoom, numObstalcesAllowed, true,
                false, numObstacleChoices,numItemChoices, numMonsterChoices);

    }
}
