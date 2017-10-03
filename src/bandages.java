
public class bandages extends item{
	private int healAmount = 30;
	public bandages(){
		this.itemName = "bandages";
		this.isUsable = true;
		this.icon = 'B';
		this.usesLeft = 2;
	}
	public void use(world world, player player){
		if(player.getHealth() == 100){return;}
		player.heal(this.healAmount);
		
		this.usesLeft--;
		if(this.usesLeft == 0){
			player.deleteItemFromInventory((item) this);
		}
	}
}
