package com.galaxy.learn.leetcode.exercise4.run;


import com.galaxy.learn.aop.aspect.MethodMeasureAspect;
import com.galaxy.learn.leetcode.exercise4.Solution;
import com.galaxy.learn.leetcode.exercise4.Solution2;
import com.galaxy.learn.util.common.RandomUtils;
import com.galaxy.learn.util.spring.SpringContextUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * Created on 2018/12/27. 已知两个有序数组，找到两个数组合并后的中位数。
 *
 * @author He Xin
 */
@Slf4j
public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		init();
	}

	private static void init() {
		int i = 100;
		while (i > 0) {
			int[] a = RandomUtils.getRandomIntArray(Integer.MAX_VALUE / 2, Integer.parseInt(RandomUtils.getNumber(7)));
			int[] b = RandomUtils.getRandomIntArray(Integer.MAX_VALUE / 2, Integer.parseInt(RandomUtils.getNumber(7)));
			Solution solution = (Solution) SpringContextUtils.getBean(Solution.class);
			double result = solution.findMedianSortedArrays(a, b);
			Solution2 solution2 = (Solution2) SpringContextUtils.getBean(Solution2.class);
			double result2 = solution2.findMedianSortedArrays(a, b);
			assert result == result2;
			i--;
			log.info("i:{}", i);
		}
		log.info(SpringContextUtils.getBean(MethodMeasureAspect.class).toString());
	}
}
