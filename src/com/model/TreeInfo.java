package com.model;

import com.util.model.BasicObject;

/**
 * 树图基本信息
 * @author QingLong
 */
public class TreeInfo extends BasicObject {
	
	private static final long serialVersionUID = -9120818132625576389L;
	private String id; //主键
	private String url; //链接
	private String code; //编号
	private String name; //名称
	private String piny; //首拼
	private Integer sort; //排序
	private Integer rank; //层级
	private String note; //备注
	private String pId; //父级
	private String pName; //父级名称
	private String pCode; //父级编号
	private String pPiny; //父级首拼
	private Boolean open; //展开标志
	private Boolean edit; //编辑标志
	private Boolean checked; //选中标志
	private Boolean isParent; //父级标志
	private String extentSymbol; //范围标志
	private String extentChoose; //范围选择
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPiny() {
		return piny;
	}
	public void setPiny(String piny) {
		this.piny = piny;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getpPiny() {
		return pPiny;
	}
	public void setpPiny(String pPiny) {
		this.pPiny = pPiny;
	}
	public Boolean getOpen() {
		return open;
	}
	public void setOpen(Boolean open) {
		this.open = open;
	}
	public Boolean getEdit() {
		return edit;
	}
	public void setEdit(Boolean edit) {
		this.edit = edit;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public Boolean getIsParent() {
		return isParent;
	}
	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}
	public String getExtentSymbol() {
		return extentSymbol;
	}
	public void setExtentSymbol(String extentSymbol) {
		this.extentSymbol = extentSymbol;
	}
	public String getExtentChoose() {
		return extentChoose;
	}
	public void setExtentChoose(String extentChoose) {
		this.extentChoose = extentChoose;
	}
}