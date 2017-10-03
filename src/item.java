
public class item implements Cloneable{
	char icon;
	String itemName = "";
	int usesLeft = -1;
	protected boolean isUsable;
	public item(){
		
	}
	public String getItemName(){
		return this.itemName;
	}
	public char getIcon(){
		return this.icon;
	}
	public void use(world world, player player){
		
	}
	public boolean getIsUsable(){
		return this.isUsable;
	}
	
	//CLONABLE

    @Override
    public item clone() {
    	item clone;
        try {
            clone = (item) super.clone();
        }
        catch (CloneNotSupportedException ex) {
            throw new RuntimeException("Error cloning item", ex);
        }

        return clone;
    }
}
