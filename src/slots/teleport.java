package slots;
import java.util.ArrayList;

import game.item;
import game.player;
import game.slot;
import game.world;

public class teleport extends slot{
	private boolean isUsed = false;
	private char isUsedIcon = 'X';
	
	public teleport() {
		this.icon = '@';
	}
	public char getIcon(){
		return this.isUsed ? this.isUsedIcon : this.icon;
	}

	public void step(world world, player player){
		if(this.isUsed){return;}
		ArrayList<teleport> teleportSlotsInWorld = getTeleportSlotsInWorld(world);
		teleport teleportTargetSlot = teleportSlotsInWorld.get((int)(Math.random() * teleportSlotsInWorld.size()));
		player.setPos(teleportTargetSlot.getPos());
		System.out.println(player.getPlayerName() + " teleported to " + teleportTargetSlot.getPos().vectorInText());
		this.isUsed = true;
	}
	public ArrayList<teleport> getTeleportSlotsInWorld(world world) {
		ArrayList<teleport> teleportsInWorld = new ArrayList<teleport>();
		slot[][] slots = world.getSlots();
		for(slot[] slotRow : slots) {
			for(slot slot : slotRow) {
				if(slot instanceof teleport) {
					teleportsInWorld.add((teleport)slot);
				}
			}
		}
		return teleportsInWorld;
	}
}
