
public class item implements Cloneable{
	char icon;
	String itemName = "";
	int usesLeft = -1;
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
