package arrays;

import java.io.IOException;
import java.util.*;


public class Solution {
    
    public static void main(String[] args) {
        
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in);
        Scanner sc = new Scanner(System.in);
        
        int test = sc.nextInt();
        
        for (int i = 0; i <= test; ++i) {
            
            String str = sc.nextLine();
            
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            str = new String(chs);
            
            String permutations = "";
            
            permute(str, permutations);
            //System.out.println();
        }
        System.out.println();
        
        
    }
    
    static void permute(String str, String result) {
        
        
        int len = str.length();
        if (len == 0) {
            System.out.print(result + " ");
            return;
        }
            
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            String left = str.substring(0, i);
            String right = str.substring(i+1);
            String rest = left + right;
            permute(rest, result + c);
        }
        
        
    }
    
}
