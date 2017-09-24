
public class world {
	config config;
	slot[][] slots;
	int xSize;
	int ySize;
	public world(config config) {
		this.config = config;
		this.xSize = config.XSIZE;
		this.ySize = config.YSIZE;

		slots = new slot[this.xSize][this.ySize];
		System.out.println("WORLD GENERATED ("+this.xSize+"x"+this.ySize+")");
		System.out.println("Generating new slot map");
		
		//System.out.println(isMapGenerated());  FALSE
		boolean isWorldGeneratedCorrectly = generateNewWorld();
		while(!isWorldGeneratedCorrectly){
			//System.out.println("World map generator failed, trying again...");
			isWorldGeneratedCorrectly = generateNewWorld();
		}
		//System.out.println(isMapGenerated());  TRUE
		
		//HAS TO CHECK WHETHER THE MAP HAS A SOLUTION OR NOT
		////NOT
		////IMPLEMENTED YET
		////////////////////////
		drawMap();
	}
	
	private boolean generateNewWorld() {
		clearWorld();
		//SET SPAWN
		Vector2D spawnPos = getRandomPos();
		setSlot(new spawn(), spawnPos);
		Vector2D lastPos = spawnPos;
		
		//CREATE PATH
		String path = "";
		int failAttempts = 0;
		Vector2D lastDirection = getRandomDirection();//-1,0left / 1,0 right / 0,1 up / 0,-1 down
		for(int i = 0; i < (this.config.MINPATHDISTANCE +(int)(Math.random() * this.config.MAXPATHDISTANCE)); i++) {
			Vector2D nextDirection = getRandomDirection();
			Vector2D nextPos = lastPos.add(nextDirection);
			//System.out.println("ATTEMPTING TO PLACE IN " + nextPos.vectorInText());
			while(nextDirection.equals(lastDirection) || !this.isValidPos(nextPos) || !this.isPosNull(nextPos)) {
				failAttempts++;
				if(failAttempts >= this.config.MAXFAILATTEMPTS){
					return false;
				}
				//System.out.println("FAILED");
				nextDirection = getRandomDirection();
				nextPos = lastPos.add(nextDirection);
				//System.out.println("NEW POS " + nextPos.vectorInText());
			}
			//System.out.println("SUCCESS!!!!!! PLACING");
			lastPos = lastPos.add(nextDirection);
			lastDirection = nextDirection;
			setSlot(new path(), lastPos);
			//System.out.println("PLACED");
			
			path += lastPos.vectorInText();
		}

		//SET EXIT
		Vector2D possibleExitPos = getRandomPos();
		setSlot(new exit(), possibleExitPos);
		

		for(int y = 0; y < this.ySize; y++) {	
			for(int x = 0; x < this.xSize; x++) {
				if(this.slots[x][y] == null) {
					
					this.setSlot(getRandomSlot(), new Vector2D(x, y));
				}
			}
		}
		
		System.out.println(path);
		return true;
	}
	private void clearWorld(){
		slots = new slot[this.xSize][this.ySize];
	}
	private boolean isValidPos(Vector2D pos){
		return (pos.getX() < this.xSize && pos.getX() >= 0) && (pos.getY() < this.ySize && pos.getY() >= 0);
	}
	private boolean isPosNull(Vector2D pos){
		return this.slots[pos.getX()][pos.getY()] == null;
	}
	private slot getSlotInWorld(Vector2D pos){
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
	private slot getRandomSlot() {
		return weightRandomAlgorithm.chooseSlot(this.config.availableSlots);
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
	private void drawMap(){
		if(!isMapGenerated()){return;}
		
		for(int x = 0; x < this.xSize; x++) {	
			for(int y = 0; y < this.ySize; y++) {
				System.out.print(this.slots[x][y].icon);
			}
			System.out.println("");
		}
		
	}
	private void setSlot(slot slot, Vector2D position) {
		this.slots[position.getX()][position.getY()] = slot;
		slot.setPos(position);
	}
}
