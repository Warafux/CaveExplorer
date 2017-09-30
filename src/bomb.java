
public class bomb extends slot{
	private final int DAMAGE = (int)Math.round(Math.random() * 25 + 25);
	
	private boolean bombDetonated = false;
	private char bombDetonatedChar = ',';
	public bomb() {
		this.icon = 'X';
		System.out.println(DAMAGE);
	}
	public char getIcon(){
		return this.bombDetonated ? this.bombDetonatedChar : this.icon;
	}
	
	public void step(player player){
		if(this.bombDetonated) {return;}
		this.bombDetonated = true;
		player.receiveDamage(this.DAMAGE);
	}
	
}
