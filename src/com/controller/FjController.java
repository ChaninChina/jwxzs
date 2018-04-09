/**
 * 
 */
package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Chanin
 *
 */
@Controller
@RequestMapping("/data/fj/")
public class FjController extends BaseController{
	
	
	

	/**
	 * 下载图片
	 * 
	 * @param fjlj
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "picture")
	public void getPicture(String fjlj, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (StringUtils.isBlank(fjlj)) {
			return;
		}
		try {
			File file = new File(configInfo.getPicPath() + fjlj); // 附件路径
			if (file.exists() && file.isFile()) {
			    response.setCharacterEncoding("utf-8");
			    response.setContentType("multipart/octet-stream");
			    response.setHeader("Content-Disposition", "attachment;fileName=" + file.getName());
			    response.setHeader("Content-Length", file.length()+"");  
				InputStream is = new FileInputStream(file);
				OutputStream os = response.getOutputStream();
				try {
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
				}
			}
		} catch (Exception e) {
			return;
		}
	}
	
	
	/**
	 * 下载音频
	 * 
	 * @param fjlj
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "audio")
	public void getAudio(String fjlj, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FJLJ ============= "+fjlj);
		if (StringUtils.isBlank(fjlj)) {
			return;
		}
		try {
			File file = new File(configInfo.getAudioPath() + fjlj); // 附件路径
		    response.setCharacterEncoding("utf-8");
		    response.setContentType("multipart/octet-stream");
		    response.setHeader("Content-Disposition", "attachment;fileName=" + file.getName());
		    response.setHeader("Content-Length", file.length()+"");  
			if (file.exists() && file.isFile()) {
				InputStream is = new FileInputStream(file);
				OutputStream os = response.getOutputStream();
				try {
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
				}
			}
		} catch (Exception e) {
			return;
		}
	}
	
	
	/**
	 * 下载视频
	 * 
	 * @param fjlj
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "video")
	public void getVideo(String fjlj, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FJLJ ============= "+fjlj);
		if (StringUtils.isBlank(fjlj)) {
			return;
		}
		try {
			File file = new File(configInfo.getVideoPath() + fjlj); // 附件路径
			
			System.out.println("FILE PATH ============= "+file.getPath());
			if (file.exists() && file.isFile()) {
			    response.setCharacterEncoding("utf-8");
			    response.setContentType("multipart/octet-stream");
			    response.setHeader("Content-Disposition", "attachment;fileName=" + file.getName());
			    response.setHeader("Content-Length", file.length()+"");  
				InputStream is = new FileInputStream(file);
				OutputStream os = response.getOutputStream();
				try {
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
				}
			}
		} catch (Exception e) {
			return;
		}
	}
	
	/**
	 * 下载文件
	 * 
	 * @param fjlj
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "file")
	public void getFile(String fjlj, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FJLJ ============= "+fjlj);
		if (StringUtils.isBlank(fjlj)) {
			return;
		}
		try {
			File file = new File(configInfo.getDocPath() + fjlj); // 附件路径
			if (file.exists() && file.isFile()) {
			    response.setCharacterEncoding("utf-8");
			    response.setContentType("multipart/octet-stream");
			    response.setHeader("Content-Disposition", "attachment;fileName=" + file.getName());
			    response.setHeader("Content-Length", file.length()+"");  
				InputStream is = new FileInputStream(file);
				OutputStream os = response.getOutputStream();
				try {
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
				}
			}else {
		
			}
		} catch (Exception e) {
			return;
		}
	}

	/**
	 * 下载版本
	 * @param bbdz
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "xzbb")
	public void doXzbb(String bbdz, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (StringUtils.isBlank(bbdz)) {
			return;
		}
		try {
			File file = new File(configInfo.getApkPath() + bbdz); // 附件路径
			if (file.exists() && file.isFile()) {
			    response.setCharacterEncoding("utf-8");
			    response.setContentType("multipart/octet-stream");
			    response.setHeader("Content-Disposition", "attachment;fileName=" + file.getName());
			    response.setHeader("Content-Length", file.length()+"");  
				InputStream is = new FileInputStream(file);
				OutputStream os = response.getOutputStream();
				try {
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
				}
			}
		} catch (Exception e) {
			return;
		}
	}
	
}
