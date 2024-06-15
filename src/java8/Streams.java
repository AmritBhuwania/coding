package java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1,4,7,2,3,9);

		List<String> strs = Arrays.asList("Amrit", "Ujjwal", "Avi", "Pishu");

		int min = list.stream().min((i1, i2)-> i1.compareTo(i2)).get();
		int max = list.stream().min((i1, i2)-> -i1.compareTo(i2)).get();
		System.out.println("Min: " + min + ", Max: " + max);

		min = list.stream().min(Integer::compareTo).get();
		max = list.stream().max((i1, i2)-> -i1.compareTo(i2)).get();
		System.out.println("Min: " + min + ", Max: " + max);

		System.out.println("Ascending order of string : " + strs.stream().sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList()));
		System.out.println("Descending order of string : " + strs.stream().sorted((s1, s2) -> -s1.compareTo(s2)).collect(Collectors.toList()));

		Comparator<String> asc = (s1, s2) -> s1.length()>s2.length() ? 1 : s1.length()<s2.length() ? -1 : 0;
		Comparator<String> desc = (s1, s2) -> s1.length()>s2.length() ? -1 : s1.length()<s2.length() ? 1 : 0;

		System.out.println("Ascending order of string length: " + strs.stream().sorted(asc).collect(Collectors.toList()));
		System.out.println("Descending order of string length: " + strs.stream().sorted(desc).collect(Collectors.toList()));

		/**
		 * toArray
		 * To convert streams of objects into array
		 */
		Integer[] array = list.stream().toArray(Integer[] :: new);
		Arrays.stream(array).forEach(System.out::print);
		System.out.println("\n------");
		Stream.of(array).forEach(System.out::print);
		System.out.println("\n------");
		
		Arrays.stream(array).collect(Collectors.toList());


		Map<String, Integer> map = new HashMap<>();
		map.put("apple", 5);
		map.put("banana", 2);
		map.put("orange", 8);
		map.put("grape", 3);

		// Sort the map by values
		Map<String, Integer> sortedMap = map.entrySet().stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));

		// Print the sorted map
		sortedMap.forEach((key, value) -> System.out.println(key + ": " + value));


		String[] arr = {"Kstr", "Vstr", "V33", "Kstr2", "V24"};



		Map<String, String> resultMap = Arrays.stream(arr)
				.filter(s -> s.startsWith("K"))
				.collect(HashMap::new,
						(m, key) -> m.put(key, getValue(key, arr)),
						HashMap::putAll);

		System.out.println(resultMap);
	}

	private static String getValue(String key, String[] array) {
		StringBuilder valueBuilder = new StringBuilder();
		boolean keyFound = false;
		int currentKIndex = -1;
		int keyIndex = -1;
		for (int i = 0; i < array.length; i++) {

			if (array[i].startsWith("K")) {
				currentKIndex = i;
			}
			if (array[i].equals(key)) {
				keyFound  = true;
				keyIndex = i;
			}

			if (keyFound && currentKIndex == keyIndex) {
				if (array[i].startsWith("V")) {
					valueBuilder.append(array[i]);
					if (i + 1 < array.length && array[i + 1].startsWith("V")) {
						valueBuilder.append("_");
					}
				}
			}
        }
		return valueBuilder.toString();
	}
}
