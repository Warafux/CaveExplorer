
public class pickaxe extends item{
	
	public pickaxe(){
		this.itemName = "pickaxe";
		this.isUsable = false;
		this.icon = 'G';
		this.usesLeft = 3;
	}
	public void use(world world, player player){
		Vector2D playerAttemptedPos = player.attemptedPos;
		
		//Make sure we're treating with a real wall
		if(!(world.getSlotInWorld(playerAttemptedPos) instanceof wall)){return;}
		
		wall wallSlot = (wall)world.getSlotInWorld(playerAttemptedPos);
		
		System.out.println("Attempting to break wall in " + wallSlot.getPos().vectorInText());
		wallSlot.breakWall();
		
		this.usesLeft--;
		if(this.usesLeft == 0){
			System.out.println("Oh, your pickaxe is broken...");
			player.deleteItemFromInventory((item) this);
		}
	}
}
