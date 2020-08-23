import java.util.Scanner;
import DungeonSource.Collectibles.Item;
import DungeonSource.Dungeon.Battle;
import DungeonSource.Dungeon.Dungeon;
import DungeonSource.DungeonCharacters.Hero;
import DungeonSource.DungeonCharacters.HeroFactory;
import DungeonSource.Obstalces.Obstacle;
import DungeonSource.Room.Room;
import RoomDisplay.Symbols.EmptyRoomSymbol;
/*
*@Kaylene
*06/02/2019
*this class is how the user plays the game, 
*it contains the character dungeon interaction and most visual/menu pieces for gameplay
*/
public class DungeonAdventurePlay {
	private Dungeon dungeon;
	private Hero hero;
	private Room currentRoom;
	private Scanner scan;
	private char quit;
   private int heroChoices =6;
	
	
    //initializes game settings
    public void initializeGame(int numItemsAllowedInRoom, int numObstaclesAllowedInRoom, int rowSize, int columnSize,
                                                int numObstacleChoices, int numItemChoices, int numMonsterChoices, int roomGenerationChance){
        dungeon= new Dungeon(numItemsAllowedInRoom, numObstaclesAllowedInRoom, rowSize, columnSize,
                                  numObstacleChoices, numItemChoices, numMonsterChoices, roomGenerationChance);
        scan = new Scanner(System.in);
        quit =0;
        currentRoom = getCurrentRoom();

    }
    //starts the game
    public void start()
    {
        welcomeScreen();
        howToPlay();
        System.out.println("------------------------");
        System.out.println("Starting Game");
        System.out.println("------------------------");
        hero = chooseHero();
        setName();
        playGame();
        System.out.println("End of game."+dungeon);

    }

    //sets the heros (player character's) name
    public void setName()
      {
        String name;
        System.out.print("Enter character name: ");
        name = scan.next();
        hero.setName(name);
      }
    
    //allows the user to choose their hero
    public Hero chooseHero()
    {
        HeroFactory heroFactory = new HeroFactory();
        displayHeroChoices();
        int choice=scan.nextInt();
        choice =DungeonAdventure.checkIfNumValid(choice,1,heroChoices, "Must choose an int between 1 and "+heroChoices,false);
        return heroFactory.createHero(choice);
    }
    
    //display menu for hero choices
    public void displayHeroChoices(){
        System.out.println("Choose a hero:\n" +
                           "1. Warrior\n" +
                           "2. Sorceress\n" +
                           "3. Thief\n"
                           + "4. Wizard\n"
                           + "5. Cleric\n"
                           + "6. Assassin");
    }
    //plays the game while the hero is alive
    public void playGame(){
        do{
            heroRoomInteraction();
        }while(hero.isAlive() && quit!='y');
        if(!(hero.isAlive())) {
                System.out.println(hero.getName() + " was has died. You Lose.");
        }

    }
    
    //,method for hero and Room interaction
    //displays the current room and determines interaction if the room is an entrance, exit, or normal room
    public void heroRoomInteraction(){
        currentRoom = getCurrentRoom();
        displayCurrentRoom();
        if(currentRoom.isEntrance()){
                menuRoomChoices();
        }
        else if(currentRoom.isExit()){
                userExitRoom();
        }else{
                interactWithRoom();
                if(hero.isAlive()){
                        menuRoomChoices();
                }
        }
    }
    
    //allows hero to  pick up items, encounter obstacles, or battle monsters if they exist
    //room is set to empty once hero interacts with room
    public void interactWithRoom() {
        for(Obstacle o: currentRoom.getObstaclesInRoom()){
                o.dealDamage(hero);
        }
        for(Item i : currentRoom.getItemsInRoom()){
                System.out.println(hero.getName()+" picked up the following: "+currentRoom.itemListNames());
                hero.pickUpItem(i);
        }
        if(currentRoom.isPillarOfOOHere()){
                System.out.println(hero.getName()+" found : "+currentRoom.getPillarOfOOName()+"!");
                hero.pickUpPillarOfOO(currentRoom.getPillarOfOO());
                currentRoom.pillarTaken();
        }
        if(currentRoom.isEnemyHere()){
                Battle battle = new Battle(hero, currentRoom.getMonsterInRoom());
                battle.startBattle();
        }
        currentRoom.setRoomToEmpty();
        currentRoom.getRoom2DDisplay().setRoomSymbol(new EmptyRoomSymbol());
    }

    //main menu display for moving, opening rucksack or quitting game
    public void menuDisplay() {
        System.out.println("------------------------");
        System.out.println("Map of Dungeon\n");
        dungeon.mapOfDungeon();
        System.out.println("\nSelect an option: ");
        System.out.println("1. Move");
        System.out.println("2. Open Rucksack");
        System.out.println("3. Quit Game");
        System.out.println("------------------------");
    }
    //user choices for main menu
    public void menuRoomChoices(){
        int choice=0;
        while(choice!=1 || choice !=2 || choice !=3){
            menuDisplay();
            choice = scan.next().charAt(0);
            if(choice =='1'){
                    move();
                    break;
            }else if(choice == '2'){
                     heroRucksackDisplayMenu();
                     break;
            }else if(choice == '3'){
                    quitMethod();
                    break;
            }else if(choice == ';') {
                    System.out.println(dungeon);

            }
        }
    }

    //ends game
    public void quitMethod() {
        System.out.println("Are you sure you would like to quit? Press 'y' to quit. Anything else to continue.");
        char playerQuit = scan.next().charAt(0);
        quit =playerQuit;
    }
    
    //gets the current room that the hero is in
    public Room getCurrentRoom(){
        int row = dungeon.getHeroLocation()[0];
        int column = dungeon.getHeroLocation()[1];
        return dungeon.getRoom(row, column);
    }

    //moves the character based on user direction choices
    public void move(){
        determineDirection(userDirectionChoices());
    }
    //displays the user direction choices until a valid selection is given
    public String userDirectionChoices(){
        String choice;
        do{
            displayDirectionChoice();
            choice = scan.next();
        }while(!(choiceIsOk(choice))); 
        return choice;
    }
    
    //checks to make sure user direction choice is ok/valid
    public boolean choiceIsOk(String choice){
        boolean choiceIsOk = false;
        for(String s: currentRoom.getDoors()){
            if(choice.equalsIgnoreCase(s)){
                    choiceIsOk =true;
            }
        }
        return choiceIsOk;
    }
    //displays the directions the user can move based on location(room)
    public void displayDirectionChoice(){
        System.out.print("Select a direction:");
        for(String s: currentRoom.getDoors()){
            System.out.print(s+" ");
        }
    }

    //sets the heros new location based on room that the hero has been moved to
    public void setNewLocation(int[] location){
        dungeon.setHeroLocation(location);
    }
    //determines the direction (user inputs n/s/e/w/ and it changes the heros location in the 2d array
    //and sets the new heros location after moving
    public void determineDirection(String choice){
        int[] location = dungeon.getHeroLocation();
        if(choice.equalsIgnoreCase("n")){
                location[0] -= 1;
        }else if(choice.equalsIgnoreCase("s")){
                location[0] +=1;
        }else if(choice.equalsIgnoreCase("e")){
                location[1] += 1;
        }else if(choice.equalsIgnoreCase("w")){
                location[1] -= 1;
        }else{
                System.out.println("Something went wrong");
        }
        setNewLocation(location);
    }
    //shows the contents of the current room in detail
    public void displayCurrentRoom(){
        System.out.println("------------------------");
        System.out.println("Displaying Current Room:\n");
        System.out.println(currentRoom);
        System.out.println(currentRoom.displayRoomContents());
        System.out.println("------------------------");
    }
    //displays the menu for the heros rucksack
    //if user chooses a valid item hero will use that item
    public void heroRucksackDisplayMenu(){
        String itemSelected="f";
        scan.nextLine();
        do{
            hero.displayEntireRucksack();
            System.out.println("Type in the name of the item that you would like to use");
            System.out.println("Type 'e' to exit");
            itemSelected= scan.nextLine();
            if(!itemSelected.equalsIgnoreCase("e")){
                hero.useItem(itemSelected);
            }
        }while(!itemSelected.equalsIgnoreCase("e"));
        menuRoomChoices();
    }
    //this method allows the user to exit the room 
    public void userExitRoom(){
        String s;
        System.out.println("This is the exit. Would you like to leave? Enter 'y' to exit. Anything else to continue");
        s = scan.next();
        if(s.equalsIgnoreCase("y")){
            if(hero.displayNumOfPillars()!=4){
                System.out.println("Are you sure? You do not have all the pillars of oo. Enter 'y' to exit. Anything else to continue.");
                s=scan.next();
                if(s.equals("y")){
                    System.out.println("You lose");
                    System.out.println("End of game."+dungeon);
                    System.exit(0);
                }
            }else{
                System.out.println("You've found all the pillars! You've won the game!");
                System.out.println("End of game."+dungeon);
                System.exit(0);
            }
        }else{
                menuRoomChoices();
        }
    }

    //display menu for welcome screen at start of game
    public void welcomeScreen() {
        System.out.println("Welcome to Dungeon Adventure!  \nIt is a text-based dungeon crawler game. Your objective is"
                        + "\nto collect the four Pillars of OO.  You will face many obstacles on your journey"
                        + "\nand will encounter various monsters within the dungeon.  Reach the exit with all"
                        + "\nfour pillars of OO and you win the game.");
    }
    //tells user how to play the game
    public void howToPlay() {
        System.out.println("\nHow to Play:\nYou can navigate your way through the dungeon by pressing "
                        + "\n'n','s', 'e', or 'w'.  You can view your location on the map that is displayed."
                        + "\nYour rucksack carries all the items and pillars you find.  To use an item or "
                        + "\nview your pillars open the rucksack.  Once all pillars have been found head for the exit"
                        + "\n...if you can find it.");
                        symbolMeanings();
    }
    //gives the meaning of room symbols
    public void symbolMeanings() {
        System.out.println("\nSymbol Meanings:");
        System.out.println("\nE-Empty Room"
                        + "\nI-Entrance"
                        + "\nO-Exit"
                        + "\nX-Monster"
                        + "\nC-Item of some sort"
                        + "\n!-Obstacle"
                        + "\nM-Multiple items"
                        + "\nP-Pillar Of OO");
    }
}

