package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class IDCardUtil {
	
	private static final Map<String, String> CITYINFO_MAP = new HashMap<String, String>() {
		private static final long serialVersionUID = -5950529569797711060L;
		{
            this.put("11", "北京");
            this.put("12", "天津");
            this.put("13", "河北");
            this.put("14", "山西");
            this.put("15", "内蒙古");
            this.put("21", "辽宁");
            this.put("22", "吉林");
            this.put("23", "黑龙江");
            this.put("31", "上海");
            this.put("32", "江苏");
            this.put("33", "浙江");
            this.put("34", "安徽");
            this.put("35", "福建");
            this.put("36", "江西");
            this.put("37", "山东");
            this.put("41", "河南");
            this.put("42", "湖北");
            this.put("43", "湖南");
            this.put("44", "广东");
            this.put("45", "广西");
            this.put("46", "海南");
            this.put("50", "重庆");
            this.put("51", "四川");
            this.put("52", "贵州");
            this.put("53", "云南");
            this.put("54", "西藏");
            this.put("61", "陕西");
            this.put("62", "甘肃");
            this.put("63", "青海");
            this.put("64", "宁夏");
            this.put("65", "新疆");
            this.put("71", "台湾");
            this.put("81", "香港");
            this.put("82", "澳门");
            this.put("91", "国外");
        }
    };
	//每位加权因子  
    private static final int POWER[] = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    //第18位校检码  
	//private static final String VERIFY_CODE[] = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
	
    /** 
     * 验证身份证号合法性 
     * @param idCard 
     * @return 
     * @throws Exception 
     */  
    public static boolean validateIDCard(String idCard) throws Exception {  
        if (!isIDCard(idCard)) {
        	throw new Exception("身份证号格式错误");
        }
        if (is15IDCard(idCard)) {
        	return validate15IDCard(idCard);
        } else if (is18IDCard(idCard)) {
        	return validate18IDCard(idCard);
        } else {
            throw new Exception("身份证号格式错误");
        }
    }
    
    /**
     * 15位的身份证号转成18位身份证号
     * @param idCard
     * @return
     * @throws Exception 
     */
    public static String convert15BitTo18Bit(String idCard) throws Exception {
    	String idCard17 = null;
        //获取出生年月日
        String birthday = idCard.substring(6, 12);
        Date birthdate = null;
        try {
            birthdate = new SimpleDateFormat("yyMMdd").parse(birthday);
        } catch (ParseException e) {
        	e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthdate);
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        idCard17 = idCard.substring(0, 6) + year + idCard.substring(8);
        char c[] = idCard17.toCharArray();
        String checkCode = "";
        if (null != c) {
        	int bit[] = new int[idCard17.length()];
        	//将字符数组转为整型数组
            bit = converCharToInt(c);
            int sum17 = 0;
            sum17 = getPowerSum(bit);
            //获取和值与11取模得到的余数进行校验码
            checkCode = getCheckCodeBySum(sum17);
            //获取不到校验位
            if (StringUtils.isBlank(checkCode)) {
            	return null;
            }
            //将前17位与第18位校验码拼接
            idCard17 += checkCode;
        }
    	return idCard17;
    }
    
    /**
     * <p>
     * 判断15位身份证号的合法性 
     * </p>
     * @param idCard
     * @return
     * @throws Exception 
     */
    public static boolean validate15IDCard(String idCard) throws Exception {
    	//15位身份证号的基本数字和位数验校 
        if (!is15IDCard(idCard)) {
            return false;
        }
        //15位的身份证号转成18位身份证号
        idCard = convert15BitTo18Bit(idCard);
        //判断18位身份证号的合法性
    	return validate18IDCard(idCard);
    }
	
    /**
     * <p>
     * 判断18位身份证号的合法性 
     * </p>
     * 根据〖中华人民共和国国家标准GB11643-1999〗中有关公民身份号码的规定，公民身份号码是特征组合码，由十七位数字本体码和一位数字校验码组成。 
     * 排列顺序从左至右依次为：六位数字地址码，八位数字出生日期码，三位数字顺序码和一位数字校验码。 
     * <p>
     * 顺序码: 表示在同一地址码所标识的区域范围内，对同年、同月、同 日出生的人编定的顺序号，顺序码的奇数分配给男性，偶数分配 给女性。 
     * </p>
     * <p>
     * 1.前1、2位数字表示：所在省份的代码； 2.第3、4位数字表示：所在城市的代码； 3.第5、6位数字表示：所在区县的代码； 
     * 4.第7~14位数字表示：出生年、月、日； 5.第15、16位数字表示：所在地的派出所的代码； 
     * 6.第17位数字表示性别：奇数表示男性，偶数表示女性； 
     * 7.第18位数字是校检码：也有的说是个人信息码，一般是随计算机的随机产生，用来检验身份证号的正确性。校检码可以是0~9的数字，有时也用x表示。 
     * </p>
     * <p>
     * 第十八位数字(校验码)的计算方法为： 1.将前面的身份证号17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
     * </p>
     * <p>
     * 2.将这17位数字和系数相乘的结果相加。 
     * </p>
     * <p>
     * 3.用加出来和除以11，看余数是多少？ 
     * </p>
     * 4.余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3 2。
     * <p>
     * 5.通过上面得知如果余数是2，就会在身份证号的第18位数字上出现罗马数字的Ⅹ。如果余数是10，身份证号的最后一位号码就是2。 
     * </p>
     * @param idCard
     * @return
     */
    public static boolean validate18IDCard(String idCard) {
    	//18位身份证号的基本数字和位数验校 
        if (!is18IDCard(idCard)) {
            return false;
        }
        //判断是否为合法的省份
        String provinceCode = idCard.substring(0, 2);
        String birthCode = idCard.substring(6, 14);
        boolean flag = false;
        for (String key : CITYINFO_MAP.keySet()) {
        	if (key.equals(provinceCode)) {
        		flag = true;
        		break;
        	}
        }
        if (!flag) {
        	return false;
        }
        //判断该身份证号生出日期是否在当前日期之前
        Date birthDate = null;
        try {
        	birthDate = new SimpleDateFormat("yyyyMMdd").parse(birthCode);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (birthDate == null || new Date().before(birthDate)) {
        	return false;
        }
        //获取前17位
        String idCard17 = idCard.substring(0, 17);
        //获取第18位
        String idCard18Code = idCard.substring(17, 18);
        char c[] = idCard17.toCharArray();;
        String checkCode = "";
        if (null != c) {
        	int bit[] = new int[idCard17.length()];
        	bit = converCharToInt(c);
        	int sum17 = 0;
        	sum17 = getPowerSum(bit);
        	//将和值与11取模得到的余数进行校验码判断
        	checkCode = getCheckCodeBySum(sum17);
        	if (null == checkCode) {
                return false;
            }
        	//将身份证号的第18位与算出来的校码进行匹配
        	 if (!idCard18Code.equalsIgnoreCase(checkCode)) {
        		 return false;
        	 }
        }
    	return true;
    }
    
    /** 
     * 15位和18位身份证号的基本数字和位数验校 
     * @param idCard 
     * @return 
     */  
    public static boolean isIDCard(String idCard) {  
        return idCard == null || "".equals(idCard) ? false : Pattern.matches("(^\\d{15}$)|(\\d{17}(?:\\d|x|X)$)", idCard);  
    }
    
    /** 
     * 15位身份证号的基本数字和位数验校 
     * @param idCard 
     * @return 
     */  
    public static boolean is15IDCard(String idCard) {  
        return idCard == null || "".equals(idCard) ? false : Pattern.matches("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$", idCard);  
    }
    
    /** 
     * 18位身份证号的基本数字和位数验校 
     * @param idCard 
     * @return 
     */  
    public static boolean is18IDCard(String idCard) {  
        return idCard == null || "".equals(idCard) ? false :  Pattern.matches("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([\\d|x|X]{1})$", idCard);  
    }
    
    /** 
     * 字符数组转为整型数组 
     * @param c 
     * @return 
     * @throws NumberFormatException 
     */  
    private static int[] converCharToInt(char[] c) throws NumberFormatException {
        int[] a = new int[c.length];
        int k = 0;
        for (char temp : c) {
            a[k++] = Integer.parseInt(String.valueOf(temp));
        }
        return a;
    }
    
    /** 
     * 将身份证号的每位和对应位的加权因子相乘之后，再得到和值 
     * @param bit 
     * @return 
     */  
    private static int getPowerSum(int[] bit) {
        int sum = 0;
        if (POWER.length != bit.length) {
            return sum;
        }
        for (int i = 0; i < bit.length; i++) {
            for (int j = 0; j < POWER.length; j++) {
                if (i == j) {
                    sum = sum + bit[i] * POWER[j];
                }
            }
        }
        return sum;
    }
    
    /** 
     * 将和值与11取模得到余数进行校验码判断
     * @param checkCode
     * @param sum17
     * @return 校验位
     */
    private static String getCheckCodeBySum(int sum17) {  
        String checkCode = null;
        //checkCode = VERIFY_CODE[sum17 % 11];
        switch (sum17 % 11) {
        case 10:
            checkCode = "2";
            break;
        case 9:
            checkCode = "3";
            break;
        case 8:
            checkCode = "4";
            break;
        case 7:
            checkCode = "5";
            break;
        case 6:
            checkCode = "6";  
            break;
        case 5:
            checkCode = "7";
            break;
        case 4:
            checkCode = "8";
            break;
        case 3:
            checkCode = "9";
            break;
        case 2:
            checkCode = "x";
            break;
        case 1:
            checkCode = "0";
            break;
        case 0:
            checkCode = "1";
            break;
        }
        return checkCode;
    }
    
    /** 
     * 提取身份证信息
     * @param idCard
     * @return
     * @throws Exception 
     */
    @SuppressWarnings("unused")
	public static String extractIDCard(String idCard) throws Exception {
    	//省份
        String province = null;
        //年份
        Integer birthDateYear = null;
        //月份
        Integer birthDateMonth = null;
        //日期
        Integer birthDateDay = null;
        //性别
        String gender = null;
        //出生日期
        Date birthDate = null;
        //校验
        if (!isIDCard(idCard)) {
        	throw new Exception("身份证号格式错误");
        }
        if (idCard.length() != 18) {
        	idCard = convert15BitTo18Bit(idCard);
        	if (!is18IDCard(idCard)) {
            	throw new Exception("身份证号格式错误");
            }
        } else {
        	if (!is18IDCard(idCard)) {
            	throw new Exception("身份证号格式错误");
            }
        }
        //获取省份
        String provinceCode = idCard.substring(0, 2);  
        Set<String> keySet = CITYINFO_MAP.keySet();  
        for (String key : keySet) {
            if (key.equals(provinceCode)) {  
                province = CITYINFO_MAP.get(key);  
                break;  
            }  
        }
        //获取性别
        String idCard17Code = idCard.substring(16, 17);
        if (Integer.parseInt(idCard17Code) % 2 != 0) {
            gender = "男";
        } else {
            gender = "女";
        }
        //获取出生日期
        String birthCode = idCard.substring(6, 14);
        birthDate = new SimpleDateFormat("yyyyMMdd").parse(birthCode);
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.setTime(birthDate);
        birthDateYear = currentDate.get(Calendar.YEAR);
        birthDateMonth = currentDate.get(Calendar.MONTH) + 1;
        birthDateDay = currentDate.get(Calendar.DAY_OF_MONTH);
        return "省份：" + province + ", 性别：" + gender + ", 出生日期：" + new SimpleDateFormat("yyyy/MM/dd").format(birthDate)+" ";
    }
    
    /** 
     * 提取出生日期
     * @param idCard
     * @return
     * @throws Exception 
     */
	public static String extractBirthDate(String idCard) throws Exception {
        //出生日期
        Date birthDate = null;
        //校验
        if (!isIDCard(idCard)) {
        	throw new Exception("身份证号格式错误");
        }
        if (idCard.length() != 18) {
        	idCard = convert15BitTo18Bit(idCard);
        	if (!is18IDCard(idCard)) {
            	throw new Exception("身份证号格式错误");
            }
        } else {
        	if (!is18IDCard(idCard)) {
            	throw new Exception("身份证号格式错误");
            }
        }
        //获取出生日期
        String birthCode = idCard.substring(6, 14);
        birthDate = new SimpleDateFormat("yyyyMMdd").parse(birthCode);
        return new SimpleDateFormat("yyyyMMdd").format(birthDate);
    }
    
	public static void main(String[] args) throws Exception {
		String idCard = "513021198001010093";
		System.out.println(validateIDCard(idCard));
		System.out.println(extractBirthDate(idCard));
	}
}