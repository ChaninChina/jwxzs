/**
 * 模板信息
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.MbTmfz;
import com.model.Mbxx;
import com.model.Yhxx;
import com.service.IMbxxService;
import com.service.IStrwService;
import com.service.Impl.MbxxService;
import com.service.Impl.StrwService;
import com.util.ParamUtil;
import com.util.dict.DictEnumUtil;
import com.util.exception.AuthException;
import com.util.model.ResultMessage;

import javafx.scene.chart.PieChart.Data;

/**
 * @author Chanin
 *
 */
@Controller
@RequestMapping("/data/mbxx/")
public class MbxxController extends BaseController{
	
	
	@Resource
	private IMbxxService mbXxService;
	@Resource
	private IStrwService stXxService;
	


	
	/**
	 * 通过任务id获取模板信息
	 * @param rwid
	 * @param token
	 * @param rndo
	 * @param sign
	 * @param request
	 * @return
	 */
	@ResponseBody	
	@RequestMapping("find")
	public ResultMessage<Mbxx> findMbxx(String rwid,String token,String rndo,String sign,HttpServletRequest request){
		ResultMessage<Mbxx> resultMessage = new ResultMessage<>();
		
		try {
			if(ParamUtil.isEmpty(rwid)){
				throw new Exception("参数有误！");
			}
			
			Yhxx yhxx = (Yhxx) request.getAttribute("yhxx");
			if (yhxx == null || StringUtils.isEmpty(yhxx.getYhid())) {
				throw new AuthException("用户信息有误！请重新登陆！");
			}
			

			boolean hasPermission = stXxService.hasPermission(rwid, yhxx.getYhid());
			if(!hasPermission) {
				throw new Exception("用户没有编辑记录权限！");
			}
			
			HashMap<String, String> paramMap = new HashMap<>();
			paramMap.put("rwid", rwid);
			paramMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			Mbxx mbXx = mbXxService.selectMbXxByRwid(rwid);
			if(null == mbXx){
				throw new Exception("未找到相关模板！");
			}
		
			resultMessage.setResultCode(ResultMessage.SUCCESS);
			resultMessage.setData(mbXx);
			
		} catch (Exception e) {
			if(e instanceof AuthException){
				resultMessage.setResultCode(ResultMessage.AUTH_FAIL);
			}else{
				resultMessage.setResultCode(ResultMessage.FAIL);
			}
			resultMessage.setResultMsg(e.getMessage());
		}
		
		resultMessage.setServerTime(System.currentTimeMillis());
		return resultMessage;
	}
}
