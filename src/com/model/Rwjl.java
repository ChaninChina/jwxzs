package com.model;

import java.io.Serializable;
import java.util.List;

import com.util.model.BasicObject;

/**
 * @TableName tb_rwjl
 * @Data 2018-01-23
 * @Author chanin 
 * 任务记录信息表
 */
public class Rwjl extends BasicObject implements Serializable {
    // 任务记录主键 (主健ID)
    private String rwjlid;

    // 任务主键(可选项)
    private String rwid;

    // 任务名称(可选项)
    private String rwmc;

    // 实体主键(可选项)
    private String stid;

    // 实体名称(可选项)
    private String stmc;

    // 模板记录条目分组主键(必填项)
    private String tmfzid;

    // 模板记录条目分组名称(必填项)
    private String tmfzmc;

    // 模板记录条目分组描述(可选项)
    private String tmfzms;

    // 模板记录条目分组排序(必填项)
    private Integer tmfzpx;

    // 模板记录条目主键(必填项)
    private String tmid;

    // 模板记录条目内容(必填项)
    private String tmnr;

    // 模板记录条目描述(可选项)
    private String tmms;

    // 模板记录条目排序(必填项)
    private Integer tmpx;

    // 模板记录条目类型(必填项)
    private String tmlx;

    // 条目结果(可选项)
    private String tmjg;

    // 记录时间(必填项)
    private String jlsj;

    // 审核标志：需要审核/不需要审核(必填项)
    private String shbz;

    // 审核状态：未审核/已审核(可选项)
    private String shzt;

    // 审核结果：已通过/未通过(可选项)
    private String shjg;

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

    //任务记录条目详细信息
    private List<RwjlTm> rwjlTmList;
    
    //记录人员姓名
    private String userName;
    
    

    private static final long serialVersionUID = 1L;

    public String getRwjlid() {
        return rwjlid;
    }

    public void setRwjlid(String rwjlid) {
        this.rwjlid = rwjlid == null ? null : rwjlid.trim();
    }

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

    public String getTmfzid() {
        return tmfzid;
    }

    public void setTmfzid(String tmfzid) {
        this.tmfzid = tmfzid == null ? null : tmfzid.trim();
    }

    public String getTmfzmc() {
        return tmfzmc;
    }

    public void setTmfzmc(String tmfzmc) {
        this.tmfzmc = tmfzmc == null ? null : tmfzmc.trim();
    }

    public String getTmfzms() {
        return tmfzms;
    }

    public void setTmfzms(String tmfzms) {
        this.tmfzms = tmfzms == null ? null : tmfzms.trim();
    }

    public Integer getTmfzpx() {
        return tmfzpx;
    }

    public void setTmfzpx(Integer tmfzpx) {
        this.tmfzpx = tmfzpx;
    }

    public String getTmid() {
        return tmid;
    }

    public void setTmid(String tmid) {
        this.tmid = tmid == null ? null : tmid.trim();
    }

    public String getTmnr() {
        return tmnr;
    }

    public void setTmnr(String tmnr) {
        this.tmnr = tmnr == null ? null : tmnr.trim();
    }

    public String getTmms() {
        return tmms;
    }

    public void setTmms(String tmms) {
        this.tmms = tmms == null ? null : tmms.trim();
    }

    public Integer getTmpx() {
        return tmpx;
    }

    public void setTmpx(Integer tmpx) {
        this.tmpx = tmpx;
    }

    public String getTmlx() {
        return tmlx;
    }

    public void setTmlx(String tmlx) {
        this.tmlx = tmlx == null ? null : tmlx.trim();
    }

    public String getTmjg() {
        return tmjg;
    }

    public void setTmjg(String tmjg) {
        this.tmjg = tmjg == null ? null : tmjg.trim();
    }

    public String getJlsj() {
        return jlsj;
    }

    public void setJlsj(String jlsj) {
        this.jlsj = jlsj == null ? null : jlsj.trim();
    }

    public String getShbz() {
        return shbz;
    }

    public void setShbz(String shbz) {
        this.shbz = shbz == null ? null : shbz.trim();
    }

    public String getShzt() {
        return shzt;
    }

    public void setShzt(String shzt) {
        this.shzt = shzt == null ? null : shzt.trim();
    }

    public String getShjg() {
        return shjg;
    }

    public void setShjg(String shjg) {
        this.shjg = shjg == null ? null : shjg.trim();
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
     * This method corresponds to the database table tb_rwjl
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static Rwjl.Builder builder() {
        return new Rwjl.Builder();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rwjlid=").append(rwjlid);
        sb.append(", rwid=").append(rwid);
        sb.append(", rwmc=").append(rwmc);
        sb.append(", stid=").append(stid);
        sb.append(", stmc=").append(stmc);
        sb.append(", tmfzid=").append(tmfzid);
        sb.append(", tmfzmc=").append(tmfzmc);
        sb.append(", tmfzms=").append(tmfzms);
        sb.append(", tmfzpx=").append(tmfzpx);
        sb.append(", tmid=").append(tmid);
        sb.append(", tmnr=").append(tmnr);
        sb.append(", tmms=").append(tmms);
        sb.append(", tmpx=").append(tmpx);
        sb.append(", tmlx=").append(tmlx);
        sb.append(", tmjg=").append(tmjg);
        sb.append(", jlsj=").append(jlsj);
        sb.append(", shbz=").append(shbz);
        sb.append(", shzt=").append(shzt);
        sb.append(", shjg=").append(shjg);
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
        Rwjl other = (Rwjl) that;
        return (this.getRwjlid() == null ? other.getRwjlid() == null : this.getRwjlid().equals(other.getRwjlid()))
            && (this.getRwid() == null ? other.getRwid() == null : this.getRwid().equals(other.getRwid()))
            && (this.getRwmc() == null ? other.getRwmc() == null : this.getRwmc().equals(other.getRwmc()))
            && (this.getStid() == null ? other.getStid() == null : this.getStid().equals(other.getStid()))
            && (this.getStmc() == null ? other.getStmc() == null : this.getStmc().equals(other.getStmc()))
            && (this.getTmfzid() == null ? other.getTmfzid() == null : this.getTmfzid().equals(other.getTmfzid()))
            && (this.getTmfzmc() == null ? other.getTmfzmc() == null : this.getTmfzmc().equals(other.getTmfzmc()))
            && (this.getTmfzms() == null ? other.getTmfzms() == null : this.getTmfzms().equals(other.getTmfzms()))
            && (this.getTmfzpx() == null ? other.getTmfzpx() == null : this.getTmfzpx().equals(other.getTmfzpx()))
            && (this.getTmid() == null ? other.getTmid() == null : this.getTmid().equals(other.getTmid()))
            && (this.getTmnr() == null ? other.getTmnr() == null : this.getTmnr().equals(other.getTmnr()))
            && (this.getTmms() == null ? other.getTmms() == null : this.getTmms().equals(other.getTmms()))
            && (this.getTmpx() == null ? other.getTmpx() == null : this.getTmpx().equals(other.getTmpx()))
            && (this.getTmlx() == null ? other.getTmlx() == null : this.getTmlx().equals(other.getTmlx()))
            && (this.getTmjg() == null ? other.getTmjg() == null : this.getTmjg().equals(other.getTmjg()))
            && (this.getJlsj() == null ? other.getJlsj() == null : this.getJlsj().equals(other.getJlsj()))
            && (this.getShbz() == null ? other.getShbz() == null : this.getShbz().equals(other.getShbz()))
            && (this.getShzt() == null ? other.getShzt() == null : this.getShzt().equals(other.getShzt()))
            && (this.getShjg() == null ? other.getShjg() == null : this.getShjg().equals(other.getShjg()))
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
        result = prime * result + ((getRwjlid() == null) ? 0 : getRwjlid().hashCode());
        result = prime * result + ((getRwid() == null) ? 0 : getRwid().hashCode());
        result = prime * result + ((getRwmc() == null) ? 0 : getRwmc().hashCode());
        result = prime * result + ((getStid() == null) ? 0 : getStid().hashCode());
        result = prime * result + ((getStmc() == null) ? 0 : getStmc().hashCode());
        result = prime * result + ((getTmfzid() == null) ? 0 : getTmfzid().hashCode());
        result = prime * result + ((getTmfzmc() == null) ? 0 : getTmfzmc().hashCode());
        result = prime * result + ((getTmfzms() == null) ? 0 : getTmfzms().hashCode());
        result = prime * result + ((getTmfzpx() == null) ? 0 : getTmfzpx().hashCode());
        result = prime * result + ((getTmid() == null) ? 0 : getTmid().hashCode());
        result = prime * result + ((getTmnr() == null) ? 0 : getTmnr().hashCode());
        result = prime * result + ((getTmms() == null) ? 0 : getTmms().hashCode());
        result = prime * result + ((getTmpx() == null) ? 0 : getTmpx().hashCode());
        result = prime * result + ((getTmlx() == null) ? 0 : getTmlx().hashCode());
        result = prime * result + ((getTmjg() == null) ? 0 : getTmjg().hashCode());
        result = prime * result + ((getJlsj() == null) ? 0 : getJlsj().hashCode());
        result = prime * result + ((getShbz() == null) ? 0 : getShbz().hashCode());
        result = prime * result + ((getShzt() == null) ? 0 : getShzt().hashCode());
        result = prime * result + ((getShjg() == null) ? 0 : getShjg().hashCode());
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
     * This class corresponds to the database table tb_rwjl
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static class Builder {
        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table tb_rwjl
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private Rwjl obj;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table tb_rwjl
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder() {
            this.obj = new Rwjl();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl.RWJLID
         *
         * @param rwjlid the value for tb_rwjl.RWJLID
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
         * This method sets the value of the database column tb_rwjl.RWID
         *
         * @param rwid the value for tb_rwjl.RWID
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
         * This method sets the value of the database column tb_rwjl.RWMC
         *
         * @param rwmc the value for tb_rwjl.RWMC
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
         * This method sets the value of the database column tb_rwjl.STID
         *
         * @param stid the value for tb_rwjl.STID
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
         * This method sets the value of the database column tb_rwjl.STMC
         *
         * @param stmc the value for tb_rwjl.STMC
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
         * This method sets the value of the database column tb_rwjl.TMFZID
         *
         * @param tmfzid the value for tb_rwjl.TMFZID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder tmfzid(String tmfzid) {
            obj.setTmfzid(tmfzid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl.TMFZMC
         *
         * @param tmfzmc the value for tb_rwjl.TMFZMC
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder tmfzmc(String tmfzmc) {
            obj.setTmfzmc(tmfzmc);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl.TMFZMS
         *
         * @param tmfzms the value for tb_rwjl.TMFZMS
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder tmfzms(String tmfzms) {
            obj.setTmfzms(tmfzms);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl.TMFZPX
         *
         * @param tmfzpx the value for tb_rwjl.TMFZPX
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder tmfzpx(Integer tmfzpx) {
            obj.setTmfzpx(tmfzpx);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl.TMID
         *
         * @param tmid the value for tb_rwjl.TMID
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
         * This method sets the value of the database column tb_rwjl.TMNR
         *
         * @param tmnr the value for tb_rwjl.TMNR
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder tmnr(String tmnr) {
            obj.setTmnr(tmnr);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl.TMMS
         *
         * @param tmms the value for tb_rwjl.TMMS
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder tmms(String tmms) {
            obj.setTmms(tmms);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl.TMPX
         *
         * @param tmpx the value for tb_rwjl.TMPX
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder tmpx(Integer tmpx) {
            obj.setTmpx(tmpx);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl.TMLX
         *
         * @param tmlx the value for tb_rwjl.TMLX
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
         * This method sets the value of the database column tb_rwjl.TMJG
         *
         * @param tmjg the value for tb_rwjl.TMJG
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder tmjg(String tmjg) {
            obj.setTmjg(tmjg);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl.JLSJ
         *
         * @param jlsj the value for tb_rwjl.JLSJ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder jlsj(String jlsj) {
            obj.setJlsj(jlsj);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl.SHBZ
         *
         * @param shbz the value for tb_rwjl.SHBZ
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
         * This method sets the value of the database column tb_rwjl.SHZT
         *
         * @param shzt the value for tb_rwjl.SHZT
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder shzt(String shzt) {
            obj.setShzt(shzt);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl.SHJG
         *
         * @param shjg the value for tb_rwjl.SHJG
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder shjg(String shjg) {
            obj.setShjg(shjg);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl.ENABLE_STATUS
         *
         * @param enableStatus the value for tb_rwjl.ENABLE_STATUS
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
         * This method sets the value of the database column tb_rwjl.DELETE_STATUS
         *
         * @param deleteStatus the value for tb_rwjl.DELETE_STATUS
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
         * This method sets the value of the database column tb_rwjl.CREATE_TIME
         *
         * @param createTime the value for tb_rwjl.CREATE_TIME
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
         * This method sets the value of the database column tb_rwjl.CREATE_ID
         *
         * @param createId the value for tb_rwjl.CREATE_ID
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
         * This method sets the value of the database column tb_rwjl.UPDATE_TIME
         *
         * @param updateTime the value for tb_rwjl.UPDATE_TIME
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
         * This method sets the value of the database column tb_rwjl.UPDATE_ID
         *
         * @param updateId the value for tb_rwjl.UPDATE_ID
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
         * This method corresponds to the database table tb_rwjl
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Rwjl build() {
            return this.obj;
        }
    }

	public List<RwjlTm> getRwjlTmList() {
		return rwjlTmList;
	}

	public void setRwjlTmList(List<RwjlTm> rwjlTmList) {
		this.rwjlTmList = rwjlTmList;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}