package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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
		
		Arrays.stream(array).collect(Collectors.toList());
		 
	} 
}
