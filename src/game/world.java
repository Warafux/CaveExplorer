package game;
import slots.exit;
import slots.floor;
import slots.path;
import slots.spawn;
import utilities.Vector2D;
import utilities.weightRandomAlgorithm;

public class world {
	config config;
	slot[][] slots;
	int xSize;
	int ySize;
	private Vector2D spawnPos;
	private Vector2D exitPos;
	private int radiusVisibility;
	public world(config config) {
		this.config = config;
		this.xSize = config.XSIZE;
		this.ySize = config.YSIZE;
		this.radiusVisibility = config.RADIUSVISIBILITY;
		
		slots = new slot[this.xSize][this.ySize];
		System.out.println("WORLD GENERATED ("+this.xSize+"x"+this.ySize+") Filling...");

		boolean isWorldGeneratedCorrectly = generateNewWorld();
		while(!isWorldGeneratedCorrectly){
			//Generator failed, try again
			isWorldGeneratedCorrectly = generateNewWorld();
		}

	}

	private boolean generateNewWorld() {
		clearWorld();//clear world
		//SET SPAWN
		setSpawnPos(getRandomPos());
		
		setSlot(new spawn(), getSpawnPos());
		Vector2D lastPos = getSpawnPos();
		
		//CREATE PATH
		//String path = "";
		int failAttempts = 0;//If x errors, quit and restart
		Vector2D lastDirection = getRandomDirection();//-1,0left / 1,0 right / 0,1 up / 0,-1 down
		
		for(int i = 0; i < (this.config.MINPATHDISTANCE +(int)(Math.random() * this.config.MAXPATHDISTANCE)); i++) {
			//Get a next direction and a next pos (nextpos = last pos + next direction)
			Vector2D nextDirection = getRandomDirection();
			Vector2D nextPos = lastPos.add(nextDirection);
			
			while(nextDirection.equals(lastDirection) || !this.isValidPos(nextPos) || !this.isPosNull(nextPos)) {
				//Check if it's possible to place something in the next position
				failAttempts++;//if not add a failure
				if(failAttempts >= this.config.MAXFAILATTEMPTS){
					return false;
					//If too many fails, return a false
				}
				//Get another direction and re-calculate the next pos
				nextDirection = getRandomDirection();
				nextPos = lastPos.add(nextDirection);
			}
			lastPos = nextPos;
			lastDirection = nextDirection;
			//Save last pos and direction
			
			//Set the slot
			setSlot(new path(), lastPos);
			
			//Path tracker
			//path += lastPos.vectorInText();
		}

		//SET EXIT
		
		Vector2D nextDirection = getRandomDirection();
		Vector2D possibleExitPos = lastPos.add(nextDirection);
		
		while(nextDirection.equals(lastDirection) || !this.isValidPos(possibleExitPos) || !this.isPosNull(possibleExitPos)) {
			//Check if it's possible to place something in the next position
			failAttempts++;//if not add a failure
			if(failAttempts >= this.config.MAXFAILATTEMPTS){
				return false;
				//If too many fails, return a false
			}
			//Get another direction and re-calculate the next pos
			nextDirection = getRandomDirection();
			possibleExitPos = lastPos.add(nextDirection);
		}

		setExitPos(lastPos.add(nextDirection));

		//Set the slot
		setSlot(new path(), lastPos);
		
		//Path tracker
		//path += lastPos.vectorInText();
		
		setSlot(new exit(), possibleExitPos);
		
		//Fill map with random slots
		for(int y = 0; y < this.ySize; y++) {	
			for(int x = 0; x < this.xSize; x++) {
				if(this.slots[x][y] == null) {
					this.setSlot(this.getRandomSlot().clone(), new Vector2D(x, y));
				}
			}
		}
		
		spreadItems();
		return true;
	}
	private void spreadItems(){
		//Sets random items to each floor slot
		if(!isMapGenerated()){return;}
		for(int y = 0; y < this.ySize; y++) {
			for(int x = 0; x < this.xSize; x++) {
				//Is floor?
				if(this.slots[x][y] instanceof floor){
					floor floorSlot = (floor)this.slots[x][y];
					item randomItem = this.getRandomItem();
					floorSlot.setItemHeld(randomItem == null ? null : randomItem.clone());
				}
			}
		}
	}
	private void clearWorld(){
		slots = new slot[this.xSize][this.ySize];
	}
	public boolean isValidPos(Vector2D pos){
		return (pos.getX() < this.xSize && pos.getX() >= 0) && (pos.getY() < this.ySize && pos.getY() >= 0);
	}
	private boolean isPosNull(Vector2D pos){
		return this.slots[pos.getX()][pos.getY()] == null;
	}
	public slot getSlotInWorld(Vector2D pos){
		return this.slots[pos.getX()][pos.getY()];
	}
	private Vector2D getRandomDirection(){
		Vector2D ret = new Vector2D(-1, 0);
		switch(1 + (int)(Math.random() * ((4 - 1) + 1))){
		case 1:
			ret = new Vector2D(1, 0);
			break;
		case 2:
			ret = new Vector2D(0, -1);
			break;
		case 3:
			ret = new Vector2D(0, 1);
			break;
		default:
			break;
		}
		return ret;
	}
	private Vector2D getRandomPos() {
		return new Vector2D((int)(Math.random() * this.xSize), (int)(Math.random() * this.ySize));
	}
	private item getRandomItem() {
		return weightRandomAlgorithm.chooseItem(this.config.availableItems);
	}
	private slot getRandomSlot() {
		return weightRandomAlgorithm.chooseSlot(this.config.availableSlots);
	}
	public slot[][] getSlots(){
		return this.slots;
	}
	private boolean isMapGenerated(){
		for(int y = 0; y < this.ySize; y++) {	
			for(int x = 0; x < this.xSize; x++) {	
				//Is there a value not belonging to slot class?
				if(!(this.slots[x][y] instanceof slot)){
					return false;
				}
			}
		}
		return true;
	}
	public void drawMap(){
		//Draw only the map without even a radius
		if(!isMapGenerated()){return;}
			for(int y = 0; y < this.ySize; y++) {
				for(int x = 0; x < this.xSize; x++) {	
					System.out.print(this.slots[x][y].getIcon());	
			}
			System.out.println("");
		}
	}
	public void drawMap(player player){
		//Draw map with player on it
		if(!isMapGenerated()){return;}
		Vector2D playerPos = player.getPos();
			for(int y = 0; y < this.ySize; y++) {
				for(int x = 0; x < this.xSize; x++) {	
				if(!playerPos.equals(new Vector2D(x, y))){
					System.out.print(this.slots[x][y].getIcon());
				}else{
					System.out.print(player.getIcon());
				}
				
			}
			System.out.println("");
		}
		
	}
	public void drawMapAround(player player){
		//Draw map with radius visibility
		if(!isMapGenerated()){return;}
		Vector2D playerPos = player.getPos();
		
		for(int i = 0; i < 20; i++){
			System.out.println("");
		}

		for(int y = 0; y < this.ySize; y++) {
			//If the row is empty, track it, to avoid println
			boolean emptyRow = true;
			for(int x = 0; x < this.xSize; x++) {
				
				Vector2D actualPos = new Vector2D(x, y);//Actual loop pos
				
				//Check distance between playerPos and actualPos
				if(Vector2D.distance(playerPos, actualPos) < this.radiusVisibility){
					//Is the actualPos where the player is located?
					if(!playerPos.equals(actualPos)){
						System.out.print(this.slots[x][y].getIcon());//Print slot icon
					}else{
						System.out.print(player.getIcon());//Print player icon
					}
					emptyRow = false;
				}
			}
			if(!emptyRow){
				System.out.println("");//If the last row was NOT empty, print a \n
			}
		}
		
	}
	private void setSlot(slot slot, Vector2D position) {
		this.slots[position.getX()][position.getY()] = slot;
		slot.setPos(position);
	}

	public Vector2D getSpawnPos() {
		return spawnPos;
	}

	public void setSpawnPos(Vector2D spawnPos) {
		this.spawnPos = spawnPos;
	}

	public Vector2D getExitPos() {
		return exitPos;
	}

	public void setExitPos(Vector2D exitPos) {
		this.exitPos = exitPos;
	}
	public void addRadiusVisibility(int amount){
		this.radiusVisibility += amount;
		System.out.println("World visibility radius has increased by " + amount + ". Now you're able to see " + this.radiusVisibility + " slots around you!");
	}
}
