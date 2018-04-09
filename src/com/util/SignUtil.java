package com.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


/**
 * Created by Chanin on 2017-11-06.
 */

public class SignUtil {
	
	
	public static String signParams(Map<String, String[]> params){
		Map<String, String[]> maps = new HashMap<>(params);
        maps.remove("sign");
        TreeMap<String, String[]> treeMap = new TreeMap<>(maps);
        Iterator<Map.Entry<String, String[]>> iterator = treeMap.entrySet().iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            Map.Entry<String, String[]> next = iterator.next();
            String[] value = next.getValue();
            if(value!=null&&value.length>0){
                int length = value.length;
                for (int i = 0; i < length; i++) {
                    sb.append(next.getKey()).append(value[i]);  
                }
            }else {
                sb.append(next.getKey()).append(value);
            }
        }
        return md5(sb.toString());
		
		
	}


    public static String signParams(HashMap<String, String> maps) {
        maps.remove("sign");
        TreeMap<String, String> treeMap = new TreeMap<>(maps);
        Iterator<Map.Entry<String, String>> iterator = treeMap.entrySet().iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            sb.append(next.getKey()).append(next.getValue());
        }
        return md5(sb.toString());
    }

    private static String md5(String s) {
        return encryptMD5ToString(s);
    }

//NiPVlqzY+mO2esOFocuvWA==

    public static void main(String[] args){
        HashMap<String,String> map = new HashMap<>();
        map.put("stId","");
        map.put("rndo", "1509937286570");
        map.put("token","");







        String s = signParams(map);
        System.out.println(s);
    }



    private static final char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private static String bytes2HexString(final byte[] bytes) {
        if (bytes == null) return null;
        int len = bytes.length;
        if (len <= 0) return null;
        char[] ret = new char[len << 1];
        for (int i = 0, j = 0; i < len; i++) {
            ret[j++] = hexDigits[bytes[i] >>> 4 & 0x0f];
            ret[j++] = hexDigits[bytes[i] & 0x0f];
        }
        return new String(ret);
    }

    /**
     * MD5加密
     *
     * @param data 明文字符串
     * @return 16进制密文
     */
    public static String encryptMD5ToString(final String data) {
        return encryptMD5ToString(data.getBytes());
    }

    /**
     * MD5加密
     *
     * @param data 明文字节数组
     * @return 16进制密文
     */
    public static String encryptMD5ToString(final byte[] data) {
        return bytes2HexString(encryptMD5(data));
    }

    /**
     * MD5加密
     *
     * @param data 明文字节数组
     * @return 密文字节数组
     */
    public static byte[] encryptMD5(final byte[] data) {
        return hashTemplate(data, "MD5");
    }

    /**
     * hash加密模板
     *
     * @param data      数据
     * @param algorithm 加密算法
     * @return 密文字节数组
     */
    private static byte[] hashTemplate(final byte[] data, final String algorithm) {
        if (data == null || data.length <= 0) return null;
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(data);
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
