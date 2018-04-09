package com.model.virtual;


public class RwCount {
	
	/**
	 * 		
	 * DictEnumUtil.RWLX; 所有
	 * DictEnumUtil.RWLX_GRRW;个人
	 * DictEnumUtil.RWLX_GXRW;共享
	 * DictEnumUtil.WCZT_WWC;未完成
	 * DictEnumUtil.WCZT_YWC;已完成
	 * DictEnumUtil.REVIEW_SYMBOL_WSH;审核中
	 * 
	 * 
	 * 
	 * */
	private String type; 
	
	private int count;
	
	

	public RwCount(String type, int count) {
		super();
		this.type = type;
		this.count = count;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}


	

}
