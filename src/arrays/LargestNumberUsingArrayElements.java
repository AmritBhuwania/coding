package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author amrit
 * Print largest num that can be formed using the given array
 */
public class LargestNumberUsingArrayElements {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("23", "54", "90", "99", "98", "9", "879");

		Comparator<String> comp = (s1, s2) -> (s1 + s2).compareTo(s2 + s1) > 0 ? -1 : 1;

		Collections.sort(list, comp);

		String ans = "";
		for (String string : list) {
			ans+=string;
		}
		
		System.out.println(ans);
	}
}
