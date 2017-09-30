
public class Game {
	
	public static void main(String[] args) {
		config config = new config();
		world world = new world(config);
		player player = new player(config);
		startGame(world, player);
	}
	
	private static void startGame(world world, player player) {
		System.out.println("GAME STARTED");
		
		//Put player on START position
		player.setPos(world.spawnPos);
		
		System.out.println("your pos: "+player.getPos().vectorInText());
		
		//check every move if player's pos equals to an exit slot
		while(!world.getSlotInWorld(player.getPos()).getPos().equals(world.exitPos) && !player.isDead()) {
			//Move the player, check if movement can be done
			movePlayer(world, player, chooseDirection());
			
			//Calls for the slot step's function that the player is stepping
			world.getSlotInWorld(player.getPos()).step(player);
			
			//Draw again the map
			world.drawMapAround(player, 3);
		}
		System.out.println("EXIT OK!!!");
	}
	private static Vector2D chooseDirection(){
		Vector2D chosenDirection;
		//System.out.println("Choose a direction:");
		//System.out.println("W UP / A LEFT / S DOWN / D RIGHT");
		switch(scanner.requestWASDChar()){
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
			default:
				chosenDirection = new Vector2D(0, 0);
				break;
		}
		return chosenDirection;
	}
	private static void movePlayer(world world, player player, Vector2D direction){
		Vector2D playerNewPos = player.getPos().add(direction);
		//Is the new pos valid?
		if(world.isValidPos(playerNewPos)){
			player.move(direction);
		}else{
			System.out.println("You're trying to move out of bounds (HARDWALL)");
		}
	}
}
