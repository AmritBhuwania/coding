package recursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author amrit
 * create all subsequence of a string
 */

public class StringSubsequence {
	
	public static void main(String[] args) {
		
		subSequence("", "abc");
		System.out.println(subSequence2("", "abc"));
		
	}
	
	static void subSequence(String processed, String unProcessed) {
		if (unProcessed.isEmpty()) {
			System.out.println(processed);
			return;
		}
		
		char ch = unProcessed.charAt(0);
		subSequence(processed + ch, unProcessed.substring(1));
		subSequence(processed, unProcessed.substring(1));
	}
	
	static ArrayList<String> subSequence2(String processed, String unProcessed) {
		
		ArrayList<String> ans = new ArrayList<String>();
		
		if (unProcessed.isEmpty()) {
			return new ArrayList<String>(Arrays.asList(processed));
		}
		
		char ch = unProcessed.charAt(0);
		ArrayList<String> temp = subSequence2(processed + ch, unProcessed.substring(1));
		ans.addAll(temp);
		temp =subSequence2(processed, unProcessed.substring(1));
		ans.addAll(temp);
		
		return ans;
	}
	
	

}
