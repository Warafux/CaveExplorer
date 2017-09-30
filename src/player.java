
public class player {
	public String playerName = "";
	private int playerHealth;
	private boolean isDead = false;
	char icon = 'p';
	private Vector2D lastPos;
	public Vector2D playerPos;
	
	public player(config config) {
		this.choosePlayerName();
		this.playerHealth = config.PLAYERHEALTH;
	}
	public void choosePlayerName() {
		System.out.println("Choose your player name:");
		this.playerName = scanner.requestString();
		System.out.println("Your new player name is: " + this.playerName);
	}
	public Vector2D getPos() {
		return this.playerPos;
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
	public char getIcon(){
		return this.icon;
	}
	public void die() {
		this.playerHealth = 0;
		this.isDead = true;
		System.out.println("YOU DIED");
	}
	public boolean isDead() {
		return this.isDead;
	}
	public void receiveDamage(int damageAmount) {
		if(damageAmount >= this.playerHealth) {
			this.die();
			return;
		}
		
		this.playerHealth -= damageAmount;
		System.out.println("YOU RECEIVED " + damageAmount + " of DAMAGE");
	}
}
