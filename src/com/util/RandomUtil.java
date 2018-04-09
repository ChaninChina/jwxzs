package com.util;

/**
 * 随机工具类
 * @author QingLong
 */
public class RandomUtil {
	
	public static String getRandom(int size){
		String str = "1234567890abcdefghijklmnopqrstopqrstuvwxyz";
		char[] charArray = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < size; i++) {
			sb.append(charArray[((int)(Math.random() * 10000.0D) % charArray.length)]);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getRandom(6));
	}
}