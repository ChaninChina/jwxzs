package com.model;

import java.io.Serializable;

import com.util.model.BasicObject;

/**
 * @TableName tb_tmmb
 * @Data 2018-01-23
 * @Author chanin 
 * 条目模板信息
 */
public class Tmmb extends BasicObject implements Serializable {
    // 条目模板主键 (主健ID)
    private String tmmbid;

    // 条目类型(必填项)
    private String tmlx;

    // 条目主键(必填项)
    private String tmid;

    // 条目模板描述(可选项)
    private String tmmbms;

    // 条目模板备注(必填项)
    private String tmmbbz;

    // 条目模板名称(必填项)
    private String tmmbmc;

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

    public String getTmmbid() {
        return tmmbid;
    }

    public void setTmmbid(String tmmbid) {
        this.tmmbid = tmmbid == null ? null : tmmbid.trim();
    }

    public String getTmlx() {
        return tmlx;
    }

    public void setTmlx(String tmlx) {
        this.tmlx = tmlx == null ? null : tmlx.trim();
    }

    public String getTmid() {
        return tmid;
    }

    public void setTmid(String tmid) {
        this.tmid = tmid == null ? null : tmid.trim();
    }

    public String getTmmbms() {
        return tmmbms;
    }

    public void setTmmbms(String tmmbms) {
        this.tmmbms = tmmbms == null ? null : tmmbms.trim();
    }

    public String getTmmbbz() {
        return tmmbbz;
    }

    public void setTmmbbz(String tmmbbz) {
        this.tmmbbz = tmmbbz == null ? null : tmmbbz.trim();
    }

    public String getTmmbmc() {
        return tmmbmc;
    }

    public void setTmmbmc(String tmmbmc) {
        this.tmmbmc = tmmbmc == null ? null : tmmbmc.trim();
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
     * This method corresponds to the database table tb_tmmb
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static Tmmb.Builder builder() {
        return new Tmmb.Builder();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tmmbid=").append(tmmbid);
        sb.append(", tmlx=").append(tmlx);
        sb.append(", tmid=").append(tmid);
        sb.append(", tmmbms=").append(tmmbms);
        sb.append(", tmmbbz=").append(tmmbbz);
        sb.append(", tmmbmc=").append(tmmbmc);
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
        Tmmb other = (Tmmb) that;
        return (this.getTmmbid() == null ? other.getTmmbid() == null : this.getTmmbid().equals(other.getTmmbid()))
            && (this.getTmlx() == null ? other.getTmlx() == null : this.getTmlx().equals(other.getTmlx()))
            && (this.getTmid() == null ? other.getTmid() == null : this.getTmid().equals(other.getTmid()))
            && (this.getTmmbms() == null ? other.getTmmbms() == null : this.getTmmbms().equals(other.getTmmbms()))
            && (this.getTmmbbz() == null ? other.getTmmbbz() == null : this.getTmmbbz().equals(other.getTmmbbz()))
            && (this.getTmmbmc() == null ? other.getTmmbmc() == null : this.getTmmbmc().equals(other.getTmmbmc()))
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
        result = prime * result + ((getTmmbid() == null) ? 0 : getTmmbid().hashCode());
        result = prime * result + ((getTmlx() == null) ? 0 : getTmlx().hashCode());
        result = prime * result + ((getTmid() == null) ? 0 : getTmid().hashCode());
        result = prime * result + ((getTmmbms() == null) ? 0 : getTmmbms().hashCode());
        result = prime * result + ((getTmmbbz() == null) ? 0 : getTmmbbz().hashCode());
        result = prime * result + ((getTmmbmc() == null) ? 0 : getTmmbmc().hashCode());
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
     * This class corresponds to the database table tb_tmmb
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static class Builder {
        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table tb_tmmb
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private Tmmb obj;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table tb_tmmb
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder() {
            this.obj = new Tmmb();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_tmmb.TMMBID
         *
         * @param tmmbid the value for tb_tmmb.TMMBID
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
         * This method sets the value of the database column tb_tmmb.TMLX
         *
         * @param tmlx the value for tb_tmmb.TMLX
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
         * This method sets the value of the database column tb_tmmb.TMID
         *
         * @param tmid the value for tb_tmmb.TMID
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
         * This method sets the value of the database column tb_tmmb.TMMBMS
         *
         * @param tmmbms the value for tb_tmmb.TMMBMS
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder tmmbms(String tmmbms) {
            obj.setTmmbms(tmmbms);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_tmmb.TMMBBZ
         *
         * @param tmmbbz the value for tb_tmmb.TMMBBZ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder tmmbbz(String tmmbbz) {
            obj.setTmmbbz(tmmbbz);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_tmmb.TMMBMC
         *
         * @param tmmbmc the value for tb_tmmb.TMMBMC
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder tmmbmc(String tmmbmc) {
            obj.setTmmbmc(tmmbmc);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_tmmb.ENABLE_STATUS
         *
         * @param enableStatus the value for tb_tmmb.ENABLE_STATUS
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
         * This method sets the value of the database column tb_tmmb.DELETE_STATUS
         *
         * @param deleteStatus the value for tb_tmmb.DELETE_STATUS
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
         * This method sets the value of the database column tb_tmmb.CREATE_TIME
         *
         * @param createTime the value for tb_tmmb.CREATE_TIME
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
         * This method sets the value of the database column tb_tmmb.CREATE_ID
         *
         * @param createId the value for tb_tmmb.CREATE_ID
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
         * This method sets the value of the database column tb_tmmb.UPDATE_TIME
         *
         * @param updateTime the value for tb_tmmb.UPDATE_TIME
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
         * This method sets the value of the database column tb_tmmb.UPDATE_ID
         *
         * @param updateId the value for tb_tmmb.UPDATE_ID
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
         * This method corresponds to the database table tb_tmmb
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Tmmb build() {
            return this.obj;
        }
    }
}