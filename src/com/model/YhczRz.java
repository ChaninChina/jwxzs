package com.model;

import com.util.model.BasicObject;
import java.io.Serializable;

/**
 * @TableName tb_yhcz_rz
 * @Data 2017-12-28
 * @Author chanin 
 * 用户操作日志
 */
public class YhczRz extends BasicObject implements Serializable {
    // 主键 (主健ID)
    private String id;

    // 操作用户ID(必填项)
    private String yhid;

    // 权限编号(必填项)
    private String qxbh;

    // 权限名称(必填项)
    private String qxmc;

    // 权限路径(必填项)
    private String qxlj;

    // 操作时间(必填项)
    private String czsj;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getYhid() {
        return yhid;
    }

    public void setYhid(String yhid) {
        this.yhid = yhid == null ? null : yhid.trim();
    }

    public String getQxbh() {
        return qxbh;
    }

    public void setQxbh(String qxbh) {
        this.qxbh = qxbh == null ? null : qxbh.trim();
    }

    public String getQxmc() {
        return qxmc;
    }

    public void setQxmc(String qxmc) {
        this.qxmc = qxmc == null ? null : qxmc.trim();
    }

    public String getQxlj() {
        return qxlj;
    }

    public void setQxlj(String qxlj) {
        this.qxlj = qxlj == null ? null : qxlj.trim();
    }

    public String getCzsj() {
        return czsj;
    }

    public void setCzsj(String czsj) {
        this.czsj = czsj == null ? null : czsj.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_yhcz_rz
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static YhczRz.Builder builder() {
        return new YhczRz.Builder();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", yhid=").append(yhid);
        sb.append(", qxbh=").append(qxbh);
        sb.append(", qxmc=").append(qxmc);
        sb.append(", qxlj=").append(qxlj);
        sb.append(", czsj=").append(czsj);
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
        YhczRz other = (YhczRz) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getYhid() == null ? other.getYhid() == null : this.getYhid().equals(other.getYhid()))
            && (this.getQxbh() == null ? other.getQxbh() == null : this.getQxbh().equals(other.getQxbh()))
            && (this.getQxmc() == null ? other.getQxmc() == null : this.getQxmc().equals(other.getQxmc()))
            && (this.getQxlj() == null ? other.getQxlj() == null : this.getQxlj().equals(other.getQxlj()))
            && (this.getCzsj() == null ? other.getCzsj() == null : this.getCzsj().equals(other.getCzsj()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getYhid() == null) ? 0 : getYhid().hashCode());
        result = prime * result + ((getQxbh() == null) ? 0 : getQxbh().hashCode());
        result = prime * result + ((getQxmc() == null) ? 0 : getQxmc().hashCode());
        result = prime * result + ((getQxlj() == null) ? 0 : getQxlj().hashCode());
        result = prime * result + ((getCzsj() == null) ? 0 : getCzsj().hashCode());
        return result;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tb_yhcz_rz
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static class Builder {
        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table tb_yhcz_rz
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private YhczRz obj;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table tb_yhcz_rz
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder() {
            this.obj = new YhczRz();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_yhcz_rz.ID
         *
         * @param id the value for tb_yhcz_rz.ID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder id(String id) {
            obj.setId(id);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_yhcz_rz.YHID
         *
         * @param yhid the value for tb_yhcz_rz.YHID
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder yhid(String yhid) {
            obj.setYhid(yhid);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_yhcz_rz.QXBH
         *
         * @param qxbh the value for tb_yhcz_rz.QXBH
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder qxbh(String qxbh) {
            obj.setQxbh(qxbh);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_yhcz_rz.QXMC
         *
         * @param qxmc the value for tb_yhcz_rz.QXMC
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder qxmc(String qxmc) {
            obj.setQxmc(qxmc);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_yhcz_rz.QXLJ
         *
         * @param qxlj the value for tb_yhcz_rz.QXLJ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder qxlj(String qxlj) {
            obj.setQxlj(qxlj);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column tb_yhcz_rz.CZSJ
         *
         * @param czsj the value for tb_yhcz_rz.CZSJ
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder czsj(String czsj) {
            obj.setCzsj(czsj);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table tb_yhcz_rz
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public YhczRz build() {
            return this.obj;
        }
    }
}