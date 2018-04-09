package com.util;

import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * Web常见工具类
 * @author QingLong
 */
public class WebUtil {
	
	static Logger logger = Logger.getLogger(WebUtil.class);
	
	/**
	 * 获取客户端网络地址
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	public static String getInternetAddr(HttpServletRequest request) throws Exception {
		String ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
				//根据网卡取本地配置IP
				InetAddress inet = InetAddress.getLocalHost();;
				ipAddress = inet.getHostAddress();
			}
		}
		if (ipAddress == null || ipAddress.length() == 0) {
			throw new Exception("返回客户端IP地址为空");
		}
		if (ipAddress != null && ipAddress.length() > 15 && ipAddress.indexOf(",") > 0) {
			ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
		}
		return ipAddress;
	}
	
	/**
	 * 获取客户端物理地址
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	public static String getPhysicalAddr(HttpServletRequest request) throws Exception {
		return null;
	}
}