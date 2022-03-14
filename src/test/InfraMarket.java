package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InfraMarket {
	
	public static void main(String[] args) {
		
		String input = "abcdabcd";
		InfraMarket infraMarket = new InfraMarket();
		
		Map<Character, Integer> countMap = new HashMap<Character, Integer>();
		
		boolean isLowerCaseString = infraMarket.checkIfLowerCase(input);
		
		if (isLowerCaseString) {
			infraMarket.printMessage(false);
			return;
		}
		
		int minFreq = infraMarket.getMinCount(countMap);
		
		infraMarket.populateMap(input, countMap);
		
		System.out.println(countMap);
		
		
		
	}

	private void populateMap(final String input, final Map<Character, Integer> countMap) {

		for (char ch : input.toCharArray()) {
			countMap.compute(ch, (key, val) -> val == null ? 1 : ++val);
		}
		
	}
	
	private int getMinCount(final Map<Character, Integer> countMap) {
		
		List<Integer> valueSet = (List<Integer>) countMap.values();
		Collections.sort(valueSet);
		
		return valueSet.get(0);
		
	}
	
	private List<Integer> populateCountDiff(final Map<Character, Integer> countMap, int minFreq) {
		
		Set<Character> keySet = countMap.keySet();
		int totalDiffInCount = 0;
		int numberOfCount1 = 0;
		int count = 0;

		for (char ch : keySet) {
			
			count = countMap.get(ch);
			
			if (count == 1) {
				++numberOfCount1;
			}
			totalDiffInCount += count - minFreq; 
			
		}
		
		List<Integer> tempList = Arrays.asList(totalDiffInCount, numberOfCount1);
		
		return tempList;
				
	}
	
	// 4,4,3
	
	private boolean checkIfLowerCase(final String input) {
		
		for (char ch : input.toCharArray()) {
			int val = (int)(ch - '0');
			if ( !(val >= 97 && val <=122)) {
				return false;
			}
		}
		
		return true;
	}
	
	private void printMessage(boolean isValidString) {
		if (isValidString) {
			System.out.println("Valid string");
		} else {
			System.out.println("Valid string");
		}
	}

}
