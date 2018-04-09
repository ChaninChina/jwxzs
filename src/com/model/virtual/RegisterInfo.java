package com.model.virtual;

import com.util.annotation.NotEmpty;

public class RegisterInfo {
	
    // 登录账号(必填项)
	@NotEmpty
    private String dlzh;

    // 登录密码(必填项)
	@NotEmpty
    private String dlmm;

    // 适用平台：android、pc(必填项)
	@NotEmpty
    private String sypt;

    // 账号类型：身份证号、手机号、邮箱(必填项)
	@NotEmpty
    private String zhlx;
	
    // 机构主键(可选项)
    private String orgnId;

    // 用户姓名(必填项)
	@NotEmpty
    private String yhxm;

    // 用户类型(必填项)
	@NotEmpty
    private String yhlx;

    // 用户性别(必填项)
	@NotEmpty
    private String yhxb;

    // 联系电话(必填项)
	@NotEmpty
    private String lxdh;

    // 身份证号(必填项)
	@NotEmpty
    private String sfzh;

    // 用户职务(必填项)
	@NotEmpty
    private String yhzw;

    // 所在单位(可选项)
    private String szdw;

	public String getDlzh() {
		return dlzh;
	}

	public void setDlzh(String dlzh) {
		this.dlzh = dlzh;
	}

	public String getDlmm() {
		return dlmm;
	}

	public void setDlmm(String dlmm) {
		this.dlmm = dlmm;
	}

	public String getSypt() {
		return sypt;
	}

	public void setSypt(String sypt) {
		this.sypt = sypt;
	}

	public String getZhlx() {
		return zhlx;
	}

	public void setZhlx(String zhlx) {
		this.zhlx = zhlx;
	}

	public String getOrgnId() {
		return orgnId;
	}

	public void setOrgnId(String orgnId) {
		this.orgnId = orgnId;
	}

	public String getYhxm() {
		return yhxm;
	}

	public void setYhxm(String yhxm) {
		this.yhxm = yhxm;
	}

	public String getYhlx() {
		return yhlx;
	}

	public void setYhlx(String yhlx) {
		this.yhlx = yhlx;
	}

	public String getYhxb() {
		return yhxb;
	}

	public void setYhxb(String yhxb) {
		this.yhxb = yhxb;
	}

	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public String getYhzw() {
		return yhzw;
	}

	public void setYhzw(String yhzw) {
		this.yhzw = yhzw;
	}

	public String getSzdw() {
		return szdw;
	}

	public void setSzdw(String szdw) {
		this.szdw = szdw;
	}
	
    
    
    

}
