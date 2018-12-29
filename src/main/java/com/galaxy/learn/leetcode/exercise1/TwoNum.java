package com.galaxy.learn.leetcode.exercise1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2018/12/24.
 *
 * @author He Xin
 */
public class TwoNum {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int num[] = s.twoSum(nums, target);
		for (int i : num) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}

class Solution {

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[]{map.get(complement), i};
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}