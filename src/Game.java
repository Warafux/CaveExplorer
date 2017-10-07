import game.config;
import game.player;
import game.stats;
import game.world;
import utilities.Vector2D;
import utilities.scanner;

public class Game {
	
	public static void main(String[] args) {
		stats stats = new stats();
		config config = new config();
		world world = new world(config);
		player player = new player(config);
		System.out.println("");
		System.out.println("Welcome to CaveExplorer. Find the exit!");
		System.out.println("W - UP / A - LEFT / S - DOWN / D - RIGHT");
		System.out.println("H - HELP / I - INVENTORY / B - BANDAGES");
		System.out.println("");
		
		startGame(world, player, stats);

	}
	
	private static void startGame(world world, player player, stats stats) {
		System.out.println("GAME STARTED");
		
		//Put player on START position
		player.setPos(world.getSpawnPos());
		
		world.drawMapAround(player);

		//check every move if player's pos equals to an exit slot
		while(!world.getSlotInWorld(player.getPos()).getPos().equals(world.getExitPos()) && !player.isDead()) {
			//Move the player, check if movement can be done
			movePlayer(world, player, chooseNextAction(world, player), stats);

			//Calls for the slot step's function that the player is stepping
			world.getSlotInWorld(player.getPos()).step(world, player);
			
			//Draw again the map
			world.drawMapAround(player);
			//world.drawMap(player);
		}
		System.out.println("GAME ENDED");
	}
	private static Vector2D chooseNextAction(world world, player player){
		Vector2D chosenDirection;
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
			case 'b':
			case 'B':	
				player.useInventoryItem(world, player, "bandages");
				chosenDirection = chooseNextAction(world, player);
				break;
			case 'h':
			case 'H':
				displayHelp(world, player);
				chosenDirection = chooseNextAction(world, player);
				break;
			case 'r':
			case 'R':
				player.useInventoryItem(world, player, "binoculars");
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
	private static void displayHelp(world world, player player){
		double angleBetwenPlayerAndExit = Vector2D.angle(player.getPos(), world.getExitPos());
		double distanceBetweenPlayerAndExit = Vector2D.distance(player.getPos(), world.getExitPos());
		System.out.print("From your position, exit is located at: ");
		if(angleBetwenPlayerAndExit > 0 && angleBetwenPlayerAndExit < 90){
			System.out.print("top-left");
		}else if(angleBetwenPlayerAndExit == 90){
			System.out.print("top");
		}else if(angleBetwenPlayerAndExit > 90 && angleBetwenPlayerAndExit < 180){
			System.out.print("top-right");
		}else if(angleBetwenPlayerAndExit == 180){
			System.out.print("right");
		}else if(angleBetwenPlayerAndExit > 180 && angleBetwenPlayerAndExit < 270){
			System.out.print("bottom-right");
		}else if(angleBetwenPlayerAndExit == 270){
			System.out.print("bottom");
		}else if(angleBetwenPlayerAndExit > 270 && angleBetwenPlayerAndExit < 360){
			System.out.print("bottom-left");
		}
		System.out.println(" (" + (int)Math.floor(distanceBetweenPlayerAndExit) + " slots aprox)");
	}
}
