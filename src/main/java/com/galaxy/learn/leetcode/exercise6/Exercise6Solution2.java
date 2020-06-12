package com.galaxy.learn.leetcode.exercise6;

import org.springframework.stereotype.Component;

/**
 * Function：
 *
 * @author HeXin
 * @date 2020年06月10日 11:25
 * @since JDK 1.8
 */
@Component("exercise6Solution2")
public class Exercise6Solution2 implements Exercise6Interface {
	/**
	 * 思路
	 *
	 * 按照与逐行读取 Z 字形图案相同的顺序访问字符串。
	 *
	 * 算法
	 *
	 * 首先访问 行 0 中的所有字符，接着访问 行 1，然后 行 2，依此类推...
	 *
	 * 对于所有整数 k， 行0 中字符位于 索引k(2*numRows-2)处 行numRows-1中的字符位于 索引 k(2*numRows-2)+numRows-1处 内部的行i中字符
	 * 位于 索引k(2*numRows-2)+i以及（k+1）(2*numRows-2)-i处
	 */
	@Override
	public String convert(String s, int numRows) {
		if (numRows == 1) return s;

		StringBuilder ret = new StringBuilder();
		int n = s.length();
		int cycleLen = 2 * numRows - 2;

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j + i < n; j += cycleLen) {
				ret.append(s.charAt(j + i));
				if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
					ret.append(s.charAt(j + cycleLen - i));
			}
		}
		return ret.toString();
	}
}
