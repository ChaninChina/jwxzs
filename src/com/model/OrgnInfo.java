package com.model;

import com.util.model.BasicObject;
import java.io.Serializable;

/**
 * @TableName tb_orgn_info
 * @Data 2017-12-28
 * @Author chanin 
 * 机构基本信息
 */
public class OrgnInfo extends BasicObject implements Serializable {
    // 机构主键 (主健ID)
    private String orgnId;

    // 父级主键(可选项)
    private String prevId;

    // 区域主键(可选项)
    private String areaId;

    // 机构编号(必填项)
    private String orgnCode;

    // 机构类型(必填项)
    private String orgnType;

    // 机构级别(必填项)
    private String orgnStep;

    // 机构名称(必填项)
    private String orgnName;

    // 机构首拼(必填项)
    private String orgnPiny;

    // 机构层级(必填项)
    private Integer orgnRank;

    // 机构排序(必填项)
    private Integer orgnSort;

    // 机构备注(可选项)
    private String orgnNote;

    // 子集标志(必填项)
    private String subsetSymbol;

    // 编辑标志(必填项)
    private String redactSymbol;

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
	private String fullName; //机构全名
	private AreaInfo areaInfo; //行政区域
	private OrgnInfo prevOrgn; //上级机构
    
    private static final long serialVersionUID = 1L;

    public String getOrgnId() {
        return orgnId;
    }

    public void setOrgnId(String orgnId) {
        this.orgnId = orgnId == null ? null : orgnId.trim();
    }

    public String getPrevId() {
        return prevId;
    }

    public void setPrevId(String prevId) {
        this.prevId = prevId == null ? null : prevId.trim();
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    public String getOrgnCode() {
        return orgnCode;
    }

    public void setOrgnCode(String orgnCode) {
        this.orgnCode = orgnCode == null ? null : orgnCode.trim();
    }

    public String getOrgnType() {
        return orgnType;
    }

    public void setOrgnType(String orgnType) {
        this.orgnType = orgnType == null ? null : orgnType.trim();
    }

    public String getOrgnStep() {
        return orgnStep;
    }

    public void setOrgnStep(String orgnStep) {
        this.orgnStep = orgnStep == null ? null : orgnStep.trim();
    }

    public String getOrgnName() {
        return orgnName;
    }

    public void setOrgnName(String orgnName) {
        this.orgnName = orgnName == null ? null : orgnName.trim();
    }

    public String getOrgnPiny() {
        return orgnPiny;
    }

    public void setOrgnPiny(String orgnPiny) {
        this.orgnPiny = orgnPiny == null ? null : orgnPiny.trim();
    }

    public Integer getOrgnRank() {
        return orgnRank;
    }

    public void setOrgnRank(Integer orgnRank) {
        this.orgnRank = orgnRank;
    }

    public Integer getOrgnSort() {
        return orgnSort;
    }

    public void setOrgnSort(Integer orgnSort) {
        this.orgnSort = orgnSort;
    }

    public String getOrgnNote() {
        return orgnNote;
    }

    public void setOrgnNote(String orgnNote) {
        this.orgnNote = orgnNote == null ? null : orgnNote.trim();
    }

    public String getSubsetSymbol() {
        return subsetSymbol;
    }

    public void setSubsetSymbol(String subsetSymbol) {
        this.subsetSymbol = subsetSymbol == null ? null : subsetSymbol.trim();
    }

    public String getRedactSymbol() {
        return redactSymbol;
    }

    public void setRedactSymbol(String redactSymbol) {
        this.redactSymbol = redactSymbol == null ? null : redactSymbol.trim();
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

    
    
    public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public AreaInfo getAreaInfo() {
		return areaInfo;
	}

	public void setAreaInfo(AreaInfo areaInfo) {
		this.areaInfo = areaInfo;
	}

	public OrgnInfo getPrevOrgn() {
		return prevOrgn;
	}

	public void setPrevOrgn(OrgnInfo prevOrgn) {
		this.prevOrgn = prevOrgn;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_orgn_info
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static OrgnInfo.Builder builder() {
        return new OrgnInfo.Builder();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orgnId=").append(orgnId);
        sb.append(", prevId=").append(prevId);
        sb.append(", areaId=").append(areaId);
        sb.append(", orgnCode=").append(orgnCode);
        sb.append(", orgnType=").append(orgnType);
        sb.append(", orgnStep=").append(orgnStep);
        sb.append(", orgnName=").append(orgnName);
        sb.append(", orgnPiny=").append(orgnPiny);
        sb.append(", orgnRank=").append(orgnRank);
        sb.append(", orgnSort=").append(orgnSort);
        sb.append(", orgnNote=").append(orgnNote);
        sb.append(", subsetSymbol=").append(subsetSymbol);
        sb.append(", redactSymbol=").append(redactSymbol);
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
        OrgnInfo other = (OrgnInfo) that;
        return (this.getOrgnId() == null ? other.getOrgnId() == null : this.getOrgnId().equals(other.getOrgnId()))
            && (this.getPrevId() == null ? other.getPrevId() == null : this.getPrevId().equals(other.getPrevId()))
            && (this.getAreaId() == null ? other.getAreaId() == null : this.getAreaId().equals(other.getAreaId()))
            && (this.getOrgnCode() == null ? other.getOrgnCode() == null : this.getOrgnCode().equals(other.getOrgnCode()))
            && (this.getOrgnType() == null ? other.getOrgnType() == null : this.getOrgnType().equals(other.getOrgnType()))
            && (this.getOrgnStep() == null ? other.getOrgnStep() == null : this.getOrgnStep().equals(other.getOrgnStep()))
            && (this.getOrgnName() == null ? other.getOrgnName() == null : this.getOrgnName().equals(other.getOrgnName()))
            && (this.getOrgnPiny() == null ? other.getOrgnPiny() == null : this.getOrgnPiny().equals(other.getOrgnPiny()))
            && (this.getOrgnRank() == null ? other.getOrgnRank() == null : this.getOrgnRank().equals(other.getOrgnRank()))
            && (this.getOrgnSort() == null ? other.getOrgnSort() == null : this.getOrgnSort().equals(other.getOrgnSort()))
            && (this.getOrgnNote() == null ? other.getOrgnNote() == null : this.getOrgnNote().equals(other.getOrgnNote()))
            && (this.getSubsetSymbol() == null ? other.getSubsetSymbol() == null : this.getSubsetSymbol().equals(other.getSubsetSymbol()))
            && (this.getRedactSymbol() == null ? other.getRedactSymbol() == null : this.getRedactSymbol().equals(other.getRedactSymbol()))
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
        result = prime * result + ((getOrgnId() == null) ? 0 : getOrgnId().hashCode());
        result = prime * result + ((getPrevId() == null) ? 0 : getPrevId().hashCode());
        result = prime * result + ((getAreaId() == null) ? 0 : getAreaId().hashCode());
        result = prime * result + ((getOrgnCode() == null) ? 0 : getOrgnCode().hashCode());
        result = prime * result + ((getOrgnType() == null) ? 0 : getOrgnType().hashCode());
        result = prime * result + ((getOrgnStep() == null) ? 0 : getOrgnStep().hashCode());
        result = prime * result + ((getOrgnName() == null) ? 0 : getOrgnName().hashCode());
        result = prime * result + ((getOrgnPiny() == null) ? 0 : getOrgnPiny().hashCode());
        result = prime * result + ((getOrgnRank() == null) ? 0 : getOrgnRank().hashCode());
        result = prime * result + ((getOrgnSort() == null) ? 0 : getOrgnSort().hashCode());
        result = prime * result + ((getOrgnNote() == null) ? 0 : getOrgnNote().hashCode());
        result = prime * result + ((getSubsetSymbol() == null) ? 0 : getSubsetSymbol().hashCode());
        result = prime * result + ((getRedactSymbol() == null) ? 0 : getRedactSymbol().hashCode());
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
     * This class corresponds to the database table tb_orgn_info
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static class Builder {
        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table tb_orgn_info
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private OrgnInfo obj;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table tb_orgn_info
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder() {
            this.obj = new OrgnInfo();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_orgn_info.ORGN_ID
         *
         * @param orgnId the value for tb_orgn_info.ORGN_ID
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
         * This method sets the value of the database column tb_orgn_info.PREV_ID
         *
         * @param prevId the value for tb_orgn_info.PREV_ID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder prevId(String prevId) {
            obj.setPrevId(prevId);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_orgn_info.AREA_ID
         *
         * @param areaId the value for tb_orgn_info.AREA_ID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder areaId(String areaId) {
            obj.setAreaId(areaId);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_orgn_info.ORGN_CODE
         *
         * @param orgnCode the value for tb_orgn_info.ORGN_CODE
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder orgnCode(String orgnCode) {
            obj.setOrgnCode(orgnCode);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_orgn_info.ORGN_TYPE
         *
         * @param orgnType the value for tb_orgn_info.ORGN_TYPE
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder orgnType(String orgnType) {
            obj.setOrgnType(orgnType);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_orgn_info.ORGN_STEP
         *
         * @param orgnStep the value for tb_orgn_info.ORGN_STEP
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder orgnStep(String orgnStep) {
            obj.setOrgnStep(orgnStep);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_orgn_info.ORGN_NAME
         *
         * @param orgnName the value for tb_orgn_info.ORGN_NAME
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder orgnName(String orgnName) {
            obj.setOrgnName(orgnName);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_orgn_info.ORGN_PINY
         *
         * @param orgnPiny the value for tb_orgn_info.ORGN_PINY
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder orgnPiny(String orgnPiny) {
            obj.setOrgnPiny(orgnPiny);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_orgn_info.ORGN_RANK
         *
         * @param orgnRank the value for tb_orgn_info.ORGN_RANK
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder orgnRank(Integer orgnRank) {
            obj.setOrgnRank(orgnRank);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_orgn_info.ORGN_SORT
         *
         * @param orgnSort the value for tb_orgn_info.ORGN_SORT
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder orgnSort(Integer orgnSort) {
            obj.setOrgnSort(orgnSort);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_orgn_info.ORGN_NOTE
         *
         * @param orgnNote the value for tb_orgn_info.ORGN_NOTE
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder orgnNote(String orgnNote) {
            obj.setOrgnNote(orgnNote);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_orgn_info.SUBSET_SYMBOL
         *
         * @param subsetSymbol the value for tb_orgn_info.SUBSET_SYMBOL
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
         * This method sets the value of the database column tb_orgn_info.REDACT_SYMBOL
         *
         * @param redactSymbol the value for tb_orgn_info.REDACT_SYMBOL
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder redactSymbol(String redactSymbol) {
            obj.setRedactSymbol(redactSymbol);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_orgn_info.ENABLE_STATUS
         *
         * @param enableStatus the value for tb_orgn_info.ENABLE_STATUS
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
         * This method sets the value of the database column tb_orgn_info.DELETE_STATUS
         *
         * @param deleteStatus the value for tb_orgn_info.DELETE_STATUS
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
         * This method sets the value of the database column tb_orgn_info.CREATE_TIME
         *
         * @param createTime the value for tb_orgn_info.CREATE_TIME
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
         * This method sets the value of the database column tb_orgn_info.CREATE_ID
         *
         * @param createId the value for tb_orgn_info.CREATE_ID
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
         * This method sets the value of the database column tb_orgn_info.UPDATE_TIME
         *
         * @param updateTime the value for tb_orgn_info.UPDATE_TIME
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
         * This method sets the value of the database column tb_orgn_info.UPDATE_ID
         *
         * @param updateId the value for tb_orgn_info.UPDATE_ID
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
         * This method corresponds to the database table tb_orgn_info
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public OrgnInfo build() {
            return this.obj;
        }
    }
}