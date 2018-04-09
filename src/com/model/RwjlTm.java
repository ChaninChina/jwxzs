package com.model;

import java.io.Serializable;
import java.util.List;

import com.util.model.BasicObject;

/**
 * @TableName tb_rwjl_tm
 * @Data 2018-01-23
 * @Author chanin 
 * 任务记录条目信息
 */
public class RwjlTm extends BasicObject implements Serializable {
    // 任务条目主键 (主健ID)
    private String rwtmid;

    // 任务记录主键(必填项)
    private String rwjlid;

    // 任务主键(可选项)
    private String rwid;

    // 任务名称(可选项)
    private String rwmc;

    // 实体主键(可选项)
    private String stid;

    // 实体名称(可选项)
    private String stmc;

    // 模板记录条目分组主键(可选项)
    private String fjtmfzid;

    // 模板记录条目分组名称(可选项)
    private String fjtmfzmc;

    // 模板记录条目分组描述(可选项)
    private String fjtmfzms;

    // 模板记录条目分组排序(可选项)
    private Integer fjtmfzpx;

    // 分组类型（普通、列表）(可选项)
    private String fjtmfzlx;

    // 模板记录条目分组主键(必填项)
    private String tmfzid;

    // 模板记录条目分组名称(必填项)
    private String tmfzmc;

    // 模板记录条目分组描述(可选项)
    private String tmfzms;

    // 模板记录条目分组排序(必填项)
    private Integer tmfzpx;

    // 子集标志(可选项)
    private String subsetSymbol;

    // 模板记录条目层级(可选项)
    private Integer tmfzcj;

    // 分组类型（普通、列表）(可选项)
    private String tmfzlx;

    // 模板记录条目主键(必填项)
    private String tmid;

    // 模板记录条目内容(可选项)
    private String tmnr;

    // 模板记录条目描述(可选项)
    private String tmms;

    // 模板记录条目排序(必填项)
    private Integer tmpx;

    // 模板记录条目类型(必填项)
    private String tmlx;

    // 选项标志：有/无(可选项)
    private String xxbz;

    // 附件标志：有/无(可选项)
    private String fjbz;

    // 列表排序(可选项)
    private Integer lbpx;

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

    // 条目结果(可选项)
    private String tmjg;
    
    
    //------------------------
    //业务逻辑使用属性
    //------------------------

    //任务记录条目选项
    private List<RwjlTmxx> rwjlTmxxes;

    //任务记录条目附件
    private List<Fjxx> fjxxes;
    
    //子集任务条目
    private List<RwjlTm> rwjlTms;
    
    

    private static final long serialVersionUID = 1L;

    public String getRwtmid() {
        return rwtmid;
    }

    public void setRwtmid(String rwtmid) {
        this.rwtmid = rwtmid == null ? null : rwtmid.trim();
    }

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

    public String getFjtmfzid() {
        return fjtmfzid;
    }

    public void setFjtmfzid(String fjtmfzid) {
        this.fjtmfzid = fjtmfzid == null ? null : fjtmfzid.trim();
    }

    public String getFjtmfzmc() {
        return fjtmfzmc;
    }

    public void setFjtmfzmc(String fjtmfzmc) {
        this.fjtmfzmc = fjtmfzmc == null ? null : fjtmfzmc.trim();
    }

    public String getFjtmfzms() {
        return fjtmfzms;
    }

    public void setFjtmfzms(String fjtmfzms) {
        this.fjtmfzms = fjtmfzms == null ? null : fjtmfzms.trim();
    }

    public Integer getFjtmfzpx() {
        return fjtmfzpx;
    }

    public void setFjtmfzpx(Integer fjtmfzpx) {
        this.fjtmfzpx = fjtmfzpx;
    }

    public String getFjtmfzlx() {
        return fjtmfzlx;
    }

    public void setFjtmfzlx(String fjtmfzlx) {
        this.fjtmfzlx = fjtmfzlx == null ? null : fjtmfzlx.trim();
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

    public String getSubsetSymbol() {
        return subsetSymbol;
    }

    public void setSubsetSymbol(String subsetSymbol) {
        this.subsetSymbol = subsetSymbol == null ? null : subsetSymbol.trim();
    }

    public Integer getTmfzcj() {
        return tmfzcj;
    }

    public void setTmfzcj(Integer tmfzcj) {
        this.tmfzcj = tmfzcj;
    }

    public String getTmfzlx() {
        return tmfzlx;
    }

    public void setTmfzlx(String tmfzlx) {
        this.tmfzlx = tmfzlx == null ? null : tmfzlx.trim();
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

    public String getXxbz() {
        return xxbz;
    }

    public void setXxbz(String xxbz) {
        this.xxbz = xxbz == null ? null : xxbz.trim();
    }

    public String getFjbz() {
        return fjbz;
    }

    public void setFjbz(String fjbz) {
        this.fjbz = fjbz == null ? null : fjbz.trim();
    }

    public Integer getLbpx() {
        return lbpx;
    }

    public void setLbpx(Integer lbpx) {
        this.lbpx = lbpx;
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

    public String getTmjg() {
        return tmjg;
    }

    public void setTmjg(String tmjg) {
        this.tmjg = tmjg == null ? null : tmjg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_rwjl_tm
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static RwjlTm.Builder builder() {
        return new RwjlTm.Builder();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rwtmid=").append(rwtmid);
        sb.append(", rwjlid=").append(rwjlid);
        sb.append(", rwid=").append(rwid);
        sb.append(", rwmc=").append(rwmc);
        sb.append(", stid=").append(stid);
        sb.append(", stmc=").append(stmc);
        sb.append(", fjtmfzid=").append(fjtmfzid);
        sb.append(", fjtmfzmc=").append(fjtmfzmc);
        sb.append(", fjtmfzms=").append(fjtmfzms);
        sb.append(", fjtmfzpx=").append(fjtmfzpx);
        sb.append(", fjtmfzlx=").append(fjtmfzlx);
        sb.append(", tmfzid=").append(tmfzid);
        sb.append(", tmfzmc=").append(tmfzmc);
        sb.append(", tmfzms=").append(tmfzms);
        sb.append(", tmfzpx=").append(tmfzpx);
        sb.append(", subsetSymbol=").append(subsetSymbol);
        sb.append(", tmfzcj=").append(tmfzcj);
        sb.append(", tmfzlx=").append(tmfzlx);
        sb.append(", tmid=").append(tmid);
        sb.append(", tmnr=").append(tmnr);
        sb.append(", tmms=").append(tmms);
        sb.append(", tmpx=").append(tmpx);
        sb.append(", tmlx=").append(tmlx);
        sb.append(", xxbz=").append(xxbz);
        sb.append(", fjbz=").append(fjbz);
        sb.append(", lbpx=").append(lbpx);
        sb.append(", enableStatus=").append(enableStatus);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", createId=").append(createId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", tmjg=").append(tmjg);
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
        RwjlTm other = (RwjlTm) that;
        return (this.getRwtmid() == null ? other.getRwtmid() == null : this.getRwtmid().equals(other.getRwtmid()))
            && (this.getRwjlid() == null ? other.getRwjlid() == null : this.getRwjlid().equals(other.getRwjlid()))
            && (this.getRwid() == null ? other.getRwid() == null : this.getRwid().equals(other.getRwid()))
            && (this.getRwmc() == null ? other.getRwmc() == null : this.getRwmc().equals(other.getRwmc()))
            && (this.getStid() == null ? other.getStid() == null : this.getStid().equals(other.getStid()))
            && (this.getStmc() == null ? other.getStmc() == null : this.getStmc().equals(other.getStmc()))
            && (this.getFjtmfzid() == null ? other.getFjtmfzid() == null : this.getFjtmfzid().equals(other.getFjtmfzid()))
            && (this.getFjtmfzmc() == null ? other.getFjtmfzmc() == null : this.getFjtmfzmc().equals(other.getFjtmfzmc()))
            && (this.getFjtmfzms() == null ? other.getFjtmfzms() == null : this.getFjtmfzms().equals(other.getFjtmfzms()))
            && (this.getFjtmfzpx() == null ? other.getFjtmfzpx() == null : this.getFjtmfzpx().equals(other.getFjtmfzpx()))
            && (this.getFjtmfzlx() == null ? other.getFjtmfzlx() == null : this.getFjtmfzlx().equals(other.getFjtmfzlx()))
            && (this.getTmfzid() == null ? other.getTmfzid() == null : this.getTmfzid().equals(other.getTmfzid()))
            && (this.getTmfzmc() == null ? other.getTmfzmc() == null : this.getTmfzmc().equals(other.getTmfzmc()))
            && (this.getTmfzms() == null ? other.getTmfzms() == null : this.getTmfzms().equals(other.getTmfzms()))
            && (this.getTmfzpx() == null ? other.getTmfzpx() == null : this.getTmfzpx().equals(other.getTmfzpx()))
            && (this.getSubsetSymbol() == null ? other.getSubsetSymbol() == null : this.getSubsetSymbol().equals(other.getSubsetSymbol()))
            && (this.getTmfzcj() == null ? other.getTmfzcj() == null : this.getTmfzcj().equals(other.getTmfzcj()))
            && (this.getTmfzlx() == null ? other.getTmfzlx() == null : this.getTmfzlx().equals(other.getTmfzlx()))
            && (this.getTmid() == null ? other.getTmid() == null : this.getTmid().equals(other.getTmid()))
            && (this.getTmnr() == null ? other.getTmnr() == null : this.getTmnr().equals(other.getTmnr()))
            && (this.getTmms() == null ? other.getTmms() == null : this.getTmms().equals(other.getTmms()))
            && (this.getTmpx() == null ? other.getTmpx() == null : this.getTmpx().equals(other.getTmpx()))
            && (this.getTmlx() == null ? other.getTmlx() == null : this.getTmlx().equals(other.getTmlx()))
            && (this.getXxbz() == null ? other.getXxbz() == null : this.getXxbz().equals(other.getXxbz()))
            && (this.getFjbz() == null ? other.getFjbz() == null : this.getFjbz().equals(other.getFjbz()))
            && (this.getLbpx() == null ? other.getLbpx() == null : this.getLbpx().equals(other.getLbpx()))
            && (this.getEnableStatus() == null ? other.getEnableStatus() == null : this.getEnableStatus().equals(other.getEnableStatus()))
            && (this.getDeleteStatus() == null ? other.getDeleteStatus() == null : this.getDeleteStatus().equals(other.getDeleteStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateId() == null ? other.getUpdateId() == null : this.getUpdateId().equals(other.getUpdateId()))
            && (this.getTmjg() == null ? other.getTmjg() == null : this.getTmjg().equals(other.getTmjg()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRwtmid() == null) ? 0 : getRwtmid().hashCode());
        result = prime * result + ((getRwjlid() == null) ? 0 : getRwjlid().hashCode());
        result = prime * result + ((getRwid() == null) ? 0 : getRwid().hashCode());
        result = prime * result + ((getRwmc() == null) ? 0 : getRwmc().hashCode());
        result = prime * result + ((getStid() == null) ? 0 : getStid().hashCode());
        result = prime * result + ((getStmc() == null) ? 0 : getStmc().hashCode());
        result = prime * result + ((getFjtmfzid() == null) ? 0 : getFjtmfzid().hashCode());
        result = prime * result + ((getFjtmfzmc() == null) ? 0 : getFjtmfzmc().hashCode());
        result = prime * result + ((getFjtmfzms() == null) ? 0 : getFjtmfzms().hashCode());
        result = prime * result + ((getFjtmfzpx() == null) ? 0 : getFjtmfzpx().hashCode());
        result = prime * result + ((getFjtmfzlx() == null) ? 0 : getFjtmfzlx().hashCode());
        result = prime * result + ((getTmfzid() == null) ? 0 : getTmfzid().hashCode());
        result = prime * result + ((getTmfzmc() == null) ? 0 : getTmfzmc().hashCode());
        result = prime * result + ((getTmfzms() == null) ? 0 : getTmfzms().hashCode());
        result = prime * result + ((getTmfzpx() == null) ? 0 : getTmfzpx().hashCode());
        result = prime * result + ((getSubsetSymbol() == null) ? 0 : getSubsetSymbol().hashCode());
        result = prime * result + ((getTmfzcj() == null) ? 0 : getTmfzcj().hashCode());
        result = prime * result + ((getTmfzlx() == null) ? 0 : getTmfzlx().hashCode());
        result = prime * result + ((getTmid() == null) ? 0 : getTmid().hashCode());
        result = prime * result + ((getTmnr() == null) ? 0 : getTmnr().hashCode());
        result = prime * result + ((getTmms() == null) ? 0 : getTmms().hashCode());
        result = prime * result + ((getTmpx() == null) ? 0 : getTmpx().hashCode());
        result = prime * result + ((getTmlx() == null) ? 0 : getTmlx().hashCode());
        result = prime * result + ((getXxbz() == null) ? 0 : getXxbz().hashCode());
        result = prime * result + ((getFjbz() == null) ? 0 : getFjbz().hashCode());
        result = prime * result + ((getLbpx() == null) ? 0 : getLbpx().hashCode());
        result = prime * result + ((getEnableStatus() == null) ? 0 : getEnableStatus().hashCode());
        result = prime * result + ((getDeleteStatus() == null) ? 0 : getDeleteStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateId() == null) ? 0 : getCreateId().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateId() == null) ? 0 : getUpdateId().hashCode());
        result = prime * result + ((getTmjg() == null) ? 0 : getTmjg().hashCode());
        return result;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tb_rwjl_tm
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static class Builder {
        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table tb_rwjl_tm
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private RwjlTm obj;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table tb_rwjl_tm
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder() {
            this.obj = new RwjlTm();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tm.RWTMID
         *
         * @param rwtmid the value for tb_rwjl_tm.RWTMID
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
         * This method sets the value of the database column tb_rwjl_tm.RWJLID
         *
         * @param rwjlid the value for tb_rwjl_tm.RWJLID
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
         * This method sets the value of the database column tb_rwjl_tm.RWID
         *
         * @param rwid the value for tb_rwjl_tm.RWID
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
         * This method sets the value of the database column tb_rwjl_tm.RWMC
         *
         * @param rwmc the value for tb_rwjl_tm.RWMC
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
         * This method sets the value of the database column tb_rwjl_tm.STID
         *
         * @param stid the value for tb_rwjl_tm.STID
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
         * This method sets the value of the database column tb_rwjl_tm.STMC
         *
         * @param stmc the value for tb_rwjl_tm.STMC
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
         * This method sets the value of the database column tb_rwjl_tm.FJTMFZID
         *
         * @param fjtmfzid the value for tb_rwjl_tm.FJTMFZID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder fjtmfzid(String fjtmfzid) {
            obj.setFjtmfzid(fjtmfzid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tm.FJTMFZMC
         *
         * @param fjtmfzmc the value for tb_rwjl_tm.FJTMFZMC
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder fjtmfzmc(String fjtmfzmc) {
            obj.setFjtmfzmc(fjtmfzmc);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tm.FJTMFZMS
         *
         * @param fjtmfzms the value for tb_rwjl_tm.FJTMFZMS
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder fjtmfzms(String fjtmfzms) {
            obj.setFjtmfzms(fjtmfzms);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tm.FJTMFZPX
         *
         * @param fjtmfzpx the value for tb_rwjl_tm.FJTMFZPX
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder fjtmfzpx(Integer fjtmfzpx) {
            obj.setFjtmfzpx(fjtmfzpx);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tm.FJTMFZLX
         *
         * @param fjtmfzlx the value for tb_rwjl_tm.FJTMFZLX
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder fjtmfzlx(String fjtmfzlx) {
            obj.setFjtmfzlx(fjtmfzlx);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tm.TMFZID
         *
         * @param tmfzid the value for tb_rwjl_tm.TMFZID
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
         * This method sets the value of the database column tb_rwjl_tm.TMFZMC
         *
         * @param tmfzmc the value for tb_rwjl_tm.TMFZMC
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
         * This method sets the value of the database column tb_rwjl_tm.TMFZMS
         *
         * @param tmfzms the value for tb_rwjl_tm.TMFZMS
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
         * This method sets the value of the database column tb_rwjl_tm.TMFZPX
         *
         * @param tmfzpx the value for tb_rwjl_tm.TMFZPX
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
         * This method sets the value of the database column tb_rwjl_tm.SUBSET_SYMBOL
         *
         * @param subsetSymbol the value for tb_rwjl_tm.SUBSET_SYMBOL
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
         * This method sets the value of the database column tb_rwjl_tm.TMFZCJ
         *
         * @param tmfzcj the value for tb_rwjl_tm.TMFZCJ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder tmfzcj(Integer tmfzcj) {
            obj.setTmfzcj(tmfzcj);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tm.TMFZLX
         *
         * @param tmfzlx the value for tb_rwjl_tm.TMFZLX
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder tmfzlx(String tmfzlx) {
            obj.setTmfzlx(tmfzlx);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tm.TMID
         *
         * @param tmid the value for tb_rwjl_tm.TMID
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
         * This method sets the value of the database column tb_rwjl_tm.TMNR
         *
         * @param tmnr the value for tb_rwjl_tm.TMNR
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
         * This method sets the value of the database column tb_rwjl_tm.TMMS
         *
         * @param tmms the value for tb_rwjl_tm.TMMS
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
         * This method sets the value of the database column tb_rwjl_tm.TMPX
         *
         * @param tmpx the value for tb_rwjl_tm.TMPX
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
         * This method sets the value of the database column tb_rwjl_tm.TMLX
         *
         * @param tmlx the value for tb_rwjl_tm.TMLX
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
         * This method sets the value of the database column tb_rwjl_tm.XXBZ
         *
         * @param xxbz the value for tb_rwjl_tm.XXBZ
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
         * This method sets the value of the database column tb_rwjl_tm.FJBZ
         *
         * @param fjbz the value for tb_rwjl_tm.FJBZ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder fjbz(String fjbz) {
            obj.setFjbz(fjbz);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tm.LBPX
         *
         * @param lbpx the value for tb_rwjl_tm.LBPX
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder lbpx(Integer lbpx) {
            obj.setLbpx(lbpx);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_rwjl_tm.ENABLE_STATUS
         *
         * @param enableStatus the value for tb_rwjl_tm.ENABLE_STATUS
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
         * This method sets the value of the database column tb_rwjl_tm.DELETE_STATUS
         *
         * @param deleteStatus the value for tb_rwjl_tm.DELETE_STATUS
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
         * This method sets the value of the database column tb_rwjl_tm.CREATE_TIME
         *
         * @param createTime the value for tb_rwjl_tm.CREATE_TIME
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
         * This method sets the value of the database column tb_rwjl_tm.CREATE_ID
         *
         * @param createId the value for tb_rwjl_tm.CREATE_ID
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
         * This method sets the value of the database column tb_rwjl_tm.UPDATE_TIME
         *
         * @param updateTime the value for tb_rwjl_tm.UPDATE_TIME
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
         * This method sets the value of the database column tb_rwjl_tm.UPDATE_ID
         *
         * @param updateId the value for tb_rwjl_tm.UPDATE_ID
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
         * This method sets the value of the database column tb_rwjl_tm.TMJG
         *
         * @param tmjg the value for tb_rwjl_tm.TMJG
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
         * This method corresponds to the database table tb_rwjl_tm
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public RwjlTm build() {
            return this.obj;
        }
    }

	public List<RwjlTmxx> getRwjlTmxxes() {
		return rwjlTmxxes;
	}

	public void setRwjlTmxxes(List<RwjlTmxx> rwjlTmxxes) {
		this.rwjlTmxxes = rwjlTmxxes;
	}

	public List<Fjxx> getFjxxes() {
		return fjxxes;
	}

	public void setFjxxes(List<Fjxx> fjxxes) {
		this.fjxxes = fjxxes;
	}

	public List<RwjlTm> getRwjlTms() {
		return rwjlTms;
	}

	public void setRwjlTms(List<RwjlTm> rwjlTms) {
		this.rwjlTms = rwjlTms;
	}
}