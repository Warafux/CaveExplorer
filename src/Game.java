
public class Game {
	
	public static void main(String[] args) {
		stats stats = new stats();
		config config = new config();
		world world = new world(config);
		player player = new player(config);
		startGame(world, player, stats);
	}
	
	private static void startGame(world world, player player, stats stats) {
		System.out.println("GAME STARTED");
		
		//Put player on START position
		player.setPos(world.spawnPos);
		
		world.drawMap(player);

		//check every move if player's pos equals to an exit slot
		while(!world.getSlotInWorld(player.getPos()).getPos().equals(world.exitPos) && !player.isDead()) {
			//Move the player, check if movement can be done
			movePlayer(world, player, chooseNextAction(world, player), stats);

			//Calls for the slot step's function that the player is stepping
			world.getSlotInWorld(player.getPos()).step(world, player);
			
			//Draw again the map
			//world.drawMapAround(player, 3);
			world.drawMap(player);
		}
		System.out.println("EXIT OK!!!");
	}
	private static Vector2D chooseNextAction(world world, player player){
		Vector2D chosenDirection;
		//System.out.println("Choose a direction:");
		//System.out.println("W UP / A LEFT / S DOWN / D RIGHT");
		switch(scanner.requestControllerChar()){
			case 'w':
			case 'W':
				chosenDirection = new Vector2D(0, -1);
				break;
			case 'a':
			case 'A':
				chosenDirection = new Vector2D(-1, 0);
				break;
			case 's':
			case 'S':
				chosenDirection = new Vector2D(0, 1);
				break;
			case 'd':
			case 'D':
				chosenDirection = new Vector2D(1, 0);
				break;
			case 'i':
			case 'I':
				player.printInventory();
				chosenDirection = chooseNextAction(world, player);
				break;
			default:
				chosenDirection = new Vector2D(0, 0);
				break;
		}
		return chosenDirection;
	}
	private static void movePlayer(world world, player player, Vector2D direction, stats stats){
		Vector2D playerNewPos = player.getPos().add(direction);
		//Is the new pos valid?
		if(world.isValidPos(playerNewPos)){
			player.move(direction);
			stats.addStep();
		}else{
			System.out.println("You're trying to move out of bounds (HARDWALL)");
		}
	}
}
