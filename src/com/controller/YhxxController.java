/**
 * 
 */
package com.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.YdYhdl;
import com.model.Yhxx;
import com.model.Yhzh;
import com.model.virtual.RegisterInfo;
import com.service.IYhxxService;
import com.sun.istack.internal.logging.Logger;
import com.util.DateUtil;
import com.util.JsonUtil;
import com.util.ParamUtil;
import com.util.dict.DictEnumUtil;
import com.util.exception.AuthException;
import com.util.model.ResultMessage;


/**
 * @author Chanin
 *
 */

@Controller
@RequestMapping("/data/yhxx/")
public class YhxxController extends BaseController{
	
	Logger logger = Logger.getLogger(YhxxController.class);
	
	@Resource
	private IYhxxService yhXxService;
	

	
	//登陆
	@ResponseBody
	@RequestMapping(value = "login")
	public ResultMessage<YdYhdl> selectYhXx(String name,String password,String rndo,String sign,HttpServletRequest request){
		long start = System.currentTimeMillis();
		ResultMessage<YdYhdl> resultMessage = new ResultMessage<>();
		try {
			if(StringUtils.isEmpty(name)||StringUtils.isEmpty(password)){
				throw new Exception("请输入用户名或登录密码！");
			}
			HashMap<String, Object> paramMap = new HashMap<>();
			paramMap.put("dlzh", name);
			paramMap.put("dlmm", password);
			paramMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			YdYhdl ydYhdl = yhXxService.selectYdYhdl(paramMap);
			resultMessage.setResultCode(ResultMessage.SUCCESS);
			resultMessage.setData(ydYhdl);
		} catch (Exception e) {
			resultMessage.setResultCode(ResultMessage.FAIL);
			resultMessage.setResultMsg(e.getMessage());
			
		}
		resultMessage.setServerTime(System.currentTimeMillis());
		resultMessage.setSpendTime((int) (System.currentTimeMillis()-start));
		return resultMessage;
	}
	
	//修改密码
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value = "change_password")
	public ResultMessage changeYhmm(String dlzh,String old_mm,String new_mm,String rndo,String sign,HttpServletRequest request){
		long start = System.currentTimeMillis();
		ResultMessage resultMessage = new ResultMessage<>();
		try {
			Yhxx yhxx = (Yhxx) request.getAttribute("yhxx");
			if(yhxx==null||StringUtils.isEmpty(yhxx.getYhid())) {
				throw new AuthException("用户信息有误！请重新登陆！");
			}
			yhXxService.changeYhmm(dlzh,old_mm,new_mm);
			
			resultMessage.setResultCode(ResultMessage.SUCCESS);
		} catch (Exception e) {
			if(e instanceof AuthException){
				resultMessage.setResultCode(ResultMessage.AUTH_FAIL);
			}else{
				resultMessage.setResultCode(ResultMessage.FAIL);
			}
			resultMessage.setResultMsg(e.getMessage());
			
		}
		resultMessage.setServerTime(System.currentTimeMillis());
		resultMessage.setSpendTime((int) (System.currentTimeMillis()-start));
		return resultMessage;
	}
	
	//注册账号
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value = "register_user")
	public ResultMessage registerUser(String registerInfo,String rndo,String sign,HttpServletRequest request){
		long start = System.currentTimeMillis();
		ResultMessage resultMessage = new ResultMessage<>();
		try {
//			if(bindingResult.hasErrors()) {
//				throw new Exception(bindingResult.getFieldError().getDefaultMessage());
//			}
			
			RegisterInfo rInfo = JsonUtil.parse(registerInfo, RegisterInfo.class);
			ParamUtil.volidateBean(rInfo);
			
			
			
			HashMap<String, Object> paramMap = new HashMap<>();
			paramMap.put("dlzh", rInfo.getDlzh());
			paramMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			List<Yhzh> yhzhs = yhXxService.selectYhzh(paramMap);
			if(!CollectionUtils.isEmpty(yhzhs)) {
				throw new Exception("账号已被注册");
			}
			
			HashMap<String, Object> sfzhParamMap = new HashMap<>();
			sfzhParamMap.put("sfzh", rInfo.getSfzh());
			sfzhParamMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			List<Yhxx> yList = yhXxService.selectYhXx(sfzhParamMap);
			if(!CollectionUtils.isEmpty(yList)) {
				throw new Exception("身份证号已被注册");
			}
			
			HashMap<String, Object> sjhParamMap = new HashMap<>();
			sjhParamMap.put("lxdh", rInfo.getLxdh());
			sjhParamMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			List<Yhxx> lYhxxs = yhXxService.selectYhXx(sjhParamMap);
			if(!CollectionUtils.isEmpty(lYhxxs)) {
				throw new Exception("手机号已被注册");
			}
			
			
			yhXxService.registerUser(rInfo);
			resultMessage.setResultCode(ResultMessage.SUCCESS);
		} catch (Exception e) {
			resultMessage.setResultCode(ResultMessage.FAIL);
			resultMessage.setResultMsg(e.getMessage());
		}
		resultMessage.setServerTime(System.currentTimeMillis());
		resultMessage.setSpendTime((int) (System.currentTimeMillis()-start));
		return resultMessage;
	}
	
	//修改用户信息
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value = "change_info")
	public ResultMessage changeUserInfo(String userInfo,String rndo,String sign,HttpServletRequest request){
		long start = System.currentTimeMillis();
		ResultMessage resultMessage = new ResultMessage<>();
		try {
//			if(bindingResult.hasErrors()) {
//				throw new Exception(bindingResult.getFieldError().getDefaultMessage());
//			}
			
			Yhxx rInfo = JsonUtil.parse(userInfo, Yhxx.class);
			//ParamUtil.volidateBean(rInfo);
			if(rInfo == null) {
				throw new Exception("参数有误！");
			}
			
			Yhxx yhxx = (Yhxx) request.getAttribute("yhxx");
			if(yhxx==null||StringUtils.isEmpty(yhxx.getYhid())) {
				throw new AuthException("用户信息有误！请重新登陆！");
			}
			
			yhxx.setLxdh(rInfo.getLxdh());
			yhxx.setOrgnId(rInfo.getOrgnId());
			yhxx.setSzdw(rInfo.getSzdw());
			yhxx.setUpdateId(yhxx.getYhid());
			yhxx.setUpdateTime(DateUtil.getDate(DateUtil.yyyy_MM_dd_HH_mm_ss));
			yhxx.setYhlx(rInfo.getYhlx());
			yhxx.setYhsp(rInfo.getYhsp());
			yhxx.setYhxm(rInfo.getYhxm());
			yhxx.setYhzw(rInfo.getYhzw());
			yhxx.setCreateId(null);
			yhxx.setCreateTime(null);
			yhxx.setSfzh(null);
			yhxx.setYhxb(null);
			yhXxService.updateYhXx(yhxx);
			resultMessage.setResultCode(ResultMessage.SUCCESS);
		} catch (Exception e) {
			resultMessage.setResultCode(ResultMessage.FAIL);
			resultMessage.setResultMsg(e.getMessage());
		}
		resultMessage.setServerTime(System.currentTimeMillis());
		resultMessage.setSpendTime((int) (System.currentTimeMillis()-start));
		return resultMessage;
	}

	
	

}
