
public class player {
	public String playerName = "";
	public Vector2D playerPos;
	public player(config config) {
		this.choosePlayerName();
	}
	public void choosePlayerName() {
		System.out.println("Choose your player name:");
		this.playerName = scanner.requestString();
		System.out.println("Your new player name is: " + this.playerName);
	}
	public Vector2D getPos() {
		return playerPos;
	}
}
