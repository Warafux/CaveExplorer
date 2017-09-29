
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
	public void setPos(Vector2D position) {
		this.position = position;
	}
	
	public void step(player player) {
		
	}
	
	//CLONABLE

    @Override
    public slot clone() {
        slot clone;
        try {
            clone = (slot) super.clone();
        }
        catch (CloneNotSupportedException ex) {
            throw new RuntimeException("Error cloning slot", ex);
        }

        return clone;
    }
}
