package com.galaxy.learn.util.common;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created on 2018/12/24.
 *
 * @author He Xin
 */
public class RandomUtils {
	private static Random random;

	// 双重校验锁获取一个Random单例
	public static Random getRandom() {
		if (random == null) {
			synchronized (org.apache.commons.lang3.RandomUtils.class) {
				if (random == null) {
					random = new Random();
				}
			}
		}

		return random;
	}

	/**
	 * 获取随机字符串 a-z,A-Z,0-9
	 *
	 * @param length 长度
	 */
	public static String getRandomString(int length) {
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = getRandom();
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < length; ++i) {
			//int number = random.nextInt(62);// [0,62)
			sb.append(str.charAt(random.nextInt(62)));
		}
		return sb.toString();
	}

	/**
	 * JAVA获得0-9,a-z,A-Z范围的随机数
	 *
	 * @param length 随机数长度
	 * @return String
	 */
	public static String getRandomChar(int length) {
		char[] chr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
				'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		Random random = getRandom();
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < length; i++) {
			buffer.append(chr[random.nextInt(62)]);
		}
		return buffer.toString();
	}

	/**
	 * 获取随机字符串 a-z
	 *
	 * @param length 长度
	 */
	public static String getLowerLetter(int length) {
		String str = "abcdefghijklmnopqrstuvwxyz";
		Random random = getRandom();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; ++i) {
			sb.append(str.charAt(random.nextInt(26)));
		}
		return sb.toString();
	}

	/**
	 * 获取随机字符串 0-9
	 *
	 * @param length 长度
	 */
	public static String getNumber(int length) {
		String str = "0123456789";
		Random random = getRandom();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; ++i) {
			sb.append(str.charAt(random.nextInt(10)));
		}
		return sb.toString();
	}

	/**
	 * 获取随机字符串 0-9,a-z,0-9 有两遍0-9，增加数字概率
	 *
	 * @param length 长度
	 */
	public static String getLowerLetterNumber(int length) {
		String str = "0123456789abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = getRandom();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; ++i) {
			sb.append(str.charAt(random.nextInt(46)));
		}
		return sb.toString();
	}

	/**
	 * 获取随机密码，lLength位小写英文+nLength位数字
	 *
	 * @param lLength 字母长度
	 * @param nLength 数字长度
	 */
	public static String getPasswordSimple(int lLength, int nLength) {
		return getLowerLetter(lLength) + getNumber(nLength);
	}

	/**
	 * 获取随机密码，包含英文和数字
	 *
	 * @param length 密码长度
	 */
	public static String getPasswordComplex(int length) {
		String password;
		while (true) {
			password = getLowerLetterNumber(6);
			//必须包含字母和数字
			if (password.matches("(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}")) {
				return password;
			}
		}
	}

	/**
	 * 获得排序好的随机数数组
	 *
	 * @param maxSize 数组内最大值
	 * @param length  数组长度
	 */
	public static int[] getRandomIntArray(int maxSize, int length) {
		if (maxSize <= 0 || length <= 0) {
			throw new IllegalArgumentException();
		}
		Random random = getRandom();
		int[] randomIntArray = IntStream.range(0, length).map(i -> random.nextInt(maxSize)).toArray();
		Arrays.sort(randomIntArray);
		return randomIntArray;
	}
}
