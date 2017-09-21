import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;

public class config {
	//WORLD CONFIG
	public static final int XSIZE = 5;
	public static final int YSIZE = 5;
	
	public static final double distanceBetweenSpawnExit = 3;
	
	List<SimpleEntry<slot, Integer>> availableSlots = new ArrayList<SimpleEntry<slot, Integer>>(
		Arrays.asList(
				new SimpleEntry<slot, Integer>(new wall(), 2),
				new SimpleEntry<slot, Integer>(new floor(), 20)
				)
		);
	
	//PLAYER CONFIG
	public String playerName;
	public config() {
		//WORLD CONFIG
		
		//PLAYER CONFIG
		this.playerName = "undefined";
	}
	
}
