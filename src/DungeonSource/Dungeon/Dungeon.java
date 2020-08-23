package DungeonSource.Dungeon;

import java.util.ArrayList;
import java.util.Random;
import DungeonSource.Collectibles.Abstraction;
import DungeonSource.Collectibles.Encapsulation;
import DungeonSource.Collectibles.Inheritance;
import DungeonSource.Collectibles.PillarsOfOO;
import DungeonSource.Collectibles.Polymorphism;
import DungeonSource.Room.EntranceRoom;
import DungeonSource.Room.ExitRoom;
import DungeonSource.Room.NormalRoom;
import DungeonSource.Room.Room;
import RoomDisplay.*;

 /* @Kaylene
  *06/02/2020
  *Dungeon class that holds various rooms and is responsible for setting up rooms based on their location
  */
public class Dungeon {

    private Room[][] dungeon;
    private int dungeonColumn, dungeonRow, numItemChoices, numObstacleChoices, numMonsterChoices;
    private int[] entranceLocation, exitLocation, abstractionPillarLocation, polymorphismPillarLocation
            ,encapsulationPillarLocation,inheritancePillarLocation, heroLocation;
    private Random rand;
    private int roomGenerationChance, numItemsAllowedInRoom, numObstaclesAllowedInRoom;
    private ArrayList<int[]> uniqueRoomNumbers, pillarsOfOOLocationList;

    //intializes state and creates the dungeon
    public Dungeon(int numItemsAllowedInRoom, int numObstaclesAllowedInRoom, int rowSize, int columnSize,
                            int numObstacleChoices, int numItemChoices, int numMonsterChoices, int roomGenerationChance){
        this.rand = new Random();
        this.entranceLocation = new int[]{0,0};
        this.exitLocation = new int[]{0, 0};
        this.roomGenerationChance = roomGenerationChance;
        this.uniqueRoomNumbers = new ArrayList<int[]>();
        this.abstractionPillarLocation = new int[]{0,0};
        this.polymorphismPillarLocation = new int[]{0,0};
        this.encapsulationPillarLocation = new int[]{0,0};
        this.inheritancePillarLocation = new int[]{0,0};
        this.dungeonRow = rowSize;
        this.dungeonColumn = columnSize;
        this.setDungeonSize(dungeonRow, dungeonColumn);
        this.numItemsAllowedInRoom = numItemsAllowedInRoom;
        this.numObstaclesAllowedInRoom = numObstaclesAllowedInRoom;
        this.pillarsOfOOLocationList = new ArrayList<int[]>();
        this.numItemChoices = numItemChoices;
        this.numObstacleChoices = numItemChoices;
        this.numMonsterChoices = numMonsterChoices;
        createDungeon();
    }

    //adds the items that need to be unique room numbers
    public void addUniqueRoomNums(){
        uniqueRoomNumbers.add(abstractionPillarLocation);
        uniqueRoomNumbers.add(polymorphismPillarLocation);
        uniqueRoomNumbers.add(inheritancePillarLocation);
        uniqueRoomNumbers.add(encapsulationPillarLocation);
        uniqueRoomNumbers.add(entranceLocation);
        uniqueRoomNumbers.add(exitLocation);
    }

    //set the size of the dungeon
    public void setDungeonSize(int dungeonRow, int dungeonColumn){
            if(dungeonRow <1 || dungeonColumn < 1 ||(dungeonRow * dungeonColumn)<6 ){
                System.out.println(dungeonRow+" "+dungeonColumn);
                    throw new IllegalArgumentException("Size must be greater than 3");
            }
            this.dungeon = new Room[dungeonRow][dungeonColumn];
    }

    //create the dungeon by adding rooms, setting up the pillars/entrance/exit in unique rooms/set room symbols
    public void createDungeon(){
        addUniqueRoomNums();
        generateUniqueRooms();
        addRooms();
        setPillarsOfOOLocation();
        setPillarsOfOOInRoom();
        setRoomSymbols();
        setHeroLocation(entranceLocation);
    }

    //loops through the uniquRoomNumebrs list and generates the unqiue rooms for the items that must be placed in a unique room
    public void generateUniqueRooms(){
        for(int[] i : uniqueRoomNumbers){
            generateUniqueRoomNum(i);
        }
    }

    //generates the room numbers for the items that need to be in unique room
    public void generateUniqueRoomNum(int[] uniqueArray){
        int row;
        int column;
        row = rand.nextInt(dungeonRow-1);
        column = rand.nextInt(dungeonColumn-1);
        uniqueArray[0]=row;
        uniqueArray[1]=column;
        for(int[] i : uniqueRoomNumbers){
            if(uniqueArray!=i) {
                while(row==i[0] && column==i[1]){
                    row = rand.nextInt(dungeonRow-1);
                    column = rand.nextInt(dungeonColumn-1);
                    uniqueArray[0]=row;
                    uniqueArray[1]=column;
                }
            }
        }
    }

    //adds the rooms to the dungeon array 
    public void addRooms(){
        for(int i=0; i<dungeon.length; i++) {
            for(int j=0; j<dungeon[i].length; j++) {
                if(entranceLocation[0]==i && entranceLocation[1]==j){
                    dungeon[i][j] = new EntranceRoom(roomGenerationChance, numItemsAllowedInRoom, numObstaclesAllowedInRoom,
                                                        numObstacleChoices, numItemChoices, numMonsterChoices);
                }else if(exitLocation[0]==i && exitLocation[1]==j){
                    dungeon[i][j] = new ExitRoom(roomGenerationChance, numItemsAllowedInRoom, numObstaclesAllowedInRoom,
                                                        numObstacleChoices, numItemChoices, numMonsterChoices);
                }else {
                    dungeon[i][j] = new NormalRoom(roomGenerationChance, numItemsAllowedInRoom, numObstaclesAllowedInRoom, 
                                                        numObstacleChoices, numItemChoices, numMonsterChoices);
                }	
            addDoorsToRoom(i, j , dungeon[i][j]);
        }
    }
    }
    
    //sets the room symbols in each room
    public void setRoomSymbols(){
        for(int i=0; i<dungeon.length; i++) {
            for(int j=0; j<dungeon[i].length; j++) {
                dungeon[i][j].setRoomSymbol();
            }
        }
    }
    
    //adds pillars of OO locations to the pillars of OO location list
    public void setPillarsOfOOLocation() {
        pillarsOfOOLocationList.add(polymorphismPillarLocation);
        pillarsOfOOLocationList.add(abstractionPillarLocation);
        pillarsOfOOLocationList.add(encapsulationPillarLocation);
        pillarsOfOOLocationList.add(inheritancePillarLocation);
    }
    
    //creates the 4 unique pillars and adds them to a list
    public ArrayList<PillarsOfOO> createUniquePillars() {
        ArrayList<PillarsOfOO> list = new ArrayList<PillarsOfOO>();
        list.add(Polymorphism.getInstance());
        list.add(Abstraction.getInstance());
        list.add(Encapsulation.getInstance());
        list.add(Inheritance.getInstance());
        return list;
    }

    //adds the pillars in the room
    public void setPillarsOfOOInRoom() {
        ArrayList<PillarsOfOO> list = createUniquePillars();
        int i=0;
        for(int[] array : pillarsOfOOLocationList) {
            dungeon[array[0]][array[1]].setPillarOfOO(list.get(i));
            i++;
        }
    }

    //adds doors to the room based on their location in the dungeon
    public void addDoorsToRoom(int row, int column, Room room){
        String[] doors = new String[4];
        String cardinalDirection;
        if(row == 0 & column == 0 ){
                cardinalDirection ="E S";
                room.set2DRoomDisplay(new UpperLeftCornerRoom());
        }else if(row == 0 && column == dungeonColumn -1 ){
                cardinalDirection = "S W";
                room.set2DRoomDisplay(new UpperRightCorner());
        }else if(row == dungeonRow -1 && column == 0){
                cardinalDirection = "N E";
                room.set2DRoomDisplay(new LowerLeftCorner());
        }else if(row == dungeonRow -1 && column == dungeonColumn - 1){
                cardinalDirection = "N W";
                room.set2DRoomDisplay(new LowerRightCorner());
        }else if(row!=0 && row!=dungeonRow -1 && column == 0){
                cardinalDirection = "N S E";
                room.set2DRoomDisplay(new WestRoom());
        }else if(row != 0 && row != 4 && column == dungeonColumn - 1){
                cardinalDirection = "N S W";
                room.set2DRoomDisplay(new EastRoom());
        }else if(row == dungeonRow -1 && (column != 0 || column != dungeonColumn -1)){
                cardinalDirection = "N E W";
                room.set2DRoomDisplay(new SouthRoom());
        }else if(row == 0 && (column !=0 || column != dungeonColumn -1)){
                cardinalDirection = "S E W";
                room.set2DRoomDisplay(new NorthRoom());
        }else{
                cardinalDirection = "N S E W";
                room.set2DRoomDisplay(new FourDoorRoom());
        }
        doors = cardinalDirection.split(" ");
        room.setDoors(doors);
    }

    //displays entire contents of dungeon as well as the 2d representation of the room
    public String toString() {
        String dungeonString="\n-----------------------\nPrinting entire dungeon: \n";
        for(int i=0; i<dungeon.length; i++) {
            for(int j=0; j<dungeon[i].length; j++) {
                dungeonString+="\n-----------------------\n"
                                + "Room: ["+i+"]"+"["+j+"]"+"\n"+
                                dungeon[i][j]+"\n"+
                                dungeon[i][j].displayRoomContents()+
                                "\n-----------------------\n";		
            }
            dungeonString+="End of dungeon print.";
        }
        return dungeonString;
    }


    //gets location of the entrance
    public int[] getEntrance(){
        return this.entranceLocation;
    }

    //returns the entire dungeon
    public Room[][] getDungeon(){
        return this.dungeon;
    }

    //returns the location of the hero
    public int[] getHeroLocation(){
        return heroLocation;
    }

    //sets the heros location
    public void setHeroLocation(int[] heroLocation){
        if(heroLocation.length != 2 || heroLocation[0]<0 || heroLocation[0]>dungeonRow-1 ||
                        heroLocation[1]<0 || heroLocation[1]>dungeonColumn-1){
            throw new IllegalArgumentException("Location wrong");
        }
        this.heroLocation = heroLocation;	
    }

    //returns a room based on location put in
    public Room getRoom(int row, int column){
        if(row>dungeonRow || row<0 || column>dungeonColumn || column <0) {
            throw new IllegalArgumentException("Room does not exist");
        }
        return dungeon[row][column];
    }

    //gives a map of the dungeon based on room numbers and gives the heros location in the dungeon
    public void mapOfDungeon() {
        int i = 0;
        for (Room[] x : dungeon){ //
           int j=0;
           for (Room y : x){
                if(heroLocation[0]==i && heroLocation[1]==j) {
                    System.out.print("["+"You"+"]");
                }else {
                    System.out.print("["+i+","+j+"]");
                }
            j++;
           }
           i++;
           System.out.println();
        }
    }

}
