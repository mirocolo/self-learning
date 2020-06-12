package com.galaxy.learn.leetcode.exercise6;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Function：
 *
 * @author HeXin
 * @date 2020年06月10日 11:25
 * @since JDK 1.8
 */
@Component("exercise6Solution1")
public class Exercise6Solution1 implements Exercise6Interface {
	public static void main(String[] args) {
		{
			String s = "LEETCODEISHIRING";
			int numRows = 3;
			System.out.println(new Exercise6Solution1().convert(s, numRows));
		}
		{
			String s = "LEETCODEISHIRING";
			int numRows = 2;
			System.out.println(new Exercise6Solution1().convert(s, numRows));
		}
	}

	/**
	 * 思路
	 *
	 * 通过从左向右迭代字符串，我们可以轻松地确定字符位于 Z 字形图案中的哪一行。
	 *
	 * 算法
	 *
	 * 我们可以使用 \text{min}( \text{numRows}, \text{len}(s))min(numRows,len(s)) 个列表来表示 Z 字形图案中的非空行。
	 *
	 * 从左到右迭代 ss，将每个字符添加到合适的行。可以使用当前行和当前方向这两个变量对合适的行进行跟踪。
	 *
	 * 只有当我们向上移动到最上面的行或向下移动到最下面的行时，当前方向才会发生改变
	 */
	@Override
	public String convert(String s, int numRows) {
		if (numRows < 1) {
			throw new RuntimeException("numRows must >= 1");
		} else if (numRows == 1) {
			return s;
		}
		int si = Math.min(s.length(), numRows);
		List<StringBuilder> rows = new ArrayList<>(si);
		for (int i = 0; i < si; i++) {
			rows.add(new StringBuilder());
		}
		int curRow = 0;
		boolean goingDown = false;
		for (char c : s.toCharArray()) {
			rows.get(curRow).append(c);
			if (curRow == 0 || curRow == numRows - 1)
				goingDown = !goingDown;
			curRow += goingDown ? 1 : -1;
		}

		return String.join("", rows);
	}
}
