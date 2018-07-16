package com.adver.tran.common.utils;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Date;
import java.util.UUID;


public class CommonUtils {


	private static SecureRandom random = new SecureRandom();


	/**
	 * 获取UUID
	 * @return
     */
	public static String getUuidString(){
		UUID uid = UUID.randomUUID();
		String uuid = uid.toString().replace("-", "");
		return uuid;
	}

	/**
	 * 生成验证码
	 * @param length	验证码长度
	 * @param hasChar	是否包含字母(不包含为纯数字)
	 * @return
	 */
	public static String getRandomString(int length, boolean hasChar) {
		StringBuilder ret = new StringBuilder();
		for (int i = 0; i < length; i++) {
			if (hasChar) {
				boolean isChar = (random.nextInt(2) % 2 == 0);// 输出字母还是数字
				if (isChar) { // 字符串
					int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; // 取得大写字母还是小写字母
					ret.append((char) (choice + random.nextInt(26)));
				} else { // 数字
					ret.append(Integer.toString(random.nextInt(10)));
				}
			} else {
				ret.append(Integer.toString(random.nextInt(10)));
			}
		}
		return ret.toString();
	}


	/**
	 * 随机生成start到end间的金额,不含start
	 * @param start
	 * @param end
	 * @return
	 */
	public static BigDecimal getRandomAmount(double start, double end) {
		
		//取[0,1)间的一个随机值
		double randomDouble = random.nextDouble();

		//换算为[0,end-start)
		double incrementDouble = randomDouble * (end - start);
		
		//换算为[start,end)
		double result = incrementDouble + start;
		
		BigDecimal amount = new BigDecimal(result);
		//舍入方式，保留两位小数
		amount = amount.setScale(2, BigDecimal.ROUND_DOWN);
		//加上0.01后，变为(start,end]
		amount = amount.add(new BigDecimal(0.01));
		return amount.setScale(2, BigDecimal.ROUND_DOWN);
	}
	
	public static String getMaskMobileNo(String mobileNo){
		
		return mobileNo.substring(0, 3) + "****" + mobileNo.substring(mobileNo.length() - 4);
		
	}
	
	public static String getMaskBankCardNo(String cardNo){
		// 6222 02100111624 5702
		return cardNo.substring(0, 4) + "***********" + cardNo.substring(cardNo.length() - 4);
	}
	

	private static byte[] md5ToBytes(String s) {
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(s.getBytes("UTF-8"));
			byte[] messageDigest = algorithm.digest();
			return messageDigest;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static final String toHex(byte[] hash) {
		if (hash == null) {
			return null;
		}
		StringBuffer buf = new StringBuffer(hash.length * 2);

		for (int i = 0; i < hash.length; ++i) {
			if ((hash[i] & 0xFF) < 16) {
				buf.append("0");
			}
			buf.append(Long.toString(hash[i] & 0xFF, 16));
		}
		return buf.toString();
	}

	/**
	 * 将金额转换为带2位小数的金额
	 * @param amtVal
	 * @return
	 */
	public static BigDecimal setAmt(BigDecimal amtVal) {
		if (null == amtVal) {
			amtVal = BigDecimal.ZERO;
		}
		return amtVal.setScale(BigDecimal.ROUND_CEILING);
	}

	/*
	 *奖金额转换为任意位数的小数
	 *
	 *
	 */

	public static BigDecimal setAmt(String amtVal,int length){
		BigDecimal bigDecimal;
		try {
			bigDecimal = new BigDecimal(amtVal.trim()).setScale(length,BigDecimal.ROUND_CEILING);
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
		return bigDecimal;
	}

	public static String getUserId(int flag){
		//用户ID的 生成规则
		//1001 + 年月日时分秒 + 随机码
		if (flag==0) {
			return "1001" + DateUtil.format(new Date(), DateUtil.DT_YYYYMMDDHHMMSS) + getUuidString().substring(0, 6);
		} else if(flag==1){
			return "2001" + DateUtil.format(new Date(), DateUtil.DT_YYYYMMDDHHMMSS) + getUuidString().substring(0, 6);
		}
		return null;
	}
	
}
