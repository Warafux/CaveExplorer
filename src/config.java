import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;

public class config {
	//Default player config
	public final int PLAYERHEALTH = 100;
	
	//WORLD CONFIG
	public final int XSIZE = 10;
	public final int YSIZE = 30;
	
	//WORLD GENERATOR CONFIG
	public final int MAXFAILATTEMPTS = 100;
	public final int MINPATHDISTANCE = 80;
	public final int MAXPATHDISTANCE = 100;
	
	//Available slots when filling world
	List<SimpleEntry<slot, Integer>> availableSlots = new ArrayList<SimpleEntry<slot, Integer>>(
		Arrays.asList(
				new SimpleEntry<slot, Integer>(new wall(), 12),
				new SimpleEntry<slot, Integer>(new floor(), 7),
				new SimpleEntry<slot, Integer>(new bomb(), 1)
				)
		);
	
	//PLAYER CONFIG
	public config() {
		//WORLD CONFIG

	}
	
}
