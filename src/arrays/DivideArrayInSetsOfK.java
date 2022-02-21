package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author amrit
 * Link: https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 */
public class DivideArrayInSetsOfK {

	public boolean isPossibleDivide(int[] nums, int k) {

		int length = nums.length;

		if (length % k != 0) {
			return false;
		}

		Arrays.sort(nums);

		Map<Integer, Integer> map = new HashMap<>();

		for (Integer i : nums) {
			map.compute(i, (key, val) -> val == null ? 1 : val + 1);
		}

		for(int i = 0; i < length; i++)
		{
			if(map.get(nums[i]) == 0)
				continue;

			for(int v = nums[i]; v < nums[i] + k; v++)
			{
				if(!map.containsKey(v) || map.get(v) == 0)
					return false;
				else
					map.put(v, map.get(v) - 1);
			}
		}
		return false;
	}
}