/**
 * 
 */
package com.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Strw;
import com.model.Stxx;
import com.model.Yhxx;
import com.service.IRwjlService;
import com.service.IStrwService;
import com.service.IStxxService;
import com.service.Impl.RwjlService;
import com.service.Impl.StxxService;
import com.sun.istack.internal.logging.Logger;
import com.util.ParamUtil;
import com.util.dict.DictEnumUtil;
import com.util.exception.AuthException;
import com.util.model.ResultMessage;

/**
 * @author Chanin
 *
 */
@Controller
@RequestMapping("/data/stxx/")
public class StxxController extends BaseController {

	Logger logger = Logger.getLogger(StxxController.class);

	@Resource
	private IStrwService strwService;

	@Resource
	private IRwjlService stJlService;

	@Resource
	private IStxxService stxxService;

	//通过实体ID获取实体信息以及实体任务信息
	@SuppressWarnings("null")
	@ResponseBody
	@RequestMapping("find")
	public ResultMessage<Stxx> findStxx(String stid, String rndo, String sign, HttpServletRequest request) {
		long start = System.currentTimeMillis();
		ResultMessage<Stxx> resultMessage = new ResultMessage<>();

		try {
			if (ParamUtil.isEmpty(stid)) {
				throw new Exception("参数有误！");
			}
			Yhxx yhxx = (Yhxx) request.getAttribute("yhxx");
			if (yhxx == null || StringUtils.isEmpty(yhxx.getYhid())) {
				throw new AuthException("用户信息有误！请重新登陆！");
			}

			HashMap<String, Object> paramMap = new HashMap<>();
			paramMap.put("stid", stid);
			paramMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			List<Stxx> stxxs = stxxService.selectStxx(paramMap);

			if (CollectionUtils.isEmpty(stxxs)) {
				throw new Exception("未找到相关实体");
			}

			Stxx stxx = stxxs.get(0);

			paramMap.put("yhid", yhxx.getYhid());

			List<Strw> strws = strwService.selectYhStrw(paramMap);//获取实体任务信息
			if(CollectionUtils.isNotEmpty(strws)) {
				for (Strw strw : strws) {
					strw.setHasPermission(true);
				}
			}
			stxx.setStrws(strws);
			resultMessage.setResultCode(ResultMessage.SUCCESS);
			resultMessage.setData(stxx);

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

}
