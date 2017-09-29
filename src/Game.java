
public class Game {
	
	public static void main(String[] args) {
		config config = new config();
		world world = new world(config);
		player player = new player(config);
		startGame(world, player);
	}
	
	private static void startGame(world world, player player) {
		System.out.println("GAME STARTED");
		//check every move if player's pos equals to an exit slot
		while(world.getSlotInWorld(player.getPos()).getClass().equals(new exit())) {
			
		}
	}

}
