package tempera.util;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;

public class ListUtil {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<Pair<?, ?>> getPairs(List<?> list) {
		List<Pair<?, ?>> pairs = new ArrayList<>();
		
		for(int x = 0; x < list.size(); x++) {
			for(int y = x + 1; y < list.size(); y++) {
				pairs.add(new Pair(list.get(x), list.get(y)));
			}
		}
		
		return pairs;
	}
	
	/**
	 * Gets all combinations of a list
	 * @param list
	 * @param combinationSize
	 * @return
	 */
	public static List<List<Object>> getCombinations(List<?> list, int combinationSize) {
		if(list.size() < combinationSize) return null;
		
		Object[] objects = list.toArray();
		
		for(Object object : objects) {
			System.out.println(object);
		}
		
		return null;
		
	}
}
