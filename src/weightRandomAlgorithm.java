import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
//WEIGHTED RANDOM SHUFFLING ALGORITHM
// https://www.youtube.com/watch?v=ETphJASzYes
public class weightRandomAlgorithm {
	public static void main(String[] args) {
		//SOME TESTING OF THE ALGORITHM
		List<SimpleEntry<slot, Integer>> list = new ArrayList<SimpleEntry<slot, Integer>>();
		list.add(new SimpleEntry<slot, Integer>(new wall(), 2));
		list.add(new SimpleEntry<slot, Integer>(new floor(), 8));
		
		System.out.println(chooseSlot(list).getClass());
		System.out.println(chooseSlot(list).getClass());
		System.out.println(chooseSlot(list).getClass());
		System.out.println(chooseSlot(list).getClass());
		System.out.println(chooseSlot(list).getClass());
		System.out.println(chooseSlot(list).getClass());
		System.out.println(chooseSlot(list).getClass());
	}
	public static slot chooseSlot(List<SimpleEntry<slot, Integer>> list){
		if(list.size() == 0){return new wall();}
		if(list.size() == 1){return list.get(0).getKey();}
		int totalWeight = 0;
		
		for(SimpleEntry<slot, Integer> row : list){
			totalWeight += row.getValue();
		}
		
		int randomNumber = (int)(totalWeight * Math.random()) + 1;
		for(SimpleEntry<slot, Integer> row : list){
			randomNumber -= row.getValue();
			if(randomNumber <= 0){
				return row.getKey();
			}
		}
		
		//Return last item (less weighted)
		return list.get(list.size() - 1).getKey();
	}
}
