package strings;

import java.util.ArrayList;
import java.util.List;

public class SubStringPermutations {
	
	public static void main(String[] args) {
		
		String s = "amriit";
		System.out.println(s.substring(1));
		int size = s.length();
		List<String> ans = new ArrayList<>();
		
		for (int i = 0; i < size; ++i) {
			String sub = "";
			
			for (int j = i; j < size; ++j) {
				sub += s.charAt(j);
				ans.add(sub);
 			}
		}
		System.out.println(ans);
	}

}
