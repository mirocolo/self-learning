package com.galaxy.learn.leetcode.exercise3;

import com.galaxy.learn.aop.annotation.MethodMonitorAnnotation;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * 蛮力方法
 */
@Component("exercise3Solution")
public class Solution implements SolutionInterface {

	@Override
	@MethodMonitorAnnotation
	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (allUnique(s, i, j)) {
					ans = Math.max(ans, j - i);
				}
			}
		}
		return ans;
	}

	public boolean allUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<>();
		for (int i = start; i < end; i++) {
			Character ch = s.charAt(i);
			if (set.contains(ch)) {
				return false;
			}
			set.add(ch);
		}
		return true;
	}
}
