
public class Game {
	
	public static void main(String[] args) {
		System.out.println("GAME STARTED");
		config config = new config();
		world world = new world(config);
		player player = new player(config);
	}
	
	private void startGame(world world, player player) {

	}

}
