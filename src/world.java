
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
		for(int y = 0; y < this.ySize; y++) {	
			for(int x = 0; x < this.xSize; x++) {
				this.slots[x][y] = getRandomSlot();
				this.slots[x][y].setPos(x, y);
			}
		}
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
}
