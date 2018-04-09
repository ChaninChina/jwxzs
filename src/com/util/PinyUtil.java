package com.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.apache.commons.lang3.StringUtils;

/**
 * 拼音工具类
 * @author QingLong
 */
public class PinyUtil {
	
	/**
	 * 首字母大写
	 * @param str
	 * @return String
	 */
	private static String firstCapital(String str) {
		char[] ch = str.toCharArray();
		if (ch[0] >= 'a' && ch[0] <= 'z') {
			ch[0] = (char) (ch[0] - 32);
		}
		return new String(ch);
	}
	
	/**
	 * 全字母大写
	 * @param str
	 * @return String
	 */
	private static String wholeCapital(String str) {
		char[] ch = str.toCharArray();
		for (int i=0;i<ch.length;i++){
			if (ch[i] >= 'a' && ch[i] <= 'z') {
				ch[i] = (char) (ch[i] - 32);
			}
		}
		return new String(ch);
	}
	
	/**
	 * 完全拼音
	 * @param str 中文汉字
	 * @param firstCapital 首字母大写
	 * @param wholeCapital 全字母大写
	 * @return pinYin
	 */
	public static String getFullyPinyin(String str, boolean firstCapital, boolean wholeCapital) throws Exception {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		//设置汉字拼音输出的格式
		HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
		outputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		outputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
		try {
			for (int i = 0; i < str.toCharArray().length; i++) {
				String[] pinYins = PinyinHelper.toHanyuPinyinStringArray(str.toCharArray()[i], outputFormat);
				//判断能否为汉字字符
				if (pinYins != null && pinYins.length > 0) { //汉字
					if (firstCapital) {
						sb.append(firstCapital(pinYins[0])); //首字母大写
					} else if (wholeCapital){
						for (int j=0;j<pinYins.length;j++){
							sb.append(wholeCapital(pinYins[j])); //全字母大写
						}
					} else {
						sb.append(pinYins[0]); //首字母小写
					}
				} else { //非汉字
					sb.append(str.charAt(i));
				}
			}
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			throw new BadHanyuPinyinOutputFormatCombination(e.getMessage());
		}
		return sb.toString();
	}
	
	/**
	 * 简洁拼音
	 * @param str 中文汉字
	 * @param firstCapital 首字母大写
	 * @return pinYin
	 */
	public static String getTersePinyin(String str, boolean firstCapital) throws Exception {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		//设置汉字拼音输出的格式
		HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
		outputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		outputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
		try {
			for (int i = 0; i < str.length(); i++) {
				String[] pinYins = PinyinHelper.toHanyuPinyinStringArray(str.charAt(i), outputFormat);
				if (pinYins != null && pinYins.length > 0) { //汉字
					if (firstCapital) {
						sb.append(firstCapital(pinYins[0]).charAt(0)); //首字母大写
					} else {
						sb.append(pinYins[0].charAt(0)); //首字母小写
					}
				} else { //非汉字
					sb.append(str.charAt(i));
				}
			}
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			throw new BadHanyuPinyinOutputFormatCombination(e.getMessage());
		}
		return sb.toString();
	}
}