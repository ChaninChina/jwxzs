package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.util.model.BasicObject;

public class YdYhdl extends BasicObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1189483065366905769L;

	@JsonIgnore
    private String yhid;//用户主键

    private String token;//token

    private Long gqsj;//过期时间

    private String dlsj;//登录时间

    @JsonIgnore
    private String imei;//IMEI

    @JsonIgnore
    private Integer khdbb;//客户端版本号
    
    @JsonIgnore
    private String sbxx;//设备信息

    // 启用状态(必填项)
    @JsonIgnore
    private String enableStatus;

    // 删除状态(必填项)
    @JsonIgnore
    private String deleteStatus;

    // 创建时间(必填项)
    @JsonIgnore
    private String createTime;

    // 创建人员(必填项)
    @JsonIgnore
    private String createId;

    // 更新时间(必填项)
    @JsonIgnore
    private String updateTime;

    // 更新人员(必填项)
    @JsonIgnore
    private String updateId;

	//------------------------
  	//业务逻辑使用属性
  	//------------------------
    private Yhxx yhxx;
    
    
    
    
    

    public Yhxx getYhxx() {
		return yhxx;
	}

	public void setYhxx(Yhxx yhxx) {
		this.yhxx = yhxx;
	}

	public String getYhid() {
        return yhid;
    }

    public void setYhid(String yhid) {
        this.yhid = yhid == null ? null : yhid.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Long getGqsj() {
        return gqsj;
    }

    public void setGqsj(Long gqsj) {
        this.gqsj = gqsj;
    }

    public String getDlsj() {
        return dlsj;
    }

    public void setDlsj(String dlsj) {
        this.dlsj = dlsj == null ? null : dlsj.trim();
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei == null ? null : imei.trim();
    }

    public Integer getKhdbb() {
        return khdbb;
    }

    public void setKhdbb(Integer khdbb) {
        this.khdbb = khdbb;
    }

    public String getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(String enableStatus) {
        this.enableStatus = enableStatus == null ? null : enableStatus.trim();
    }

    public String getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus == null ? null : deleteStatus.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId == null ? null : updateId.trim();
    }

    public String getSbxx() {
        return sbxx;
    }

    public void setSbxx(String sbxx) {
        this.sbxx = sbxx == null ? null : sbxx.trim();
    }
}