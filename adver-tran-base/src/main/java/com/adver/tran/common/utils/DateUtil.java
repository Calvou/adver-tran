package com.adver.tran.common.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class DateUtil {
	public static final String D_YYYYMMDD = "yyyyMMdd";
	public static final String T_HHMMSS = "HHmmss";
	public static final String T_HHMMSSSSS = "HHmmssSSS";
	public static final String DT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public static final String DT_YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";

	private static Calendar gregorianCalendar = null;

	// 默认日期格式
	public static final String DATE_DEFAULT_FORMAT = "yyyy-MM-dd";
	// 默认时间格式
	public static final String DATETIME_DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String TIME_DEFAULT_FORMAT = "HH:mm:ss";
	// 日期格式化
	private static DateFormat dateFormatC = null;
	// 时间格式化
	private static DateFormat dateTimeFormatC = null;
	private static DateFormat timeFormatC = null;	
	
	static {
		dateFormatC = new SimpleDateFormat(DATE_DEFAULT_FORMAT);
		dateTimeFormatC = new SimpleDateFormat(DATETIME_DEFAULT_FORMAT);
		timeFormatC = new SimpleDateFormat(TIME_DEFAULT_FORMAT);
		gregorianCalendar = new GregorianCalendar();
	}

	/**
	 * 将一个字符串转换成日期格式
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static Date toDate(String date, String pattern) {
		if (("" + date).equals("")) {
			return null;
		}
		if (pattern == null) {
			pattern = "yyyy-MM-dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date newDate = new Date();
		try {
			newDate = sdf.parse(date);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return newDate;
	}

	/**
	 * 把日期转换成字符串型
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String toString(Date date, String pattern) {
		if (date == null) {
			return "";
		}
		if (pattern == null) {
			pattern = "yyyy-MM-dd";
		}
		String dateString = "";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			dateString = sdf.format(date);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dateString;
	}

	/**
	 * 时间戳转换为指定格式的时间字符串
	 * 
	 * @param stamp
	 * @param pattern
	 * @return
	 * @author wb-wanghao
	 */
	public static String timeStampToString(Timestamp stamp, String pattern) {
		if (stamp == null) {
			return "";
		}
		if (pattern == null) {
			pattern = "yyyy-MM-dd";
		}
		String dateString = "";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			dateString = sdf.format(stamp);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dateString;
	}

	/*
	 * public static void main(String[] args) { Timestamp stamp = new
	 * Timestamp(1500480000000L); String timeStampToString =
	 * timeStampToString(stamp, "yyyyMMddHHmmss");
	 * System.out.println(timeStampToString); }
	 */
	/**
	 * 获取上个月的开始结束时间
	 * 
	 * @return
	 */
	public static String[] getLastMonth() {
		// 取得系统当前时间
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;

		// 取得系统当前时间所在月第一天时间对象
		cal.set(Calendar.DAY_OF_MONTH, 1);

		// 日期减一,取得上月最后一天时间对象
		cal.add(Calendar.DAY_OF_MONTH, -1);

		// 输出上月最后一天日期
		int day = cal.get(Calendar.DAY_OF_MONTH);

		String months = "";
		String days = "";

		if (month > 1) {
			month--;
		} else {
			year--;
			month = 12;
		}
		if (!(String.valueOf(month).length() > 1)) {
			months = "0" + month;
		} else {
			months = String.valueOf(month);
		}
		if (!(String.valueOf(day).length() > 1)) {
			days = "0" + day;
		} else {
			days = String.valueOf(day);
		}
		String firstDay = "" + year + "-" + months + "-01";
		String lastDay = "" + year + "-" + months + "-" + days;

		String[] lastMonth = new String[2];
		lastMonth[0] = firstDay;
		lastMonth[1] = lastDay;

		// System.out.println(lastMonth[0] + "||" + lastMonth[1]);
		return lastMonth;
	}

	/**
	 * 获取当月的开始结束时间
	 * 
	 * @return
	 */
	public static String[] getCurrentMonth() {
		// 取得系统当前时间
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;

		// 取得系统当前时间所在月第一天时间对象
		cal.set(Calendar.DAY_OF_MONTH, 1);

		// 日期减一,取得上月最后一天时间对象
		cal.add(Calendar.DAY_OF_MONTH, -1);

		// 输出上月最后一天日期
		int day = cal.get(Calendar.DAY_OF_MONTH);

		String months = "";
		String days = "";

		if (!(String.valueOf(month).length() > 1)) {
			months = "0" + month;
		} else {
			months = String.valueOf(month);
		}
		if (!(String.valueOf(day).length() > 1)) {
			days = "0" + day;
		} else {
			days = String.valueOf(day);
		}
		String firstDay = "" + year + "-" + months + "-01";
		String lastDay = "" + year + "-" + months + "-" + days;

		String[] currentMonth = new String[2];
		currentMonth[0] = firstDay;
		currentMonth[1] = lastDay;

		// System.out.println(lastMonth[0] + "||" + lastMonth[1]);
		return currentMonth;
	}

	public static int getDateline() {

		return (int) (System.currentTimeMillis() / 1000);
	}

	public static int getDateline(String date) {
		return (int) (toDate(date, "yyyy-MM-dd").getTime() / 1000);
	}

	// lzf 经测，int最大值反应到日期上为2038-01-19，故补充以下两个方法
	public static long getDatelineLong() {

		return (long) (System.currentTimeMillis() / 1000);
	}

	// 计算还有多长时间限时抢购结束
	public static String getStartTime(Date StartTime) {
		String timeStr = "";
		Date now;
		now = new Date();
		Date date = StartTime;
		long l = date.getTime() - now.getTime();
		long day = l / (24 * 60 * 60 * 1000);
		long hour = (l / (60 * 60 * 1000) - day * 24);
		long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		if (day > 0) {
			if (day > 999) {
				timeStr = "999天";
			} else {
				timeStr = day + "天";
			}
		} else if (hour > 0) {
			timeStr = hour + "小时";
		} else if (min > 0) {
			timeStr = min + "分钟";
		} else if (s > 0) {
			timeStr = "刚刚";
		}
		if (null == timeStr || "".equals(timeStr)) {
			return "已过期";
		} else {
			if (timeStr.indexOf("刚刚") != -1) {
				return "抢购即将开始";
			} else {
				return "还有" + timeStr + "结束";
			}
		}
	}

	public static long getDatelineLong(String date) {
		return (long) (toDate(date, "yyyy-MM-dd").getTime() / 1000);
	}

	public static String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(date);
	}

	public static String getCurrentYMonth() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String mon = sdf.format(date);
		return mon.substring(0, 6);
	}

	public static String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(DT_YYYYMMDDHHMMSS);
		return sdf.format(date);
	}

	public static Date parseDate(String time, String partten) {
		if (time == null) {
			return null;
		}
		if (partten == null) {
			partten = "yyyy-MM-dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(partten, Locale.US);
		Date date = null;
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;

	}

	/**
	 * 线程时间存储
	 */
	private static ThreadLocal<Map<String, SimpleDateFormat>> dateFormat = new ThreadLocal<Map<String, SimpleDateFormat>>() {
		@Override
		protected Map<String, SimpleDateFormat> initialValue() {
			return new HashMap<String, SimpleDateFormat>();
		}
	};

	private static SimpleDateFormat getDateFormat(final String pattern) {
		Map<String, SimpleDateFormat> local = dateFormat.get();
		SimpleDateFormat sdf = local.get(pattern);
		if (null == sdf) {
			sdf = new SimpleDateFormat(pattern);
			local.put(pattern, sdf);
		}
		return sdf;
	}

	/**
	 * 将时间类型转为字符串
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String format(Date date, String pattern) {
		if (null == date) {
			return null;
		}
		if (CheckParam.isNull(pattern)) {
			pattern = "yyyy-MM-dd";
		}
		return getDateFormat(pattern).format(date);
	}

	// 格式化显示的时间
	public static String formatYh24ms(Date date) {
		if (null != date) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return format.format(date);
		} else {
			return null;
		}
	}

	/**
	 * 将时间类型转为字符串
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static Date parseByTimeZone(String dateStr, String pattern, String timeZone) throws ParseException {
		if (CheckParam.isNull(dateStr)) {
			return null;
		}
		if (CheckParam.isNull(pattern)) {
			pattern = "yyyy-MM-dd";
		}

		TimeZone cdtTime = TimeZone.getTimeZone(timeZone);
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setTimeZone(cdtTime);

		return sdf.parse(dateStr);
	}

	/**
	 * 将字符串时间转为时间
	 * 
	 * @param dateStr
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String dateStr, String pattern) throws ParseException {
		if (CheckParam.isNull(dateStr)) {
			return null;
		}
		if (CheckParam.isNull(pattern)) {
			pattern = "yyyy-MM-dd";
		}
		return getDateFormat(pattern).parse(dateStr);
	}

	/**
	 * date与compareDate比较，如果date<=compareDate则返回true，否则返回false
	 * 
	 * @param date
	 * @param compareDate
	 * @param seconds
	 * @return
	 */
	public static boolean isAfterDate(long date, long compareDate, int seconds) {
		return date + seconds * 1000 <= compareDate;
	}

	/**
	 * date与compareDate比较，如果date<=compareDate则返回true，否则返回false
	 * 
	 * @param date
	 * @param seconds
	 * @return
	 */
	public static boolean isAfterDate(long date, int seconds) {
		return isAfterDate(date, new Date().getTime(), seconds);
	}

	/**
	 * 
	 * @param date1
	 *            <String>
	 * @param date2
	 *            <String>
	 * @return int
	 * @throws ParseException
	 */
	public static int getMonthSpace(String begindate, String enddate) throws ParseException {
		int result = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(sdf.parse(begindate));
		c2.setTime(sdf.parse(enddate));
		result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
		System.out.println(result);
		return result == 0 ? 1 : Math.abs(result);
	}

	/**
	 * 
	 * @param date1
	 *            <String>
	 * @param date2
	 *            <String>
	 * @return int
	 * @throws ParseException
	 */
	public static int getMonthSpace(Date begindate, Date enddate) {
		int result = 0;
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(begindate);
		c2.setTime(enddate);
		result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
		System.out.println(result);
		return result == 0 ? 1 : Math.abs(result);
	}

	public static Date addDateDay(Date date, int dd) {
		if (null == date) {
			return date;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date); // 设置当前日期
		c.add(Calendar.DATE, dd); // 日期加1天
		date = c.getTime();
		return date;
	}

	public static Date addDateMonth(Date date, int dd) {
		if (null == date) {
			return date;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date); // 设置当前日期
		c.add(Calendar.MONTH, dd); // 日期加1月
		date = c.getTime();
		return date;
	}

	/**
	 * 获取当前日期星期一日期
	 * 
	 * @return date
	 */
	public static Date getFirstDayOfWeek() {
		gregorianCalendar.setFirstDayOfWeek(Calendar.MONDAY);
		gregorianCalendar.setTime(new Date());
		gregorianCalendar.set(Calendar.DAY_OF_WEEK, gregorianCalendar.getFirstDayOfWeek()); // Monday
		return gregorianCalendar.getTime();
	}

	/**
	 * 获取当前日期星期日日期
	 * 
	 * @return date
	 */
	public static Date getLastDayOfWeek() {
		gregorianCalendar.setFirstDayOfWeek(Calendar.MONDAY);
		gregorianCalendar.setTime(new Date());
		gregorianCalendar.set(Calendar.DAY_OF_WEEK, gregorianCalendar.getFirstDayOfWeek() + 6); // Monday
		return gregorianCalendar.getTime();
	}

	/**
	 * 获取日期星期一日期
	 * 
	 * @param 指定日期
	 * @return date
	 */
	public static Date getFirstDayOfWeek(Date date) {
		if (date == null) {
			return null;
		}
		gregorianCalendar.setFirstDayOfWeek(Calendar.MONDAY);
		gregorianCalendar.setTime(date);
		gregorianCalendar.set(Calendar.DAY_OF_WEEK, gregorianCalendar.getFirstDayOfWeek()); // Monday
		return gregorianCalendar.getTime();
	}

	/**
	 * 获取日期星期一日期
	 * 
	 * @param 指定日期
	 * @return date
	 */
	public static Date getLastDayOfWeek(Date date) {
		if (date == null) {
			return null;
		}
		gregorianCalendar.setFirstDayOfWeek(Calendar.MONDAY);
		gregorianCalendar.setTime(date);
		gregorianCalendar.set(Calendar.DAY_OF_WEEK, gregorianCalendar.getFirstDayOfWeek() + 6); // Monday
		return gregorianCalendar.getTime();
	}

	/**
	 * 获取当前月的第一天
	 * 
	 * @return date
	 */
	public static Date getFirstDayOfMonth() {
		gregorianCalendar.setTime(new Date());
		gregorianCalendar.set(Calendar.DAY_OF_MONTH, 1);
		return gregorianCalendar.getTime();
	}

	/**
	 * 获取当前月的最后一天
	 * 
	 * @return
	 */
	public static Date getLastDayOfMonth() {
		gregorianCalendar.setTime(new Date());
		gregorianCalendar.set(Calendar.DAY_OF_MONTH, 1);
		gregorianCalendar.add(Calendar.MONTH, 1);
		gregorianCalendar.add(Calendar.DAY_OF_MONTH, -1);
		return gregorianCalendar.getTime();
	}

	/**
	 * 获取指定月的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfMonth(Date date) {
		gregorianCalendar.setTime(date);
		gregorianCalendar.set(Calendar.DAY_OF_MONTH, 1);
		return gregorianCalendar.getTime();
	}

	/**
	 * 获取指定月的最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfMonth(Date date) {
		gregorianCalendar.setTime(date);
		gregorianCalendar.set(Calendar.DAY_OF_MONTH, 1);
		gregorianCalendar.add(Calendar.MONTH, 1);
		gregorianCalendar.add(Calendar.DAY_OF_MONTH, -1);
		return gregorianCalendar.getTime();
	}

	/**
	 * 获取日期前一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDayBefore(Date date) {
		gregorianCalendar.setTime(date);
		int day = gregorianCalendar.get(Calendar.DATE);
		gregorianCalendar.set(Calendar.DATE, day - 1);
		return gregorianCalendar.getTime();
	}

	/**
	 * 获取日期后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDayAfter(Date date) {
		gregorianCalendar.setTime(date);
		int day = gregorianCalendar.get(Calendar.DATE);
		gregorianCalendar.set(Calendar.DATE, day + 1);
		return gregorianCalendar.getTime();
	}

	/**
	 * 获取当前年
	 * 
	 * @return
	 */
	public static int getNowYear() {
		Calendar d = Calendar.getInstance();
		return d.get(Calendar.YEAR);
	}

	/**
	 * 获取当前月份
	 * 
	 * @return
	 */
	public static int getNowMonth() {
		Calendar d = Calendar.getInstance();
		return d.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获取当月天数
	 * 
	 * @return
	 */
	public static int getNowMonthDay() {
		Calendar d = Calendar.getInstance();
		return d.getActualMaximum(Calendar.DATE);
	}

	/**
	 * 获取提前多少个月
	 * 
	 * @param monty
	 * @return
	 */
	public static Date getFirstMonth(int monty) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -monty);
		return c.getTime();
	}

	public static void main(String[] args) throws ParseException {
		System.out.println(getMonthSpace("2017-11-21", "2017-10-28"));
		System.out.println(addDateDay(new Date(),1));
	}

}
