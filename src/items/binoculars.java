package items;
import game.item;
import game.player;
import game.world;

public class binoculars extends item{
	private int visibilityExtraRange = 2;
	public binoculars(){
		this.itemName = "binoculars";
		this.isUsable = true;
		this.icon = 'R';
		this.usesLeft = 1;
	}
	public void use(world world, player player){
		world.addRadiusVisibility(this.visibilityExtraRange);
	}
}
