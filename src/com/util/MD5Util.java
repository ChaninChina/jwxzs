package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

/**
 * MD5工具类
 * @author QingLong
 */
public class MD5Util {
	
	static Logger logger = Logger.getLogger(MD5Util.class);
	
	public static final String enCodeData(String data) throws Exception {
		MessageDigest digest = null;
		if (digest == null) {
            try {
                digest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException ex) {
            	logger.error(ex.getMessage(), ex);
                throw new Exception(ex.getMessage(), ex);
            }
        }
		digest.update(data.getBytes()); //更新摘要
        return enCodeData(digest.digest());
	}
	
	public static final String enCodeData(File file) throws Exception {
		MessageDigest digest = null;
		if (digest == null) {
            try {
                digest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException ex) {
            	logger.error(ex.getMessage(), ex);
                throw new Exception(ex.getMessage(), ex);
            }
        }
		DigestInputStream ds = null;
		try {
			ds = new DigestInputStream(new FileInputStream(file), digest);
			byte[] b = new byte[1024];
			int r = 0;
			while ((r = ds.read(b)) != -1) {
				digest.update(b,0,r);
			}
		} catch (IOException ex) {
			throw new Exception(ex.getMessage(), ex);
		} finally {
			ds.close();
		}
		return enCodeData(digest.digest());
	}
	
	public static final String enCodeData(MultipartFile file) throws Exception {
		MessageDigest digest = null;
		if (digest == null) {
            try {
                digest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException ex) {
            	logger.error(ex.getMessage(), ex);
                throw new Exception(ex.getMessage(), ex);
            }
        }
		DigestInputStream ds = null;
		try {
			ds = new DigestInputStream(file.getInputStream(), digest);
			byte[] b = new byte[1024];
			int r = 0;
			while ((r = ds.read(b)) != -1) {
				digest.update(b,0,r);
			}
		} catch (IOException ex) {
			throw new Exception(ex.getMessage(), ex);
		} finally {
			ds.close();
		}
		return enCodeData(digest.digest());
	}
	
	private static final String enCodeData(byte[] bytes) {
        StringBuffer buf = new StringBuffer();
        int i;
        for (i = 0; i < bytes.length; i++) {
            if (((int) bytes[i] & 0xff) < 0x10) {
                buf.append("0");
            }
            buf.append(Long.toString((int) bytes[i] & 0xff, 16));
        }
        return buf.toString();
    }
}