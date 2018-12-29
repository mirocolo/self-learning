package com.galaxy.learn.leetcode.exercise5;

import com.galaxy.learn.aop.annotation.MethodMonitorAnnotation;

import org.springframework.stereotype.Component;

/**
 * Created on 2018/12/29.
 *
 * @author He Xin
 */
@Component
public class Exercise5Solution5 implements Exercise5SolutionInterface {

	@Override
	@MethodMonitorAnnotation
	public String longestPalindrome(String s) {
		int curLen = 0;
		int start = -1;
		char[] array = s.toCharArray();
		for (int i = 0; i < array.length; i++) {
			if (isPalindrome(array, i - curLen - 1, i)) {
				start = i - curLen - 1;
				curLen += 2;
			} else if (isPalindrome(array, i - curLen, i)) {
				start = i - curLen;
				curLen += 1;
			}
		}
		return new String(array, start, curLen);
	}

	private boolean isPalindrome(char[] array, int start, int end) {
		if (start < 0) {
			return false;
		}
		while (start < end) {
			if (array[start++] != array[end--]) {
				return false;
			}
		}
		return true;
	}
}
