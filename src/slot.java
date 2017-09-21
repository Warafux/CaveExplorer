
public class slot implements Cloneable{
	Vector2D position;
	char icon;
	public slot() {
			
	}
	public slot(int xPos, int yPos) {
		this.position = new Vector2D(xPos, yPos);
		System.out.println("SLOT GENERATED ("+xPos+"x"+yPos+")");
	}
	
	public void setPos(int xPos, int yPos) {
		this.position = new Vector2D(xPos, yPos);
	}
	
	//CLONABLE
	@Override
	protected Object clone() throws CloneNotSupportedException {
	    return this.clone();
	}
}
