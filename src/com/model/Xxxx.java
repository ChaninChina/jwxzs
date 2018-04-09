package com.model;

import java.io.Serializable;

import com.util.model.BasicObject;

/**
 * @TableName tb_xxxx
 * @Data 2018-01-23
 * @Author chanin 
 * 消息基本信息
 */
public class Xxxx extends BasicObject implements Serializable {
    // 消息主键 (主健ID)
    private String xxid;

    // 消息标题(可选项)
    private String xxbt;

    // 消息内容(可选项)
    private String xxnr;

    // 消息类型：系统消息、任务消息、群主消息(必填项)
    private String xxlx;

    // 消息关联实体主键(可选项)
    private String stid;

    // 消息关联任务主键(可选项)
    private String rwid;

    // 消息关联群组主键(可选项)
    private String qzid;

    // 消息关联任务记录主键(可选项)
    private String rwjlid;

    // 消息关联内容(可选项)
    private String xxglnr;

    // 消息关联类型(可选项)
    private String xxgllx;

    // 阅读状态(可选项)
    private String ydzt;

    // 发送时间(必填项)
    private String fssj;

    // 过期时间(可选项)
    private String gqsj;

    // 发送方(可选项)
    private String fsfid;

    // 接收方(可选项)
    private String jsfid;

    // 时间戳(必填项)
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

    private static final long serialVersionUID = 1L;

    public String getXxid() {
        return xxid;
    }

    public void setXxid(String xxid) {
        this.xxid = xxid == null ? null : xxid.trim();
    }

    public String getXxbt() {
        return xxbt;
    }

    public void setXxbt(String xxbt) {
        this.xxbt = xxbt == null ? null : xxbt.trim();
    }

    public String getXxnr() {
        return xxnr;
    }

    public void setXxnr(String xxnr) {
        this.xxnr = xxnr == null ? null : xxnr.trim();
    }

    public String getXxlx() {
        return xxlx;
    }

    public void setXxlx(String xxlx) {
        this.xxlx = xxlx == null ? null : xxlx.trim();
    }

    public String getStid() {
        return stid;
    }

    public void setStid(String stid) {
        this.stid = stid == null ? null : stid.trim();
    }

    public String getRwid() {
        return rwid;
    }

    public void setRwid(String rwid) {
        this.rwid = rwid == null ? null : rwid.trim();
    }

    public String getQzid() {
        return qzid;
    }

    public void setQzid(String qzid) {
        this.qzid = qzid == null ? null : qzid.trim();
    }

    public String getRwjlid() {
        return rwjlid;
    }

    public void setRwjlid(String rwjlid) {
        this.rwjlid = rwjlid == null ? null : rwjlid.trim();
    }

    public String getXxglnr() {
        return xxglnr;
    }

    public void setXxglnr(String xxglnr) {
        this.xxglnr = xxglnr == null ? null : xxglnr.trim();
    }

    public String getXxgllx() {
        return xxgllx;
    }

    public void setXxgllx(String xxgllx) {
        this.xxgllx = xxgllx == null ? null : xxgllx.trim();
    }

    public String getYdzt() {
        return ydzt;
    }

    public void setYdzt(String ydzt) {
        this.ydzt = ydzt == null ? null : ydzt.trim();
    }

    public String getFssj() {
        return fssj;
    }

    public void setFssj(String fssj) {
        this.fssj = fssj == null ? null : fssj.trim();
    }

    public String getGqsj() {
        return gqsj;
    }

    public void setGqsj(String gqsj) {
        this.gqsj = gqsj == null ? null : gqsj.trim();
    }

    public String getFsfid() {
        return fsfid;
    }

    public void setFsfid(String fsfid) {
        this.fsfid = fsfid == null ? null : fsfid.trim();
    }

    public String getJsfid() {
        return jsfid;
    }

    public void setJsfid(String jsfid) {
        this.jsfid = jsfid == null ? null : jsfid.trim();
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
     * This method corresponds to the database table tb_xxxx
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static Xxxx.Builder builder() {
        return new Xxxx.Builder();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", xxid=").append(xxid);
        sb.append(", xxbt=").append(xxbt);
        sb.append(", xxnr=").append(xxnr);
        sb.append(", xxlx=").append(xxlx);
        sb.append(", stid=").append(stid);
        sb.append(", rwid=").append(rwid);
        sb.append(", qzid=").append(qzid);
        sb.append(", rwjlid=").append(rwjlid);
        sb.append(", xxglnr=").append(xxglnr);
        sb.append(", xxgllx=").append(xxgllx);
        sb.append(", ydzt=").append(ydzt);
        sb.append(", fssj=").append(fssj);
        sb.append(", gqsj=").append(gqsj);
        sb.append(", fsfid=").append(fsfid);
        sb.append(", jsfid=").append(jsfid);
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
        Xxxx other = (Xxxx) that;
        return (this.getXxid() == null ? other.getXxid() == null : this.getXxid().equals(other.getXxid()))
            && (this.getXxbt() == null ? other.getXxbt() == null : this.getXxbt().equals(other.getXxbt()))
            && (this.getXxnr() == null ? other.getXxnr() == null : this.getXxnr().equals(other.getXxnr()))
            && (this.getXxlx() == null ? other.getXxlx() == null : this.getXxlx().equals(other.getXxlx()))
            && (this.getStid() == null ? other.getStid() == null : this.getStid().equals(other.getStid()))
            && (this.getRwid() == null ? other.getRwid() == null : this.getRwid().equals(other.getRwid()))
            && (this.getQzid() == null ? other.getQzid() == null : this.getQzid().equals(other.getQzid()))
            && (this.getRwjlid() == null ? other.getRwjlid() == null : this.getRwjlid().equals(other.getRwjlid()))
            && (this.getXxglnr() == null ? other.getXxglnr() == null : this.getXxglnr().equals(other.getXxglnr()))
            && (this.getXxgllx() == null ? other.getXxgllx() == null : this.getXxgllx().equals(other.getXxgllx()))
            && (this.getYdzt() == null ? other.getYdzt() == null : this.getYdzt().equals(other.getYdzt()))
            && (this.getFssj() == null ? other.getFssj() == null : this.getFssj().equals(other.getFssj()))
            && (this.getGqsj() == null ? other.getGqsj() == null : this.getGqsj().equals(other.getGqsj()))
            && (this.getFsfid() == null ? other.getFsfid() == null : this.getFsfid().equals(other.getFsfid()))
            && (this.getJsfid() == null ? other.getJsfid() == null : this.getJsfid().equals(other.getJsfid()))
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
        result = prime * result + ((getXxid() == null) ? 0 : getXxid().hashCode());
        result = prime * result + ((getXxbt() == null) ? 0 : getXxbt().hashCode());
        result = prime * result + ((getXxnr() == null) ? 0 : getXxnr().hashCode());
        result = prime * result + ((getXxlx() == null) ? 0 : getXxlx().hashCode());
        result = prime * result + ((getStid() == null) ? 0 : getStid().hashCode());
        result = prime * result + ((getRwid() == null) ? 0 : getRwid().hashCode());
        result = prime * result + ((getQzid() == null) ? 0 : getQzid().hashCode());
        result = prime * result + ((getRwjlid() == null) ? 0 : getRwjlid().hashCode());
        result = prime * result + ((getXxglnr() == null) ? 0 : getXxglnr().hashCode());
        result = prime * result + ((getXxgllx() == null) ? 0 : getXxgllx().hashCode());
        result = prime * result + ((getYdzt() == null) ? 0 : getYdzt().hashCode());
        result = prime * result + ((getFssj() == null) ? 0 : getFssj().hashCode());
        result = prime * result + ((getGqsj() == null) ? 0 : getGqsj().hashCode());
        result = prime * result + ((getFsfid() == null) ? 0 : getFsfid().hashCode());
        result = prime * result + ((getJsfid() == null) ? 0 : getJsfid().hashCode());
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
     * This class corresponds to the database table tb_xxxx
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static class Builder {
        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table tb_xxxx
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private Xxxx obj;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table tb_xxxx
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder() {
            this.obj = new Xxxx();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_xxxx.XXID
         *
         * @param xxid the value for tb_xxxx.XXID
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
         * This method sets the value of the database column tb_xxxx.XXBT
         *
         * @param xxbt the value for tb_xxxx.XXBT
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder xxbt(String xxbt) {
            obj.setXxbt(xxbt);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_xxxx.XXNR
         *
         * @param xxnr the value for tb_xxxx.XXNR
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
         * This method sets the value of the database column tb_xxxx.XXLX
         *
         * @param xxlx the value for tb_xxxx.XXLX
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder xxlx(String xxlx) {
            obj.setXxlx(xxlx);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_xxxx.STID
         *
         * @param stid the value for tb_xxxx.STID
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
         * This method sets the value of the database column tb_xxxx.RWID
         *
         * @param rwid the value for tb_xxxx.RWID
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
         * This method sets the value of the database column tb_xxxx.QZID
         *
         * @param qzid the value for tb_xxxx.QZID
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
         * This method sets the value of the database column tb_xxxx.RWJLID
         *
         * @param rwjlid the value for tb_xxxx.RWJLID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder rwjlid(String rwjlid) {
            obj.setRwjlid(rwjlid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_xxxx.XXGLNR
         *
         * @param xxglnr the value for tb_xxxx.XXGLNR
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder xxglnr(String xxglnr) {
            obj.setXxglnr(xxglnr);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_xxxx.XXGLLX
         *
         * @param xxgllx the value for tb_xxxx.XXGLLX
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder xxgllx(String xxgllx) {
            obj.setXxgllx(xxgllx);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_xxxx.YDZT
         *
         * @param ydzt the value for tb_xxxx.YDZT
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder ydzt(String ydzt) {
            obj.setYdzt(ydzt);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_xxxx.FSSJ
         *
         * @param fssj the value for tb_xxxx.FSSJ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder fssj(String fssj) {
            obj.setFssj(fssj);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_xxxx.GQSJ
         *
         * @param gqsj the value for tb_xxxx.GQSJ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder gqsj(String gqsj) {
            obj.setGqsj(gqsj);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_xxxx.FSFID
         *
         * @param fsfid the value for tb_xxxx.FSFID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder fsfid(String fsfid) {
            obj.setFsfid(fsfid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_xxxx.JSFID
         *
         * @param jsfid the value for tb_xxxx.JSFID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder jsfid(String jsfid) {
            obj.setJsfid(jsfid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_xxxx.TIME_STAMP
         *
         * @param timeStamp the value for tb_xxxx.TIME_STAMP
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
         * This method sets the value of the database column tb_xxxx.ENABLE_STATUS
         *
         * @param enableStatus the value for tb_xxxx.ENABLE_STATUS
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
         * This method sets the value of the database column tb_xxxx.DELETE_STATUS
         *
         * @param deleteStatus the value for tb_xxxx.DELETE_STATUS
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
         * This method sets the value of the database column tb_xxxx.CREATE_TIME
         *
         * @param createTime the value for tb_xxxx.CREATE_TIME
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
         * This method sets the value of the database column tb_xxxx.CREATE_ID
         *
         * @param createId the value for tb_xxxx.CREATE_ID
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
         * This method sets the value of the database column tb_xxxx.UPDATE_TIME
         *
         * @param updateTime the value for tb_xxxx.UPDATE_TIME
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
         * This method sets the value of the database column tb_xxxx.UPDATE_ID
         *
         * @param updateId the value for tb_xxxx.UPDATE_ID
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
         * This method corresponds to the database table tb_xxxx
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Xxxx build() {
            return this.obj;
        }
    }
}