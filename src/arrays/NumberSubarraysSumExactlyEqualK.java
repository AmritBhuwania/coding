package arrays;

import java.util.HashMap;

public class NumberSubarraysSumExactlyEqualK {


    static int findSubarraySum(int arr[], int n, int sum) {
        // HashMap to store number of subarrays
        // starting from index zero having
        // particular value of sum.
        HashMap<Integer, Integer> prevSum = new HashMap<>();
        prevSum.put(0,1);
        int result = 0;

        // Sum of elements so far.
        int currSum = 0;

        for (int i = 0; i < n; i++) {

            // Add current element to sum so far.
            currSum += arr[i];
            //calculate the sum that have to be removed
            //so that we can get the desired sum

            int removeSum=currSum-sum;

            //get count of occurrences of that sum that
            //have to removed and add it to res value
            if (prevSum.containsKey(removeSum))
                result += prevSum.get(removeSum);

            // Add currsum value to count of
            // different values of sum.
            prevSum.put(currSum,prevSum.getOrDefault(currSum,0)+1);
        }
        return result;
    }


    public static void main(String[] args) {

        int arr[] = {1,0,1,0,1};
        int sum = 2;
        int n = arr.length;
        System.out.println(findSubarraySum(arr, n, sum));
    }
}
