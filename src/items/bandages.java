package items;
import game.item;
import game.player;
import game.world;

public class bandages extends item{
	private int healAmount = 30;
	public bandages(){
		this.itemName = "bandages";
		this.isUsable = true;
		this.icon = 'B';
		this.usesLeft = 2;
	}
	public void use(world world, player player){
		if(player.getHealth() == 100){
			System.out.println("You're already full HP.");
			return;
			}
		player.heal(this.healAmount);
		
		this.usesLeft--;
		if(this.usesLeft == 0){
			player.deleteItemFromInventory((item) this);
		}
	}
}
