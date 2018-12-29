package com.galaxy.learn.leetcode.exercise3;

import com.galaxy.learn.aop.annotation.MethodMonitorAnnotation;

import org.springframework.stereotype.Component;

/**
 * 滑动窗口优化版本 Java (Assuming ASCII 128)
 */
@Component("exercise3Solution4")
public class Solution4 implements SolutionInterface {
	@Override
	@MethodMonitorAnnotation
	public int lengthOfLongestSubstring(String s) {
		int n = s.length(), ans = 0;
		int[] index = new int[128]; // current index of character
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			i = Math.max(index[s.charAt(j)], i);
			ans = Math.max(ans, j - i + 1);
			index[s.charAt(j)] = j + 1;
		}
		return ans;
	}
}
