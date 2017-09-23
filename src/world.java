
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
		generateNewWorld();
		//System.out.println(isMapGenerated());  TRUE
		
		//HAS TO CHECK WHETHER THE MAP HAS A SOLUTION OR NOT
		////NOT
		////IMPLEMENTED YET
		////////////////////////
		drawMap();
	}
	
	private void generateNewWorld() {
		//SET SPAWN
		Vector2D spawnPos = getRandomPos();
		setSlot(new spawn(), spawnPos);
		
		//CREATE PATH
		Vector2D lastDirection = new Vector2D(0, 1);//-1,0left / 1,0 right / 0,1 up / 0,-1 down
		for(int i = 0; i < (this.config.MINPATHDISTANCE +(int)(Math.random() * this.config.MAXPATHDISTANCE)); i++) {
			Vector2D nextDirection = new Vector2D((int)Math.round(Math.random()), (int)Math.round(Math.random()));
			while(nextDirection == lastDirection) {
				nextDirection = (int)(Math.random() * 4) + 1;
			}
			
		}

		//SET EXIT
		Vector2D possibleExitPos = getRandomPos();
		while(Vector2D.distance(spawnPos, possibleExitPos) < this.config.distanceBetweenSpawnExit) {
			possibleExitPos = getRandomPos();
		}
		System.out.println(Vector2D.distance(spawnPos, possibleExitPos));
		setSlot(new exit(), possibleExitPos);
		
		
		for(int y = 0; y < this.ySize; y++) {	
			for(int x = 0; x < this.xSize; x++) {
				if(this.slots[x][y] == null) {
					this.setSlot(getRandomSlot(), new Vector2D(x, y));
				}
			}
		}
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
		
		for(int y = 0; y < this.ySize; y++) {
			
			for(int x = 0; x < this.xSize; x++) {	
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
