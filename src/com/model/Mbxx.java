package com.model;

import com.util.model.BasicObject;
import java.io.Serializable;
import java.util.List;

/**
 * @TableName tb_mbxx
 * @Data 2017-12-28
 * @Author chanin 
 * 模板基本信息
 */
public class Mbxx extends BasicObject implements Serializable {
    // 模板主键 (主健ID)
    private String mbid;

    // 父模板主键(可选项)
    private String fmbid;

    // 模板分组主键(可选项)
    private String mbfzid;

    // 模板类型(必填项)
    private String mblxid;

    // 模板名称(必填项)
    private String mbmc;

    // 模板首拼(必填项)
    private String mbsp;

    // 模板描述(可选项)
    private String mbms;

    // 模板备注(可选项)
    private String mbbz;

    // 模板排序(必填项)
    private Integer mbpx;

    // 群主主键(可选项)
    private String yhid;

    // 共享类型：不共享、共享到系统、共享到群(必填项)
    private String gxlxid;

    // 共享范围(可选项)
    private String gxqzId;

    // 提醒类型(必填项)
    private String txlxid;

    // 记录周期最大值(可选项)
    private Integer jlzqZdz;

    // 记录周期最小值(可选项)
    private Integer jlzqZxz;

    // 记录周期值(可选项)
    private Integer jlzqQdz;

    // 记录周期类型(必填项)
    private String jlzqlx;

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
    private List<MbTmfz> mbTmfzs; //模板条目分组信息
    
    private List<MbTmkz> mbtmkzs; //模板条目控制信息
    
    
    

    private static final long serialVersionUID = 1L;

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid == null ? null : mbid.trim();
    }

    public String getFmbid() {
        return fmbid;
    }

    public void setFmbid(String fmbid) {
        this.fmbid = fmbid == null ? null : fmbid.trim();
    }

    public String getMbfzid() {
        return mbfzid;
    }

    public void setMbfzid(String mbfzid) {
        this.mbfzid = mbfzid == null ? null : mbfzid.trim();
    }

    public String getMblxid() {
        return mblxid;
    }

    public void setMblxid(String mblxid) {
        this.mblxid = mblxid == null ? null : mblxid.trim();
    }

    public String getMbmc() {
        return mbmc;
    }

    public void setMbmc(String mbmc) {
        this.mbmc = mbmc == null ? null : mbmc.trim();
    }

    public String getMbsp() {
        return mbsp;
    }

    public void setMbsp(String mbsp) {
        this.mbsp = mbsp == null ? null : mbsp.trim();
    }

    public String getMbms() {
        return mbms;
    }

    public void setMbms(String mbms) {
        this.mbms = mbms == null ? null : mbms.trim();
    }

    public String getMbbz() {
        return mbbz;
    }

    public void setMbbz(String mbbz) {
        this.mbbz = mbbz == null ? null : mbbz.trim();
    }

    public Integer getMbpx() {
        return mbpx;
    }

    public void setMbpx(Integer mbpx) {
        this.mbpx = mbpx;
    }

    public String getYhid() {
        return yhid;
    }

    public void setYhid(String yhid) {
        this.yhid = yhid == null ? null : yhid.trim();
    }

    public String getGxlxid() {
        return gxlxid;
    }

    public void setGxlxid(String gxlxid) {
        this.gxlxid = gxlxid == null ? null : gxlxid.trim();
    }

    public String getGxqzId() {
        return gxqzId;
    }

    public void setGxqzId(String gxqzId) {
        this.gxqzId = gxqzId == null ? null : gxqzId.trim();
    }

    public String getTxlxid() {
        return txlxid;
    }

    public void setTxlxid(String txlxid) {
        this.txlxid = txlxid == null ? null : txlxid.trim();
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
     * This method corresponds to the database table tb_mbxx
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static Mbxx.Builder builder() {
        return new Mbxx.Builder();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mbid=").append(mbid);
        sb.append(", fmbid=").append(fmbid);
        sb.append(", mbfzid=").append(mbfzid);
        sb.append(", mblxid=").append(mblxid);
        sb.append(", mbmc=").append(mbmc);
        sb.append(", mbsp=").append(mbsp);
        sb.append(", mbms=").append(mbms);
        sb.append(", mbbz=").append(mbbz);
        sb.append(", mbpx=").append(mbpx);
        sb.append(", yhid=").append(yhid);
        sb.append(", gxlxid=").append(gxlxid);
        sb.append(", gxqzId=").append(gxqzId);
        sb.append(", txlxid=").append(txlxid);
        sb.append(", jlzqZdz=").append(jlzqZdz);
        sb.append(", jlzqZxz=").append(jlzqZxz);
        sb.append(", jlzqQdz=").append(jlzqQdz);
        sb.append(", jlzqlx=").append(jlzqlx);
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
        Mbxx other = (Mbxx) that;
        return (this.getMbid() == null ? other.getMbid() == null : this.getMbid().equals(other.getMbid()))
            && (this.getFmbid() == null ? other.getFmbid() == null : this.getFmbid().equals(other.getFmbid()))
            && (this.getMbfzid() == null ? other.getMbfzid() == null : this.getMbfzid().equals(other.getMbfzid()))
            && (this.getMblxid() == null ? other.getMblxid() == null : this.getMblxid().equals(other.getMblxid()))
            && (this.getMbmc() == null ? other.getMbmc() == null : this.getMbmc().equals(other.getMbmc()))
            && (this.getMbsp() == null ? other.getMbsp() == null : this.getMbsp().equals(other.getMbsp()))
            && (this.getMbms() == null ? other.getMbms() == null : this.getMbms().equals(other.getMbms()))
            && (this.getMbbz() == null ? other.getMbbz() == null : this.getMbbz().equals(other.getMbbz()))
            && (this.getMbpx() == null ? other.getMbpx() == null : this.getMbpx().equals(other.getMbpx()))
            && (this.getYhid() == null ? other.getYhid() == null : this.getYhid().equals(other.getYhid()))
            && (this.getGxlxid() == null ? other.getGxlxid() == null : this.getGxlxid().equals(other.getGxlxid()))
            && (this.getGxqzId() == null ? other.getGxqzId() == null : this.getGxqzId().equals(other.getGxqzId()))
            && (this.getTxlxid() == null ? other.getTxlxid() == null : this.getTxlxid().equals(other.getTxlxid()))
            && (this.getJlzqZdz() == null ? other.getJlzqZdz() == null : this.getJlzqZdz().equals(other.getJlzqZdz()))
            && (this.getJlzqZxz() == null ? other.getJlzqZxz() == null : this.getJlzqZxz().equals(other.getJlzqZxz()))
            && (this.getJlzqQdz() == null ? other.getJlzqQdz() == null : this.getJlzqQdz().equals(other.getJlzqQdz()))
            && (this.getJlzqlx() == null ? other.getJlzqlx() == null : this.getJlzqlx().equals(other.getJlzqlx()))
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
        result = prime * result + ((getMbid() == null) ? 0 : getMbid().hashCode());
        result = prime * result + ((getFmbid() == null) ? 0 : getFmbid().hashCode());
        result = prime * result + ((getMbfzid() == null) ? 0 : getMbfzid().hashCode());
        result = prime * result + ((getMblxid() == null) ? 0 : getMblxid().hashCode());
        result = prime * result + ((getMbmc() == null) ? 0 : getMbmc().hashCode());
        result = prime * result + ((getMbsp() == null) ? 0 : getMbsp().hashCode());
        result = prime * result + ((getMbms() == null) ? 0 : getMbms().hashCode());
        result = prime * result + ((getMbbz() == null) ? 0 : getMbbz().hashCode());
        result = prime * result + ((getMbpx() == null) ? 0 : getMbpx().hashCode());
        result = prime * result + ((getYhid() == null) ? 0 : getYhid().hashCode());
        result = prime * result + ((getGxlxid() == null) ? 0 : getGxlxid().hashCode());
        result = prime * result + ((getGxqzId() == null) ? 0 : getGxqzId().hashCode());
        result = prime * result + ((getTxlxid() == null) ? 0 : getTxlxid().hashCode());
        result = prime * result + ((getJlzqZdz() == null) ? 0 : getJlzqZdz().hashCode());
        result = prime * result + ((getJlzqZxz() == null) ? 0 : getJlzqZxz().hashCode());
        result = prime * result + ((getJlzqQdz() == null) ? 0 : getJlzqQdz().hashCode());
        result = prime * result + ((getJlzqlx() == null) ? 0 : getJlzqlx().hashCode());
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
     * This class corresponds to the database table tb_mbxx
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static class Builder {
        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table tb_mbxx
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private Mbxx obj;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table tb_mbxx
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder() {
            this.obj = new Mbxx();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mbxx.MBID
         *
         * @param mbid the value for tb_mbxx.MBID
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
         * This method sets the value of the database column tb_mbxx.FMBID
         *
         * @param fmbid the value for tb_mbxx.FMBID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder fmbid(String fmbid) {
            obj.setFmbid(fmbid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mbxx.MBFZID
         *
         * @param mbfzid the value for tb_mbxx.MBFZID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder mbfzid(String mbfzid) {
            obj.setMbfzid(mbfzid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mbxx.MBLXID
         *
         * @param mblxid the value for tb_mbxx.MBLXID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder mblxid(String mblxid) {
            obj.setMblxid(mblxid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mbxx.MBMC
         *
         * @param mbmc the value for tb_mbxx.MBMC
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder mbmc(String mbmc) {
            obj.setMbmc(mbmc);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mbxx.MBSP
         *
         * @param mbsp the value for tb_mbxx.MBSP
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder mbsp(String mbsp) {
            obj.setMbsp(mbsp);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mbxx.MBMS
         *
         * @param mbms the value for tb_mbxx.MBMS
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder mbms(String mbms) {
            obj.setMbms(mbms);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mbxx.MBBZ
         *
         * @param mbbz the value for tb_mbxx.MBBZ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder mbbz(String mbbz) {
            obj.setMbbz(mbbz);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mbxx.MBPX
         *
         * @param mbpx the value for tb_mbxx.MBPX
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder mbpx(Integer mbpx) {
            obj.setMbpx(mbpx);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mbxx.YHID
         *
         * @param yhid the value for tb_mbxx.YHID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder yhid(String yhid) {
            obj.setYhid(yhid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mbxx.GXLXID
         *
         * @param gxlxid the value for tb_mbxx.GXLXID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder gxlxid(String gxlxid) {
            obj.setGxlxid(gxlxid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mbxx.GXQZ_ID
         *
         * @param gxqzId the value for tb_mbxx.GXQZ_ID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder gxqzId(String gxqzId) {
            obj.setGxqzId(gxqzId);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mbxx.TXLXID
         *
         * @param txlxid the value for tb_mbxx.TXLXID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder txlxid(String txlxid) {
            obj.setTxlxid(txlxid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mbxx.JLZQ_ZDZ
         *
         * @param jlzqZdz the value for tb_mbxx.JLZQ_ZDZ
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
         * This method sets the value of the database column tb_mbxx.JLZQ_ZXZ
         *
         * @param jlzqZxz the value for tb_mbxx.JLZQ_ZXZ
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
         * This method sets the value of the database column tb_mbxx.JLZQ_QDZ
         *
         * @param jlzqQdz the value for tb_mbxx.JLZQ_QDZ
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
         * This method sets the value of the database column tb_mbxx.JLZQLX
         *
         * @param jlzqlx the value for tb_mbxx.JLZQLX
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
         * This method sets the value of the database column tb_mbxx.ENABLE_STATUS
         *
         * @param enableStatus the value for tb_mbxx.ENABLE_STATUS
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
         * This method sets the value of the database column tb_mbxx.DELETE_STATUS
         *
         * @param deleteStatus the value for tb_mbxx.DELETE_STATUS
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
         * This method sets the value of the database column tb_mbxx.CREATE_TIME
         *
         * @param createTime the value for tb_mbxx.CREATE_TIME
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
         * This method sets the value of the database column tb_mbxx.CREATE_ID
         *
         * @param createId the value for tb_mbxx.CREATE_ID
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
         * This method sets the value of the database column tb_mbxx.UPDATE_TIME
         *
         * @param updateTime the value for tb_mbxx.UPDATE_TIME
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
         * This method sets the value of the database column tb_mbxx.UPDATE_ID
         *
         * @param updateId the value for tb_mbxx.UPDATE_ID
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
         * This method corresponds to the database table tb_mbxx
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Mbxx build() {
            return this.obj;
        }
    }

	public List<MbTmfz> getMbTmfzs() {
		return mbTmfzs;
	}

	public void setMbTmfzs(List<MbTmfz> mbTmfzs) {
		this.mbTmfzs = mbTmfzs;
	}

	public List<MbTmkz> getMbtmkzs() {
		return mbtmkzs;
	}

	public void setMbtmkzs(List<MbTmkz> mbtmkzs) {
		this.mbtmkzs = mbtmkzs;
	}
}