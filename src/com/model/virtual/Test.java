package com.model.virtual;

import com.util.ParamUtil;

public class Test {
	
	public static void main(String ... args) {
		UniqueCheckRequest uniqueCheckRequest = new UniqueCheckRequest();
		uniqueCheckRequest.setTableName("tableName");
		//uniqueCheckRequest.setKey("key");
		uniqueCheckRequest.setValue("value");
		try {
			ParamUtil.volidateBean(uniqueCheckRequest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("over");
	}

}
