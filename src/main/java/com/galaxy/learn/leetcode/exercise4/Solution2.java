package com.galaxy.learn.leetcode.exercise4;

import com.galaxy.learn.aop.annotation.MethodMonitorAnnotation;

import org.springframework.stereotype.Component;

/**
 * Created on 2018/12/27.
 *
 * @author He Xin
 */
@Component("exercise4Solution2")
public class Solution2 implements Exerxise4SolutionInterface {

	@Override
	@MethodMonitorAnnotation
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;

		int[] mNums = nums1;
		int[] nNums = nums2;

		if (m > n) {
			int temp = m;
			m = n;
			n = temp;

			int[] tempNums = mNums;
			mNums = nNums;
			nNums = tempNums;
		}

		int imin = 0;
		int imax = m;
		int halfLen = (m + n + 1) / 2;

		while (imin <= imax) {
			int i = (imin + imax) / 2;
			int j = halfLen - i;

			if (i < imax && nNums[j - 1] > mNums[i]) {
				imin = i + 1;
			} else if (i > imin && mNums[i - 1] > nNums[j]) {
				imax = i - 1;
			} else {
				int maxLeft = 0;
				if (i == 0) {
					maxLeft = nNums[j - 1];
				} else if (j == 0) {
					maxLeft = mNums[i - 1];
				} else {
					maxLeft = Math.max(mNums[i - 1], nNums[j - 1]);
				}
				if ((m + n) % 2 == 1) {
					return maxLeft;
				}

				int minRight = 0;
				if (i == m) {
					minRight = nNums[j];
				} else if (j == n) {
					minRight = mNums[i];
				} else {
					minRight = Math.min(mNums[i], nNums[j]);
				}

				return (maxLeft + minRight) / 2.0;
			}
		}

		return 0.0;
	}
}
