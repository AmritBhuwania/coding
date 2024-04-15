package interviews2024;

import java.util.*;

public class Axiamatic {
    public static String StringChallenge(String[] strArr) {

        // code goes here

        String str = strArr[0];
        String pattern = strArr[1];

        Map<Character, Integer> patternMap = countMap(pattern);
        System.out.println(patternMap);

        int len = pattern.length();

        int start = 0, end = 0, startIndex = 0, count = 0, min = Integer.MAX_VALUE;
        boolean flag = false;
        for (end = 0; end < str.toCharArray().length; ++end) {
            if (patternMap.containsKey(str.charAt(end))) {
                ++count;
                int c = patternMap.get(str.charAt(end)) - 1;
                if (c == 0) {
                    patternMap.remove(str.charAt(end));
                } else {
                    patternMap.put(str.charAt(end), c);
                }
            }

            if (patternMap.isEmpty()) {
                patternMap = countMap(pattern);
                while(start < end) {
                    if (!patternMap.containsKey(str.charAt(start))) {
                        ++start;
                    } else {
                        startIndex = start;

                        int size = end - start + 1;
                        if (size < min) {
                            min = size;
                            System.out.println(start + "->"  + min);
                        }
                        flag = true;
                        break;
                    }
                }
            }

            if (flag) {
                start = ++start;
                end = start;
                patternMap = countMap(pattern);
            }
            flag = false;

        }

        return str.substring(startIndex, startIndex + min);
    }

    private static Map<Character, Integer> countMap(String str) {
        Map<Character, Integer> patternMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            patternMap.compute(ch, (k,v) -> v == null ? 1 : v+1);
        }
        return patternMap;

    }

    public static void main (String[] args) {
        // keep this function call here
        //Scanner s = new Scanner(System.in);
        System.out.print(StringChallenge(new String[] {"aaabaaddae", "aed"}));
    }

}
