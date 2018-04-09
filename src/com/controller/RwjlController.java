/**
 * 
 */
package com.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fasterxml.jackson.core.type.TypeReference;
import com.model.Rwjl;
import com.model.RwjlTm;
import com.model.Yhxx;
import com.service.IRwjlService;
import com.service.Impl.RwjlService;
import com.sun.xml.internal.stream.Entity;
import com.util.FileUtil;
import com.util.JsonUtil;
import com.util.ParamUtil;
import com.util.UUIDUtil;
import com.util.dict.DictEnumUtil;
import com.util.exception.AuthException;
import com.util.model.ResultMessage;
import com.util.page.PageResult;

/**
 * @author Chanin
 *
 */
@Controller
@RequestMapping("/data/rwjl/")
public class RwjlController extends BaseController {

	@Resource
	private IRwjlService rwjlService;

	// 通过任务记录主键获取任务记录详细信息
	@ResponseBody
	@RequestMapping("find_info")
	public ResultMessage<Rwjl> findRwjl(String rwjlid, String rndo, String sign, HttpServletRequest request) {
		long start = System.currentTimeMillis();
		ResultMessage<Rwjl> resultMessage = new ResultMessage<>();
		try {
			if (ParamUtil.isEmpty(rwjlid)) {
				throw new Exception("参数有误！");
			}
			Yhxx yhxx = (Yhxx) request.getAttribute("yhxx");
			if (yhxx == null || StringUtils.isEmpty(yhxx.getYhid())) {
				throw new AuthException("用户信息有误！请重新登陆！");
			}

			HashMap<String, Object> paramMap = new HashMap<>();
			paramMap.put("rwjlid", rwjlid);
			paramMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			List<Rwjl> rwjls = rwjlService.selectRwjlInfo(paramMap);
			if (CollectionUtils.isEmpty(rwjls)) {
				throw new Exception("未找到相关信息！");
			}
			resultMessage.setResultCode(ResultMessage.SUCCESS);
			resultMessage.setData(rwjls.get(0));
		} catch (Exception e) {
			if (e instanceof AuthException) {
				resultMessage.setResultCode(ResultMessage.AUTH_FAIL);
			} else {
				resultMessage.setResultCode(ResultMessage.FAIL);
			}
			resultMessage.setResultMsg(e.getMessage());
		}

		resultMessage.setServerTime(System.currentTimeMillis());
		resultMessage.setSpendTime((int) (System.currentTimeMillis() - start));
		return resultMessage;

	}

	/**
	 * 保存任务记录
	 * @param rwjlInfo
	 * @param rndo
	 * @param sign
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping("save")
	public ResultMessage saveRwjl(String rwjlInfo, String rndo, String sign, HttpServletRequest request) {
		ResultMessage resultMessage = new ResultMessage<>();
		try {
			if (ParamUtil.isEmpty(rwjlInfo)) {
				throw new Exception("参数错误！");
			}

			Yhxx yhxx = (Yhxx) request.getAttribute("yhxx");
			if (yhxx == null || StringUtils.isEmpty(yhxx.getYhid())) {
				throw new AuthException("用户信息有误！请重新登陆！");
			}
			Map<String, List<MultipartFile>> files = null;
			MultipartResolver multipartResolver = new CommonsMultipartResolver(
					request.getSession().getServletContext());
			// 判断 request 是否有文件上传,即多部分请求
			if (multipartResolver.isMultipart(request)) {
				MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
				files = multipartHttpServletRequest.getMultiFileMap();

			}

			Rwjl rwjl = JsonUtil.parse(rwjlInfo, Rwjl.class);
			if (null != rwjl) {
				rwjlService.saveRwjl(yhxx.getYhid(), rwjl, files);
			} else {
				throw new Exception("无法解析参数！");
			}

			resultMessage.setResultCode(ResultMessage.SUCCESS);
		} catch (Exception e) {
			if (e instanceof AuthException) {
				resultMessage.setResultCode(ResultMessage.AUTH_FAIL);
			} else {
				resultMessage.setResultCode(ResultMessage.FAIL);
			}
			resultMessage.setResultMsg(e.getMessage());
		}

		resultMessage.setServerTime(System.currentTimeMillis());
		return resultMessage;

	}

	// 获取用户历史任务记录
	@ResponseBody
	@RequestMapping("find_yh")
	public ResultMessage<PageResult<Rwjl>> findRwjlByYh(String ep, String cn, String rndo, String sign,
			HttpServletRequest request) {
		ResultMessage<PageResult<Rwjl>> resultMessage = new ResultMessage<>();
		try {
			Yhxx yhxx = (Yhxx) request.getAttribute("yhxx");
			if (yhxx == null || StringUtils.isEmpty(yhxx.getYhid())) {
				throw new AuthException("用户信息有误！请重新登陆！");
			}

			HashMap<String, Object> paramMap = new HashMap<>();
			paramMap.put("createId", yhxx.getYhid());
			paramMap.put("ep", ep);
			paramMap.put("cn", cn);
			paramMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			PageResult<Rwjl> pageResult = rwjlService.selectRwjlPage(paramMap);

			resultMessage.setResultCode(ResultMessage.SUCCESS);
			resultMessage.setData(pageResult);
		} catch (Exception e) {
			if (e instanceof AuthException) {
				resultMessage.setResultCode(ResultMessage.AUTH_FAIL);
			} else {
				resultMessage.setResultCode(ResultMessage.FAIL);
			}
			resultMessage.setResultMsg(e.getMessage());
		}
		resultMessage.setServerTime(System.currentTimeMillis());
		return resultMessage;
	}

	// 获取任务的任务记录
	@ResponseBody
	@RequestMapping("find_rw")
	public ResultMessage<PageResult<Rwjl>> findRwjlByRw(String rwid, String ep, String cn, String rndo, String sign,
			HttpServletRequest request) {
		ResultMessage<PageResult<Rwjl>> resultMessage = new ResultMessage<>();
		try {
			if (ParamUtil.isEmpty(rwid)) {
				throw new Exception("参数有误！");
			}

			Yhxx yhxx = (Yhxx) request.getAttribute("yhxx");
			if (yhxx == null || StringUtils.isEmpty(yhxx.getYhid())) {
				throw new AuthException("用户信息有误！请重新登陆！");
			}

			HashMap<String, Object> paramMap = new HashMap<>();
			paramMap.put("rwid", rwid);
			paramMap.put("ep", ep);
			paramMap.put("cn", cn);
			paramMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			PageResult<Rwjl> pageResult = rwjlService.selectRwjlPage(paramMap);

			resultMessage.setResultCode(ResultMessage.SUCCESS);
			resultMessage.setData(pageResult);
		} catch (Exception e) {
			if (e instanceof AuthException) {
				resultMessage.setResultCode(ResultMessage.AUTH_FAIL);
			} else {
				resultMessage.setResultCode(ResultMessage.FAIL);
			}
			resultMessage.setResultMsg(e.getMessage());
		}
		resultMessage.setServerTime(System.currentTimeMillis());
		return resultMessage;
	}

}
