

import java.util.Scanner;

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

//starts the game
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
   System.out.println("Max number of collectibles allowed in any given room: ");
   numItemsAllowedInRoom=checkIfNumValid(0,0, Integer.MAX_VALUE, "Must be greater than or equal to 0", false);
   System.out.println("Max number of obstacles allowed in any given room: ");
   numObstaclesAllowedInRoom = checkIfNumValid(0,0, Integer.MAX_VALUE,"Must be greater than or equal to 0", false);
   System.out.println("Width of dungeon (number of rows): ");
   rowSize=checkIfNumValid(0,4, Integer.MAX_VALUE, "Must be greater than or equal to 4", false);
   System.out.println("Length of dungeon (number of columns): ");
   columnSize=checkIfNumValid(0,4, Integer.MAX_VALUE, "Must be greater than or equal to 4", false);
   System.out.println("Chance that a room will generate collectibles, obstalces or monsters (0-100): ");
   roomGenerationChance=checkIfNumValid(0,0, 100, "Must between 0 and 100", true);
   System.out.println("The following allows you to choose how many different obstacles, collectibles, and monsters are in the game."+
                     "\nThese cannot be cherry-picked, but rather choosing a number allows all objects to have a possibility of"+
                     "\nbeing generated up to the number you have selected. \nFor example when choosing the number 3 for monsters,"+
                     "\nall monsters 1-3 will have the possibility of being generated int the game, but 4-5 won't.");
   System.out.println("\nObstacles are numbered as 1.Pit 2.Poison Arrows: ");
   numObstacleChoices=checkIfNumValid(0,1, 2, "Must be between 1 and 2", true);
   System.out.println("Collectibles are numbered as 1.Health Potion 2.Increase Attack Speed Potion: ");
   numItemChoices=checkIfNumValid(0,1, 2, "Must be between 1 and 2", true);
   System.out.println("Monsters are numbered as 1.Ogre 2.Gremlin 3.Skeleton 4.Giant 5.Troll:");
   numMonsterChoices = checkIfNumValid(0,1, 5, "Must be between 1 and 5", true);

}

//checks if number entered by user is valid
public static int checkIfNumValid(int num, int min, int max, String errorMsg, boolean isForRandGenerator){
   num = scan.nextInt();
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
