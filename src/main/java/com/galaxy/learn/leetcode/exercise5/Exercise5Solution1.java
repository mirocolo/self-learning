package com.galaxy.learn.leetcode.exercise5;

import com.galaxy.learn.aop.annotation.MethodMonitorAnnotation;

import org.springframework.stereotype.Component;

/**
 * Created on 2018/12/27.
 *
 * @author He Xin
 */
@Component
public class Exercise5Solution1 implements Exercise5SolutionInterface {

	@Override
	@MethodMonitorAnnotation
	public String longestPalindrome(String s) {
		String ans = "";
		int max = 0;
		int len = s.length();
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j <= len; j++) {
				String test = s.substring(i, j);
				if (isPalindromic(test) && test.length() > max) {
					ans = s.substring(i, j);
					max = Math.max(max, ans.length());
				}
			}
		}
		return ans;
	}

	private boolean isPalindromic(String s) {
		int len = s.length();
		for (int i = 0; i < len / 2; i++) {
			if (s.charAt(i) != s.charAt(len - i - 1)) {
				return false;
			}
		}
		return true;
	}
}
