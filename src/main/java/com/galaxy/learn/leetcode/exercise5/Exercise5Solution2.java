package com.galaxy.learn.leetcode.exercise5;

import com.galaxy.learn.aop.annotation.MethodMonitorAnnotation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Created on 2018/12/27.
 *
 * @author He Xin
 */
@Component
public class Exercise5Solution2 implements Exercise5SolutionInterface {

	@Override
	@MethodMonitorAnnotation
	public String longestPalindrome(String s) {
		if (StringUtils.isEmpty(s)) {
			return "";
		}
		String origin = s;
		String reverse = new StringBuffer(s).reverse().toString();
		int length = s.length();
		int[][] arr = new int[length][length];
		int maxLen = 0;
		int maxEnd = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (origin.charAt(i) == reverse.charAt(j)) {
					if (i == 0 || j == 0) {
						arr[i][j] = 1;
					} else {
						arr[i][j] = arr[i - 1][j - 1] + 1;
					}
				}
				/**********修改的地方*******************/
				if (arr[i][j] > maxLen) {
					int beforeRev = length - 1 - j;
					//判断下标是否对应
					if (beforeRev + arr[i][j] - 1 == i) {
						maxLen = arr[i][j];
						maxEnd = i;
					}
					/*************************************/
				}
			}
		}
		return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
	}
}
