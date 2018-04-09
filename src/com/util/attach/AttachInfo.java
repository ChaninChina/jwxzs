 package com.util.attach;

import java.text.MessageFormat;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.util.config.ConfigInfo;

/**
 * 附件实体类
 * @author QingLong
 */
@Component("attachInfo")
public class AttachInfo {
	
	@Resource
	private ConfigInfo configInfo;
	
	@Value("#{configProperties['attach.tp.error.sl']}")
	private String attachTpErrorSl;
	@Value("#{configProperties['attach.tp.error.lx']}")
	private String attachTpErrorLx;
	@Value("#{configProperties['attach.tp.error.dx']}")
	private String attachTpErrorDx;
	@Value("#{configProperties['attach.tp.type']}")
	private String attachTpType;
	@Value("#{configProperties['attach.tp.path.wrfj']}")
	private String attachTpPathWrfj;
	@Value("#{configProperties['attach.tp.path.czry']}")
	private String attachTpPathCzry;
	@Value("#{configProperties['attach.tp.size.mr']}")
	private String attachTpSizeMr;
	
	public String getAttachTpErrorSl() {
		return attachTpErrorSl;
	}
	public void setAttachTpErrorSl(String attachTpErrorSl) {
		this.attachTpErrorSl = attachTpErrorSl;
	}
	public String getAttachTpErrorLx() {
		return attachTpErrorLx;
	}
	public void setAttachTpErrorLx(String attachTpErrorLx) {
		this.attachTpErrorLx = attachTpErrorLx;
	}
	public String getAttachTpErrorDx() {
		return attachTpErrorDx;
	}
	public void setAttachTpErrorDx(String attachTpErrorDx) {
		this.attachTpErrorDx = attachTpErrorDx;
	}
	public String getAttachTpType() {
		return attachTpType;
	}
	public void setAttachTpType(String attachTpType) {
		this.attachTpType = attachTpType;
	}
	public String getAttachTpPathWrfj() {
		return MessageFormat.format(attachTpPathWrfj, configInfo.getDefaultPath()); //格式路径
	}
	public void setAttachTpPathWrfj(String attachTpPathWrfj) {
		this.attachTpPathWrfj = attachTpPathWrfj;
	}
	public String getAttachTpPathCzry() {
		return MessageFormat.format(attachTpPathCzry, configInfo.getDefaultPath()); //格式路径
	}
	public void setAttachTpPathCzry(String attachTpPathCzry) {
		this.attachTpPathCzry = attachTpPathCzry;
	}
	public String getAttachTpSizeMr() {
		return attachTpSizeMr;
	}
	public void setAttachTpSizeMr(String attachTpSizeMr) {
		this.attachTpSizeMr = attachTpSizeMr;
	}
}