package com.galaxy.learn.leetcode.exercise7;

import org.springframework.stereotype.Component;

/**
 * Function：
 *
 * @author HeXin
 * @date 2020年06月11日 15:59
 * @since JDK 1.8
 */
@Component("exercise7Solution1")
public class Exercise7Solution1 implements Exercise7Interface {

	private static final int MAX_CON = Integer.MAX_VALUE / 10;
	private static final int MIN_CON = Integer.MIN_VALUE / 10;

	@Override
	public int reverse(int x) {
		int res = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			if (res > MAX_CON || (res == MAX_CON && pop > 7))
				return 0;
			if (res < MIN_CON || (res == MIN_CON && pop < -8))
				return 0;
			res = res * 10 + pop;
		}
		return res;
	}
}
