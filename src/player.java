
public class player {
	public String playerName = "";
	private int playerHealth;
	private boolean isDead = false;
	char icon = 'p';
	
	private Vector2D lastPos;
	public Vector2D playerPos;
	public Vector2D attemptedPos;
	
	private inventory inventory = new inventory();
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
	public Vector2D getLastPos() {
		return this.lastPos;
	}
	public void setPos(Vector2D newPos){
		if(this.playerPos != null){this.lastPos = this.playerPos;}
		this.playerPos = newPos;
	}
	public void move(Vector2D direction){
		if(this.playerPos != null){this.lastPos = this.playerPos;}
		this.playerPos = this.playerPos.add(direction);//Pos that player is attemptint to step (will be modified out of this function too)
		this.attemptedPos = this.playerPos;//Pos that player is attempting to step(only modified every time a step is attempted)
		
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
	public void addInventory(item item) {
		this.inventory.addItem(item);
		System.out.println(item.getItemName() + " has been added to your inventory.");
	}
	public boolean hasItemInInventory(String itemName){
		for(item invItem : this.inventory.items){
			if(itemName == invItem.getItemName()){
				return true;
			}
		}
		return false;
	}
	public item getItemFormInventory(String itemName){
		for(item invItem : this.inventory.items){
			if(itemName == invItem.getItemName()){
				return invItem;
			}
		}
		return null;
	}
	public void deleteItemFromInventory(item item){
		int index = 0;
		for(item invItem : this.inventory.items){
			if(item.equals(invItem)){
				this.inventory.removeItem(index);
				return;
			}
			index++;
		}
	}
}
