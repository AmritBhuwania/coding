package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 
 * @author amrit
 * Create all permutations of a list
 */
public class Permuations {

	public static void main(String[] args) {

		permutations("", "abc");
		System.out.println(permutationList("", "abc"));
		System.out.println(permutationCount("", "abc"));
		
	}

	static void permutations(String p , String up){

		if (up.isEmpty()) {
			System.out.println(p);
			return;
		}
		char ch = up.charAt(0);

		for (int i = 0; i <= p.length(); ++i) {
			String first = p.substring(0, i);
			String second = p.substring(i, p.length());
			System.out.println(first + "-" + ch + "-" + second);
			permutations(first + ch + second, up.substring(1));
		}
	}

	static List<String> permutationList(String p , String up){

		List<String> ans = new ArrayList<String>();
		if (up.isEmpty()) {
			//System.out.println(p);
			return new ArrayList<String>(Arrays.asList(p));
		}
		char ch = up.charAt(0);

		for (int i = 0; i <= p.length(); ++i) {
			String first = p.substring(0, i);
			String second = p.substring(i, p.length());
			ans.addAll(permutationList(first + ch + second, up.substring(1)));
		}

		return ans;
	}
	
	static int permutationCount(String p , String up){

		if (up.isEmpty()) {
			System.out.println(p);
			return 1;
		}
		
		int count = 0;
		char ch = up.charAt(0);

		for (int i = 0; i <= p.length(); ++i) {
			String first = p.substring(0, i);
			String second = p.substring(i, p.length());
			count += permutationCount(first + ch + second, up.substring(1));
		}

		return count;
	}
}
