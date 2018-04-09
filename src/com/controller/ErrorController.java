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
@RequestMapping("data/error/")
public class ErrorController extends BaseController{
	//参数签名错误
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping("sign")
	public ResultMessage signError(){
		ResultMessage resultMessage = new ResultMessage<>();
		resultMessage.setResultCode(ResultMessage.FAIL);
		resultMessage.setResultMsg("参数有误，请求无效");
		return resultMessage;
	}
	
	//token错误
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping("token")
	public ResultMessage tokenError(){
		ResultMessage resultMessage = new ResultMessage<>();
		resultMessage.setResultCode(ResultMessage.AUTH_FAIL);
		resultMessage.setResultMsg("token无效或过期！");
		return resultMessage;
	}

}
