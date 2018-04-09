/**
 * 群组信息
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
import com.model.Qzxx;
import com.model.YhQz;
import com.model.Yhxx;
import com.service.IMbxxService;
import com.service.IQzxxService;
import com.service.IStrwService;
import com.service.IYhQzService;
import com.service.IYhxxService;
import com.service.Impl.MbxxService;
import com.service.Impl.StrwService;
import com.service.Impl.YhQzService;
import com.util.DateUtil;
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
@RequestMapping("/data/qzxx/")
public class QzxxController extends BaseController{
	
	
	@Resource
	private IYhxxService yhxxService;
	@Resource
	private IQzxxService qzxxService;
	@Resource
	private IYhQzService yhQzService;
	


	/**
	 * 通过群组ID获取群组信息
	 * @param qzid
	 * @param token
	 * @param rndo
	 * @param sign
	 * @param request
	 * @return
	 */
	@ResponseBody	
	@RequestMapping("find")
	public ResultMessage<Qzxx> findQzxx(String qzid,String token,String rndo,String sign,HttpServletRequest request){
		ResultMessage<Qzxx> resultMessage = new ResultMessage<>();
		
		try {
			if(ParamUtil.isEmpty(qzid)){
				throw new Exception("参数有误！");
			}
			
			Yhxx yhxx = (Yhxx) request.getAttribute("yhxx");
			if (yhxx == null || StringUtils.isEmpty(yhxx.getYhid())) {
				throw new AuthException("用户信息有误！请重新登陆！");
			}
			

			
			HashMap<String, Object> paramMap = new HashMap<>();
			paramMap.put("qzid", qzid);
			paramMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);

			Qzxx qzxx = qzxxService.selectQzxxByQzid(paramMap);
			paramMap.put("yhid", yhxx.getYhid());
			List<YhQz> yhqzs = yhQzService.selectYhQz(paramMap);
			if(CollectionUtils.isNotEmpty(yhqzs)) {
				qzxx.setYhQz(yhqzs.get(0));
			}
		
			resultMessage.setResultCode(ResultMessage.SUCCESS);
			resultMessage.setData(qzxx);
			
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
	
	/**
	 * 通过群组标识码获取群组信息
	 * @param qzbsm 群组标识码
	 * @param token
	 * @param rndo
	 * @param sign
	 * @param request
	 * @return
	 */
	@ResponseBody	
	@RequestMapping("find_qr")
	public ResultMessage<Qzxx> findQzxxByQr(String qzbsm,String token,String rndo,String sign,HttpServletRequest request){
		ResultMessage<Qzxx> resultMessage = new ResultMessage<>();
		
		try {
			if(ParamUtil.isEmpty(qzbsm)){
				throw new Exception("参数有误！");
			}
			
			Yhxx yhxx = (Yhxx) request.getAttribute("yhxx");
			if (yhxx == null || StringUtils.isEmpty(yhxx.getYhid())) {
				throw new AuthException("用户信息有误！请重新登陆！");
			}
			
			HashMap<String, Object> paramMap = new HashMap<>();
			paramMap.put("bsm", qzbsm);
			paramMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);

			Qzxx qzxx = qzxxService.selectQzxxByQzBzm(paramMap);
			paramMap.put("yhid", yhxx.getYhid());
			paramMap.put("qzid", qzxx.getQzid());
			List<YhQz> yhqzs = yhQzService.selectYhQz(paramMap);
			if(CollectionUtils.isNotEmpty(yhqzs)) {
				qzxx.setYhQz(yhqzs.get(0));
			}
		
			resultMessage.setResultCode(ResultMessage.SUCCESS);
			resultMessage.setData(qzxx);
			
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
	
	/**
	 * 申请加入群组
	 * @param qzid
	 * @param token
	 * @param rndo
	 * @param sign
	 * @param request
	 * @return
	 */
	@ResponseBody	
	@RequestMapping("request_join")
	public ResultMessage requstJoin(String qzid,String token,String rndo,String sign,HttpServletRequest request){
		ResultMessage resultMessage = new ResultMessage<>();
		
		try {
			if(ParamUtil.isEmpty(qzid)){
				throw new Exception("参数有误！");
			}
			
			Yhxx yhxx = (Yhxx) request.getAttribute("yhxx");
			if (yhxx == null || StringUtils.isEmpty(yhxx.getYhid())) {
				throw new AuthException("用户信息有误！请重新登陆！");
			}
			

			HashMap<String, Object> paramMap = new HashMap<>();
			paramMap.put("qzid", qzid);
			paramMap.put("yhid",yhxx.getYhid());
			paramMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			List<YhQz> yhqzs = yhQzService.selectYhQz(paramMap);
			if(CollectionUtils.isNotEmpty(yhqzs)) {
				YhQz qz = yhqzs.get(0);
				if(DictEnumUtil.REVIEW_STATUS_WSH.equals(qz.getShzt())) {
					throw new Exception("您已申请加入");
				}
				if(DictEnumUtil.REVIEW_STATUS_YSH.equals(qz.getShzt())&&DictEnumUtil.REVIEW_RESULT_YTG.equals(qz.getShjg())) {
					throw new Exception("您已加入该群");
				}
				qz.setShzt(DictEnumUtil.REVIEW_STATUS_WSH);
				qz.setShjg(DictEnumUtil.REVIEW_RESULT_WTG);
				qz.setUpdateId(yhxx.getYhid());
				qz.setUpdateTime(DateUtil.getDate(DateUtil.yyyy_MM_dd_HH_mm_ss));
				yhQzService.update(qz);
				
			}else {
				yhQzService.save(qzid,yhxx.getYhid());
			}
			
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
		return resultMessage;
	}
}
