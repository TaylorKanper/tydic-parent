package com.tydic.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {
	
	public static final int SECONDS_IN_WEEK = 7 * 24 * 60 * 60;
	
	public static final int SECONDS_IN_DAY = 24 * 60 * 60;
	
	
	public static final String format_Simple_YYYYMMdd = "yyyyMMdd";

	//返回时间格式: 2014-09-21 12:23:21
	public static String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date= sdf.format(new Date(System.currentTimeMillis()));
		return date;
	}
	
	//返回时间格式: 2014-09-21 12:23:21
	public static String getFullDate(long second) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date= sdf.format(new Date(second * 1000));
		return date;
	}
	
	//返回时间格式: 2014-09-21 12:23
	public static String getDate(long seconds) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String date= sdf.format(new Date(seconds * 1000));
		return date;
	}
	
	//返回时间格式: 2014-09-21
	public static String getYearDate(long timeStamp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date= sdf.format(new Date(timeStamp * 1000));
		return date;
	}


	public static String getSlashYearDate(long timeStamp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String date= sdf.format(new Date(timeStamp * 1000));
		return date;
	}
	
	//返回时间格式: 12:00
	public static String getHourDate(long timeStamp) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String date= sdf.format(new Date(timeStamp * 1000));
		return date;
	}
	
	//返回时间格式 12.11
	public static String getMonthDate(long timeStamp) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM.dd");
		String date= sdf.format(new Date(timeStamp * 1000));
		return date;
	}
	
	//返回时间格式 12-11
	public static String getMonthDate1(long timeStamp) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String date= sdf.format(new Date(timeStamp * 1000));
		return date;
	}
	
	//判断某个时间戳是否属于当天
	public static boolean isToday(long seconds) {
		Date date2 = new Date();
		date2.setTime(seconds * 1000);
		return DateUtils.isSameDay(new Date(), date2);
	}
	
	//获取当前系统时间戳
	public static int currentTimeStamp() {
		return (int)(System.currentTimeMillis() / 1000);
	}
	
	//获取距某个时间倒计时小时
	public static int getCountDownHour(int beginTime) {
		int now = (int)(System.currentTimeMillis() / 1000);
	    return ((beginTime - now)) / (60 * 60);
	}
	
	//获取距某个时间的倒计时 (12:22:22)
	public static String getCountDownTime(int beginTime) {
		int now = (int)(System.currentTimeMillis() / 1000);
	    int daySeconds = 24 * 60 * 60;
	    int hour = ((beginTime - now)) / (60 * 60);
	    int minutes = (((beginTime - now) % daySeconds) % (60 * 60)) / 60;
	    int seconds = (((beginTime - now) % daySeconds) % (60 * 60)) % 60;
	    return hour + ":" + minutes + ":" + seconds;
	}
	
	//获得本周一0点时间
	public static int getTimesWeekmorning() { 
		Calendar cal = Calendar.getInstance(); 
		cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0,0); 
		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			cal.set(Calendar.WEEK_OF_MONTH, cal.get(Calendar.WEEK_OF_MONTH) - 1);
		}
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); 
		return (int) (cal.getTimeInMillis()/1000); 
	}
	
	public static int getTimesWeekmorning(int time) { 
		Calendar cal = Calendar.getInstance(); 
		cal.setTimeInMillis((long)time * 1000);
		cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0,0);
		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			cal.set(Calendar.WEEK_OF_MONTH, cal.get(Calendar.WEEK_OF_MONTH) - 1);
		}
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); 
		return (int) (cal.getTimeInMillis()/1000); 
	} 
	
	//获得本周日24点时间 
	public static int getTimesWeeknight() { 
		Calendar cal = Calendar.getInstance(); 
		cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0,0); 
		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			cal.set(Calendar.WEEK_OF_MONTH, cal.get(Calendar.WEEK_OF_MONTH) - 1);
		}
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); 
		return (int) ((cal.getTime().getTime()+ (7 * 24 * 60 * 60 * 1000))/1000); 
	} 
	
	public static int getTimesWeeknight(int time) { 
		Calendar cal = Calendar.getInstance(); 
		cal.setTimeInMillis((long)time * 1000);
		cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0,0); 
		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			cal.set(Calendar.WEEK_OF_MONTH, cal.get(Calendar.WEEK_OF_MONTH) - 1);
		}
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); 
		return (int) ((cal.getTime().getTime()+ (7 * 24 * 60 * 60 * 1000))/1000); 
	} 
	
	//获得当天0点时间 
	public static int getTimesmorning() { 
		Calendar cal = Calendar.getInstance(); 
		cal.set(Calendar.HOUR_OF_DAY, 0); 
		cal.set(Calendar.SECOND, 0); 
		cal.set(Calendar.MINUTE, 0); 
		cal.set(Calendar.MILLISECOND, 0); 
		return (int) (cal.getTimeInMillis()/1000); 
	} 
	
	public static int getTimesmorning(int nowTime) {
		Calendar cal = Calendar.getInstance(); 
		cal.setTimeInMillis((long)nowTime * 1000);
		cal.set(Calendar.HOUR_OF_DAY, 0); 
		cal.set(Calendar.SECOND, 0); 
		cal.set(Calendar.MINUTE, 0); 
		cal.set(Calendar.MILLISECOND, 0); 
		return (int) (cal.getTimeInMillis()/1000); 
	}
	
	//获得当天24点时间 
	public static int getTimesnight() { 
		Calendar cal = Calendar.getInstance(); 
		cal.set(Calendar.HOUR_OF_DAY, 24); 
		cal.set(Calendar.SECOND, 0); 
		cal.set(Calendar.MINUTE, 0); 
		cal.set(Calendar.MILLISECOND, 0); 
		return (int) (cal.getTimeInMillis()/1000); 
	}
	
	public static int getTimesnight(int nowTime) {
		Calendar cal = Calendar.getInstance(); 
		cal.setTimeInMillis((long)nowTime * 1000);
		cal.set(Calendar.HOUR_OF_DAY, 24); 
		cal.set(Calendar.SECOND, 0); 
		cal.set(Calendar.MINUTE, 0); 
		cal.set(Calendar.MILLISECOND, 0); 
		return (int) (cal.getTimeInMillis()/1000); 
	}
	
	//获得本月第一天0点时间 
	public static int getTimesMonthmorning() { 
		Calendar cal = Calendar.getInstance(); 
		cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0,0);
		cal.set(Calendar.DAY_OF_MONTH,cal.getActualMinimum(Calendar.DAY_OF_MONTH)); 
		return (int) (cal.getTimeInMillis()/1000); 
	} 

	//获得本月最后一天24点时间 
	public static int getTimesMonthnight() { 
		Calendar cal = Calendar.getInstance(); 
		cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0,0);
		cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DAY_OF_MONTH)); 
		cal.set(Calendar.HOUR_OF_DAY, 24); 
		return (int) (cal.getTimeInMillis()/1000); 
	}
	
	// time1和time2是否在同一天
	public static boolean isInOneDay(Calendar cal1, Calendar cal2) {
		if (cal1.get(Calendar.YEAR) != cal2.get(Calendar.YEAR)) {
			return false;
		}
		return cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
	}
	
	public static String getBetweenTime(int beginTime, int endTime) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTimeInMillis((long)beginTime * 1000);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTimeInMillis((long)endTime * 1000);
		int year1 = cal1.get(Calendar.YEAR);
		int month1 = cal1.get(Calendar.MONTH) + 1;
		int day1 = cal1.get(Calendar.DAY_OF_MONTH);
		int hours1 = cal1.get(Calendar.HOUR_OF_DAY);
		int minute1 = cal1.get(Calendar.MINUTE);
		int year2 = cal2.get(Calendar.YEAR);
		int month2 = cal2.get(Calendar.MONTH) + 1;
		int day2 = cal2.get(Calendar.DAY_OF_MONTH);
		int hours2 = cal2.get(Calendar.HOUR_OF_DAY);
		int minute2 = cal2.get(Calendar.MINUTE);
		StringBuilder sb = new StringBuilder();
		if (year1 == year2 && month1 == month2 && day1 == day2) {
			sb.append(year1).append("-").append(month1 < 10 ? "0" + month1 : month1).append("-").append(day1 < 10 ? "0" + day1 : day1).append("\r\n")
				.append(hours1 < 10 ? "0" + hours1 : hours1).append(":").append(minute1 < 10 ? "0" + minute1 : minute1).append("-")
				.append(hours2 < 10 ? "0" + hours2 : hours2).append(":").append(minute2 < 10 ? "0" + minute2 : minute2);
		} else {
			sb.append(year1).append("-").append(month1 < 10 ? "0" + month1 : month1).append("-").append(day1 < 10 ? "0" + day1 : day1).append(" ")
				.append(hours1 < 10 ? "0" + hours1 : hours1).append(":").append(minute1 < 10 ? "0" + minute1 : minute1)
				.append("\r\n").append("至 ")
				.append(year2).append("-").append(month2 < 10 ? "0" + month2 : month2).append("-").append(day2 < 10 ? "0" + day2 : day2).append(" ")
				.append(hours2 < 10 ? "0" + hours2 : hours2).append(":").append(minute2 < 10 ? "0" + minute2 : minute2);
		}
		return sb.toString();
	}

	//根据时间获取星期，0为星期日
	public static int getWeek(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK)-1;
	}


	//传入格式  9:00  16:30
	public static int getStrToDayTime(String timeStr)
	{
		int toDayTime = 0;
		if(null!=timeStr)
		{
			String[] tr = timeStr.split(":");
			if(tr.length==2){
				toDayTime = DateUtil.getTimeIntByHourMinute(tr[0],tr[1]);
				return toDayTime;
			}
		}
		return 0;
	}

	public static int getTimeIntByHourMinute(String hour,String minute){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour));
		cal.set(Calendar.MINUTE, Integer.parseInt(minute));
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.SECOND,0);
		return (int) (cal.getTimeInMillis()/1000);
	}

	/**
	 * 判断当前日期是否在开始和结束日期之间
	 *  beginDate 与endDate 格式  yyyy-MM-dd HH:mm
	 */
	public static boolean getNowInBegEndMidDate(int beginDate,int endDate,int now){
		return beginDate < now && now < endDate;
	}

	//返回时间格式: 2014-09-21
	public static String getCurrentDateYMD() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date= sdf.format(new Date(System.currentTimeMillis()));
		return date;
	}
	
	public static String getYesterdayYMD() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_YEAR, cal.get(Calendar.DAY_OF_YEAR) - 1);
		Date date = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	/**
	 * 将毫秒转换成 月-日
	 * @param millis 毫秒时间
	 * @return
     */
	public static String getMonthAndDay(long millis) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(millis);
		return (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DAY_OF_MONTH) + "日";
	}
	
	public static int getDaysFromUTCZero() {
		return (currentTimeStamp() - getDeviationFromUtcSeconds()) / 3600 / 24;
	}

	public static int getDeviationFromUtcSeconds() {
		// 专业踩坑20年，请注意，有可能机器的时区不是上海，而是重庆，重庆时区请小心，PRC成立以前算东7区，不是东8区
		// 所以获取PRC成立以前的时间的时候请考虑时区是否正确
		Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai"));
		c.set(1970, Calendar.JANUARY, 1, 0, 0, 0);
		c.set(Calendar.MILLISECOND, 0);
		return (int) (c.getTime().getTime() / 1000);
	}

	/**
	 * 将毫秒转换为格式化时间，获取时分秒
	 * @param millis 毫秒时间
	 * @return
	 */
	public static long getBuyGoodsTime(long millis) {
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmssSSS");
		String date= sdf.format(new Date(millis));
		return Long.parseLong(date);
	}

	public static String getMillsTime(long millis) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return sdf.format(new Date(millis));
	}


	public static int getIntTimeByString(String timeStr,String format) {
		int time = 0;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Date date = sdf.parse(timeStr);
			time = new Long(date.getTime()/1000).intValue();
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		return time;
	}

	/**
	 * string装int的时间
	 * @param timeStr
	 * @return
     */
	public static long getIntTimeByString(String timeStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = sdf.parse(timeStr);
			 return date.getTime()/1000;
		}
		catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 支持格式yyyy-MM-dd HH:mm:ss 与 yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static Date Str2Date(String date){
		if(StringUtils.isBlank(date)){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return  sdf.parse(date);
		}catch (Exception e){
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				return sdf.parse(date);
			} catch (ParseException e1) {
				e1.printStackTrace();
				return null;
			}
		}
	}
	
	
	
	/**
	 * 支持格式yyyy-MM-dd HH:mm:ss 与 yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static Date Str2Date(String date,String format){
		if(StringUtils.isBlank(date) || StringUtils.isBlank(format)){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return  sdf.parse(date);
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static Date Str2DateAfterDay(String date){
   	 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(StringUtils.isBlank(date)){
			return null;
		}
		try {
			Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(date));
            c.set(Calendar.HOUR_OF_DAY, 23);
            c.set(Calendar.MINUTE, 59);
            c.set(Calendar.SECOND, 59);
            c.set(Calendar.MILLISECOND, 999);
			System.out.println(sdf1.format(c.getTime()));
			return  c.getTime();
		}catch (Exception e){
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Calendar c = Calendar.getInstance();
	            c.setTime(sdf.parse(date));
	            c.set(Calendar.HOUR_OF_DAY, 23);
	            c.set(Calendar.MINUTE, 59);
	            c.set(Calendar.SECOND, 59);
	            c.set(Calendar.MILLISECOND, 999);
				System.out.println(sdf1.format(c.getTime()));
				return  c.getTime();
			} catch (ParseException e1) {
				e1.printStackTrace();
				return null;
			}
		}
	}
	/**
	 *
	 * @param date
	 * @return
     */
	public static int date2Integer(Date date){
		if(date==null){
			return 0;
		}
		return (int) (date.getTime()/1000);
	}

	/**
	 * 获取一个时间的 前几天或者后几天
	 * @param currentDate
	 * @param nextDay
     * @return
     */
	public static String getNextDate(String currentDate,Integer nextDay){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse(currentDate);
			Long nextDateInt= (date.getTime()/1000)+nextDay*24*60*60;
			return getYearDate(nextDateInt);
		}
		catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * int 转时间
	 * @param intDate
	 * @return
     */
	public static Date int2date(Integer intDate){
		Date date=new Date(intDate*1000l);
		return date;
	}

	//返回时间格式: 2014-09-21
	public static String getFullYearDate(long timeStamp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String date= sdf.format(new Date(timeStamp * 1000));
		return date;
	}

	public static String date2string(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  sdf.format(date);
	}

	/**
	 * 获得当前的时间戳
	 * @return
     */
	public static Integer getCurrentTimeInt(){
		return (int)(System.currentTimeMillis()/1000);
	}

}
