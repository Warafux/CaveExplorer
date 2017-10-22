package utilities;
import java.util.AbstractMap.SimpleEntry;

import game.item;
import game.slot;
import slots.wall;

import java.util.ArrayList;
import java.util.List;
//WEIGHTED RANDOM SHUFFLING ALGORITHM
// https://www.youtube.com/watch?v=ETphJASzYes
public class weightRandomAlgorithm {
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
	public static item chooseItem(List<SimpleEntry<item, Integer>> list){
		int totalWeight = 0;
		
		for(SimpleEntry<item, Integer> row : list){
			totalWeight += row.getValue();
		}
		
		int randomNumber = (int)(totalWeight * Math.random()) + 1;
		for(SimpleEntry<item, Integer> row : list){
			randomNumber -= row.getValue();
			if(randomNumber <= 0){
				return row.getKey();
			}
		}
		
		//Return last item (less weighted)
		return list.get(list.size() - 1).getKey();
	}
}
