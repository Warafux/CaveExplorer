import java.util.ArrayList;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;

public class config {
	public static final int XSIZE = 5;
	public static final int YSIZE = 5;
	
	List<SimpleEntry<slot, Integer>> availableSlots = new ArrayList<SimpleEntry<slot, Integer>>();
	
	public config() {
		this.availableSlots.add(new SimpleEntry<slot, Integer>(new wall(), 2));
		this.availableSlots.add(new SimpleEntry<slot, Integer>(new floor(), 20));
	}
	
}
