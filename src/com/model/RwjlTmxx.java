package com.model;

import java.io.Serializable;

import com.util.model.BasicObject;

/**
 * @TableName tb_rwjl_tmxx
 * @Data 2018-01-23
 * @Author chanin 
 * 任务记录条目选项信息
 */
public class RwjlTmxx extends BasicObject implements Serializable {
    // 任务记录选项主键 (主健ID)
    private String rwxxid;

    // 任务记录条目主键(必填项)
    private String rwtmid;

    // 选项主键(可选项)
    private String xxid;

    // 选项内容(必填项)
    private String xxnr;

    // 选项备注(可选项)
    private String xxbz;

    // 选项编号(可选项)
    private String xxbh;

    // 选项排序(必填项)
    private Integer xxpx;

    // 子集标志(可选项)
    private String subsetSymbol;

    // 父级选项主键(可选项)
    private String fjxxid;

    // 选项层级(可选项)
    private Integer xxcj;

    // 选项标识(可选项)
    private String xxbs;

    // 选项层级名称(可选项)
    private String xxcjmc;

    // 选项扩展标志：有/无(可选项)
    private String xxkzbz;

    // 选项扩展类型：文本(可选项)
    private String xxkzlx;

    // 实体记录选项扩展内容(可选项)
    private String stxxkznr;

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

    public String getRwxxid() {
        return rwxxid;
    }

    public void setRwxxid(String rwxxid) {
        this.rwxxid = rwxxid == null ? null : rwxxid.trim();
    }

    public String getRwtmid() {
        return rwtmid;
    }

    public void setRwtmid(String rwtmid) {
        this.rwtmid = rwtmid == null ? null : rwtmid.trim();
    }

    public String getXxid() {
        return xxid;
    }

    public void setXxid(String xxid) {
        this.xxid = xxid == null ? null : xxid.trim();
    }

    public String getXxnr() {
        return xxnr;
    }

    public void setXxnr(String xxnr) {
        this.xxnr = xxnr == null ? null : xxnr.trim();
    }

    public String getXxbz() {
        return xxbz;
    }

    public void setXxbz(String xxbz) {
        this.xxbz = xxbz == null ? null : xxbz.trim();
    }

    public String getXxbh() {
        return xxbh;
    }

    public void setXxbh(String xxbh) {
        this.xxbh = xxbh == null ? null : xxbh.trim();
    }

    public Integer getXxpx() {
        return xxpx;
    }

    public void setXxpx(Integer xxpx) {
        this.xxpx = xxpx;
    }

    public String getSubsetSymbol() {
        return subsetSymbol;
    }

    public void setSubsetSymbol(String subsetSymbol) {
        this.subsetSymbol = subsetSymbol == null ? null : subsetSymbol.trim();
    }

    public String getFjxxid() {
        return fjxxid;
    }

    public void setFjxxid(String fjxxid) {
        this.fjxxid = fjxxid == null ? null : fjxxid.trim();
    }

    public Integer getXxcj() {
        return xxcj;
    }

    public void setXxcj(Integer xxcj) {
        this.xxcj = xxcj;
    }

    public String getXxbs() {
        return xxbs;
    }

    public void setXxbs(String xxbs) {
        this.xxbs = xxbs == null ? null : xxbs.trim();
    }

    public String getXxcjmc() {
        return xxcjmc;
    }

    public void setXxcjmc(String xxcjmc) {
        this.xxcjmc = xxcjmc == null ? null : xxcjmc.trim();
    }

    public String getXxkzbz() {
        return xxkzbz;
    }

    public void setXxkzbz(String xxkzbz) {
        this.xxkzbz = xxkzbz == null ? null : xxkzbz.trim();
    }

    public String getXxkzlx() {
        return xxkzlx;
    }

    public void setXxkzlx(String xxkzlx) {
        this.xxkzlx = xxkzlx == null ? null : xxkzlx.trim();
    }

    public String getStxxkznr() {
        return stxxkznr;
    }

    public void setStxxkznr(String stxxkznr) {
        this.stxxkznr = stxxkznr == null ? null : stxxkznr.trim();
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
     * This method corresponds to the database table tb_rwjl_tmxx
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static RwjlTmxx.Builder builder() {
        return new RwjlTmxx.Builder();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rwxxid=").append(rwxxid);
        sb.append(", rwtmid=").append(rwtmid);
        sb.append(", xxid=").append(xxid);
        sb.append(", xxnr=").append(xxnr);
        sb.append(", xxbz=").append(xxbz);
        sb.append(", xxbh=").append(xxbh);
        sb.append(", xxpx=").append(xxpx);
        sb.append(", subsetSymbol=").append(subsetSymbol);
        sb.append(", fjxxid=").append(fjxxid);
        sb.append(", xxcj=").append(xxcj);
        sb.append(", xxbs=").append(xxbs);
        sb.append(", xxcjmc=").append(xxcjmc);
        sb.append(", xxkzbz=").append(xxkzbz);
        sb.append(", xxkzlx=").append(xxkzlx);
        sb.append(", stxxkznr=").append(stxxkznr);
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
        RwjlTmxx other = (RwjlTmxx) that;
        return (this.getRwxxid() == null ? other.getRwxxid() == null : this.getRwxxid().equals(other.getRwxxid()))
            && (this.getRwtmid() == null ? other.getRwtmid() == null : this.getRwtmid().equals(other.getRwtmid()))
            && (this.getXxid() == null ? other.getXxid() == null : this.getXxid().equals(other.getXxid()))
            && (this.getXxnr() == null ? other.getXxnr() == null : this.getXxnr().equals(other.getXxnr()))
            && (this.getXxbz() == null ? other.getXxbz() == null : this.getXxbz().equals(other.getXxbz()))
            && (this.getXxbh() == null ? other.getXxbh() == null : this.getXxbh().equals(other.getXxbh()))
            && (this.getXxpx() == null ? other.getXxpx() == null : this.getXxpx().equals(other.getXxpx()))
            && (this.getSubsetSymbol() == null ? other.getSubsetSymbol() == null : this.getSubsetSymbol().equals(other.getSubsetSymbol()))
            && (this.getFjxxid() == null ? other.getFjxxid() == null : this.getFjxxid().equals(other.getFjxxid()))
            && (this.getXxcj() == null ? other.getXxcj() == null : this.getXxcj().equals(other.getXxcj()))
            && (this.getXxbs() == null ? other.getXxbs() == null : this.getXxbs().equals(other.getXxbs()))
            && (this.getXxcjmc() == null ? other.getXxcjmc() == null : this.getXxcjmc().equals(other.getXxcjmc()))
            && (this.getXxkzbz() == null ? other.getXxkzbz() == null : this.getXxkzbz().equals(other.getXxkzbz()))
            && (this.getXxkzlx() == null ? other.getXxkzlx() == null : this.getXxkzlx().equals(other.getXxkzlx()))
            && (this.getStxxkznr() == null ? other.getStxxkznr() == null : this.getStxxkznr().equals(other.getStxxkznr()))
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
        result = prime * result + ((getRwxxid() == null) ? 0 : getRwxxid().hashCode());
        result = prime * result + ((getRwtmid() == null) ? 0 : getRwtmid().hashCode());
        result = prime * result + ((getXxid() == null) ? 0 : getXxid().hashCode());
        result = prime * result + ((getXxnr() == null) ? 0 : getXxnr().hashCode());
        result = prime * result + ((getXxbz() == null) ? 0 : getXxbz().hashCode());
        result = prime * result + ((getXxbh() == null) ? 0 : getXxbh().hashCode());
        result = prime * result + ((getXxpx() == null) ? 0 : getXxpx().hashCode());
        result = prime * result + ((getSubsetSymbol() == null) ? 0 : getSubsetSymbol().hashCode());
        result = prime * result + ((getFjxxid() == null) ? 0 : getFjxxid().hashCode());
        result = prime * result + ((getXxcj() == null) ? 0 : getXxcj().hashCode());
        result = prime * result + ((getXxbs() == null) ? 0 : getXxbs().hashCode());
        result = prime * result + ((getXxcjmc() == null) ? 0 : getXxcjmc().hashCode());
        result = prime * result + ((getXxkzbz() == null) ? 0 : getXxkzbz().hashCode());
        result = prime * result + ((getXxkzlx() == null) ? 0 : getXxkzlx().hashCode());
        result = prime * result + ((getStxxkznr() == null) ? 0 : getStxxkznr().hashCode());
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
     * This class corresponds to the database table tb_rwjl_tmxx
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static class Builder {
        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table tb_rwjl_tmxx
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private RwjlTmxx obj;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table tb_rwjl_tmxx
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder() {
            this.obj = new RwjlTmxx();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tmxx.RWXXID
         *
         * @param rwxxid the value for tb_rwjl_tmxx.RWXXID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder rwxxid(String rwxxid) {
            obj.setRwxxid(rwxxid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tmxx.RWTMID
         *
         * @param rwtmid the value for tb_rwjl_tmxx.RWTMID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder rwtmid(String rwtmid) {
            obj.setRwtmid(rwtmid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tmxx.XXID
         *
         * @param xxid the value for tb_rwjl_tmxx.XXID
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
         * This method sets the value of the database column tb_rwjl_tmxx.XXNR
         *
         * @param xxnr the value for tb_rwjl_tmxx.XXNR
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder xxnr(String xxnr) {
            obj.setXxnr(xxnr);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tmxx.XXBZ
         *
         * @param xxbz the value for tb_rwjl_tmxx.XXBZ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder xxbz(String xxbz) {
            obj.setXxbz(xxbz);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tmxx.XXBH
         *
         * @param xxbh the value for tb_rwjl_tmxx.XXBH
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder xxbh(String xxbh) {
            obj.setXxbh(xxbh);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tmxx.XXPX
         *
         * @param xxpx the value for tb_rwjl_tmxx.XXPX
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder xxpx(Integer xxpx) {
            obj.setXxpx(xxpx);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tmxx.SUBSET_SYMBOL
         *
         * @param subsetSymbol the value for tb_rwjl_tmxx.SUBSET_SYMBOL
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder subsetSymbol(String subsetSymbol) {
            obj.setSubsetSymbol(subsetSymbol);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tmxx.FJXXID
         *
         * @param fjxxid the value for tb_rwjl_tmxx.FJXXID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder fjxxid(String fjxxid) {
            obj.setFjxxid(fjxxid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tmxx.XXCJ
         *
         * @param xxcj the value for tb_rwjl_tmxx.XXCJ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder xxcj(Integer xxcj) {
            obj.setXxcj(xxcj);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tmxx.XXBS
         *
         * @param xxbs the value for tb_rwjl_tmxx.XXBS
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder xxbs(String xxbs) {
            obj.setXxbs(xxbs);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tmxx.XXCJMC
         *
         * @param xxcjmc the value for tb_rwjl_tmxx.XXCJMC
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder xxcjmc(String xxcjmc) {
            obj.setXxcjmc(xxcjmc);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tmxx.XXKZBZ
         *
         * @param xxkzbz the value for tb_rwjl_tmxx.XXKZBZ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder xxkzbz(String xxkzbz) {
            obj.setXxkzbz(xxkzbz);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tmxx.XXKZLX
         *
         * @param xxkzlx the value for tb_rwjl_tmxx.XXKZLX
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
         * This method sets the value of the database column tb_rwjl_tmxx.STXXKZNR
         *
         * @param stxxkznr the value for tb_rwjl_tmxx.STXXKZNR
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder stxxkznr(String stxxkznr) {
            obj.setStxxkznr(stxxkznr);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tmxx.ENABLE_STATUS
         *
         * @param enableStatus the value for tb_rwjl_tmxx.ENABLE_STATUS
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
         * This method sets the value of the database column tb_rwjl_tmxx.DELETE_STATUS
         *
         * @param deleteStatus the value for tb_rwjl_tmxx.DELETE_STATUS
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
         * This method sets the value of the database column tb_rwjl_tmxx.CREATE_TIME
         *
         * @param createTime the value for tb_rwjl_tmxx.CREATE_TIME
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
         * This method sets the value of the database column tb_rwjl_tmxx.CREATE_ID
         *
         * @param createId the value for tb_rwjl_tmxx.CREATE_ID
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
         * This method sets the value of the database column tb_rwjl_tmxx.UPDATE_TIME
         *
         * @param updateTime the value for tb_rwjl_tmxx.UPDATE_TIME
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
         * This method sets the value of the database column tb_rwjl_tmxx.UPDATE_ID
         *
         * @param updateId the value for tb_rwjl_tmxx.UPDATE_ID
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
         * This method corresponds to the database table tb_rwjl_tmxx
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public RwjlTmxx build() {
            return this.obj;
        }
    }
}