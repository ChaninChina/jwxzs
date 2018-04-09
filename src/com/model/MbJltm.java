package com.model;

import java.util.List;

/**
 * @TableName TB_MB_JLTM
 * @Data 2018-01-23
 * @Author chanin 
 * null
 */
public class MbJltm {
    // 条目主键 (主健ID)
    private String tmid;

    // 条目模板主键(可选项)
    private String tmmbid;
	// 条目分组主键(可选项)
    private String tmfzid;

 // 条目类型：文本（普通文本、单行文本、多行文本、富文本、身份证号、手机号、时间、日期、日期以及时间、位置）、单选（普通单选、性别、简单单选（是、否）、区域）、多选、附件（图片、视频、文件）、隐藏位置(必填项)
	private String tmlx;

    // 条目名称(必填项)
    private String tmmc;

    // 条目描述(可选项)
    private String tmms;

    // 条目备注(可选项)
    private String tmbz;

    // 编号(可选项)
    private String bh;

    // 条目排序(必填项)
    private Integer tmpx;

    // // 默认值(可选项)
    private String mrz;

    // 允许为空：是、否(可选项)
    private String yxwk;

    // 最小值(可选项)
    private Long zxz;

    // 最大值(可选项)
    private Long zdz;

    // 验证规则(可选项)
    private String yzgz;

    // 错误提示(可选项)
    private String cwts;

    // 联动开始层级（可选项）
    private Integer kscj;

    // 联动结束层级（可选项）
    private Integer jscj;

	// 启用状态(必填项)
	private String enableStatus;

	// 删除状态(必填项)
	private String deleteStatus;

	// 创建时间(必填项)
	private String createTime;

	// 创建人员(必填项)
	private String createId;

	// 更新时间(必填项)
	private String updateTime;

	// 更新人员(必填项)
	private String updateId;
    
    
	// ------------------------
	// 业务逻辑使用属性
	// ------------------------
	private List<MbJlxx> mbJlxxes;// 模板记录选项

	
    public String getTmid() {
        return tmid;
    }

    public void setTmid(String tmid) {
        this.tmid = tmid == null ? null : tmid.trim();
    }

    public String getTmmbid() {
        return tmmbid;
    }

    public void setTmmbid(String tmmbid) {
        this.tmmbid = tmmbid == null ? null : tmmbid.trim();
    }

    public String getTmfzid() {
        return tmfzid;
    }

    public void setTmfzid(String tmfzid) {
        this.tmfzid = tmfzid == null ? null : tmfzid.trim();
    }

    public String getTmlx() {
        return tmlx;
    }

    public void setTmlx(String tmlx) {
        this.tmlx = tmlx == null ? null : tmlx.trim();
    }

    public String getTmmc() {
        return tmmc;
    }

    public void setTmmc(String tmmc) {
        this.tmmc = tmmc == null ? null : tmmc.trim();
    }

    public String getTmms() {
        return tmms;
    }

    public void setTmms(String tmms) {
        this.tmms = tmms == null ? null : tmms.trim();
    }

    public String getTmbz() {
        return tmbz;
    }

    public void setTmbz(String tmbz) {
        this.tmbz = tmbz == null ? null : tmbz.trim();
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh == null ? null : bh.trim();
    }

    public Integer getTmpx() {
        return tmpx;
    }

    public void setTmpx(Integer tmpx) {
        this.tmpx = tmpx;
    }

    public String getMrz() {
        return mrz;
    }

    public void setMrz(String mrz) {
        this.mrz = mrz == null ? null : mrz.trim();
    }

    public String getYxwk() {
        return yxwk;
    }

    public void setYxwk(String yxwk) {
        this.yxwk = yxwk == null ? null : yxwk.trim();
    }

    public Long getZxz() {
        return zxz;
    }

    public void setZxz(Long zxz) {
        this.zxz = zxz;
    }

    public Long getZdz() {
        return zdz;
    }

    public void setZdz(Long zdz) {
        this.zdz = zdz;
    }

    public String getYzgz() {
        return yzgz;
    }

    public void setYzgz(String yzgz) {
        this.yzgz = yzgz == null ? null : yzgz.trim();
    }

    public String getCwts() {
        return cwts;
    }

    public void setCwts(String cwts) {
        this.cwts = cwts == null ? null : cwts.trim();
    }

    public Integer getKscj() {
        return kscj;
    }

    public void setKscj(Integer kscj) {
        this.kscj = kscj;
    }

    public Integer getJscj() {
        return jscj;
    }

    public void setJscj(Integer jscj) {
        this.jscj = jscj;
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

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TB_MB_JLTM
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static MbJltm.Builder builder() {
        return new MbJltm.Builder();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tmid=").append(tmid);
        sb.append(", tmmbid=").append(tmmbid);
        sb.append(", tmfzid=").append(tmfzid);
        sb.append(", tmlx=").append(tmlx);
        sb.append(", tmmc=").append(tmmc);
        sb.append(", tmms=").append(tmms);
        sb.append(", tmbz=").append(tmbz);
        sb.append(", bh=").append(bh);
        sb.append(", tmpx=").append(tmpx);
        sb.append(", mrz=").append(mrz);
        sb.append(", yxwk=").append(yxwk);
        sb.append(", zxz=").append(zxz);
        sb.append(", zdz=").append(zdz);
        sb.append(", yzgz=").append(yzgz);
        sb.append(", cwts=").append(cwts);
        sb.append(", kscj=").append(kscj);
        sb.append(", jscj=").append(jscj);
        sb.append(", enableStatus=").append(enableStatus);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", createId=").append(createId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateId=").append(updateId);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        MbJltm other = (MbJltm) that;
        return (this.getTmid() == null ? other.getTmid() == null : this.getTmid().equals(other.getTmid()))
            && (this.getTmmbid() == null ? other.getTmmbid() == null : this.getTmmbid().equals(other.getTmmbid()))
            && (this.getTmfzid() == null ? other.getTmfzid() == null : this.getTmfzid().equals(other.getTmfzid()))
            && (this.getTmlx() == null ? other.getTmlx() == null : this.getTmlx().equals(other.getTmlx()))
            && (this.getTmmc() == null ? other.getTmmc() == null : this.getTmmc().equals(other.getTmmc()))
            && (this.getTmms() == null ? other.getTmms() == null : this.getTmms().equals(other.getTmms()))
            && (this.getTmbz() == null ? other.getTmbz() == null : this.getTmbz().equals(other.getTmbz()))
            && (this.getBh() == null ? other.getBh() == null : this.getBh().equals(other.getBh()))
            && (this.getTmpx() == null ? other.getTmpx() == null : this.getTmpx().equals(other.getTmpx()))
            && (this.getMrz() == null ? other.getMrz() == null : this.getMrz().equals(other.getMrz()))
            && (this.getYxwk() == null ? other.getYxwk() == null : this.getYxwk().equals(other.getYxwk()))
            && (this.getZxz() == null ? other.getZxz() == null : this.getZxz().equals(other.getZxz()))
            && (this.getZdz() == null ? other.getZdz() == null : this.getZdz().equals(other.getZdz()))
            && (this.getYzgz() == null ? other.getYzgz() == null : this.getYzgz().equals(other.getYzgz()))
            && (this.getCwts() == null ? other.getCwts() == null : this.getCwts().equals(other.getCwts()))
            && (this.getKscj() == null ? other.getKscj() == null : this.getKscj().equals(other.getKscj()))
            && (this.getJscj() == null ? other.getJscj() == null : this.getJscj().equals(other.getJscj()))
            && (this.getEnableStatus() == null ? other.getEnableStatus() == null : this.getEnableStatus().equals(other.getEnableStatus()))
            && (this.getDeleteStatus() == null ? other.getDeleteStatus() == null : this.getDeleteStatus().equals(other.getDeleteStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateId() == null ? other.getUpdateId() == null : this.getUpdateId().equals(other.getUpdateId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTmid() == null) ? 0 : getTmid().hashCode());
        result = prime * result + ((getTmmbid() == null) ? 0 : getTmmbid().hashCode());
        result = prime * result + ((getTmfzid() == null) ? 0 : getTmfzid().hashCode());
        result = prime * result + ((getTmlx() == null) ? 0 : getTmlx().hashCode());
        result = prime * result + ((getTmmc() == null) ? 0 : getTmmc().hashCode());
        result = prime * result + ((getTmms() == null) ? 0 : getTmms().hashCode());
        result = prime * result + ((getTmbz() == null) ? 0 : getTmbz().hashCode());
        result = prime * result + ((getBh() == null) ? 0 : getBh().hashCode());
        result = prime * result + ((getTmpx() == null) ? 0 : getTmpx().hashCode());
        result = prime * result + ((getMrz() == null) ? 0 : getMrz().hashCode());
        result = prime * result + ((getYxwk() == null) ? 0 : getYxwk().hashCode());
        result = prime * result + ((getZxz() == null) ? 0 : getZxz().hashCode());
        result = prime * result + ((getZdz() == null) ? 0 : getZdz().hashCode());
        result = prime * result + ((getYzgz() == null) ? 0 : getYzgz().hashCode());
        result = prime * result + ((getCwts() == null) ? 0 : getCwts().hashCode());
        result = prime * result + ((getKscj() == null) ? 0 : getKscj().hashCode());
        result = prime * result + ((getJscj() == null) ? 0 : getJscj().hashCode());
        result = prime * result + ((getEnableStatus() == null) ? 0 : getEnableStatus().hashCode());
        result = prime * result + ((getDeleteStatus() == null) ? 0 : getDeleteStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateId() == null) ? 0 : getCreateId().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateId() == null) ? 0 : getUpdateId().hashCode());
        return result;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_MB_JLTM
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static class Builder {
        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table TB_MB_JLTM
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private MbJltm obj;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table TB_MB_JLTM
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder() {
            this.obj = new MbJltm();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column TB_MB_JLTM.TMID
         *
         * @param tmid the value for TB_MB_JLTM.TMID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder tmid(String tmid) {
            obj.setTmid(tmid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column TB_MB_JLTM.TMMBID
         *
         * @param tmmbid the value for TB_MB_JLTM.TMMBID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder tmmbid(String tmmbid) {
            obj.setTmmbid(tmmbid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column TB_MB_JLTM.TMFZID
         *
         * @param tmfzid the value for TB_MB_JLTM.TMFZID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder tmfzid(String tmfzid) {
            obj.setTmfzid(tmfzid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column TB_MB_JLTM.TMLX
         *
         * @param tmlx the value for TB_MB_JLTM.TMLX
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder tmlx(String tmlx) {
            obj.setTmlx(tmlx);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column TB_MB_JLTM.TMMC
         *
         * @param tmmc the value for TB_MB_JLTM.TMMC
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder tmmc(String tmmc) {
            obj.setTmmc(tmmc);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column TB_MB_JLTM.TMMS
         *
         * @param tmms the value for TB_MB_JLTM.TMMS
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder tmms(String tmms) {
            obj.setTmms(tmms);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column TB_MB_JLTM.TMBZ
         *
         * @param tmbz the value for TB_MB_JLTM.TMBZ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder tmbz(String tmbz) {
            obj.setTmbz(tmbz);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column TB_MB_JLTM.BH
         *
         * @param bh the value for TB_MB_JLTM.BH
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder bh(String bh) {
            obj.setBh(bh);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column TB_MB_JLTM.TMPX
         *
         * @param tmpx the value for TB_MB_JLTM.TMPX
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder tmpx(Integer tmpx) {
            obj.setTmpx(tmpx);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column TB_MB_JLTM.MRZ
         *
         * @param mrz the value for TB_MB_JLTM.MRZ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder mrz(String mrz) {
            obj.setMrz(mrz);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column TB_MB_JLTM.YXWK
         *
         * @param yxwk the value for TB_MB_JLTM.YXWK
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder yxwk(String yxwk) {
            obj.setYxwk(yxwk);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column TB_MB_JLTM.ZXZ
         *
         * @param zxz the value for TB_MB_JLTM.ZXZ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder zxz(Long zxz) {
            obj.setZxz(zxz);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column TB_MB_JLTM.ZDZ
         *
         * @param zdz the value for TB_MB_JLTM.ZDZ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder zdz(Long zdz) {
            obj.setZdz(zdz);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column TB_MB_JLTM.YZGZ
         *
         * @param yzgz the value for TB_MB_JLTM.YZGZ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder yzgz(String yzgz) {
            obj.setYzgz(yzgz);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column TB_MB_JLTM.CWTS
         *
         * @param cwts the value for TB_MB_JLTM.CWTS
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder cwts(String cwts) {
            obj.setCwts(cwts);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column TB_MB_JLTM.KSCJ
         *
         * @param kscj the value for TB_MB_JLTM.KSCJ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder kscj(Integer kscj) {
            obj.setKscj(kscj);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column TB_MB_JLTM.JSCJ
         *
         * @param jscj the value for TB_MB_JLTM.JSCJ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder jscj(Integer jscj) {
            obj.setJscj(jscj);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column TB_MB_JLTM.ENABLE_STATUS
         *
         * @param enableStatus the value for TB_MB_JLTM.ENABLE_STATUS
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder enableStatus(String enableStatus) {
            obj.setEnableStatus(enableStatus);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column TB_MB_JLTM.DELETE_STATUS
         *
         * @param deleteStatus the value for TB_MB_JLTM.DELETE_STATUS
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder deleteStatus(String deleteStatus) {
            obj.setDeleteStatus(deleteStatus);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column TB_MB_JLTM.CREATE_TIME
         *
         * @param createTime the value for TB_MB_JLTM.CREATE_TIME
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder createTime(String createTime) {
            obj.setCreateTime(createTime);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column TB_MB_JLTM.CREATE_ID
         *
         * @param createId the value for TB_MB_JLTM.CREATE_ID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder createId(String createId) {
            obj.setCreateId(createId);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column TB_MB_JLTM.UPDATE_TIME
         *
         * @param updateTime the value for TB_MB_JLTM.UPDATE_TIME
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder updateTime(String updateTime) {
            obj.setUpdateTime(updateTime);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column TB_MB_JLTM.UPDATE_ID
         *
         * @param updateId the value for TB_MB_JLTM.UPDATE_ID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder updateId(String updateId) {
            obj.setUpdateId(updateId);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table TB_MB_JLTM
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public MbJltm build() {
            return this.obj;
        }
    }

	public List<MbJlxx> getMbJlxxes() {
		return mbJlxxes;
	}

	public void setMbJlxxes(List<MbJlxx> mbJlxxes) {
		this.mbJlxxes = mbJlxxes;
	}
}