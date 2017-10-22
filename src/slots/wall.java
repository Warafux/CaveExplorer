package slots;
import game.player;
import game.slot;
import game.world;
import items.pickaxe;

public class wall extends slot{
	private boolean broken = false;
	public char brokenChar = '_';
	public wall() {
		this.icon = '#';
	}
	public char getIcon(){
		return this.broken ? this.brokenChar : this.icon;
	}
	public int hola = 2;
	
	@Override
	public void step(world world, player player) {
		//If the wall is broken just return
		if(this.broken){return;}
		
		//If not, check if player has a pickaxe and use it
		if(player.hasItemInInventory("pickaxe")){
			pickaxe pickaxe = (pickaxe) player.getItemFormInventory("pickaxe");
			pickaxe.use(world, player);
		}else{
			System.out.println("You can't go through this wall.");
			player.goBack();
		}
		
	}
	
	public void breakWall(){
		if(!this.broken){
			System.out.println("Breaking the wall!");
			this.broken = true;
		}else{
			
		}
	}
}
