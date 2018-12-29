package com.galaxy.learn.leetcode.exercise5.run;

import com.galaxy.learn.aop.aspect.MethodMeasureAspect;
import com.galaxy.learn.leetcode.exercise5.Exercise5Solution1;
import com.galaxy.learn.leetcode.exercise5.Exercise5Solution2;
import com.galaxy.learn.leetcode.exercise5.Exercise5SolutionInterface;
import com.galaxy.learn.util.common.RandomUtils;
import com.galaxy.learn.util.log.Loggers;
import com.galaxy.learn.util.spring.SpringContextUtils;

/**
 * Created on 2018/12/27. 最长回文子串
 *
 * @author He Xin
 */
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		init();
	}

	private static void init() {
		int i = 100;
		while (i > 0) {
			String testStr = RandomUtils.getRandomChar(100);
			Exercise5SolutionInterface solution1 = (Exercise5Solution1) SpringContextUtils.getBean(Exercise5Solution1.class);
			Exercise5SolutionInterface solution2 = (Exercise5Solution2) SpringContextUtils.getBean(Exercise5Solution2.class);
			String result = solution1.longestPalindrome(testStr);
			String result2 = solution2.longestPalindrome(testStr);
			assert result.equals(result2);
			i--;
			Loggers.runLogger.info("i:{}", i);
		}
		Loggers.monitorLogger.info(SpringContextUtils.getBean(MethodMeasureAspect.class).toString());
	}
}
