package com.model;

import com.util.model.BasicObject;
import java.io.Serializable;

/**
 * @TableName tb_mb_tmkz
 * @Data 2017-12-28
 * @Author chanin 
 * 模板条目控制信息
 */
public class MbTmkz extends BasicObject implements Serializable {
    // 控制主键 (主健ID)
    private String kzid;

    // 模板主键(必填项)
    private String mbid;

    // 控制项主键(必填项)
    private String kzxid;

    // 
    private String kzxsx;

    // 控制项类型：条目、选项、选项扩展(必填项)
    private String kzxlx;

    // 被控制项主键(必填项)
    private String bkzxid;

    // 被控制项类型：条目分组、条目、选项、选项扩展(必填项)
    private String bkzxlx;

    // 默认状态：显示、隐藏(可选项)
    private String mrzt;

    // 控制条件：选择、填写(必填项)
    private String kztj;

    // 控制结果:（已填、已选）显示、（未填、未选）隐藏、（已填、已选）隐藏、（未填、未选）显示(必填项)
    private String kzjg;

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

    public String getKzid() {
        return kzid;
    }

    public void setKzid(String kzid) {
        this.kzid = kzid == null ? null : kzid.trim();
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid == null ? null : mbid.trim();
    }

    public String getKzxid() {
        return kzxid;
    }

    public void setKzxid(String kzxid) {
        this.kzxid = kzxid == null ? null : kzxid.trim();
    }

    public String getKzxsx() {
        return kzxsx;
    }

    public void setKzxsx(String kzxsx) {
        this.kzxsx = kzxsx == null ? null : kzxsx.trim();
    }

    public String getKzxlx() {
        return kzxlx;
    }

    public void setKzxlx(String kzxlx) {
        this.kzxlx = kzxlx == null ? null : kzxlx.trim();
    }

    public String getBkzxid() {
        return bkzxid;
    }

    public void setBkzxid(String bkzxid) {
        this.bkzxid = bkzxid == null ? null : bkzxid.trim();
    }

    public String getBkzxlx() {
        return bkzxlx;
    }

    public void setBkzxlx(String bkzxlx) {
        this.bkzxlx = bkzxlx == null ? null : bkzxlx.trim();
    }

    public String getMrzt() {
        return mrzt;
    }

    public void setMrzt(String mrzt) {
        this.mrzt = mrzt == null ? null : mrzt.trim();
    }

    public String getKztj() {
        return kztj;
    }

    public void setKztj(String kztj) {
        this.kztj = kztj == null ? null : kztj.trim();
    }

    public String getKzjg() {
        return kzjg;
    }

    public void setKzjg(String kzjg) {
        this.kzjg = kzjg == null ? null : kzjg.trim();
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
     * This method corresponds to the database table tb_mb_tmkz
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static MbTmkz.Builder builder() {
        return new MbTmkz.Builder();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", kzid=").append(kzid);
        sb.append(", mbid=").append(mbid);
        sb.append(", kzxid=").append(kzxid);
        sb.append(", kzxsx=").append(kzxsx);
        sb.append(", kzxlx=").append(kzxlx);
        sb.append(", bkzxid=").append(bkzxid);
        sb.append(", bkzxlx=").append(bkzxlx);
        sb.append(", mrzt=").append(mrzt);
        sb.append(", kztj=").append(kztj);
        sb.append(", kzjg=").append(kzjg);
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
        MbTmkz other = (MbTmkz) that;
        return (this.getKzid() == null ? other.getKzid() == null : this.getKzid().equals(other.getKzid()))
            && (this.getMbid() == null ? other.getMbid() == null : this.getMbid().equals(other.getMbid()))
            && (this.getKzxid() == null ? other.getKzxid() == null : this.getKzxid().equals(other.getKzxid()))
            && (this.getKzxsx() == null ? other.getKzxsx() == null : this.getKzxsx().equals(other.getKzxsx()))
            && (this.getKzxlx() == null ? other.getKzxlx() == null : this.getKzxlx().equals(other.getKzxlx()))
            && (this.getBkzxid() == null ? other.getBkzxid() == null : this.getBkzxid().equals(other.getBkzxid()))
            && (this.getBkzxlx() == null ? other.getBkzxlx() == null : this.getBkzxlx().equals(other.getBkzxlx()))
            && (this.getMrzt() == null ? other.getMrzt() == null : this.getMrzt().equals(other.getMrzt()))
            && (this.getKztj() == null ? other.getKztj() == null : this.getKztj().equals(other.getKztj()))
            && (this.getKzjg() == null ? other.getKzjg() == null : this.getKzjg().equals(other.getKzjg()))
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
        result = prime * result + ((getKzid() == null) ? 0 : getKzid().hashCode());
        result = prime * result + ((getMbid() == null) ? 0 : getMbid().hashCode());
        result = prime * result + ((getKzxid() == null) ? 0 : getKzxid().hashCode());
        result = prime * result + ((getKzxsx() == null) ? 0 : getKzxsx().hashCode());
        result = prime * result + ((getKzxlx() == null) ? 0 : getKzxlx().hashCode());
        result = prime * result + ((getBkzxid() == null) ? 0 : getBkzxid().hashCode());
        result = prime * result + ((getBkzxlx() == null) ? 0 : getBkzxlx().hashCode());
        result = prime * result + ((getMrzt() == null) ? 0 : getMrzt().hashCode());
        result = prime * result + ((getKztj() == null) ? 0 : getKztj().hashCode());
        result = prime * result + ((getKzjg() == null) ? 0 : getKzjg().hashCode());
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
     * This class corresponds to the database table tb_mb_tmkz
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static class Builder {
        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table tb_mb_tmkz
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private MbTmkz obj;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table tb_mb_tmkz
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder() {
            this.obj = new MbTmkz();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mb_tmkz.KZID
         *
         * @param kzid the value for tb_mb_tmkz.KZID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder kzid(String kzid) {
            obj.setKzid(kzid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mb_tmkz.MBID
         *
         * @param mbid the value for tb_mb_tmkz.MBID
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
         * This method sets the value of the database column tb_mb_tmkz.KZXID
         *
         * @param kzxid the value for tb_mb_tmkz.KZXID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder kzxid(String kzxid) {
            obj.setKzxid(kzxid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mb_tmkz.KZXSX
         *
         * @param kzxsx the value for tb_mb_tmkz.KZXSX
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder kzxsx(String kzxsx) {
            obj.setKzxsx(kzxsx);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mb_tmkz.KZXLX
         *
         * @param kzxlx the value for tb_mb_tmkz.KZXLX
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder kzxlx(String kzxlx) {
            obj.setKzxlx(kzxlx);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mb_tmkz.BKZXID
         *
         * @param bkzxid the value for tb_mb_tmkz.BKZXID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder bkzxid(String bkzxid) {
            obj.setBkzxid(bkzxid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mb_tmkz.BKZXLX
         *
         * @param bkzxlx the value for tb_mb_tmkz.BKZXLX
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder bkzxlx(String bkzxlx) {
            obj.setBkzxlx(bkzxlx);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mb_tmkz.MRZT
         *
         * @param mrzt the value for tb_mb_tmkz.MRZT
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder mrzt(String mrzt) {
            obj.setMrzt(mrzt);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mb_tmkz.KZTJ
         *
         * @param kztj the value for tb_mb_tmkz.KZTJ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder kztj(String kztj) {
            obj.setKztj(kztj);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mb_tmkz.KZJG
         *
         * @param kzjg the value for tb_mb_tmkz.KZJG
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder kzjg(String kzjg) {
            obj.setKzjg(kzjg);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_mb_tmkz.ENABLE_STATUS
         *
         * @param enableStatus the value for tb_mb_tmkz.ENABLE_STATUS
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
         * This method sets the value of the database column tb_mb_tmkz.DELETE_STATUS
         *
         * @param deleteStatus the value for tb_mb_tmkz.DELETE_STATUS
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
         * This method sets the value of the database column tb_mb_tmkz.CREATE_TIME
         *
         * @param createTime the value for tb_mb_tmkz.CREATE_TIME
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
         * This method sets the value of the database column tb_mb_tmkz.CREATE_ID
         *
         * @param createId the value for tb_mb_tmkz.CREATE_ID
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
         * This method sets the value of the database column tb_mb_tmkz.UPDATE_TIME
         *
         * @param updateTime the value for tb_mb_tmkz.UPDATE_TIME
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
         * This method sets the value of the database column tb_mb_tmkz.UPDATE_ID
         *
         * @param updateId the value for tb_mb_tmkz.UPDATE_ID
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
         * This method corresponds to the database table tb_mb_tmkz
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public MbTmkz build() {
            return this.obj;
        }
    }
}