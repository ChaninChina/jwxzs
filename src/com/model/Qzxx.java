package com.model;

import com.util.model.BasicObject;
import java.io.Serializable;
import java.util.List;

/**
 * @TableName tb_qzxx
 * @Data 2017-12-28
 * @Author chanin 
 * 群组信息
 */
public class Qzxx extends BasicObject implements Serializable {
    // 群组主键 (主健ID)
    private String qzid;

    // 群主主键(必填项)
    private String yhid;

    // 群组分组主键(可选项)
    private String qzfzid;

    // 群组编号(必填项)
    private String qzbh;

    // 群组类型(必填项)
    private String qzlx;

    // 群组级别(必填项)
    private String qzjb;

    // 群组名称(必填项)
    private String qzmc;

    // 群组首拼(必填项)
    private String qzsp;

    // 群组排序(必填项)
    private Integer qzpx;

    // 群组简介(可选项)
    private String qzjj;

    // 群组备注(可选项)
    private String qzbz;

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

    private static final long serialVersionUID = 1L;
    
    
    //------------------------
  	//业务逻辑使用属性
  	//------------------------
    private Yhxx yhxx;//群主信息
    
    private List<Yhxx> yhxxs;//管理员信息
    
    private YhQz yhQz;//用户群组
    
    

    
    public String getQzid() {
        return qzid;
    }

    public void setQzid(String qzid) {
        this.qzid = qzid == null ? null : qzid.trim();
    }

    public String getYhid() {
        return yhid;
    }

    public void setYhid(String yhid) {
        this.yhid = yhid == null ? null : yhid.trim();
    }

    public String getQzfzid() {
        return qzfzid;
    }

    public void setQzfzid(String qzfzid) {
        this.qzfzid = qzfzid == null ? null : qzfzid.trim();
    }

    public String getQzbh() {
        return qzbh;
    }

    public void setQzbh(String qzbh) {
        this.qzbh = qzbh == null ? null : qzbh.trim();
    }

    public String getQzlx() {
        return qzlx;
    }

    public void setQzlx(String qzlx) {
        this.qzlx = qzlx == null ? null : qzlx.trim();
    }

    public String getQzjb() {
        return qzjb;
    }

    public void setQzjb(String qzjb) {
        this.qzjb = qzjb == null ? null : qzjb.trim();
    }

    public String getQzmc() {
        return qzmc;
    }

    public void setQzmc(String qzmc) {
        this.qzmc = qzmc == null ? null : qzmc.trim();
    }

    public String getQzsp() {
        return qzsp;
    }

    public void setQzsp(String qzsp) {
        this.qzsp = qzsp == null ? null : qzsp.trim();
    }

    public Integer getQzpx() {
        return qzpx;
    }

    public void setQzpx(Integer qzpx) {
        this.qzpx = qzpx;
    }

    public String getQzjj() {
        return qzjj;
    }

    public void setQzjj(String qzjj) {
        this.qzjj = qzjj == null ? null : qzjj.trim();
    }

    public String getQzbz() {
        return qzbz;
    }

    public void setQzbz(String qzbz) {
        this.qzbz = qzbz == null ? null : qzbz.trim();
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
     * This method corresponds to the database table tb_qzxx
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static Qzxx.Builder builder() {
        return new Qzxx.Builder();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", qzid=").append(qzid);
        sb.append(", yhid=").append(yhid);
        sb.append(", qzfzid=").append(qzfzid);
        sb.append(", qzbh=").append(qzbh);
        sb.append(", qzlx=").append(qzlx);
        sb.append(", qzjb=").append(qzjb);
        sb.append(", qzmc=").append(qzmc);
        sb.append(", qzsp=").append(qzsp);
        sb.append(", qzpx=").append(qzpx);
        sb.append(", qzjj=").append(qzjj);
        sb.append(", qzbz=").append(qzbz);
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
        Qzxx other = (Qzxx) that;
        return (this.getQzid() == null ? other.getQzid() == null : this.getQzid().equals(other.getQzid()))
            && (this.getYhid() == null ? other.getYhid() == null : this.getYhid().equals(other.getYhid()))
            && (this.getQzfzid() == null ? other.getQzfzid() == null : this.getQzfzid().equals(other.getQzfzid()))
            && (this.getQzbh() == null ? other.getQzbh() == null : this.getQzbh().equals(other.getQzbh()))
            && (this.getQzlx() == null ? other.getQzlx() == null : this.getQzlx().equals(other.getQzlx()))
            && (this.getQzjb() == null ? other.getQzjb() == null : this.getQzjb().equals(other.getQzjb()))
            && (this.getQzmc() == null ? other.getQzmc() == null : this.getQzmc().equals(other.getQzmc()))
            && (this.getQzsp() == null ? other.getQzsp() == null : this.getQzsp().equals(other.getQzsp()))
            && (this.getQzpx() == null ? other.getQzpx() == null : this.getQzpx().equals(other.getQzpx()))
            && (this.getQzjj() == null ? other.getQzjj() == null : this.getQzjj().equals(other.getQzjj()))
            && (this.getQzbz() == null ? other.getQzbz() == null : this.getQzbz().equals(other.getQzbz()))
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
        result = prime * result + ((getQzid() == null) ? 0 : getQzid().hashCode());
        result = prime * result + ((getYhid() == null) ? 0 : getYhid().hashCode());
        result = prime * result + ((getQzfzid() == null) ? 0 : getQzfzid().hashCode());
        result = prime * result + ((getQzbh() == null) ? 0 : getQzbh().hashCode());
        result = prime * result + ((getQzlx() == null) ? 0 : getQzlx().hashCode());
        result = prime * result + ((getQzjb() == null) ? 0 : getQzjb().hashCode());
        result = prime * result + ((getQzmc() == null) ? 0 : getQzmc().hashCode());
        result = prime * result + ((getQzsp() == null) ? 0 : getQzsp().hashCode());
        result = prime * result + ((getQzpx() == null) ? 0 : getQzpx().hashCode());
        result = prime * result + ((getQzjj() == null) ? 0 : getQzjj().hashCode());
        result = prime * result + ((getQzbz() == null) ? 0 : getQzbz().hashCode());
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
     * This class corresponds to the database table tb_qzxx
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static class Builder {
        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table tb_qzxx
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private Qzxx obj;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table tb_qzxx
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder() {
            this.obj = new Qzxx();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_qzxx.QZID
         *
         * @param qzid the value for tb_qzxx.QZID
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
         * This method sets the value of the database column tb_qzxx.YHID
         *
         * @param yhid the value for tb_qzxx.YHID
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
         * This method sets the value of the database column tb_qzxx.QZFZID
         *
         * @param qzfzid the value for tb_qzxx.QZFZID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder qzfzid(String qzfzid) {
            obj.setQzfzid(qzfzid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_qzxx.QZBH
         *
         * @param qzbh the value for tb_qzxx.QZBH
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder qzbh(String qzbh) {
            obj.setQzbh(qzbh);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_qzxx.QZLX
         *
         * @param qzlx the value for tb_qzxx.QZLX
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder qzlx(String qzlx) {
            obj.setQzlx(qzlx);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_qzxx.QZJB
         *
         * @param qzjb the value for tb_qzxx.QZJB
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder qzjb(String qzjb) {
            obj.setQzjb(qzjb);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_qzxx.QZMC
         *
         * @param qzmc the value for tb_qzxx.QZMC
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder qzmc(String qzmc) {
            obj.setQzmc(qzmc);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_qzxx.QZSP
         *
         * @param qzsp the value for tb_qzxx.QZSP
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder qzsp(String qzsp) {
            obj.setQzsp(qzsp);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_qzxx.QZPX
         *
         * @param qzpx the value for tb_qzxx.QZPX
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder qzpx(Integer qzpx) {
            obj.setQzpx(qzpx);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_qzxx.QZJJ
         *
         * @param qzjj the value for tb_qzxx.QZJJ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder qzjj(String qzjj) {
            obj.setQzjj(qzjj);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_qzxx.QZBZ
         *
         * @param qzbz the value for tb_qzxx.QZBZ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder qzbz(String qzbz) {
            obj.setQzbz(qzbz);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_qzxx.ENABLE_STATUS
         *
         * @param enableStatus the value for tb_qzxx.ENABLE_STATUS
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
         * This method sets the value of the database column tb_qzxx.DELETE_STATUS
         *
         * @param deleteStatus the value for tb_qzxx.DELETE_STATUS
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
         * This method sets the value of the database column tb_qzxx.CREATE_TIME
         *
         * @param createTime the value for tb_qzxx.CREATE_TIME
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
         * This method sets the value of the database column tb_qzxx.CREATE_ID
         *
         * @param createId the value for tb_qzxx.CREATE_ID
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
         * This method sets the value of the database column tb_qzxx.UPDATE_TIME
         *
         * @param updateTime the value for tb_qzxx.UPDATE_TIME
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
         * This method sets the value of the database column tb_qzxx.UPDATE_ID
         *
         * @param updateId the value for tb_qzxx.UPDATE_ID
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
         * This method corresponds to the database table tb_qzxx
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Qzxx build() {
            return this.obj;
        }
    }

	public Yhxx getYhxx() {
		return yhxx;
	}

	public void setYhxx(Yhxx yhxx) {
		this.yhxx = yhxx;
	}

	public List<Yhxx> getYhxxs() {
		return yhxxs;
	}

	public void setYhxxs(List<Yhxx> yhxxs) {
		this.yhxxs = yhxxs;
	}

	public YhQz getYhQz() {
		return yhQz;
	}

	public void setYhQz(YhQz yhQz) {
		this.yhQz = yhQz;
	}
}