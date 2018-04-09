/**
 * 
 */
package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.model.YhQz;
import com.model.Yhxx;
import com.model.virtual.RwCount;
import com.service.IRwjlService;
import com.service.IStrwService;
import com.service.IYhQzService;
import com.service.Impl.YhQzService;
import com.sun.istack.internal.logging.Logger;
import com.util.ParamUtil;
import com.util.dict.DictEnumUtil;
import com.util.exception.AuthException;
import com.util.model.ResultMessage;
import com.util.page.PageResult;

/**
 * @author Chanin
 *
 */
@Controller
@RequestMapping("/data/strw/")
public class StrwController extends BaseController {

	Logger logger = Logger.getLogger(StrwController.class);

	@Resource
	private IStrwService strwService;

	@Resource
	private IRwjlService stJlService;

	@Resource
	private IYhQzService yhQzService;

	// 分页获取用户任务信息（所有）
	@SuppressWarnings("null")
	@ResponseBody
	@RequestMapping("find_page_yh_all")
	public ResultMessage<PageResult<Strw>> findStrwAllByYhid(Long timestamp,Integer ep, Integer cn, String rndo, String sign,
			HttpServletRequest request) {
		long start = System.currentTimeMillis();
		ResultMessage<PageResult<Strw>> resultMessage = new ResultMessage<>();

		try {
			Yhxx yhxx = (Yhxx) request.getAttribute("yhxx");
			if (yhxx == null || StringUtils.isEmpty(yhxx.getYhid())) {
				throw new AuthException("用户信息有误！请重新登陆！");
			}
			PageResult<Strw> strws = null;
			HashMap<String, Object> strwParamMap = new HashMap<>();
			strwParamMap.put("yhid", yhxx.getYhid());
			strwParamMap.put("ep", ep);
			strwParamMap.put("cn", cn);
			strwParamMap.put("gtTimeStamp", timestamp);
			strwParamMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			strws = strwService.selectStrwPageZT(strwParamMap);// 分页获取所有任务
			resultMessage.setResultCode(ResultMessage.SUCCESS);
			resultMessage.setData(strws);

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

	// 分页获取用户任务信息（个人）
	@SuppressWarnings("null")
	@ResponseBody
	@RequestMapping("find_page_yh_presonal")
	public ResultMessage<PageResult<Strw>> findStrwPresonalByYhid(Long timestamp,Integer ep, Integer cn, String rndo, String sign,
			HttpServletRequest request) {
		long start = System.currentTimeMillis();
		ResultMessage<PageResult<Strw>> resultMessage = new ResultMessage<>();

		try {
			Yhxx yhxx = (Yhxx) request.getAttribute("yhxx");
			if (yhxx == null || StringUtils.isEmpty(yhxx.getYhid())) {
				throw new AuthException("用户信息有误！请重新登陆！");
			}
			PageResult<Strw> strws = null;
			HashMap<String, Object> strwParamMap = new HashMap<>();
			strwParamMap.put("yhid", yhxx.getYhid());
			strwParamMap.put("ep", ep);
			strwParamMap.put("cn", cn);
			strwParamMap.put("gtTimeStamp", timestamp);
			strwParamMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			strwParamMap.put("rwlx", DictEnumUtil.RWLX_GRRW);
			strws = strwService.selectStrwPageZT(strwParamMap);

			resultMessage.setResultCode(ResultMessage.SUCCESS);
			resultMessage.setData(strws);

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

	// 分页获取用户任务信息（共享）
	@SuppressWarnings("null")
	@ResponseBody
	@RequestMapping("find_page_yh_share")
	public ResultMessage<PageResult<Strw>> findStrwShareByYhid(Long timestamp,Integer ep, Integer cn,String rndo, String sign,
			HttpServletRequest request) {
		long start = System.currentTimeMillis();
		ResultMessage<PageResult<Strw>> resultMessage = new ResultMessage<>();

		try {
			Yhxx yhxx = (Yhxx) request.getAttribute("yhxx");
			if (yhxx == null || StringUtils.isEmpty(yhxx.getYhid())) {
				throw new AuthException("用户信息有误！请重新登陆！");
			}
			PageResult<Strw> strws = null;

			HashMap<String, Object> strwParamMap = new HashMap<>();
			strwParamMap.put("yhid", yhxx.getYhid());
			strwParamMap.put("ep", ep);
			strwParamMap.put("cn", cn);
			strwParamMap.put("gtTimeStamp", timestamp);
			strwParamMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			strwParamMap.put("rwlx", DictEnumUtil.RWLX_GXRW);
			strws = strwService.selectStrwPageZT(strwParamMap);

			resultMessage.setResultCode(ResultMessage.SUCCESS);
			resultMessage.setData(strws);

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

	// 分页获取用户任务信息（已完成）
	@SuppressWarnings("null")
	@ResponseBody
	@RequestMapping("find_page_yh_complete")
	public ResultMessage<PageResult<Strw>> findStrwCompleteByYhid(Long timestamp,Integer ep, Integer cn,String rndo, String sign,
			HttpServletRequest request) {
		long start = System.currentTimeMillis();
		ResultMessage<PageResult<Strw>> resultMessage = new ResultMessage<>();

		try {
			Yhxx yhxx = (Yhxx) request.getAttribute("yhxx");
			if (yhxx == null || StringUtils.isEmpty(yhxx.getYhid())) {
				throw new AuthException("用户信息有误！请重新登陆！");
			}
			PageResult<Strw> strws = null;

			HashMap<String, Object> strwParamMap = new HashMap<>();
			strwParamMap.put("yhid", yhxx.getYhid());
			strwParamMap.put("ep", ep);
			strwParamMap.put("cn", cn);
			strwParamMap.put("gtTimeStamp", timestamp);
			strwParamMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			strwParamMap.put("wczt", DictEnumUtil.WCZT_YWC);
			strws = strwService.selectStrwPageZT(strwParamMap);
			resultMessage.setResultCode(ResultMessage.SUCCESS);
			resultMessage.setData(strws);

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

	// 分页获取用户任务信息（未完成）
	@SuppressWarnings("null")
	@ResponseBody
	@RequestMapping("find_page_yh_uncomplete")
	public ResultMessage<PageResult<Strw>> findStrwUncompleteByYhid(Long timestamp,Integer ep, Integer cn,String rndo, String sign,
			HttpServletRequest request) {
		long start = System.currentTimeMillis();
		ResultMessage<PageResult<Strw>> resultMessage = new ResultMessage<>();

		try {
			Yhxx yhxx = (Yhxx) request.getAttribute("yhxx");
			if (yhxx == null || StringUtils.isEmpty(yhxx.getYhid())) {
				throw new AuthException("用户信息有误！请重新登陆！");
			}
			PageResult<Strw> strws = null;


			HashMap<String, Object> strwParamMap = new HashMap<>();
			strwParamMap.put("yhid", yhxx.getYhid());
			strwParamMap.put("ep", ep);
			strwParamMap.put("cn", cn);
			strwParamMap.put("gtTimeStamp", timestamp);
			strwParamMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			strwParamMap.put("wczt", DictEnumUtil.WCZT_WWC);
			strws = strwService.selectStrwPageZT(strwParamMap);

			resultMessage.setResultCode(ResultMessage.SUCCESS);
			resultMessage.setData(strws);

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

	// 分页获取用户任务信息（审核中）
	@SuppressWarnings("null")
	@ResponseBody
	@RequestMapping("find_page_yh_reviewing")
	public ResultMessage<PageResult<Strw>> findStrwReviewingByYhid(Long timestamp,Integer ep, Integer cn, String rndo, String sign,
			HttpServletRequest request) {
		long start = System.currentTimeMillis();
		ResultMessage<PageResult<Strw>> resultMessage = new ResultMessage<>();

		try {
			Yhxx yhxx = (Yhxx) request.getAttribute("yhxx");
			if (yhxx == null || StringUtils.isEmpty(yhxx.getYhid())) {
				throw new AuthException("用户信息有误！请重新登陆！");
			}
			PageResult<Strw> strws = null;
			HashMap<String, Object> strwParamMap = new HashMap<>();
			strwParamMap.put("yhid", yhxx.getYhid());
			strwParamMap.put("ep", ep);
			strwParamMap.put("cn", cn);
			strwParamMap.put("gtTimeStamp", timestamp);
			strwParamMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			strwParamMap.put("shzt", DictEnumUtil.REVIEW_STATUS_WSH);
			strws = strwService.selectStrwPageZT(strwParamMap);

			resultMessage.setResultCode(ResultMessage.SUCCESS);
			resultMessage.setData(strws);

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

	//获取用户所有任务
	@SuppressWarnings("null")
	@ResponseBody
	@RequestMapping("find_all_yh")
	@Deprecated
	public ResultMessage<List<Strw>> findStrwAllByYhid(String rndo, String sign, HttpServletRequest request) {
		long start = System.currentTimeMillis();
		ResultMessage<List<Strw>> resultMessage = new ResultMessage<>();

		try {

			Yhxx yhxx = (Yhxx) request.getAttribute("yhxx");
			if (yhxx == null || StringUtils.isEmpty(yhxx.getYhid())) {
				throw new AuthException("用户信息有误！请重新登陆！");
			}

			HashMap<String, Object> paramMap = new HashMap<>();
			paramMap.put("yhid", yhxx.getYhid());
			paramMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			List<Strw> strws = strwService.selectStrw(paramMap);

			resultMessage.setResultCode(ResultMessage.SUCCESS);
			resultMessage.setData(strws);

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
	
	//通过关键字搜索分页获取用户实体任务
	@SuppressWarnings("null")
	@ResponseBody
	@RequestMapping("search")
	public ResultMessage<PageResult<Strw>> searchStrwAllByYhid(String key,Integer ep, Integer cn,String rndo, String sign, HttpServletRequest request) {
		long start = System.currentTimeMillis();
		ResultMessage<PageResult<Strw>> resultMessage = new ResultMessage<>();

		try {

			Yhxx yhxx = (Yhxx) request.getAttribute("yhxx");
			if (yhxx == null || StringUtils.isEmpty(yhxx.getYhid())) {
				throw new AuthException("用户信息有误！请重新登陆！");
			}

			HashMap<String, Object> paramMap = new HashMap<>();
			paramMap.put("yhid", yhxx.getYhid());
			paramMap.put("key", "%"+key+"%");
			paramMap.put("ep", ep);
			paramMap.put("cn", cn);
			paramMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			PageResult<Strw> strws = strwService.searchStrw(paramMap);
			resultMessage.setResultCode(ResultMessage.SUCCESS);
			resultMessage.setData(strws);

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
	
	//增量获取所有未完成任务
	@SuppressWarnings("null")
	@ResponseBody
	@RequestMapping("find_all_yh_uncomplete")
	@Deprecated
	public ResultMessage<List<Strw>> findStrwIcreByYhid(Long timestamp,String rndo, String sign, HttpServletRequest request) {
		long start = System.currentTimeMillis();
		ResultMessage<List<Strw>> resultMessage = new ResultMessage<>();

		try {

			Yhxx yhxx = (Yhxx) request.getAttribute("yhxx");
			if (yhxx == null || StringUtils.isEmpty(yhxx.getYhid())) {
				throw new AuthException("用户信息有误！请重新登陆！");
			}

			HashMap<String, Object> paramMap = new HashMap<>();
			paramMap.put("yhid", yhxx.getYhid());
			paramMap.put("gtTimeStamp",timestamp);
			paramMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			List<Strw> strws = strwService.selectStrwWWC(paramMap);

			resultMessage.setResultCode(ResultMessage.SUCCESS);
			resultMessage.setData(strws);

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
	
	

	// 获取用户所有实体任务数量
	@SuppressWarnings("null")
	@ResponseBody
	@RequestMapping("find_count_yh")
	public ResultMessage<List<RwCount>> findCountByYhid(String rndo, String sign, HttpServletRequest request) {
		long start = System.currentTimeMillis();
		ResultMessage<List<RwCount>> resultMessage = new ResultMessage<>();

		try {

			Yhxx yhxx = (Yhxx) request.getAttribute("yhxx");
			if (yhxx == null || StringUtils.isEmpty(yhxx.getYhid())) {
				throw new AuthException("用户信息有误！请重新登陆！");
			}

			List<RwCount> rwCounts = new ArrayList<>();
			HashMap<String, Object> paramMap = new HashMap<>();
			paramMap.put("yhid", yhxx.getYhid());
			paramMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			int allCount = strwService.selectCount(paramMap); // 所有任务
			rwCounts.add(new RwCount(DictEnumUtil.RWLX, allCount));

			HashMap<String, Object> p1 = new HashMap<>();
			p1.put("yhid", yhxx.getYhid());
			p1.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			p1.put("rwlx", DictEnumUtil.RWLX_GRRW);
			int c1 = strwService.selectCount(p1); // 个人任务
			rwCounts.add(new RwCount(DictEnumUtil.RWLX_GRRW, c1));

			HashMap<String, Object> p2 = new HashMap<>();
			p2.put("yhid", yhxx.getYhid());
			p2.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			p2.put("rwlx", DictEnumUtil.RWLX_GXRW);
			int c2 = strwService.selectCount(p2); // 共享任务
			rwCounts.add(new RwCount(DictEnumUtil.RWLX_GXRW, c2));

			HashMap<String, Object> p3 = new HashMap<>();
			p3.put("yhid", yhxx.getYhid());
			p3.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			p3.put("wczt", DictEnumUtil.WCZT_YWC);
			int c3 = strwService.selectCount(p3); // 已完成
			rwCounts.add(new RwCount(DictEnumUtil.WCZT_YWC, c3));

			HashMap<String, Object> p4 = new HashMap<>();
			p4.put("yhid", yhxx.getYhid());
			p4.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			p4.put("wczt", DictEnumUtil.WCZT_WWC);
			int c4 = strwService.selectCount(p4); // 未完成
			rwCounts.add(new RwCount(DictEnumUtil.WCZT_WWC, c4));

			HashMap<String, Object> p5 = new HashMap<>();
			p5.put("yhid", yhxx.getYhid());
			p5.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			p5.put("shzt", DictEnumUtil.REVIEW_STATUS_WSH);
			int c5 = strwService.selectCount(p5); // 审核中
			rwCounts.add(new RwCount(DictEnumUtil.REVIEW_STATUS_WSH, c5));

			resultMessage.setResultCode(ResultMessage.SUCCESS);
			resultMessage.setData(rwCounts);

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

	// 通过任务主键获取任务详细信息
	@SuppressWarnings("null")
	@ResponseBody
	@RequestMapping("find_strw")
	public ResultMessage<Strw> findStrw(String rwid,Long timestamp, String rndo, String sign, HttpServletRequest request) {
		long start = System.currentTimeMillis();
		ResultMessage<Strw> resultMessage = new ResultMessage<>();

		try {

			Yhxx yhxx = (Yhxx) request.getAttribute("yhxx");
			if (yhxx == null || StringUtils.isEmpty(yhxx.getYhid())) {
				throw new AuthException("用户信息有误！请重新登陆！");
			}
	
			Strw strw = strwService.selectStrwByRwId(rwid, yhxx.getYhid());
		
			resultMessage.setResultCode(ResultMessage.SUCCESS);
			resultMessage.setData(strw);

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
