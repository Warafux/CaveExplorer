
public class slot implements Cloneable{
	Vector2D position;
	char icon;
	public slot() {
			
	}
	public slot(int xPos, int yPos) {
		this.position = new Vector2D(xPos, yPos);
	}
	public Vector2D getPos(){
		return this.position;
	}
	public char getIcon(){
		return this.icon;
	}
	public void setPos(int xPos, int yPos) {
		this.position = new Vector2D(xPos, yPos);
	}
	public void setPos(Vector2D position) {
		this.position = position;
	}
	
	public void step(world world, player player){
		
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
