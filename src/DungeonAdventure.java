import java.util.Scanner;
/*@Kaylene
* 08/20/2020
*This class contains the main method to launch the game.
* It allows the user to choose the game settings such as room size, 
* number of obstacles and items allowed in a room. Change of a room
* generating a monster, obstacle, or item. 
*
*/
public class DungeonAdventure{
private static int numItemsAllowedInRoom;
private static int numObstaclesAllowedInRoom;
private static int rowSize;
private static int columnSize;
private static int numObstacleChoices;
private static int numItemChoices;
private static int numMonsterChoices;
private static int roomGenerationChance;
private static Scanner scan;

//current max and minimum setting options based on options available in monster, obstalce, and items classes
private static int minOption = 0;
private static int minOptionDungeonWidth = 3;
private static int maxOptionDungeonWidth = 100;
private static int minOptionDungeonLength = 3;
private static int maxOptionDungeonLength = 100;
private static int maxNumItemsAllowedInRoom = Integer.MAX_VALUE;
private static int maxNumObstaclesAllowedInRoom = Integer.MAX_VALUE;
private static int maxNumObstacleChoices = 2;
private static int minNumChoices = 1;
private static int maxNumItemChoices = 2;
private static int maxNumMonsterChoices =5;
private static final int maxRoomGenerationChance = 100;

public static void main(String[] args) {
      scan = new Scanner(System.in);
      System.out.println("~Dungeon Adventure~");
      System.out.println("Edit Settings?(Y/N)");
      char choice = scan.next().charAt(0);
      if(choice == 'Y' || choice == 'y'){
         settings();
      }else{
         numItemsAllowedInRoom = 2;
         numObstaclesAllowedInRoom = 2;
         rowSize = 5;
         columnSize = 5;
         numObstacleChoices = 3;
         numItemChoices = 3;
         numMonsterChoices = 5;
         roomGenerationChance = 10;
      }
      DungeonAdventurePlay game = new DungeonAdventurePlay();
		game.initializeGame(numItemsAllowedInRoom, numObstaclesAllowedInRoom, rowSize, columnSize,
				              numObstacleChoices, numItemChoices, numMonsterChoices, roomGenerationChance);     
		game.start();
	}
   
//sets up user settings for the game
public static void settings(){
   int choice;
   System.out.println("\nMax number of collectibles allowed in any given room: ");
   choice = scan.nextInt();
   numItemsAllowedInRoom=checkIfNumValid(choice, minOption, maxNumItemsAllowedInRoom, "Must be greater than or equal to "+minOption, false);
   
   System.out.println("Max number of obstacles allowed in any given room: ");
   choice = scan.nextInt();
   numObstaclesAllowedInRoom = checkIfNumValid(choice, minOption, maxNumObstaclesAllowedInRoom,"Must be greater than or equal to "+minOption, false);
   
   System.out.println("Width of dungeon (number of rows): ");
   choice = scan.nextInt();
   rowSize=checkIfNumValid(choice, minOptionDungeonWidth, maxOptionDungeonWidth , "Must be between "+minOptionDungeonWidth+" and "+maxOptionDungeonWidth, false);
   
   System.out.println("Length of dungeon (number of columns): ");
   choice = scan.nextInt();
   columnSize=checkIfNumValid(choice, minOptionDungeonLength, maxOptionDungeonLength, "Must be between "+minOptionDungeonLength+" and "+maxOptionDungeonLength, false);
   
   System.out.println("Chance that a room will generate collectibles, obstalces or monsters ("+minOption+"-"+maxRoomGenerationChance+")");
   choice = scan.nextInt();
   roomGenerationChance=checkIfNumValid(choice, minOption, maxRoomGenerationChance, "Must between "+minOption+" and "+maxRoomGenerationChance, true);
   
   System.out.println("The following allows you to choose how many different obstacles, collectibles, and monsters are in the game."+
                     "\nThese cannot be cherry-picked, but rather choosing a number allows all objects to have a possibility of"+
                     "\nbeing generated up to the number you have selected. \nFor example when choosing the number 3 for monsters,"+
                     "\nall monsters 1-3 will have the possibility of being generated int the game, but 4-5 won't.");
   System.out.println("\nObstacles are numbered as 1.Pit 2.Poison Arrows: ");
   choice = scan.nextInt();
   numObstacleChoices=checkIfNumValid(choice, minNumChoices, maxNumObstacleChoices, "Must be between "+minNumChoices+" and "+maxNumObstacleChoices, false);
   
   System.out.println("Collectibles are numbered as 1.Health Potion 2.Increase Attack Speed Potion: ");
   choice = scan.nextInt();
   numItemChoices=checkIfNumValid(choice, minNumChoices,  maxNumItemChoices, "Must be between "+ minNumChoices+" and "+maxNumItemChoices, false);
   
   System.out.println("Monsters are numbered as 1.Ogre 2.Gremlin 3.Skeleton 4.Giant 5.Troll:");
   choice = scan.nextInt();
   numMonsterChoices = checkIfNumValid(choice, minNumChoices, maxNumMonsterChoices, "Must be between "+minNumChoices+" and "+maxNumMonsterChoices, false);

}

public static int checkIfNumValid(int num, int min, int max, String errorMsg, boolean isForRandGenerator){

   while(num<min || num>max){
      System.out.println(errorMsg);
      num = scan.nextInt();
   }
   if(isForRandGenerator){
      return num+1;
   }else{
    return num;
   }
}


}
