package com.model;

import com.util.model.BasicObject;
import java.io.Serializable;

/**
 * @TableName tb_mb_jlxx_kzxx
 * @Data 2017-12-28
 * @Author chanin 
 * 模板记录条目选项扩展信息表
 */
public class MbJlxxKzxx extends BasicObject implements Serializable {
    // 记录选项主键 (主健ID)
    private String xxid;

    // 选项扩展类型(必填项)
    private String xxkzlx;

    // 选项扩展描述(可选项)
    private String xxkzms;

    // 扩展内容备注(可选项)
    private String kznrbz;

    // 允许为空(可选项)
    private String yxwk;

    // 默认值(可选项)
    private String mrz;

    // 扩展内容最小值(可选项)
    private Integer kznrZxz;

    // 扩展内容最大值(可选项)
    private Integer kznrZdz;

    // 扩展内容验证规则(可选项)
    private String kznrYzgz;

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

    public String getXxid() {
        return xxid;
    }

    public void setXxid(String xxid) {
        this.xxid = xxid == null ? null : xxid.trim();
    }

    public String getXxkzlx() {
        return xxkzlx;
    }

    public void setXxkzlx(String xxkzlx) {
        this.xxkzlx = xxkzlx == null ? null : xxkzlx.trim();
    }

    public String getXxkzms() {
        return xxkzms;
    }

    public void setXxkzms(String xxkzms) {
        this.xxkzms = xxkzms == null ? null : xxkzms.trim();
    }

    public String getKznrbz() {
        return kznrbz;
    }

    public void setKznrbz(String kznrbz) {
        this.kznrbz = kznrbz == null ? null : kznrbz.trim();
    }

    public String getYxwk() {
        return yxwk;
    }

    public void setYxwk(String yxwk) {
        this.yxwk = yxwk == null ? null : yxwk.trim();
    }

    public String getMrz() {
        return mrz;
    }

    public void setMrz(String mrz) {
        this.mrz = mrz == null ? null : mrz.trim();
    }

    public Integer getKznrZxz() {
        return kznrZxz;
    }

    public void setKznrZxz(Integer kznrZxz) {
        this.kznrZxz = kznrZxz;
    }

    public Integer getKznrZdz() {
        return kznrZdz;
    }

    public void setKznrZdz(Integer kznrZdz) {
        this.kznrZdz = kznrZdz;
    }

    public String getKznrYzgz() {
        return kznrYzgz;
    }

    public void setKznrYzgz(String kznrYzgz) {
        this.kznrYzgz = kznrYzgz == null ? null : kznrYzgz.trim();
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
     * This method corresponds to the database table tb_mb_jlxx_kzxx
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static MbJlxxKzxx.Builder builder() {
        return new MbJlxxKzxx.Builder();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", xxid=").append(xxid);
        sb.append(", xxkzlx=").append(xxkzlx);
        sb.append(", xxkzms=").append(xxkzms);
        sb.append(", kznrbz=").append(kznrbz);
        sb.append(", yxwk=").append(yxwk);
        sb.append(", mrz=").append(mrz);
        sb.append(", kznrZxz=").append(kznrZxz);
        sb.append(", kznrZdz=").append(kznrZdz);
        sb.append(", kznrYzgz=").append(kznrYzgz);
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
        MbJlxxKzxx other = (MbJlxxKzxx) that;
        return (this.getXxid() == null ? other.getXxid() == null : this.getXxid().equals(other.getXxid()))
            && (this.getXxkzlx() == null ? other.getXxkzlx() == null : this.getXxkzlx().equals(other.getXxkzlx()))
            && (this.getXxkzms() == null ? other.getXxkzms() == null : this.getXxkzms().equals(other.getXxkzms()))
            && (this.getKznrbz() == null ? other.getKznrbz() == null : this.getKznrbz().equals(other.getKznrbz()))
            && (this.getYxwk() == null ? other.getYxwk() == null : this.getYxwk().equals(other.getYxwk()))
            && (this.getMrz() == null ? other.getMrz() == null : this.getMrz().equals(other.getMrz()))
            && (this.getKznrZxz() == null ? other.getKznrZxz() == null : this.getKznrZxz().equals(other.getKznrZxz()))
            && (this.getKznrZdz() == null ? other.getKznrZdz() == null : this.getKznrZdz().equals(other.getKznrZdz()))
            && (this.getKznrYzgz() == null ? other.getKznrYzgz() == null : this.getKznrYzgz().equals(other.getKznrYzgz()))
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
        result = prime * result + ((getXxid() == null) ? 0 : getXxid().hashCode());
        result = prime * result + ((getXxkzlx() == null) ? 0 : getXxkzlx().hashCode());
        result = prime * result + ((getXxkzms() == null) ? 0 : getXxkzms().hashCode());
        result = prime * result + ((getKznrbz() == null) ? 0 : getKznrbz().hashCode());
        result = prime * result + ((getYxwk() == null) ? 0 : getYxwk().hashCode());
        result = prime * result + ((getMrz() == null) ? 0 : getMrz().hashCode());
        result = prime * result + ((getKznrZxz() == null) ? 0 : getKznrZxz().hashCode());
        result = prime * result + ((getKznrZdz() == null) ? 0 : getKznrZdz().hashCode());
        result = prime * result + ((getKznrYzgz() == null) ? 0 : getKznrYzgz().hashCode());
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
     * This class corresponds to the database table tb_mb_jlxx_kzxx
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static class Builder {
        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table tb_mb_jlxx_kzxx
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private MbJlxxKzxx obj;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table tb_mb_jlxx_kzxx
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder() {
            this.obj = new MbJlxxKzxx();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mb_jlxx_kzxx.XXID
         *
         * @param xxid the value for tb_mb_jlxx_kzxx.XXID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder xxid(String xxid) {
            obj.setXxid(xxid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mb_jlxx_kzxx.XXKZLX
         *
         * @param xxkzlx the value for tb_mb_jlxx_kzxx.XXKZLX
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder xxkzlx(String xxkzlx) {
            obj.setXxkzlx(xxkzlx);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mb_jlxx_kzxx.XXKZMS
         *
         * @param xxkzms the value for tb_mb_jlxx_kzxx.XXKZMS
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder xxkzms(String xxkzms) {
            obj.setXxkzms(xxkzms);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mb_jlxx_kzxx.KZNRBZ
         *
         * @param kznrbz the value for tb_mb_jlxx_kzxx.KZNRBZ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder kznrbz(String kznrbz) {
            obj.setKznrbz(kznrbz);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mb_jlxx_kzxx.YXWK
         *
         * @param yxwk the value for tb_mb_jlxx_kzxx.YXWK
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
         * This method sets the value of the database column tb_mb_jlxx_kzxx.MRZ
         *
         * @param mrz the value for tb_mb_jlxx_kzxx.MRZ
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
         * This method sets the value of the database column tb_mb_jlxx_kzxx.KZNR_ZXZ
         *
         * @param kznrZxz the value for tb_mb_jlxx_kzxx.KZNR_ZXZ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder kznrZxz(Integer kznrZxz) {
            obj.setKznrZxz(kznrZxz);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mb_jlxx_kzxx.KZNR_ZDZ
         *
         * @param kznrZdz the value for tb_mb_jlxx_kzxx.KZNR_ZDZ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder kznrZdz(Integer kznrZdz) {
            obj.setKznrZdz(kznrZdz);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mb_jlxx_kzxx.KZNR_YZGZ
         *
         * @param kznrYzgz the value for tb_mb_jlxx_kzxx.KZNR_YZGZ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder kznrYzgz(String kznrYzgz) {
            obj.setKznrYzgz(kznrYzgz);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mb_jlxx_kzxx.ENABLE_STATUS
         *
         * @param enableStatus the value for tb_mb_jlxx_kzxx.ENABLE_STATUS
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
         * This method sets the value of the database column tb_mb_jlxx_kzxx.DELETE_STATUS
         *
         * @param deleteStatus the value for tb_mb_jlxx_kzxx.DELETE_STATUS
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
         * This method sets the value of the database column tb_mb_jlxx_kzxx.CREATE_TIME
         *
         * @param createTime the value for tb_mb_jlxx_kzxx.CREATE_TIME
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
         * This method sets the value of the database column tb_mb_jlxx_kzxx.CREATE_ID
         *
         * @param createId the value for tb_mb_jlxx_kzxx.CREATE_ID
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
         * This method sets the value of the database column tb_mb_jlxx_kzxx.UPDATE_TIME
         *
         * @param updateTime the value for tb_mb_jlxx_kzxx.UPDATE_TIME
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
         * This method sets the value of the database column tb_mb_jlxx_kzxx.UPDATE_ID
         *
         * @param updateId the value for tb_mb_jlxx_kzxx.UPDATE_ID
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
         * This method corresponds to the database table tb_mb_jlxx_kzxx
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public MbJlxxKzxx build() {
            return this.obj;
        }
    }
}