/**
 * 
 */
package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Bbxx;
import com.model.Xtpz;
import com.model.Yhxx;
import com.model.virtual.UniqueCheckRequest;
import com.model.virtual.Xtxx;
import com.service.IBbxxService;
import com.service.IXtpzService;
import com.service.Impl.BbxxService;
import com.service.Impl.XtpzService;
import com.sun.istack.internal.logging.Logger;
import com.util.JsonUtil;
import com.util.ParamUtil;
import com.util.dict.DictEnumUtil;
import com.util.model.ResultMessage;

/**
 * @author Chanin
 *
 */

@Controller
@RequestMapping("/data/xtpz/")
public class XtpzController extends BaseController{

	
	Logger logger = Logger.getLogger(XtpzController.class);
	
	@Resource
	private IXtpzService xtPzService;
	@Resource
	private IBbxxService bbXxService;
	/**
	 * 获取系统配置信息（包括版本信息）
	 * @param version
	 * @param rndo
	 * @param sign
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("find")
	public ResultMessage<Xtxx> findXtPz(Integer version,String rndo,String sign,HttpServletRequest request){
		System.out.println("rndo===="+rndo+"sign===="+sign);
		long start = System.currentTimeMillis();
		ResultMessage<Xtxx> resultMessage = new ResultMessage<>();
		
		try {
			Xtxx xtxx = new Xtxx();
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			List<Xtpz> xtPzs = xtPzService.selectXtPz(paramMap );//查询系统配置信息
			xtxx.setXtpzs(xtPzs);
			
			Map<String, Object> bbXxparamMap = new HashMap<>();
			bbXxparamMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			bbXxparamMap.put("bbbh", version);
			List<Bbxx> bbXxs = bbXxService.selectBbXx(bbXxparamMap);//查询版本信息
			if(CollectionUtils.isNotEmpty(bbXxs)){
				xtxx.setBbxx(bbXxs.get(0));
			}
		
			resultMessage.setResultCode(ResultMessage.SUCCESS);
			resultMessage.setData(xtxx);
		} catch (Exception e) {
			resultMessage.setResultCode(ResultMessage.FAIL);
			resultMessage.setResultMsg(e.getMessage());
		}
		resultMessage.setServerTime(System.currentTimeMillis());
		resultMessage.setSpendTime((int) (System.currentTimeMillis()-start));
		return resultMessage;
		
	}
	
	
	//查询账号、身份证号、身份证号重复
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value = "unique_check")
	public ResultMessage uniqueCheck(String uniqueCheckRequest,String rndo,String sign,HttpServletRequest request){
		long start = System.currentTimeMillis();
		ResultMessage resultMessage = new ResultMessage<>();
		try {			
			
			UniqueCheckRequest uCheckRequest = JsonUtil.parse(uniqueCheckRequest, UniqueCheckRequest.class);
			ParamUtil.volidateBean(uCheckRequest);
			System.out.println(uCheckRequest.toString());
			
			if(!"TB_YHZH".equalsIgnoreCase(uCheckRequest.getTableName())&&!"TB_YHXX".equalsIgnoreCase(uCheckRequest.getTableName())) {
				throw new Exception("参数有误！");
			}
			
			if(uCheckRequest.getValue().contains(";")) {
				throw new Exception("参数有误！");
			}
			
			HashMap<String, Object> paramMap = new HashMap<>();
			paramMap.put("tableName", uCheckRequest.getTableName());
			paramMap.put("key", uCheckRequest.getKey().toUpperCase());
			paramMap.put("value", uCheckRequest.getValue());
			paramMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			int count = xtPzService.countByKey(paramMap);
			if(count ==  0) {
				resultMessage.setResultCode(ResultMessage.SUCCESS);	
			}else {
				throw new Exception("值已存在！");
			}

			
			
		} catch (Exception e) {
			resultMessage.setResultCode(ResultMessage.FAIL);
			resultMessage.setResultMsg(e.getMessage());
		}
		resultMessage.setServerTime(System.currentTimeMillis());
		resultMessage.setSpendTime((int) (System.currentTimeMillis()-start));
		return resultMessage;
	}
	
}
