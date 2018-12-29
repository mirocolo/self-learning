package com.galaxy.learn.leetcode.exercise3;

import com.galaxy.learn.aop.annotation.MethodMonitorAnnotation;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口优化版本 Java (Using HashMap)
 */
@Component("exercise3Solution3")
public class Solution3 implements LongestSubstringWithoutRepeatingCharactersInterface {

	@Override
	@MethodMonitorAnnotation
	public int lengthOfLongestSubstring(String s) {
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<>(); // current index of character
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}
}
