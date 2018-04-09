package com.util;

import java.util.UUID;

/**
 * UUID工具类
 * @author QingLong
 */
public class UUIDUtil {
	
	public static String getUUID(){
		String uuid = UUID.randomUUID().toString();
		return uuid.replace("-", "");
	}
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(getUUID());
		}
	}
}