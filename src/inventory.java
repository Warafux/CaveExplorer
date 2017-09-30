import java.util.ArrayList;

public class inventory {
	ArrayList<item> items = new ArrayList<item>();
	
	public void addItem(item item) {
		this.items.add(item);
	}
	public void removeItem(int inventoryIndex){
		this.items.remove(inventoryIndex);
	}
}
