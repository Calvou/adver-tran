package com.adver.tran.common.utils;

public class StringUtil {

	/**
	 * 字符串补齐
	 * 
	 * @param source
	 *            源字符串
	 * @param fillLength
	 *            补齐长度
	 * @param fillChar
	 *            补齐的字符
	 * @param isLeftFill
	 *            true为左补齐，false为右补齐
	 * @return
	 */
	public static String stringFill(String source, int fillLength, char fillChar, boolean isLeftFill) {
		if (source == null || source.length() >= fillLength)
			return source;

		StringBuilder result = new StringBuilder(fillLength);
		int len = fillLength - source.length();
		if (isLeftFill) {
			for (; len > 0; len--) {
				result.append(fillChar);
			}
			result.append(source);
		} else {
			result.append(source);
			for (; len > 0; len--) {
				result.append(fillChar);
			}
		}
		return result.toString();
	}

	public static String stringFill2(String source, int fillLength, char fillChar, boolean isLeftFill) {
		if (source == null || source.length() >= fillLength)
			return source;

		char[] c = new char[fillLength];
		char[] s = source.toCharArray();
		int len = s.length;
		if (isLeftFill) {
			int fl = fillLength - len;
			for (int i = 0; i < fl; i++) {
				c[i] = fillChar;
			}
			System.arraycopy(s, 0, c, fl, len);
		} else {
			System.arraycopy(s, 0, c, 0, len);
			for (int i = len; i < fillLength; i++) {
				c[i] = fillChar;
			}
		}
		return String.valueOf(c);
	}

	public static void main(String[] args){
		System.out.println(stringFill("2",5,'*',true));
		System.out.println(stringFill("2",6,'*',false));
		System.out.println(stringFill("02",6,'*',true));
	}
	
}
