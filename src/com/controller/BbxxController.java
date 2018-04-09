/**
 * 
 */
package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.model.Bbxx;
import com.service.IBbxxService;
import com.service.Impl.BbxxService;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.util.dict.DictEnumUtil;
import com.util.model.ResultMessage;

/**
 * @author Chanin
 *
 */
@Controller
@RequestMapping("data/bbxx/")
public class BbxxController extends BaseController{
	
	@Resource
	private IBbxxService bbXxService;
	//通过版本号获取版本信息
	@ResponseBody
	@RequestMapping("find")
	public ResultMessage<Bbxx> findBbXx(Integer version){
		ResultMessage<Bbxx> resultMessage = new ResultMessage<>();
		try {
			Map<String, Object> bbXxparamMap = new HashMap<>();
			bbXxparamMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			bbXxparamMap.put("bbbh", version);
			List<Bbxx> bbXxs = bbXxService.selectBbXx(bbXxparamMap);
			if(CollectionUtils.isEmpty(bbXxs)){
				throw new Exception("未查询到相关信息！");
			}
		
			resultMessage.setData(bbXxs.get(0));
			resultMessage.setResultCode(ResultMessage.SUCCESS);
			
		} catch (Exception e) {
			// TODO: handle exception
			resultMessage.setResultCode(ResultMessage.FAIL);
			resultMessage.setResultMsg(e.getMessage());
		}
	
		resultMessage.setServerTime(System.currentTimeMillis());
		
		return resultMessage;
	}

	

	
}
