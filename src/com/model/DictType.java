package com.model;

import com.util.model.BasicObject;
import java.io.Serializable;

/**
 * @TableName tb_dict_type
 * @Data 2017-12-28
 * @Author chanin 
 * 字典类型信息
 */
public class DictType extends BasicObject implements Serializable {
    // 类型主键 (主健ID)
    private String typeId;

    // 类型编号(必填项)
    private String typeCode;

    // 类型名称(必填项)
    private String typeName;

    // 类型拼音(必填项)
    private String typePiny;

    // 类型描述(可选项)
    private String typeDesc;

    // 类型识别(必填项)
    private String typeSpot;

    // 排列序号(必填项)
    private Integer typeSort;

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

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode == null ? null : typeCode.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getTypePiny() {
        return typePiny;
    }

    public void setTypePiny(String typePiny) {
        this.typePiny = typePiny == null ? null : typePiny.trim();
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc == null ? null : typeDesc.trim();
    }

    public String getTypeSpot() {
        return typeSpot;
    }

    public void setTypeSpot(String typeSpot) {
        this.typeSpot = typeSpot == null ? null : typeSpot.trim();
    }

    public Integer getTypeSort() {
        return typeSort;
    }

    public void setTypeSort(Integer typeSort) {
        this.typeSort = typeSort;
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
     * This method corresponds to the database table tb_dict_type
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static DictType.Builder builder() {
        return new DictType.Builder();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", typeId=").append(typeId);
        sb.append(", typeCode=").append(typeCode);
        sb.append(", typeName=").append(typeName);
        sb.append(", typePiny=").append(typePiny);
        sb.append(", typeDesc=").append(typeDesc);
        sb.append(", typeSpot=").append(typeSpot);
        sb.append(", typeSort=").append(typeSort);
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
        DictType other = (DictType) that;
        return (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getTypeCode() == null ? other.getTypeCode() == null : this.getTypeCode().equals(other.getTypeCode()))
            && (this.getTypeName() == null ? other.getTypeName() == null : this.getTypeName().equals(other.getTypeName()))
            && (this.getTypePiny() == null ? other.getTypePiny() == null : this.getTypePiny().equals(other.getTypePiny()))
            && (this.getTypeDesc() == null ? other.getTypeDesc() == null : this.getTypeDesc().equals(other.getTypeDesc()))
            && (this.getTypeSpot() == null ? other.getTypeSpot() == null : this.getTypeSpot().equals(other.getTypeSpot()))
            && (this.getTypeSort() == null ? other.getTypeSort() == null : this.getTypeSort().equals(other.getTypeSort()))
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
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getTypeCode() == null) ? 0 : getTypeCode().hashCode());
        result = prime * result + ((getTypeName() == null) ? 0 : getTypeName().hashCode());
        result = prime * result + ((getTypePiny() == null) ? 0 : getTypePiny().hashCode());
        result = prime * result + ((getTypeDesc() == null) ? 0 : getTypeDesc().hashCode());
        result = prime * result + ((getTypeSpot() == null) ? 0 : getTypeSpot().hashCode());
        result = prime * result + ((getTypeSort() == null) ? 0 : getTypeSort().hashCode());
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
     * This class corresponds to the database table tb_dict_type
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static class Builder {
        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table tb_dict_type
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private DictType obj;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table tb_dict_type
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder() {
            this.obj = new DictType();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_dict_type.TYPE_ID
         *
         * @param typeId the value for tb_dict_type.TYPE_ID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder typeId(String typeId) {
            obj.setTypeId(typeId);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_dict_type.TYPE_CODE
         *
         * @param typeCode the value for tb_dict_type.TYPE_CODE
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder typeCode(String typeCode) {
            obj.setTypeCode(typeCode);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_dict_type.TYPE_NAME
         *
         * @param typeName the value for tb_dict_type.TYPE_NAME
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder typeName(String typeName) {
            obj.setTypeName(typeName);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_dict_type.TYPE_PINY
         *
         * @param typePiny the value for tb_dict_type.TYPE_PINY
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder typePiny(String typePiny) {
            obj.setTypePiny(typePiny);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_dict_type.TYPE_DESC
         *
         * @param typeDesc the value for tb_dict_type.TYPE_DESC
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder typeDesc(String typeDesc) {
            obj.setTypeDesc(typeDesc);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_dict_type.TYPE_SPOT
         *
         * @param typeSpot the value for tb_dict_type.TYPE_SPOT
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder typeSpot(String typeSpot) {
            obj.setTypeSpot(typeSpot);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_dict_type.TYPE_SORT
         *
         * @param typeSort the value for tb_dict_type.TYPE_SORT
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder typeSort(Integer typeSort) {
            obj.setTypeSort(typeSort);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_dict_type.ENABLE_STATUS
         *
         * @param enableStatus the value for tb_dict_type.ENABLE_STATUS
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
         * This method sets the value of the database column tb_dict_type.DELETE_STATUS
         *
         * @param deleteStatus the value for tb_dict_type.DELETE_STATUS
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
         * This method sets the value of the database column tb_dict_type.CREATE_TIME
         *
         * @param createTime the value for tb_dict_type.CREATE_TIME
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
         * This method sets the value of the database column tb_dict_type.CREATE_ID
         *
         * @param createId the value for tb_dict_type.CREATE_ID
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
         * This method sets the value of the database column tb_dict_type.UPDATE_TIME
         *
         * @param updateTime the value for tb_dict_type.UPDATE_TIME
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
         * This method sets the value of the database column tb_dict_type.UPDATE_ID
         *
         * @param updateId the value for tb_dict_type.UPDATE_ID
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
         * This method corresponds to the database table tb_dict_type
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public DictType build() {
            return this.obj;
        }
    }
}