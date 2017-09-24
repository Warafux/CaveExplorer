import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;

public class config {
	//WORLD CONFIG
	public final int XSIZE = 10;
	public final int YSIZE = 30;
	
	public final int MAXFAILATTEMPTS = 100;
	public final int MINPATHDISTANCE = 89;
	public final int MAXPATHDISTANCE = 90;
	
	public static final double distanceBetweenSpawnExit = 3;
	
	List<SimpleEntry<slot, Integer>> availableSlots = new ArrayList<SimpleEntry<slot, Integer>>(
		Arrays.asList(
				new SimpleEntry<slot, Integer>(new wall(), 8),
				new SimpleEntry<slot, Integer>(new floor(), 0)
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
