package com.adver.tran.common.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author lgf
 *
 */
public class NumberUtils {

	public static String fortmatDouble2(double src, String formatP) {
		if (StringUtils.isEmpty(formatP)) {
			formatP = "##0.00";
		}
		BigDecimal bd = new BigDecimal(src);
		DecimalFormat mformat = new DecimalFormat(formatP);
		return mformat.format(bd.doubleValue());
	}
	
	public static String fortmat(BigDecimal src, String formatP) {
		if (StringUtils.isEmpty(formatP)) {
			formatP = "##0.00";
		}
		if(src == null){
			src = BigDecimal.ZERO;
		}
		DecimalFormat mformat = new DecimalFormat(formatP);
		return mformat.format(src.doubleValue());
	}
	
	public static BigDecimal fortmat(BigDecimal src) {
		if(src == null){
			return BigDecimal.ZERO;
		}
		return BigDecimal.valueOf(Double.valueOf(fortmat(src, null)));
	}
	
	public static Integer getInteger(String src) {
		if(src == null||"".equals(src.trim())){
			return null;
		}
		return Integer.valueOf(src);
	}
	
	public static Double getDouble(String src) {
		if(src == null||"".equals(src.trim())){
			return null;
		}
		return Double.valueOf(src);
	}
	
	public static String getFloating(String src , double fl) {
		if(src == null||"".equals(src.trim())){
			return null;
		}		
		Integer it = Integer.valueOf(src);
		Integer base = (it.intValue() / 100) * 100;
		Integer mbase = (int) (base+(base * fl));		
		return base + "~" + mbase;
	}
	
	public static void main(String[] args){
		BigDecimal bg = new BigDecimal("300.000000");
		String ss = NumberUtils.fortmat(bg, null);
		System.out.println(ss);
		System.out.println(NumberUtils.fortmat(bg));
		
		bg = new BigDecimal("500.000000");
		ss = NumberUtils.fortmat(bg, null);
		System.out.println(ss);
		System.out.println(NumberUtils.fortmat(bg,"#0.00"));
		
		bg = new BigDecimal("0");
		System.out.println(bg);
		ss = NumberUtils.fortmat(bg, null);
		System.out.println(ss);
		System.out.println(NumberUtils.fortmat(bg));
		
		bg = new BigDecimal("0.00");
		System.out.println(bg);
		ss = NumberUtils.fortmat(bg, null);
		System.out.println(ss);
		System.out.println(NumberUtils.fortmat(bg));
		
		System.out.println(getFloating("3218", 0.1));
		
	}
}
