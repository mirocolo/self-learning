package com.galaxy.learn.leetcode.exercise4;

import com.galaxy.learn.aop.annotation.MethodMonitorAnnotation;

import org.springframework.stereotype.Component;

/**
 * Created on 2018/12/27.
 *
 * @author He Xin
 */
@Component("exercise4Solution")
public class Solution implements Exerxise4SolutionInterface {

	@Override
	@MethodMonitorAnnotation
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] tempNums1 = nums1;
		int[] tempNums2 = nums2;
		int m = tempNums1.length;
		int n = tempNums2.length;
		if (m > n) { // to ensure m<=n
			int[] temp = tempNums1;
			tempNums1 = tempNums2;
			tempNums2 = temp;
			int tmp = m;
			m = n;
			n = tmp;
		}
		int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
		while (iMin <= iMax) {
			int i = (iMin + iMax) / 2;
			int j = halfLen - i;
			if (i < iMax && tempNums2[j - 1] > tempNums1[i]) {
				iMin = i + 1; // i is too small
			} else if (i > iMin && tempNums1[i - 1] > tempNums2[j]) {
				iMax = i - 1; // i is too big
			} else { // i is perfect
				int maxLeft = 0;
				if (i == 0) {
					maxLeft = tempNums2[j - 1];
				} else if (j == 0) {
					maxLeft = tempNums1[i - 1];
				} else {
					maxLeft = Math.max(tempNums1[i - 1], tempNums2[j - 1]);
				}
				if ((m + n) % 2 == 1) {
					return maxLeft;
				}

				int minRight = 0;
				if (i == m) {
					minRight = tempNums2[j];
				} else if (j == n) {
					minRight = tempNums1[i];
				} else {
					minRight = Math.min(tempNums2[j], tempNums1[i]);
				}

				return (maxLeft + minRight) / 2.0;
			}
		}
		return 0.0;
	}
}
