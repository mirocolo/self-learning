package com.galaxy.learn.leetcode.exercise5.run;

import com.galaxy.learn.aop.aspect.MethodMeasureAspect;
import com.galaxy.learn.leetcode.exercise5.Exercise5Solution1;
import com.galaxy.learn.leetcode.exercise5.Exercise5Solution2;
import com.galaxy.learn.leetcode.exercise5.Exercise5Solution3;
import com.galaxy.learn.leetcode.exercise5.Exercise5Solution4;
import com.galaxy.learn.leetcode.exercise5.Exercise5Solution5;
import com.galaxy.learn.leetcode.exercise5.Exercise5Solution6;
import com.galaxy.learn.leetcode.exercise5.Exercise5SolutionInterface;
import com.galaxy.learn.util.common.RandomUtils;
import com.galaxy.learn.util.spring.SpringContextUtils;

import java.util.Objects;

import lombok.extern.slf4j.Slf4j;

/**
 * Created on 2018/12/27. 最长回文子串
 *
 * @author He Xin
 */
@Slf4j
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		init();
	}

	private static void init() {
		int i = 2;
		while (i > 0) {
			String testStr = RandomUtils.getRandomChar(Integer.MAX_VALUE / 50);
			Exercise5SolutionInterface solution1 = (Exercise5Solution1) SpringContextUtils.getBean(Exercise5Solution1.class);
			Exercise5SolutionInterface solution2 = (Exercise5Solution2) SpringContextUtils.getBean(Exercise5Solution2.class);
			Exercise5SolutionInterface solution3 = (Exercise5Solution3) SpringContextUtils.getBean(Exercise5Solution3.class);
			Exercise5SolutionInterface solution4 = (Exercise5Solution4) SpringContextUtils.getBean(Exercise5Solution4.class);
			Exercise5SolutionInterface solution5 = (Exercise5Solution5) SpringContextUtils.getBean(Exercise5Solution5.class);
			Exercise5SolutionInterface solution6 = (Exercise5Solution6) SpringContextUtils.getBean(Exercise5Solution6.class);
//			String result = solution1.longestPalindrome(testStr);
//			String result2 = solution2.longestPalindrome(testStr);
			String result3 = solution3.longestPalindrome(testStr);
			String result4 = solution4.longestPalindrome(testStr);
			String result5 = solution5.longestPalindrome(testStr);
			String result6 = solution6.longestPalindrome(testStr);
//			assert Objects.equals(result, result2);
//			assert Objects.equals(result2, result3);
			assert Objects.equals(result3, result4);
			assert Objects.equals(result4, result5);
			assert Objects.equals(result5, result6);
			i--;
			log.info("i:{}", i);
		}
		log.info(SpringContextUtils.getBean(MethodMeasureAspect.class).toString());
	}
}
