
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
	public int hola = 2;
	
	public void step(player player){
		this.steppedOn = true;
		if(this.itemHeld != null){
			player.addInventory(itemHeld);
		}
		this.itemHeld = null;
		System.out.println("YEAH");
	}
	public void setItemHeld(item item){
		this.itemHeld = item;
	}
}
