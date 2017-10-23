# CaveExplorer
CaveExplorer is a console-game based which is made in Java. You're lost in a cave, with low visibility of your surround and you must find the exit.

## How to play
You can move with W,A,S,D to find new things like items, teleportation tiles, bombs and of course walls that will difficult even more your job.
### Items
Items can be seen by pressing I. Some items have uses left. If you consume them and uses left are 0 they will be removed from your inventory.
There are some items that can be used via keyboard shortcut, these are:

| Item | Shortcut | Description |
| --- | --- | --- |
| Binoculars | R | They give you more vision of your surroundings |
| Bandages | B | This item will restore 30hp on the player |
| Pickaxe | NONE | This specific item will allow you to break through walls and get through them |

### Map
Map will show your position and your surrounding. Everything has it's own character and this is the actual configuration:

| Char | Name | Description | Link to file |
| --- | --- | --- | --- |
| X | BOMB | If a player steps on it, this will be hurt by a random amount of damage. | [bomb.java](src/slots/bomb.java) |
| # | WALL | A wall which the player can get through, breakable with a pickaxe. | [wall.java](src/slots/wall.java) |
| @ | TELEPORT | This will teleport a player to another teleport point of the map. | [teleport.java](src/slots/teleport.java) |
| O | SPAWN | Where the player spawned by the first time, initial position. | [spawn.java](src/slots/spawn.java) |
| NONE | PATH | This is not shown to the player, but it's used for the algorithm that builds the path. | [path.java](src/slots/path.java) |
| NONE | FLOOR | Regular tile, which player can step. There's a chance that the floor helds an item. | [floor.java](src/slots/floor.java) |
| S | EXIT | Exit tile. | [src/slots/exit.java](src/slots/exit.java) |

### Execution

You need Java in order to execute the main file.
All you have to do in order to execute it is to open the console (windows or linux):

Move into the repo
```sh
cd CaveExplorer/
```
Execute the file
```sh
java -jar CaveExplorer.jar
```
