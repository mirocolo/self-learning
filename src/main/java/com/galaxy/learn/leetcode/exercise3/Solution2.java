package com.galaxy.learn.leetcode.exercise3;

import com.galaxy.learn.aop.annotation.MethodMonitorAnnotation;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * 滑动窗口
 */
@Component("exercise3Solution2")
public class Solution2 implements SolutionInterface {

	@Override
	@MethodMonitorAnnotation
	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0, i = 0, j = 0;
		while (i < n && j < n) {
			// try to extend the range [i, j]
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return ans;
	}
}
