
public class world {
	slot[][] slots;
	int xSize;
	int ySize;
	public world(int xSize, int ySize) {
		this.xSize = xSize;
		this.ySize = ySize;
		
		
		slots = new slot[this.xSize][this.ySize];
		System.out.println("WORLD GENERATED ("+this.xSize+"x"+this.ySize+")");
		
		
	}
	
	private void generateWorld() {
		for(int x = 0; x < this.xSize; x++) {
			for(int y = 0; y < this.ySize; y++) {
				
			}
		}
	}
	
	private slot getRandomSlot() {
		slot slot;
		return slot;
	}
}
