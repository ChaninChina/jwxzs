package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.util.model.BasicObject;
import java.io.Serializable;

/**
 * @TableName tb_yhxx
 * @Data 2017-12-28
 * @Author chanin 
 * 用户基本信息
 */
public class Yhxx extends BasicObject implements Serializable {
    // 用户主键 (主健ID)
	@JsonIgnore
    private String yhid;

    // 机构主键(可选项)
    private String orgnId;

    // 用户姓名(必填项)
    private String yhxm;

    // 用户首拼(必填项)
    private String yhsp;

    // 用户类型(必填项)
    private String yhlx;

    // 用户性别(必填项)
    private String yhxb;

    // 联系电话(必填项)
    private String lxdh;

    // 身份证号(必填项)
    private String sfzh;

    // 用户职务(必填项)
    private String yhzw;

    // 所在单位(可选项)
    private String szdw;

    // 管理员标志：是、否(必填项)
    @JsonIgnore
    private String glybz;

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

    private static final long serialVersionUID = 1L;

    public String getYhid() {
        return yhid;
    }

    public void setYhid(String yhid) {
        this.yhid = yhid == null ? null : yhid.trim();
    }

    public String getOrgnId() {
        return orgnId;
    }

    public void setOrgnId(String orgnId) {
        this.orgnId = orgnId == null ? null : orgnId.trim();
    }

    public String getYhxm() {
        return yhxm;
    }

    public void setYhxm(String yhxm) {
        this.yhxm = yhxm == null ? null : yhxm.trim();
    }

    public String getYhsp() {
        return yhsp;
    }

    public void setYhsp(String yhsp) {
        this.yhsp = yhsp == null ? null : yhsp.trim();
    }

    public String getYhlx() {
        return yhlx;
    }

    public void setYhlx(String yhlx) {
        this.yhlx = yhlx == null ? null : yhlx.trim();
    }

    public String getYhxb() {
        return yhxb;
    }

    public void setYhxb(String yhxb) {
        this.yhxb = yhxb == null ? null : yhxb.trim();
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh == null ? null : lxdh.trim();
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh == null ? null : sfzh.trim();
    }

    public String getYhzw() {
        return yhzw;
    }

    public void setYhzw(String yhzw) {
        this.yhzw = yhzw == null ? null : yhzw.trim();
    }

    public String getSzdw() {
        return szdw;
    }

    public void setSzdw(String szdw) {
        this.szdw = szdw == null ? null : szdw.trim();
    }

    public String getGlybz() {
        return glybz;
    }

    public void setGlybz(String glybz) {
        this.glybz = glybz == null ? null : glybz.trim();
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
     * This method corresponds to the database table tb_yhxx
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static Yhxx.Builder builder() {
        return new Yhxx.Builder();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", yhid=").append(yhid);
        sb.append(", orgnId=").append(orgnId);
        sb.append(", yhxm=").append(yhxm);
        sb.append(", yhsp=").append(yhsp);
        sb.append(", yhlx=").append(yhlx);
        sb.append(", yhxb=").append(yhxb);
        sb.append(", lxdh=").append(lxdh);
        sb.append(", sfzh=").append(sfzh);
        sb.append(", yhzw=").append(yhzw);
        sb.append(", szdw=").append(szdw);
        sb.append(", glybz=").append(glybz);
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
        Yhxx other = (Yhxx) that;
        return (this.getYhid() == null ? other.getYhid() == null : this.getYhid().equals(other.getYhid()))
            && (this.getOrgnId() == null ? other.getOrgnId() == null : this.getOrgnId().equals(other.getOrgnId()))
            && (this.getYhxm() == null ? other.getYhxm() == null : this.getYhxm().equals(other.getYhxm()))
            && (this.getYhsp() == null ? other.getYhsp() == null : this.getYhsp().equals(other.getYhsp()))
            && (this.getYhlx() == null ? other.getYhlx() == null : this.getYhlx().equals(other.getYhlx()))
            && (this.getYhxb() == null ? other.getYhxb() == null : this.getYhxb().equals(other.getYhxb()))
            && (this.getLxdh() == null ? other.getLxdh() == null : this.getLxdh().equals(other.getLxdh()))
            && (this.getSfzh() == null ? other.getSfzh() == null : this.getSfzh().equals(other.getSfzh()))
            && (this.getYhzw() == null ? other.getYhzw() == null : this.getYhzw().equals(other.getYhzw()))
            && (this.getSzdw() == null ? other.getSzdw() == null : this.getSzdw().equals(other.getSzdw()))
            && (this.getGlybz() == null ? other.getGlybz() == null : this.getGlybz().equals(other.getGlybz()))
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
        result = prime * result + ((getYhid() == null) ? 0 : getYhid().hashCode());
        result = prime * result + ((getOrgnId() == null) ? 0 : getOrgnId().hashCode());
        result = prime * result + ((getYhxm() == null) ? 0 : getYhxm().hashCode());
        result = prime * result + ((getYhsp() == null) ? 0 : getYhsp().hashCode());
        result = prime * result + ((getYhlx() == null) ? 0 : getYhlx().hashCode());
        result = prime * result + ((getYhxb() == null) ? 0 : getYhxb().hashCode());
        result = prime * result + ((getLxdh() == null) ? 0 : getLxdh().hashCode());
        result = prime * result + ((getSfzh() == null) ? 0 : getSfzh().hashCode());
        result = prime * result + ((getYhzw() == null) ? 0 : getYhzw().hashCode());
        result = prime * result + ((getSzdw() == null) ? 0 : getSzdw().hashCode());
        result = prime * result + ((getGlybz() == null) ? 0 : getGlybz().hashCode());
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
     * This class corresponds to the database table tb_yhxx
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static class Builder {
        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table tb_yhxx
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private Yhxx obj;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table tb_yhxx
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder() {
            this.obj = new Yhxx();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_yhxx.YHID
         *
         * @param yhid the value for tb_yhxx.YHID
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
         * This method sets the value of the database column tb_yhxx.ORGN_ID
         *
         * @param orgnId the value for tb_yhxx.ORGN_ID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder orgnId(String orgnId) {
            obj.setOrgnId(orgnId);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_yhxx.YHXM
         *
         * @param yhxm the value for tb_yhxx.YHXM
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder yhxm(String yhxm) {
            obj.setYhxm(yhxm);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_yhxx.YHSP
         *
         * @param yhsp the value for tb_yhxx.YHSP
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder yhsp(String yhsp) {
            obj.setYhsp(yhsp);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_yhxx.YHLX
         *
         * @param yhlx the value for tb_yhxx.YHLX
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder yhlx(String yhlx) {
            obj.setYhlx(yhlx);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_yhxx.YHXB
         *
         * @param yhxb the value for tb_yhxx.YHXB
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder yhxb(String yhxb) {
            obj.setYhxb(yhxb);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_yhxx.LXDH
         *
         * @param lxdh the value for tb_yhxx.LXDH
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder lxdh(String lxdh) {
            obj.setLxdh(lxdh);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_yhxx.SFZH
         *
         * @param sfzh the value for tb_yhxx.SFZH
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder sfzh(String sfzh) {
            obj.setSfzh(sfzh);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_yhxx.YHZW
         *
         * @param yhzw the value for tb_yhxx.YHZW
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder yhzw(String yhzw) {
            obj.setYhzw(yhzw);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_yhxx.SZDW
         *
         * @param szdw the value for tb_yhxx.SZDW
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder szdw(String szdw) {
            obj.setSzdw(szdw);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_yhxx.GLYBZ
         *
         * @param glybz the value for tb_yhxx.GLYBZ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder glybz(String glybz) {
            obj.setGlybz(glybz);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_yhxx.ENABLE_STATUS
         *
         * @param enableStatus the value for tb_yhxx.ENABLE_STATUS
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
         * This method sets the value of the database column tb_yhxx.DELETE_STATUS
         *
         * @param deleteStatus the value for tb_yhxx.DELETE_STATUS
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
         * This method sets the value of the database column tb_yhxx.CREATE_TIME
         *
         * @param createTime the value for tb_yhxx.CREATE_TIME
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
         * This method sets the value of the database column tb_yhxx.CREATE_ID
         *
         * @param createId the value for tb_yhxx.CREATE_ID
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
         * This method sets the value of the database column tb_yhxx.UPDATE_TIME
         *
         * @param updateTime the value for tb_yhxx.UPDATE_TIME
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
         * This method sets the value of the database column tb_yhxx.UPDATE_ID
         *
         * @param updateId the value for tb_yhxx.UPDATE_ID
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
         * This method corresponds to the database table tb_yhxx
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Yhxx build() {
            return this.obj;
        }
    }
}