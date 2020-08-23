package DungeonSource.Room;
import java.util.ArrayList;
import java.util.Random;

import DungeonSource.Collectibles.IncreaseStatsItemFactory;
import DungeonSource.Collectibles.Item;
import DungeonSource.Collectibles.ItemFactory;
import DungeonSource.Collectibles.PillarsOfOO;
import DungeonSource.DungeonCharacters.*;
import DungeonSource.Misc.*;
import DungeonSource.Obstalces.Obstacle;
import DungeonSource.Obstalces.ObstacleFactory;
import RoomDisplay.Room2DDisplay;
import RoomDisplay.Symbols.*;
/*@Kaylene
 *06/02/2019
 *This class holds all items in the room. Generates the irems, monsters, and obstacles in the room
  *based on chance determined by settings. May contain a pillar of OO.
 */
public abstract class Room{
    private ArrayList<Item> itemsInRoom;
    private ArrayList<Obstacle> obstaclesInRoom;
    private Random rand;
    private boolean isEntrance, isExit, enemyHere, containsPillarOfOO;
    private String[] doors;
    private Monster enemy;
    private int numItemsAllowedInRoom, numObstaclesAllowedInRoom, numObstacleChoices, numItemChoices,  numMonsterChoices;
    private final int chance;
    private ItemFactory itemFactory; 
    private MonsterFactory monsterFactory;
    private ObstacleFactory obstacleFactory;
    private PillarsOfOO pillar;
    private String room2DRepresentation;
    private Room2DDisplay room2dDisplay;


    //if the room is an entrance or exit set to empty else generate the monster, obstacles, and items
    public Room(int chance, int numItemsAllowedInRoom, int numObstalcesAllowed, boolean isRoomAnEntrance,
                    boolean isRoomAnExit, int numObstacleChoices, int numItemChoices, int numMonsterChoices){
        this.numItemsAllowedInRoom = numItemsAllowedInRoom;
        this.numObstaclesAllowedInRoom = numObstalcesAllowed;
        this.chance = chance;
        this.isExit = isRoomAnExit;
        this.isEntrance = isRoomAnEntrance;
        this.numObstacleChoices = numObstacleChoices;
        this.numItemChoices = numItemChoices;
        this.numMonsterChoices = numMonsterChoices;
        this.rand = new Random();
        this.monsterFactory = new MonsterFactory();
        this.obstacleFactory = new ObstacleFactory();
        this.itemFactory = new IncreaseStatsItemFactory();
        this.itemsInRoom = new ArrayList<Item>();
        this.obstaclesInRoom = new ArrayList<Obstacle>();
        if(isRoomAnEntrance || isRoomAnExit) {
            setRoomToEmpty();
        }else {
            generateObstaclesInRoom();
            generateItemsInRoom();
            generateMonsterInRoom();
        }
    }

    //sets the room to empty
    public void setRoomToEmpty(){
        this.numItemsAllowedInRoom = 0;
        this.numObstaclesAllowedInRoom = 0;
        this.enemyHere = false;
        enemy =null;
        this.itemsInRoom = new ArrayList<Item>();
        this.obstaclesInRoom = new ArrayList<Obstacle>();	
    }

    //returns if the room is empty or not
    public boolean isRoomEmpty() {
        if(itemsInRoom.size()==0 && obstaclesInRoom.size()==0 && enemy == null && pillar==null) {
            return true;
        }
        return false;
    }

    //returns the Monster in the room
    public Monster getMonsterInRoom(){
        return this.enemy;
    }

    //returns if room is an entrance or not
    public boolean isEntrance(){
        return this.isEntrance;
    }
    
    //reutrns if the rooms in an exit or not
    public boolean isExit(){
        return this.isExit;
    }
    
    //returns chance of item, monster, obstacle generation
    public int getChance(){
        return this.chance;
    }
    
    //allows the room doors to be set
    public void setDoors(String[] doors){
        if(doors.length > 4 || doors.length < 0){
            throw new IllegalArgumentException("Incorrect number of doors");
        }
        this.doors = doors;
    }
    
    //allows the mosnter in the room to be set
    public void setMonsterInRoom(Monster monster){
        if(monster == null){
            throw new IllegalArgumentException("Monster can't be null");
        }
        this.enemy = monster;
    }
    
    //allows obstacles in the room to be set
    public void setObstaclesInRoom(ArrayList<Obstacle> ObstaclesInRoom){
        if(obstaclesInRoom == null){
            throw new IllegalArgumentException("Items in room list can't be null");
        }
        this.obstaclesInRoom = obstaclesInRoom;
    }
    
    //generates items in the room based on the chance var
    //if the room as x num of items allowed each has y chance to generate and be added to the room
    public void generateItemsInRoom(){
        int chanceToGenerate;
        int selection;
        for(int i = 0; i < numItemsAllowedInRoom; i++){
            chanceToGenerate = rand.nextInt(101);
            if(chanceToGenerate <= chance){
                selection = rand.nextInt(numItemChoices);
                itemsInRoom.add(itemFactory.createItem(selection));
            }
        }	
    }
    
    //generates obstacles in the room based on the chance var
    //if the room as x num of obstacles allowed each has y chance to generate and be added to the room
    public void generateObstaclesInRoom(){
        int chanceToGenerate;
        for(int i = 0; i < numObstaclesAllowedInRoom; i++){
            chanceToGenerate = rand.nextInt(101);
            if(chanceToGenerate <= chance){
                int selection = rand.nextInt(numObstacleChoices);
                obstaclesInRoom.add(obstacleFactory.createObstacle(selection));
            }
        }
    }
    
    //generates monster in room if the gereated num is less than or equal to the chance var
    public void generateMonsterInRoom(){
        int chanceToGenerate = rand.nextInt(101);
        if(chanceToGenerate <= chance){
            enemyHere = true;
            int selection = rand.nextInt(numMonsterChoices);
            this.enemy = monsterFactory.createMonster(selection);
        }
    }

    //set items in the room
    public void setItemsInRoom(ArrayList<Item> itemsInRoom){
        if(itemsInRoom == null){
            throw new IllegalArgumentException("Items in room list can't be null");
        }
        this.itemsInRoom = itemsInRoom;
    }

    //set number of items allowed in room
    public void setNumOfItemsAllowedInRoom(int numOfItemsInRoomAllowed){
        if(numOfItemsInRoomAllowed == 0){
            throw new IllegalArgumentException("Must be greater than 0");
        }
        this.numItemsAllowedInRoom = numItemsAllowedInRoom;
    }

    //gets the num of items allowed in the room
    public int getNumOfItemsAllowedInRoom(){
        return this.numItemsAllowedInRoom;
    }

    //sets the num of obstalces allowed in the room
    public void setNumOfObstaclessAllowedInRoom(int numOfObstaclesAllowedInRoom){
        if(numOfObstaclesAllowedInRoom < 0){
            throw new IllegalArgumentException("Must be greater than or equal to 0");
        }
        this.numObstaclesAllowedInRoom = numObstaclesAllowedInRoom;
    }
    
    //gets the num of obstacles in a room
    public int getNumObstaclesAllowedInRoom(){
        return this.numObstaclesAllowedInRoom;
    }
    
    //returns if there is an enemy in the room
    public boolean isEnemyHere(){
        return (enemy != null);
    }
    
    //displays all of the rooms contents
    public String displayRoomContents(){
        if(isEntrance()){
            return "This room is an entrance. \nIt contains nothing";
        }else if(isExit()){
            return "This room is an exit. \nIt contains nothing";
        }
        return "This room contains the following: \n" + "+Items: \n" + itemListNames() +
                "+Obstacles: \n" + obstacleList() + "+Monsters: \n" + getMonster()
                +"\n+Pillar: \n"+getPillarOfOOName();
    }

    //returns the name of the OO pillar if it is here
    public String getPillarOfOOName() {
        if(isPillarOfOOHere()) {
            return this.pillar.toString();
        }return "0";
    }

    //gets the lsit of item names
    public String itemListNames(){
        if(itemsInRoom == null || itemsInRoom.size()==0){
            return "0\n";
        }
        String s = "";
        for(Item i : itemsInRoom){
            s += i+"\n";
        }
        return s;
    }

    //gets the list of obstacle names
    public String obstacleList(){
        if(obstaclesInRoom == null ||obstaclesInRoom.size()==0){
            return "0\n";
        }
        String s ="";
        for(Obstacle o : obstaclesInRoom){
            s += o+"\n";
        }
        return s;
    }

    //gets the name of monster if it is present
    public String getMonster(){
        if(isEnemyHere()){
            return enemy.getName();
        }
        return "0";
    }

    //returns the list of items in room
    public ArrayList<Item> getItemsInRoom(){
            return this.itemsInRoom;
    }
    
    //returns the list of osbtacles in room
    public ArrayList<Obstacle> getObstaclesInRoom(){
        return this.obstaclesInRoom;
    }
    
    //returns the pillar of OO if present
    public PillarsOfOO getPillarOfOO() {
        return pillar;
    }

    //check if pillar of OO is present
    public boolean isPillarOfOOHere(){
        return (pillar!=null); 	
    }
    
    //returns the doors in the room
    public String[] getDoors(){
        return this.doors;
    }
    
    //sets the pillar of OO
    public void setPillarOfOO(PillarsOfOO pillar){
        if(pillar == null){
            throw new IllegalArgumentException("Pillar can't be added");		
        }
        this.pillar = pillar;
    }

    //if the pillar is taken it's set to null
    public void pillarTaken() {
        this.pillar = null;
    }
    
    //counts if room has an obstacle, pillar, monster, and item
    public int countIfVariousItemsInRoom() {
        int i = 0;
        if(isEnemyHere()) {
            i++;
        }
        if(isPillarOfOOHere()) {
            i++;
        }
        if(itemsInRoom.size()>0) {
            i++;
        }if(obstaclesInRoom.size()>0) {
            i++;
        }
        return i;
    }
    
    //sets the 2d representaiton of the room
    public void set2DRoomDisplay(Room2DDisplay display) {
        if(display == null) {
            throw new IllegalArgumentException("Room display can't be null");
        }
        this.room2dDisplay = display;
    }
    
    //returns the 2d representation of the room
    public Room2DDisplay getRoom2DDisplay() {
        return this.room2dDisplay;
    }

    public String toString() {
        return room2dDisplay.toString();
    } 

    //allows symbol in the 2d representation of the room to be changed if the room items change
    public void setRoomSymbol() {
        if(isEntrance()) {
                this.room2dDisplay.setRoomSymbol(new EntranceRoomSymbol());
        }
        else if(isExit()) {
                room2dDisplay.setRoomSymbol(new ExitRoomSymbol());
        }else if(isRoomEmpty() && !(isEntrance()) && !(isExit())) {
                room2dDisplay.setRoomSymbol(new EmptyRoomSymbol());
        }else if(countIfVariousItemsInRoom()>1 ) {
                room2dDisplay.setRoomSymbol(new MultipleItemsSymbol());
        }else if(isEnemyHere() && countIfVariousItemsInRoom() == 1) {
                room2dDisplay.setRoomSymbol(new MonsterRoomSymbol());
        }else if(isPillarOfOOHere() && countIfVariousItemsInRoom()==1) {
                room2dDisplay.setRoomSymbol(new PillarOfOOSymbol());
        }else if(getItemsInRoom().size()>0 && countIfVariousItemsInRoom() ==1) {
                room2dDisplay.setRoomSymbol(new ItemsRoomSymbol());
        }else if(getObstaclesInRoom().size()>0 && countIfVariousItemsInRoom() ==1) {
                room2dDisplay.setRoomSymbol(new ObstacleInRoomSymbol());
        }
    }
}
