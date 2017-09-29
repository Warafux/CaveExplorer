
public class player {
	public String playerName = "";
	
	private Vector2D lastPos;
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
	public void setPos(Vector2D newPos){
		if(this.playerPos != null){this.lastPos = this.playerPos;}
		this.playerPos = newPos;
	}
	public void move(Vector2D direction){
		if(this.playerPos != null){this.lastPos = this.playerPos;}
		this.playerPos = this.playerPos.add(direction);
	}
	public void goBack(){
		if(this.playerPos != null){
			this.playerPos = this.lastPos;
		}
	}
}
