package com.model;

import com.util.model.BasicObject;
import java.io.Serializable;

/**
 * @TableName tb_rwjl_tm_tjmx
 * @Data 2017-12-28
 * @Author chanin 
 * 任务记录条目统计明细
 */
public class RwjlTmTjmx extends BasicObject implements Serializable {
    // 明细主键 (主健ID)
    private String mxid;

    // 
    private String qzid;

    // 任务主键(可选项)
    private String rwid;

    // 实体主键(必填项)
    private String stid;

    // 实体名称(必填项)
    private String stmc;

    // 模板主键(必填项)
    private String mbid;

    // 条目主键(必填项)
    private String tmid;

    // 答题次数(必填项)
    private Integer dtcs;

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

    public String getMxid() {
        return mxid;
    }

    public void setMxid(String mxid) {
        this.mxid = mxid == null ? null : mxid.trim();
    }

    public String getQzid() {
        return qzid;
    }

    public void setQzid(String qzid) {
        this.qzid = qzid == null ? null : qzid.trim();
    }

    public String getRwid() {
        return rwid;
    }

    public void setRwid(String rwid) {
        this.rwid = rwid == null ? null : rwid.trim();
    }

    public String getStid() {
        return stid;
    }

    public void setStid(String stid) {
        this.stid = stid == null ? null : stid.trim();
    }

    public String getStmc() {
        return stmc;
    }

    public void setStmc(String stmc) {
        this.stmc = stmc == null ? null : stmc.trim();
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid == null ? null : mbid.trim();
    }

    public String getTmid() {
        return tmid;
    }

    public void setTmid(String tmid) {
        this.tmid = tmid == null ? null : tmid.trim();
    }

    public Integer getDtcs() {
        return dtcs;
    }

    public void setDtcs(Integer dtcs) {
        this.dtcs = dtcs;
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
     * This method corresponds to the database table tb_rwjl_tm_tjmx
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static RwjlTmTjmx.Builder builder() {
        return new RwjlTmTjmx.Builder();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mxid=").append(mxid);
        sb.append(", qzid=").append(qzid);
        sb.append(", rwid=").append(rwid);
        sb.append(", stid=").append(stid);
        sb.append(", stmc=").append(stmc);
        sb.append(", mbid=").append(mbid);
        sb.append(", tmid=").append(tmid);
        sb.append(", dtcs=").append(dtcs);
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
        RwjlTmTjmx other = (RwjlTmTjmx) that;
        return (this.getMxid() == null ? other.getMxid() == null : this.getMxid().equals(other.getMxid()))
            && (this.getQzid() == null ? other.getQzid() == null : this.getQzid().equals(other.getQzid()))
            && (this.getRwid() == null ? other.getRwid() == null : this.getRwid().equals(other.getRwid()))
            && (this.getStid() == null ? other.getStid() == null : this.getStid().equals(other.getStid()))
            && (this.getStmc() == null ? other.getStmc() == null : this.getStmc().equals(other.getStmc()))
            && (this.getMbid() == null ? other.getMbid() == null : this.getMbid().equals(other.getMbid()))
            && (this.getTmid() == null ? other.getTmid() == null : this.getTmid().equals(other.getTmid()))
            && (this.getDtcs() == null ? other.getDtcs() == null : this.getDtcs().equals(other.getDtcs()))
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
        result = prime * result + ((getMxid() == null) ? 0 : getMxid().hashCode());
        result = prime * result + ((getQzid() == null) ? 0 : getQzid().hashCode());
        result = prime * result + ((getRwid() == null) ? 0 : getRwid().hashCode());
        result = prime * result + ((getStid() == null) ? 0 : getStid().hashCode());
        result = prime * result + ((getStmc() == null) ? 0 : getStmc().hashCode());
        result = prime * result + ((getMbid() == null) ? 0 : getMbid().hashCode());
        result = prime * result + ((getTmid() == null) ? 0 : getTmid().hashCode());
        result = prime * result + ((getDtcs() == null) ? 0 : getDtcs().hashCode());
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
     * This class corresponds to the database table tb_rwjl_tm_tjmx
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static class Builder {
        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table tb_rwjl_tm_tjmx
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private RwjlTmTjmx obj;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table tb_rwjl_tm_tjmx
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder() {
            this.obj = new RwjlTmTjmx();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tm_tjmx.MXID
         *
         * @param mxid the value for tb_rwjl_tm_tjmx.MXID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder mxid(String mxid) {
            obj.setMxid(mxid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tm_tjmx.QZID
         *
         * @param qzid the value for tb_rwjl_tm_tjmx.QZID
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
         * This method sets the value of the database column tb_rwjl_tm_tjmx.RWID
         *
         * @param rwid the value for tb_rwjl_tm_tjmx.RWID
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
         * This method sets the value of the database column tb_rwjl_tm_tjmx.STID
         *
         * @param stid the value for tb_rwjl_tm_tjmx.STID
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
         * This method sets the value of the database column tb_rwjl_tm_tjmx.STMC
         *
         * @param stmc the value for tb_rwjl_tm_tjmx.STMC
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder stmc(String stmc) {
            obj.setStmc(stmc);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tm_tjmx.MBID
         *
         * @param mbid the value for tb_rwjl_tm_tjmx.MBID
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
         * This method sets the value of the database column tb_rwjl_tm_tjmx.TMID
         *
         * @param tmid the value for tb_rwjl_tm_tjmx.TMID
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
         * This method sets the value of the database column tb_rwjl_tm_tjmx.DTCS
         *
         * @param dtcs the value for tb_rwjl_tm_tjmx.DTCS
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder dtcs(Integer dtcs) {
            obj.setDtcs(dtcs);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tm_tjmx.ENABLE_STATUS
         *
         * @param enableStatus the value for tb_rwjl_tm_tjmx.ENABLE_STATUS
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
         * This method sets the value of the database column tb_rwjl_tm_tjmx.DELETE_STATUS
         *
         * @param deleteStatus the value for tb_rwjl_tm_tjmx.DELETE_STATUS
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
         * This method sets the value of the database column tb_rwjl_tm_tjmx.CREATE_TIME
         *
         * @param createTime the value for tb_rwjl_tm_tjmx.CREATE_TIME
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
         * This method sets the value of the database column tb_rwjl_tm_tjmx.CREATE_ID
         *
         * @param createId the value for tb_rwjl_tm_tjmx.CREATE_ID
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
         * This method sets the value of the database column tb_rwjl_tm_tjmx.UPDATE_TIME
         *
         * @param updateTime the value for tb_rwjl_tm_tjmx.UPDATE_TIME
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
         * This method sets the value of the database column tb_rwjl_tm_tjmx.UPDATE_ID
         *
         * @param updateId the value for tb_rwjl_tm_tjmx.UPDATE_ID
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
         * This method corresponds to the database table tb_rwjl_tm_tjmx
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public RwjlTmTjmx build() {
            return this.obj;
        }
    }
}