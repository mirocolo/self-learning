package com.galaxy.learn.leetcode.exercise3.run;

import com.galaxy.learn.aop.aspect.MethodMeasureAspect;
import com.galaxy.learn.leetcode.exercise3.Solution;
import com.galaxy.learn.leetcode.exercise3.Solution2;
import com.galaxy.learn.leetcode.exercise3.Solution3;
import com.galaxy.learn.leetcode.exercise3.Solution4;
import com.galaxy.learn.util.common.RandomUtils;
import com.galaxy.learn.util.spring.SpringContextUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * Created on 2018/12/24. 给定一个字符串，找到没有重复字符的最长子串，返回它的长度
 *
 * @author He Xin
 * @link https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
@Slf4j
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) throws IllegalAccessException, InstantiationException {
		int i = 100;
		while (i > 0) {
			String testStr = RandomUtils.getRandomString(1024);
			Solution solution = (Solution) SpringContextUtils.getBean(Solution.class);
			solution.lengthOfLongestSubstring(testStr);
			Solution2 solution2 = (Solution2) SpringContextUtils.getBean(Solution2.class);
			solution2.lengthOfLongestSubstring(testStr);
			Solution3 solution3 = (Solution3) SpringContextUtils.getBean(Solution3.class);
			solution3.lengthOfLongestSubstring(testStr);
			Solution4 solution4 = (Solution4) SpringContextUtils.getBean(Solution4.class);
			solution4.lengthOfLongestSubstring(testStr);
			i--;
		}
		log.info(SpringContextUtils.getBean(MethodMeasureAspect.class).toString());
	}
}

