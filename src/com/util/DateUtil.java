package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.log4j.Logger;

import com.sun.org.apache.bcel.internal.generic.NEW;

import javafx.scene.chart.PieChart.Data;
import oracle.net.aso.d;

/**
 * 日期工具
 * 
 * @author QingLong
 */
public class DateUtil {

	Logger logger = Logger.getLogger(DateUtil.class);

	public final static String dd = "dd";
	public final static String MM = "MM";
	public final static String MMdd = "MMdd";
	public final static String yyyy = "yyyy";
	public final static String yyyy_M_d = "yyyy-M-d";
	public final static String yyyy_MM_dd = "yyyy-MM-dd";
	public final static String yyyyMMdd = "yyyyMMdd";
	public final static String yyyyMM = "yyyyMM";
	public final static String HH_mm_ss = "HH:mm:ss";
	public final static String yyyyMMddHHmmss = "yyyyMMddHHmmss";
	public final static String yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
	public final static String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
	public final static String yyyy_年_MM_月_dd_日 = "yyyy年MM月dd日";
	public final static String yyyy_年_MM_月_dd_日_HH_mm_ss = "yyyy年MM月dd日 HH:mm:ss";
	public final static String yyyy_年_M_月_d_日 = "yyyy年M月d日";
	public final static String yyyy_年_M_月_d_日_HH_mm_ss = "yyyy年M月d日 HH:mm:ss";

	/**
	 * 返回指定格式日期
	 * 
	 * @param format
	 * @return
	 */
	public static String getDate(String format) {
		return DateFormatUtils.format(new Date(), format);
	}

	/**
	 * 返回日期类型日期
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static Date toDate(String date) throws Exception {
		SimpleDateFormat simpledate = null;
		if (!date.contains(":")) {
			simpledate = new SimpleDateFormat(yyyy_MM_dd);
		} else {
			simpledate = new SimpleDateFormat(yyyyMMddHHmmss);
		}
		Date d = null;
		try {
			d = simpledate.parse(date);
		} catch (ParseException ex) {
			throw new Exception("日期格式不符合要求：" + ex.getMessage(), ex);
		}
		return d;
	}

	/**
	 * 返回日期类型日期
	 * 
	 * @param dateTime
	 * @param format
	 * @return
	 * @throws Exception
	 */
	public static Date toDate(String date, String format) throws Exception {
		SimpleDateFormat simpledate = new SimpleDateFormat(format);
		Date d = null;
		try {
			d = simpledate.parse(format);
		} catch (ParseException ex) {
			throw new Exception("日期格式不符合要求：" + ex.getMessage(), ex);
		}
		return d;
	}

	/**
	 * 返回日期相差天数
	 * 
	 * @param ksrq
	 * @param jsrq
	 * @param rqgs
	 * @return
	 * @throws Exception
	 */
	public static int getSubtractDay(String ksrq, String jsrq, String rqgs) throws Exception {
		if (StringUtils.isBlank(rqgs)) {
			rqgs = yyyy_MM_dd;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(rqgs);
		Date newPrevDate = null;
		try {
			newPrevDate = sdf.parse(ksrq);
		} catch (ParseException ex) {
			throw new Exception("日期格式不符合要求：" + ex.getMessage(), ex);
		}
		Date newNextDate = null;
		try {
			newNextDate = sdf.parse(jsrq);
		} catch (ParseException ex) {
			throw new Exception("日期格式不符合要求：" + ex.getMessage(), ex);
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(newPrevDate);
		long ks = calendar.getTimeInMillis();
		calendar.setTime(newNextDate);
		long js = calendar.getTimeInMillis();
		return (int) (Math.ceil((double) (js - ks) / (24 * 60 * 60 * 1000)));
	}

	/**
	 * 返回日期相差秒数
	 * 
	 * @param kssj
	 * @param jssj
	 * @param rqgs
	 * @return
	 * @throws Exception
	 */
	public static int getSubtractSec(String kssj, String jssj, String rqgs) throws Exception {
		if (StringUtils.isBlank(rqgs)) {
			rqgs = yyyy_MM_dd_HH_mm_ss;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(rqgs);
		Date d1 = null;
		try {
			d1 = sdf.parse(kssj);
		} catch (ParseException ex) {
			throw new Exception("日期格式不符合要求：" + ex.getMessage(), ex);
		}
		Date d2 = null;
		try {
			d2 = sdf.parse(jssj);
		} catch (ParseException ex) {
			throw new Exception("日期格式不符合要求：" + ex.getMessage(), ex);
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d1);
		long ks = calendar.getTimeInMillis();
		calendar.setTime(d2);
		long js = calendar.getTimeInMillis();
		return (int) (Math.ceil((double) (js - ks) / (1000)));
	}

	/**
	 * 返回上一年
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static String getPreviousYear(String date) throws Exception {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat simpledate = new SimpleDateFormat(yyyy);
		Date d = null;
		try {
			d = simpledate.parse(date);
		} catch (ParseException ex) {
			throw new Exception("日期格式不符合要求：" + ex.getMessage(), ex);
		}
		now.setTime(d);
		now.add(Calendar.YEAR, -1);
		String time = simpledate.format(now.getTime());
		return time;
	}

	/**
	 * 返回下一年
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static String getNextYear(String date) throws Exception {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat simpledate = new SimpleDateFormat(yyyy);
		Date d = null;
		try {
			d = simpledate.parse(date);
		} catch (ParseException ex) {
			throw new Exception("日期格式不符合要求：" + ex.getMessage(), ex);
		}
		now.setTime(d);
		now.add(Calendar.YEAR, 1);
		String time = simpledate.format(now.getTime());
		return time;
	}

	/**
	 * 返回上一个月
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static String getPreviousMonth(String date) throws Exception {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat simpledate = new SimpleDateFormat(yyyy_MM_dd);
		Date d = null;
		try {
			d = simpledate.parse(date);
		} catch (ParseException ex) {
			throw new Exception("日期格式不符合要求：" + ex.getMessage(), ex);
		}
		now.setTime(d);
		now.add(Calendar.MONTH, -1);
		String time = simpledate.format(now.getTime());
		return time;
	}

	/**
	 * 返回下一个月
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static String getNextMonth(String date) throws Exception {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat simpledate = new SimpleDateFormat(yyyy_MM_dd);
		Date d = null;
		try {
			d = simpledate.parse(date);
		} catch (ParseException ex) {
			throw new Exception("日期格式不符合要求：" + ex.getMessage(), ex);
		}
		now.setTime(d);
		now.add(Calendar.MONTH, 1);
		String time = simpledate.format(now.getTime());
		return time;
	}

	/**
	 * 返回上一天
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static String getPreviousDate(String date) throws Exception {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat simpledate = new SimpleDateFormat(yyyy_MM_dd);
		Date d = null;
		try {
			d = simpledate.parse(date);
		} catch (ParseException ex) {
			throw new Exception("日期格式不符合要求：" + ex.getMessage(), ex);
		}
		now.setTime(d);
		now.add(Calendar.DATE, -1);
		String time = simpledate.format(now.getTime());
		return time;
	}

	/**
	 * 返回下一天
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static String getNextDate(String date) throws Exception {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat simpledate = new SimpleDateFormat(yyyy_MM_dd);
		Date d = null;
		try {
			d = simpledate.parse(date);
		} catch (ParseException ex) {
			throw new Exception("日期格式不符合要求：" + ex.getMessage(), ex);
		}
		now.setTime(d);
		now.add(Calendar.DATE, 1);
		String time = simpledate.format(now.getTime());
		return time;
	}

	/**
	 * 返回指定天数前日期
	 * 
	 * @param days
	 * @return
	 * @throws Exception
	 */
	public static String getPreviousDate(int days) throws Exception {
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DATE, -days);
		String time = new SimpleDateFormat(yyyy_MM_dd).format(now.getTime());
		return time;
	}

	/**
	 * 返回指定天数前日期
	 * 
	 * @param date
	 * @param days
	 * @return
	 * @throws Exception
	 */
	public static String getPreviousDate(String date, int days) throws Exception {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat simpledate = new SimpleDateFormat(yyyy_MM_dd);
		Date d = null;
		try {
			d = simpledate.parse(date);
		} catch (ParseException ex) {
			throw new Exception("日期格式不符合要求：" + ex.getMessage(), ex);
		}
		now.setTime(d);
		now.add(Calendar.DATE, -days);
		String time = simpledate.format(now.getTime());
		return time;
	}

	/**
	 * 返回指定天数后日期
	 * 
	 * @param days
	 * @return
	 * @throws Exception
	 */
	public static String getNextDate(int days) throws Exception {
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DATE, days);
		String time = new SimpleDateFormat(yyyy_MM_dd).format(now.getTime());
		return time;
	}

	/**
	 * 返回指定天数后日期
	 * 
	 * @param date
	 * @param days
	 * @return
	 * @throws Exception
	 */
	public static String getNextDate(String date, int days) throws Exception {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat simpledate = new SimpleDateFormat(yyyy_MM_dd);
		Date d = null;
		try {
			d = simpledate.parse(date);
		} catch (ParseException ex) {
			throw new Exception("日期格式不符合要求：" + ex.getMessage(), ex);
		}
		now.setTime(d);
		now.add(Calendar.DATE, days);
		String time = simpledate.format(now.getTime());
		return time;
	}

	/**
	 * 获取当前时间
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getNowDate() throws Exception {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(yyyy_MM_dd_HH_mm_ss);
		return simpleDateFormat.format(new Date());
	}

	/**
	 * 获取当前时间
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getHourStartTime() throws Exception {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:00:00");
		return simpleDateFormat.format(new Date());
	}

	/**
	 * 获取当天开始时间
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getDayStartTime() throws Exception {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		return simpleDateFormat.format(new Date());
	}

	/**
	 * 返回周一
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getWeekStartTime() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		return simpleDateFormat.format(calendar.getTime());
	}

	/**
	 * 返回1号
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getMonthStartTime() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		return simpleDateFormat.format(calendar.getTime());
	}

	/**
	 * 返回1月1号
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getYearStartTime() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		return simpleDateFormat.format(calendar.getTime());
	}
	
	
	/**
	 * 返回当前季度的第一天
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getQuarterStartTime() throws Exception {
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH);
		month = month/3*3;
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		return simpleDateFormat.format(calendar.getTime());
	}
	
	
	
	public static void main(String[] args) {
		try {
			System.out.println("当前时间："+getNowDate());
			System.out.println("每小时的开始时间："+getHourStartTime());
			System.out.println("每天的开始时间："+getDayStartTime());
			System.out.println("每月的开始时间："+getMonthStartTime());
			System.out.println("每季度的开始时间："+getQuarterStartTime());
			System.out.println("每年的开始时间："+getYearStartTime());
			System.out.println("比较时间:"+compareTime(getMonthStartTime(),getNowDate(),yyyy_MM_dd_HH_mm_ss));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static boolean compareTime(String time1,String time2,String fromat){
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(fromat);
			Date data1 = simpleDateFormat.parse(time1);
			Date date2 = simpleDateFormat.parse(time2);
			return data1.getTime()>date2.getTime();
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 是否已超时
	 * @param str yyyy-MM-dd HH：mm：ss 格式的时间字符串
	 * @return
	 * @throws Exception
	 */
	public static boolean isOverTime(String str) throws Exception {
		return compareTime(getNowDate(),str,yyyy_MM_dd_HH_mm_ss);
	}
}