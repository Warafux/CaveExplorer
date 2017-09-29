
public class wall extends slot{
	public wall() {
		this.icon = '#';
	}

	public int hola = 2;
	
	public void step(player player) {
		System.out.println("This is a wall, go back...");
		player.goBack();
	}
	
}
