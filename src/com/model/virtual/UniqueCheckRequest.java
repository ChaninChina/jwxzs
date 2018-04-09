package com.model.virtual;

import com.util.annotation.NotEmpty;

public class UniqueCheckRequest {
	
	// 表名(必填项)
	@NotEmpty(message = "表名不能为空！")
	private String tableName;
	
    // 检测字段(必填项)
	@NotEmpty(message = "查询字段不能为空！")
	private String key;
	
    // 检测值(必填项)
	@NotEmpty(message = "查询值不能为空！")
	private String value;
	
	
	
	
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	@Override
	public String toString() {
		return "UniqueCheckRequest [tableName=" + tableName + ", key=" + key + ", value=" + value + "]";
	}
	
	

}
