
public class pickaxe extends item{
	
	public pickaxe(){
		this.itemName = "pickaxe";
		this.icon = 'G';
		this.usesLeft = 3;
	}
	public void use(world world, player player){
		Vector2D playerAttemptedPos = player.attemptedPos;
		wall wallSlot = (wall)world.getSlotInWorld(playerAttemptedPos);
		
		System.out.println("Attempting to break wall in " + wallSlot.getPos().vectorInText());
		wallSlot.breakWall();
		
		this.usesLeft--;
		if(this.usesLeft == 0){
			player.deleteItemFromInventory((item) this);
		}
	}
}
