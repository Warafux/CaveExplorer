
public class floor extends slot{
	private boolean steppedOn = false;
	private char steppedChar = '@';
	public floor() {
		this.icon = ' ';
		
		
		this.steppedChar = this.icon;
	}
	public char getIcon(){
		return this.steppedOn ? this.steppedChar : this.icon;
	}
	public int hola = 2;
	
	public void step(player player){
		this.steppedOn = true;
		System.out.println("YEAH");
	}
	
}
