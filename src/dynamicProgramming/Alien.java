package dynamicProgramming;

import java.util.Arrays;

/**
 * @author amrit
 * 
 * Convert a k note music to 4 note music.
 * 
 * Rules:
 * 1. If a pitch is higher than prev note, it should be converted into a higher
 * pitched key than the previous note conversion
 * 2. If a pitch is lower than prev note, it should be converted into a lower
 * pitched key than the previous note conversion
 * 3. If a pitch is identical than prev note, it should be converted into a same
 * pitched key than the previous note conversion
 * 4. 2 notes of same pitch if not adjacent need not be converted to same key.
 * 
 * if any rules are broken, there's a penalty. Minimise this penalty
 */
public class Alien {
	
	public static void main(String[] args) {
		int [] ar = { 6,5,4,3,2,1 };
		int [][] dp = new int[ar.length][4]; // since 4 notes conversion
		
		for (int i = 0; i < 4; i++) {
			dp[0][i] = 0;
		}
		System.out.println("Min Penalty: " + minimisePenalty(ar, dp));
}

	private static int minimisePenalty(int[] ar, int[][] dp) {

		int minPenalty = Integer.MAX_VALUE;
		
		System.out.println(Arrays.toString(dp[0]));
		for (int i = 1; i < ar.length; i++) {
			for (int j = 0; j < 4; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				
				for (int z = 0; z < 4; z++) {
					int penalty = 0;
				 	
					if (j == z && ar[i] != ar[i-1]) penalty = 1;
					else if (j > z && ar[i] <= ar[i-1]) penalty = 1;
					else if (j < z && ar[i] >= ar[i-1]) penalty = 1;
					
					dp[i][j] = Math.min(dp[i][j], dp[i-1][z] + penalty);
				}
			}
			System.out.println(Arrays.toString(dp[i]));
		}
		
		for (int i = 0; i < 4; i++) {
			minPenalty = Math.min(minPenalty, dp[ar.length-1][i]);
		}
		
		return minPenalty;
		
	}
}
