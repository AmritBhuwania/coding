package dynamicProgramming.longestCommonSubSequence;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {

        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("babad"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("agbcba"));
    }

    public int longestPalindrome(String s) {

        String rev = new StringBuilder(s).reverse().toString();

        int [][] arr = new int[s.length()+1][s.length()+1];

        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 0; j < s.length() + 1; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {

                if (s.charAt(i-1) == rev.charAt(j-1)) {
                    arr[i][j] = 1 + arr[i-1][j-1];
                } else {
                    arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
                }

            }
        }
        return arr[s.length()][s.length()];

    }
}
