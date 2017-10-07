package slots;
import game.player;
import game.slot;
import game.world;

public class bomb extends slot{
	private final int DAMAGE = (int)Math.round(Math.random() * 25 + 25);//Random for every game (not for individual bomb)
	
	private boolean bombDetonated = false;
	private char bombDetonatedChar = ',';
	public bomb() {
		this.icon = 'X';
	}
	public char getIcon(){
		return this.bombDetonated ? this.bombDetonatedChar : this.icon;
	}
	
	public void step(world world, player player){
		if(this.bombDetonated) {return;}
		this.bombDetonated = true;
		player.receiveDamage(this.DAMAGE);
	}
	
}
