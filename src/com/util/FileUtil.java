package com.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件工具类
 * @author QingLong
 */
public class FileUtil {
	
	Logger logger = Logger.getLogger(FileUtil.class);
	
	/**
	 * 返回文件格式
	 * @param fileName
	 * @return
	 **/
	public static String getFileMode(String fileName) throws Exception {
		String mode = "";
		if (fileName != null && !"".equals(fileName)) {
			if ((fileName.lastIndexOf(".") > -1) && (fileName.lastIndexOf(".") < (fileName.length()))) {
				mode = fileName.substring(fileName.lastIndexOf(".") + 1);
			}
		} else {
			throw new Exception("文件名称异常");
		}
		return mode;
	}
	
	/**
	 * 返回日期路径
	 * @return
	 */
	public static String getDatePath() throws Exception{
		String datePath = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy/");
		datePath = df.format(new Date());
		df = new SimpleDateFormat("MM/");
		datePath += df.format(new Date());
		df = new SimpleDateFormat("dd/");
		datePath += df.format(new Date());
		return datePath;
	}
	
	/**
	 * 删除单个文件
	 * @param filePath
	 * @return
	 * @throws IOException 
	 */
	public static void deleteFile(String filePath) throws IOException {
		File file = new File(filePath);
		if (file.exists() && file.isFile()) {
			if (!file.delete()) {
				throw new IOException("删除文件失败");
			}
		}
	}
	
	/**
	 * 删除文件目录
	 * @param direPath
	 * @return
	 * @throws IOException 
	 */
	public static void deleteDire(String direPath) throws IOException {
		File dire = new File(direPath);
		if(!dire.exists() || !dire.isDirectory()){
			return;
		}
		File[] files = dire.listFiles();
		for (int i=0;i<files.length;i++){
			if (files[i].isFile()){
				deleteFile(files[i].getAbsolutePath());
			} else if (files[i].isDirectory()){
				deleteDire(files[i].getAbsolutePath());
			}
		}
		if (!dire.delete()) {
			throw new IOException("删除文件失败");
		}
	}
	
	/**
	 * 上传文件,返回文件地址
	 * @param filePath
	 * @param fileName
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static String doUpload(String filePath, String fileName, File file) throws Exception {
		//文件路径
		if (StringUtils.isBlank(filePath)) {
			throw new Exception("文件路径为空");
		}
		if (!new File(filePath).exists()) {
			new File(filePath).mkdirs();
		}
		//文件格式
		String fileMode = getFileMode(file.getName());
		//文件名称
		if (StringUtils.isBlank(fileName)) {
			fileName = UUID.randomUUID().toString().replace("-", "");
		}
		fileName += "." + fileMode;
		//执行写入硬盘
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new BufferedInputStream(new FileInputStream(file));
			os = new BufferedOutputStream(new FileOutputStream(new File(filePath, fileName)));
			byte[] b = new byte[1024];
			int r = 0;
			while ((r = is.read(b)) > 0) {
				os.write(b, 0, r);
			}
		} catch (IOException ex) {
			throw new IOException(ex.getMessage(), ex);
		} finally {
			if (os != null) {
				os.close();
			}
			if (is != null) {
				is.close();
			}
			//删除临时文件
			if (file.exists()) {
				file.delete();
			}
		}
		return filePath + fileName;
	}
	
	/**
	 * 上传文件,返回文件地址
	 * @param filePath
	 * @param fileName
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static String doUpload(String filePath, String fileName, MultipartFile file) throws Exception {
		//文件路径
		if (StringUtils.isBlank(filePath)) {
			throw new Exception("文件路径为空");
		}
		if (!new File(filePath).exists()) {
			new File(filePath).mkdirs();
		}
		//文件格式
		String fileMode = getFileMode(file.getOriginalFilename());
		//文件名称
		if (StringUtils.isBlank(fileName)) {
			fileName = UUID.randomUUID().toString().replace("-", "");
		}
		fileName += "." + fileMode.toLowerCase();
		File newFile = new File(filePath,fileName);
		file.transferTo(newFile);
		return newFile.getPath();
	}
}