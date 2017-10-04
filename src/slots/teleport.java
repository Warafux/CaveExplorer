package slots;
import java.util.ArrayList;

import game.item;
import game.player;
import game.slot;
import game.world;

public class teleport extends slot{

	public teleport() {
		this.icon = '@';
	}
	public char getIcon(){
		return this.icon;
	}

	public void step(world world, player player){
		
	}
	public ArrayList<teleport> getTeleportSlotsInWorld(world world) {
		ArrayList<teleport> teleportsInWorld = new ArrayList<teleport>();
		return teleportsInWorld;
	}
}
