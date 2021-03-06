package game;
import utilities.Vector2D;
import utilities.scanner;

public class player {
	private String playerName = "";
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
		this.setPlayerName(scanner.requestString());
		System.out.println("Your new player name is: " + this.getPlayerName());
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
	public int getHealth(){
		return this.playerHealth;
	}
	public void die() {
		this.playerHealth = 0;
		this.isDead = true;
		System.out.println("YOU DIED");
	}
	public void heal(int healAmount){
		if(healAmount + this.playerHealth >= 100){
			this.playerHealth = 100;
			System.out.println("You've been healed up to 100hp");
		}else{
			this.playerHealth += healAmount;
			System.out.println("You've recovered " + healAmount + ". (" + this.playerHealth + "hp)");
		}
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
		System.out.println("You've received " + damageAmount + " of DAMAGE. (" + this.playerHealth + "hp)");
	}
	public void useInventoryItem(world world, player player, String itemName){
		for(item invItem : this.inventory.items){
			if(itemName == invItem.getItemName() && invItem.getIsUsable()){
				invItem.use(world, player);
				return;
			}
		}
		System.out.println("Item not available.");
		return;
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
	public void printInventory(){
		System.out.println("Printing inventory: " + this.inventory.items.size() + " item" + (this.inventory.items.size() == 1 ? "" : "s"));
		for(item invItem : this.inventory.items){
			System.out.println(invItem.getItemName() + " - " + invItem.usesLeft + " use" + (invItem.usesLeft == 1 ? "" : "s") + " left");
		}
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
}
