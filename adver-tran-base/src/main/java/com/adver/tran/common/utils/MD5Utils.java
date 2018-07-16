package com.adver.tran.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

public class MD5Utils {

	private final static String[] strs = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c",
			"d", "e", "f" };

	/**
	 * 生成string类型md5信息
	 */
	public static String MD5(String value) {
		String md5 = "";
		try {
			if (value == null) {
				return null;
			}
			byte[] btInput = value.getBytes("UTF-8");
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();

			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < md.length; i++) {
				int num = md[i];
				if (num < 0) {
					num += 256;
				}
				int index1 = num / 16;
				int index2 = num % 16;
				buffer.append(strs[index1] + strs[index2]);
			}
			md5 = buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return md5;
	}

	public static String getMd5ByFile(File file) throws FileNotFoundException {
		String value = null;
		FileInputStream in = new FileInputStream(file);
		try {
			MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(byteBuffer);
			BigInteger bi = new BigInteger(1, md5.digest());
			value = bi.toString(16);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}

}
