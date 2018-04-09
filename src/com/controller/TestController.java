/**
 * 
 */
package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.util.model.ResultMessage;

/**
 * @author Chanin
 *
 */
@Controller
@RequestMapping("data/test/")
public class TestController extends BaseController{
	
	
	@ResponseBody
	@RequestMapping("test")
	public ResultMessage select(String param1) {
		ResultMessage resultMessage = new ResultMessage<>();
		resultMessage.setResultCode(ResultMessage.SUCCESS);
		resultMessage.setResultMsg("This is data" + System.currentTimeMillis());
		return resultMessage;
	}

}
