package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfThree {

	public static void main(String[] args) {
		
		SumOfThree sumOfThree = new SumOfThree();
		List<List<Integer>> answers = new ArrayList<>();
		
		int[] nums =  new int [] {1,-1,-1,0};
		
		Arrays.sort(nums);
		
		System.out.println(Arrays.toString(nums));
		
		for(int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            else {
				sumOfThree.threeSum(nums, nums[i], i+1, answers);
			}
		}
		
		System.out.println(answers);

	}

	public List<List<Integer>> threeSum(int[] nums, int sum, int left, List<List<Integer>> answers) {
		int right = nums.length - 1;
		while (left < right) {
			int curSum = nums[left] + nums[right];
			System.out.println("left index: " + left + ", left: " + nums[left] + ", right index: " + right + ", right: " + nums[right] + " -> " + curSum + " + " + sum + " = " + (curSum + sum));
			if (curSum + sum == 0) {
				answers.add(Arrays.asList(sum, nums[left], nums[right]));
				left++; right--;
				
				while (left < right && nums[left] == nums[left-1]) {
					left++;
				}
				while (left < right && nums[right] == nums[right+1]) {
					right--;
				}
			} else if (curSum + sum < 0) {
				left++;
				System.out.println("Left: " + "left index: " + left + ", left: " + nums[left] + ", right index: " + right + ", right: " + nums[right] + " -> " + curSum + " + " + sum + " = " + (curSum + sum));
			} else {
				System.out.println("Right: " + "left index: " + left + ", left: " + nums[left] + ", right index: " + right + ", right: " + nums[right] + " -> " + curSum + " + " + sum + " = " + (curSum + sum));
				right--;
			}
		}
		return answers;
	}
}
