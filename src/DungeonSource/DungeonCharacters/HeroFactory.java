package DungeonSource.DungeonCharacters;
 /* @Kaylene
  *06/02/2020
 *factory that creates heroes based on input
 */
public class HeroFactory {

    public Hero createHero(int selection) {
        if(selection == 1){
            return new Warrior();
        }
        else if(selection == 2){
            return new Sorceress();
        }
        else if(selection == 3){
            return new Thief();
        }else if(selection == 4) {
            return new Wizard();
        }else if(selection == 5) {
            return new Cleric();
        }else if(selection == 6) {
            return new Assassin();
        }
        else{
            System.out.println("Invalid selection returning warrior");
            return defaultMonster();
        }
    }

    public Hero defaultMonster(){
            return new Warrior();
    }
}