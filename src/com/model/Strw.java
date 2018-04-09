package com.model;

import java.io.Serializable;

import com.util.model.BasicObject;

/**
 * @TableName tb_strw
 * @Data 2018-01-23
 * @Author chanin 
 * 实体任务信息
 */
public class Strw extends BasicObject implements Serializable {
    // 任务主键 (主健ID)
    private String rwid;

    // 任务名称(可选项)
    private String rwmc;

    // 群组主键(可选项)
    private String qzid;

    // 实体主键(可选项)
    private String stid;

    // 模板主键(可选项)
    private String mbid;

    // 任务分组主键(可选项)
    private String rwfzid;

    // 任务类型：共享任务、个人任务、协同任务(必填项)
    private String rwlx;

    // 提醒类型：不提醒、推送、短信、自动提醒(必填项)
    private String txlx;

    // 记录周期最大值(可选项)
    private Integer jlzqZdz;

    // 记录周期最小值(可选项)
    private Integer jlzqZxz;

    // 记录周期值(可选项)
    private Integer jlzqQdz;

    // 记录周期类型：无、每小时、每日、每周、每月、每季度、每年(必填项)
    private String jlzqlx;

    // 开始时间(可选项)
    private String kssj;

    // 结束时间(可选项)
    private String jssj;

    // 最大记录数(可选项)
    private Long zdjls;

    // 审核标志：需要审核、不需要审核(必填项)
    private String shbz;

    // 
    private Long timeStamp;

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
    
    
    //------------------------
  	//业务逻辑使用属性
  	//------------------------
    private boolean hasPermission;//是否有相关权限
    
    private Stxx stxx;//实体信息
    

    // 完成状态（未完成、已完成）
    private String wczt;

    // 审核状态（已审核、未审核）
    private String shzt;
    
    
    
    private static final long serialVersionUID = 1L;

    public String getRwid() {
        return rwid;
    }

    public void setRwid(String rwid) {
        this.rwid = rwid == null ? null : rwid.trim();
    }

    public String getRwmc() {
        return rwmc;
    }

    public void setRwmc(String rwmc) {
        this.rwmc = rwmc == null ? null : rwmc.trim();
    }

    public String getQzid() {
        return qzid;
    }

    public void setQzid(String qzid) {
        this.qzid = qzid == null ? null : qzid.trim();
    }

    public String getStid() {
        return stid;
    }

    public void setStid(String stid) {
        this.stid = stid == null ? null : stid.trim();
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid == null ? null : mbid.trim();
    }

    public String getRwfzid() {
        return rwfzid;
    }

    public void setRwfzid(String rwfzid) {
        this.rwfzid = rwfzid == null ? null : rwfzid.trim();
    }

    public String getRwlx() {
        return rwlx;
    }

    public void setRwlx(String rwlx) {
        this.rwlx = rwlx == null ? null : rwlx.trim();
    }

    public String getTxlx() {
        return txlx;
    }

    public void setTxlx(String txlx) {
        this.txlx = txlx == null ? null : txlx.trim();
    }

    public Integer getJlzqZdz() {
        return jlzqZdz;
    }

    public void setJlzqZdz(Integer jlzqZdz) {
        this.jlzqZdz = jlzqZdz;
    }

    public Integer getJlzqZxz() {
        return jlzqZxz;
    }

    public void setJlzqZxz(Integer jlzqZxz) {
        this.jlzqZxz = jlzqZxz;
    }

    public Integer getJlzqQdz() {
        return jlzqQdz;
    }

    public void setJlzqQdz(Integer jlzqQdz) {
        this.jlzqQdz = jlzqQdz;
    }

    public String getJlzqlx() {
        return jlzqlx;
    }

    public void setJlzqlx(String jlzqlx) {
        this.jlzqlx = jlzqlx == null ? null : jlzqlx.trim();
    }

    public String getKssj() {
        return kssj;
    }

    public void setKssj(String kssj) {
        this.kssj = kssj == null ? null : kssj.trim();
    }

    public String getJssj() {
        return jssj;
    }

    public void setJssj(String jssj) {
        this.jssj = jssj == null ? null : jssj.trim();
    }

    public Long getZdjls() {
        return zdjls;
    }

    public void setZdjls(Long zdjls) {
        this.zdjls = zdjls;
    }

    public String getShbz() {
        return shbz;
    }

    public void setShbz(String shbz) {
        this.shbz = shbz == null ? null : shbz.trim();
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
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
     * This method corresponds to the database table tb_strw
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static Strw.Builder builder() {
        return new Strw.Builder();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rwid=").append(rwid);
        sb.append(", rwmc=").append(rwmc);
        sb.append(", qzid=").append(qzid);
        sb.append(", stid=").append(stid);
        sb.append(", mbid=").append(mbid);
        sb.append(", rwfzid=").append(rwfzid);
        sb.append(", rwlx=").append(rwlx);
        sb.append(", txlx=").append(txlx);
        sb.append(", jlzqZdz=").append(jlzqZdz);
        sb.append(", jlzqZxz=").append(jlzqZxz);
        sb.append(", jlzqQdz=").append(jlzqQdz);
        sb.append(", jlzqlx=").append(jlzqlx);
        sb.append(", kssj=").append(kssj);
        sb.append(", jssj=").append(jssj);
        sb.append(", zdjls=").append(zdjls);
        sb.append(", shbz=").append(shbz);
        sb.append(", timeStamp=").append(timeStamp);
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
        Strw other = (Strw) that;
        return (this.getRwid() == null ? other.getRwid() == null : this.getRwid().equals(other.getRwid()))
            && (this.getRwmc() == null ? other.getRwmc() == null : this.getRwmc().equals(other.getRwmc()))
            && (this.getQzid() == null ? other.getQzid() == null : this.getQzid().equals(other.getQzid()))
            && (this.getStid() == null ? other.getStid() == null : this.getStid().equals(other.getStid()))
            && (this.getMbid() == null ? other.getMbid() == null : this.getMbid().equals(other.getMbid()))
            && (this.getRwfzid() == null ? other.getRwfzid() == null : this.getRwfzid().equals(other.getRwfzid()))
            && (this.getRwlx() == null ? other.getRwlx() == null : this.getRwlx().equals(other.getRwlx()))
            && (this.getTxlx() == null ? other.getTxlx() == null : this.getTxlx().equals(other.getTxlx()))
            && (this.getJlzqZdz() == null ? other.getJlzqZdz() == null : this.getJlzqZdz().equals(other.getJlzqZdz()))
            && (this.getJlzqZxz() == null ? other.getJlzqZxz() == null : this.getJlzqZxz().equals(other.getJlzqZxz()))
            && (this.getJlzqQdz() == null ? other.getJlzqQdz() == null : this.getJlzqQdz().equals(other.getJlzqQdz()))
            && (this.getJlzqlx() == null ? other.getJlzqlx() == null : this.getJlzqlx().equals(other.getJlzqlx()))
            && (this.getKssj() == null ? other.getKssj() == null : this.getKssj().equals(other.getKssj()))
            && (this.getJssj() == null ? other.getJssj() == null : this.getJssj().equals(other.getJssj()))
            && (this.getZdjls() == null ? other.getZdjls() == null : this.getZdjls().equals(other.getZdjls()))
            && (this.getShbz() == null ? other.getShbz() == null : this.getShbz().equals(other.getShbz()))
            && (this.getTimeStamp() == null ? other.getTimeStamp() == null : this.getTimeStamp().equals(other.getTimeStamp()))
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
        result = prime * result + ((getRwid() == null) ? 0 : getRwid().hashCode());
        result = prime * result + ((getRwmc() == null) ? 0 : getRwmc().hashCode());
        result = prime * result + ((getQzid() == null) ? 0 : getQzid().hashCode());
        result = prime * result + ((getStid() == null) ? 0 : getStid().hashCode());
        result = prime * result + ((getMbid() == null) ? 0 : getMbid().hashCode());
        result = prime * result + ((getRwfzid() == null) ? 0 : getRwfzid().hashCode());
        result = prime * result + ((getRwlx() == null) ? 0 : getRwlx().hashCode());
        result = prime * result + ((getTxlx() == null) ? 0 : getTxlx().hashCode());
        result = prime * result + ((getJlzqZdz() == null) ? 0 : getJlzqZdz().hashCode());
        result = prime * result + ((getJlzqZxz() == null) ? 0 : getJlzqZxz().hashCode());
        result = prime * result + ((getJlzqQdz() == null) ? 0 : getJlzqQdz().hashCode());
        result = prime * result + ((getJlzqlx() == null) ? 0 : getJlzqlx().hashCode());
        result = prime * result + ((getKssj() == null) ? 0 : getKssj().hashCode());
        result = prime * result + ((getJssj() == null) ? 0 : getJssj().hashCode());
        result = prime * result + ((getZdjls() == null) ? 0 : getZdjls().hashCode());
        result = prime * result + ((getShbz() == null) ? 0 : getShbz().hashCode());
        result = prime * result + ((getTimeStamp() == null) ? 0 : getTimeStamp().hashCode());
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
     * This class corresponds to the database table tb_strw
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static class Builder {
        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table tb_strw
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private Strw obj;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table tb_strw
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder() {
            this.obj = new Strw();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_strw.RWID
         *
         * @param rwid the value for tb_strw.RWID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder rwid(String rwid) {
            obj.setRwid(rwid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_strw.RWMC
         *
         * @param rwmc the value for tb_strw.RWMC
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder rwmc(String rwmc) {
            obj.setRwmc(rwmc);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_strw.QZID
         *
         * @param qzid the value for tb_strw.QZID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder qzid(String qzid) {
            obj.setQzid(qzid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_strw.STID
         *
         * @param stid the value for tb_strw.STID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder stid(String stid) {
            obj.setStid(stid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_strw.MBID
         *
         * @param mbid the value for tb_strw.MBID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder mbid(String mbid) {
            obj.setMbid(mbid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_strw.RWFZID
         *
         * @param rwfzid the value for tb_strw.RWFZID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder rwfzid(String rwfzid) {
            obj.setRwfzid(rwfzid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_strw.RWLX
         *
         * @param rwlx the value for tb_strw.RWLX
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder rwlx(String rwlx) {
            obj.setRwlx(rwlx);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_strw.TXLX
         *
         * @param txlx the value for tb_strw.TXLX
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder txlx(String txlx) {
            obj.setTxlx(txlx);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_strw.JLZQ_ZDZ
         *
         * @param jlzqZdz the value for tb_strw.JLZQ_ZDZ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder jlzqZdz(Integer jlzqZdz) {
            obj.setJlzqZdz(jlzqZdz);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_strw.JLZQ_ZXZ
         *
         * @param jlzqZxz the value for tb_strw.JLZQ_ZXZ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder jlzqZxz(Integer jlzqZxz) {
            obj.setJlzqZxz(jlzqZxz);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_strw.JLZQ_QDZ
         *
         * @param jlzqQdz the value for tb_strw.JLZQ_QDZ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder jlzqQdz(Integer jlzqQdz) {
            obj.setJlzqQdz(jlzqQdz);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_strw.JLZQLX
         *
         * @param jlzqlx the value for tb_strw.JLZQLX
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder jlzqlx(String jlzqlx) {
            obj.setJlzqlx(jlzqlx);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_strw.KSSJ
         *
         * @param kssj the value for tb_strw.KSSJ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder kssj(String kssj) {
            obj.setKssj(kssj);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_strw.JSSJ
         *
         * @param jssj the value for tb_strw.JSSJ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder jssj(String jssj) {
            obj.setJssj(jssj);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_strw.ZDJLS
         *
         * @param zdjls the value for tb_strw.ZDJLS
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder zdjls(Long zdjls) {
            obj.setZdjls(zdjls);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_strw.SHBZ
         *
         * @param shbz the value for tb_strw.SHBZ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder shbz(String shbz) {
            obj.setShbz(shbz);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_strw.TIME_STAMP
         *
         * @param timeStamp the value for tb_strw.TIME_STAMP
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder timeStamp(Long timeStamp) {
            obj.setTimeStamp(timeStamp);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_strw.ENABLE_STATUS
         *
         * @param enableStatus the value for tb_strw.ENABLE_STATUS
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
         * This method sets the value of the database column tb_strw.DELETE_STATUS
         *
         * @param deleteStatus the value for tb_strw.DELETE_STATUS
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
         * This method sets the value of the database column tb_strw.CREATE_TIME
         *
         * @param createTime the value for tb_strw.CREATE_TIME
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
         * This method sets the value of the database column tb_strw.CREATE_ID
         *
         * @param createId the value for tb_strw.CREATE_ID
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
         * This method sets the value of the database column tb_strw.UPDATE_TIME
         *
         * @param updateTime the value for tb_strw.UPDATE_TIME
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
         * This method sets the value of the database column tb_strw.UPDATE_ID
         *
         * @param updateId the value for tb_strw.UPDATE_ID
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
         * This method corresponds to the database table tb_strw
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Strw build() {
            return this.obj;
        }
    }

	public boolean isHasPermission() {
		return hasPermission;
	}

	public void setHasPermission(boolean hasPermission) {
		this.hasPermission = hasPermission;
	}

	public Stxx getStxx() {
		return stxx;
	}

	public void setStxx(Stxx stxx) {
		this.stxx = stxx;
	}

	public String getWczt() {
		return wczt;
	}

	public void setWczt(String wczt) {
		this.wczt = wczt;
	}

	public String getShzt() {
		return shzt;
	}

	public void setShzt(String shzt) {
		this.shzt = shzt;
	}
}