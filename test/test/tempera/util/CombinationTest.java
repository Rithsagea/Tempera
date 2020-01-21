package test.tempera.util;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;
import tempera.util.ListUtil;

public class CombinationTest {
	public static void main(String[] args) {
		List<Integer> values = new ArrayList<Integer>();
		
		for(int x = 0; x < 10; x++) {
			values.add(x);
		}
		
		for(Pair pair : ListUtil.getPairs(values)) {
			System.out.println(pair.getKey() + ": " + pair.getValue());
		}
	}
}
