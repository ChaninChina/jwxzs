 package com.util.config;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 配置实体类
 * @author QingLong
 */
@Component("configInfo")
public class ConfigInfo {
	
	@Value("#{configProperties['cert_authURL']}")
	private String certAuthURL;
	@Value("#{configProperties['cert_appId']}")
	private String certAppId;
	@Value("#{configProperties['cert_attrType']}")
	private String certAttrType;
	@Value("#{configProperties['cert_attributes']}")
	private String certAttributes;
	//默认路径
	@Value("#{configProperties['default.path']}")
	private String defaultPath;
	//下载路径
	@Value("#{configProperties['dowload.path']}")
	private String dowloadPath;
	//工程名称
	@Value("#{configProperties['project.name']}")
	private String projectName;
	//工程首拼
	@Value("#{configProperties['project.piny']}")
	private String projectPiny;
	//初始密码
	@Value("#{configProperties['initial.password']}")
	private String initialPassword;
	//允许次数
	@Value("#{configProperties['allowed.mistaken']}")
	private String allowedMistaken;
	//系统错误,请联系管理人员！
	@Value("#{configProperties['error.default']}")
	private String errorDefault;
	//无效访问,请不要再次尝试！
	@Value("#{configProperties['error.invalid']}")
	private String errorInvalid;
	//登录超时,请重新登录系统！
	@Value("#{configProperties['error.timeout']}")
	private String errorTimeout;
	//图片附件路径
	@Value("#{configProperties['pic.path']}")
	private String picPath;
	//音频附件路径
	@Value("#{configProperties['audio.path']}")
	private String audioPath;
	//视频附件路径
	@Value("#{configProperties['video.path']}")
	private String videoPath;
	//视频附件路径
	@Value("#{configProperties['doc.path']}")
	private String docPath;
	//安装包路径
	@Value("#{configProperties['apk.path']}")
	private String apkPath;
	
	
	public String getCertAuthURL() {
		return certAuthURL;
	}
	public void setCertAuthURL(String certAuthURL) {
		this.certAuthURL = certAuthURL;
	}
	public String getCertAppId() {
		return certAppId;
	}
	public void setCertAppId(String certAppId) {
		this.certAppId = certAppId;
	}
	public String getCertAttrType() {
		return certAttrType;
	}
	public void setCertAttrType(String certAttrType) {
		this.certAttrType = certAttrType;
	}
	public String getCertAttributes() {
		return certAttributes;
	}
	public void setCertAttributes(String certAttributes) {
		this.certAttributes = certAttributes;
	}
	public String getDefaultPath() {
		return defaultPath;
	}
	public void setDefaultPath(String defaultPath) {
		this.defaultPath = defaultPath;
	}
	public String getDowloadPath() {
		return MessageFormat.format(dowloadPath, defaultPath); //格式路径
	}
	public void Dowload(String dowloadPath) {
		this.dowloadPath = dowloadPath;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectPiny() {
		return projectPiny;
	}
	public void setProjectPiny(String projectPiny) {
		this.projectPiny = projectPiny;
	}
	public String getInitialPassword() {
		return initialPassword;
	}
	public void setInitialPassword(String initialPassword) {
		this.initialPassword = initialPassword;
	}
	public String getAllowedMistaken() {
		return allowedMistaken;
	}
	public void setAllowedMistaken(String allowedMistaken) {
		this.allowedMistaken = allowedMistaken;
	}
	public String getErrorDefault() {
		return errorDefault;
	}
	public void setErrorDefault(String errorDefault) {
		this.errorDefault = errorDefault;
	}
	public String getErrorInvalid() {
		return errorInvalid;
	}
	public void setErrorInvalid(String errorInvalid) {
		this.errorInvalid = errorInvalid;
	}
	public String getErrorTimeout() {
		return errorTimeout;
	}
	public void setErrorTimeout(String errorTimeout) {
		this.errorTimeout = errorTimeout;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public String getAudioPath() {
		return audioPath;
	}
	public void setAudioPath(String audioPath) {
		this.audioPath = audioPath;
	}
	public String getVideoPath() {
		return videoPath;
	}
	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}
	public void setDowloadPath(String dowloadPath) {
		this.dowloadPath = dowloadPath;
	}
	public String getApkPath() {
		return apkPath;
	}
	public void setApkPath(String apkPath) {
		this.apkPath = apkPath;
	}
	public String getDocPath() {
		return docPath;
	}
	public void setDocPath(String docPath) {
		this.docPath = docPath;
	}
	
	
}