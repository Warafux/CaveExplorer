package slots;
import game.item;
import game.player;
import game.slot;
import game.world;

public class floor extends slot{
	private boolean steppedOn = false;
	private char steppedChar = '@';
	private item itemHeld = null;
	public floor() {
		this.icon = ' ';
		
		
		this.steppedChar = this.icon;
	}
	public char getIcon(){
		return this.steppedOn ? this.steppedChar : (this.itemHeld == null ? this.icon : this.itemHeld.getIcon());
	}

	public void step(world world, player player){
		this.steppedOn = true;
		if(this.itemHeld != null){
			player.addInventory(itemHeld);
		}
		this.itemHeld = null;
	}
	public void setItemHeld(item item){
		this.itemHeld = item;
	}
}
