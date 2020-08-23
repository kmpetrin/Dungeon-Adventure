
							        *******To Run*******	
download the code and navigate to it's location on the command line.
cd src
javac *.java
java DungeonAdventure						
								*******Intro*******
Welcome to Dungeon Adventure!  
Dungeon Adventure is a text-based dungeon crawler game. Your objective is
to collect the four Pillars of OO.  You will face many obstacles on your journey
and will encounter various monsters within the dungeon.  Reach the exit with all
four pillars of OO and you win the game.

How to Play:
You can navigate your way through the dungeon by pressing 
'n','s', 'e', or 'w'.  You can view your location on the map that is displayed.
Your rucksack carries all the items and pillars you find.  To use an item or 
view your pillars open the rucksack.  Once all pillars have been found head for the exit
...if you can find it.

------------------------------------------------------------------------------------------------------------------------------------

								*******Settings*******

Dungeon Adventure randomly places you in a 5x5 dungeon.  The four pillars of OO, monsters, obstacles, collectibles, and exit are all randomly placed as well.
The settings can be altered to change the max number of collectibles and obstacles that can be found in each room.  Rooms can only contain a maximum of 1 monster.  
The chances of a room generating either a monster, obstacle, or collectible can be changed as well.  A 0% chance means no monsters, obstacles, or collectibles
will be generated. While 100% chance means these items and characters will be found in every room.  For chances between 0 and 100, while all items and characters 
have the same chance of being generated, that does not mean they will always all be present in the same room.  The probability of any given item or character appearing
in any given room is independent of all other items and characters. It should be noted that entrance rooms, the room you are randomly placed 
in at the start of the game, and exit rooms are always empty.  The size of the dungeon may also be changed.  It has a minimum size of 5x5 but may be changed to a 
larger size.
------------------------------------------------------------------------------------------------------------------------------------
							    *******About the Project*******	
				
This game was a final project for the class Design Patterns. The original code contained only the Battle class, 3 hero classes, and 3 monster classes.
The purpose was to refactor the code, reducing code smells, and implement various design patterns. This project contains over 80 classes and interfaces and implements 
various design patterns such as: strategy pattern, factory pattern, singleton, and more.


Cheat code to print entire dungeon: type ';' when the main menu is displayed. So anytime you see "1. Move 2. Open Rucksack 3. Quit" and press ';' 
it prints the entire dungeon. This cheat doesn't work during battle or when rucksack is open or when choosing a "move" option.


The uml broke up into 6 pages so some of the "has a" connections are broken. The pages are labeled as such and should be read in this order:
		 1a 1b
		 2a 2b
		 3a 3b

please see UML.pdf
------------------------------------------------------------------------------------------------------------------------------------
							       *******Output Example*******	

please see Output.pdf
