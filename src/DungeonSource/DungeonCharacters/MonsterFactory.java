package DungeonSource.DungeonCharacters;
 /* @Kaylene
  *06/02/2020
  *factory that creates monsters based on input
 */
public class MonsterFactory {

    public Monster createMonster(int selection) {
        if(selection == 1){
            return new Ogre();
        }
        else if(selection == 2){
            return new Gremlin();
        }
        else if(selection == 3){
            return new Skeleton();
        }else if(selection == 4) {
            return new Giant();
        }else if(selection == 5) {
            return new Troll();
        }
        else{
            return defaultMonster();
        }
    }

    public Monster defaultMonster(){
        return new Ogre();
    }
}
