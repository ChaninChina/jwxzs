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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Strw;
import com.model.Stxx;
import com.model.Xxxx;
import com.model.Yhxx;
import com.service.IFjService;
import com.service.IRwjlService;
import com.service.IStrwService;
import com.service.IStxxService;
import com.service.IXxxxService;
import com.service.Impl.RwjlService;
import com.service.Impl.StxxService;
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
@RequestMapping("/data/xxxx/")
public class XxxxController extends BaseController {

	Logger logger = Logger.getLogger(XxxxController.class);

	@Resource
	private IXxxxService xxxxService;

	@Resource
	private IFjService fjService;

	/**
	 * 获取用户所有消息信息
	 * @param ep
	 * @param cn
	 * @param timestamp
	 * @param rndo
	 * @param sign
	 * @param request
	 * @return
	 */
	@SuppressWarnings("null")
	@ResponseBody
	@RequestMapping("find")
	public ResultMessage<PageResult<Xxxx>> findXxxx(Integer ep, Integer cn,Long timestamp, String rndo, String sign,
			HttpServletRequest request) {
		long start = System.currentTimeMillis();
		ResultMessage<PageResult<Xxxx>> resultMessage = new ResultMessage<>();

		try {
			Yhxx yhxx = (Yhxx) request.getAttribute("yhxx");
			if (yhxx == null || StringUtils.isEmpty(yhxx.getYhid())) {
				throw new AuthException("用户信息有误！请重新登陆！");
			}

			HashMap<String, Object> paramMap = new HashMap<>();
			paramMap.put("jsfid", yhxx.getYhid());
			paramMap.put("ep", ep);
			paramMap.put("cn", cn);
			paramMap.put("order", "asc");
			if (timestamp != null) {
				paramMap.put("gtTimeStamp", timestamp);
			}
			paramMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			PageResult<Xxxx> xxxxs = xxxxService.selectXxxxPage(paramMap);

			resultMessage.setResultCode(ResultMessage.SUCCESS);
			resultMessage.setData(xxxxs);
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
	 * 获取特定发送方的消息信息
	 * @param ep
	 * @param cn
	 * @param fsfid
	 * @param timestamp
	 * @param rndo
	 * @param sign
	 * @param request
	 * @return
	 */
	@SuppressWarnings("null")
	@ResponseBody
	@RequestMapping("find_fsf")
	public ResultMessage<PageResult<Xxxx>> findXxxxByFsf(Integer ep, Integer cn,String fsfid, Long timestamp, String rndo, String sign,
			HttpServletRequest request) {
		long start = System.currentTimeMillis();
		ResultMessage<PageResult<Xxxx>> resultMessage = new ResultMessage<>();

		try {
			
			if(ParamUtil.isEmpty(fsfid)) {
				throw new Exception("参数有误！");
			}
			
			Yhxx yhxx = (Yhxx) request.getAttribute("yhxx");
			if (yhxx == null || StringUtils.isEmpty(yhxx.getYhid())) {
				throw new AuthException("用户信息有误！请重新登陆！");
			}

			HashMap<String, Object> paramMap = new HashMap<>();
			paramMap.put("yhid", yhxx.getYhid());
			paramMap.put("fsfid", fsfid);
			paramMap.put("ep", ep);
			paramMap.put("cn", cn);
			paramMap.put("order", "desc");
			if (timestamp != null) {
				paramMap.put("ltTimeStamp", timestamp);
			}
			paramMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			PageResult<Xxxx> xxxxs = xxxxService.selectXxxxPage(paramMap);
			resultMessage.setResultCode(ResultMessage.SUCCESS);
			resultMessage.setData(xxxxs);
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
	 * 获取发送方头像
	 * @param id
	 * @param type
	 * @param rndo
	 * @param sign
	 * @param request
	 * @param response
	 */
	@RequestMapping("avatar")
	public void findAvatar(String id, String type, String rndo, String sign, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (ParamUtil.isEmpty(id, type)) {
				return;
			}
			String fjlj = null;

			if (DictEnumUtil.XXLX_XTXX.equals(type)) {

			} else if (DictEnumUtil.XXLX_RWXX.equals(type)) {
				HashMap<String, Object> hashMap = new HashMap<>();
				hashMap.put("rwid", id);
				hashMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
				fjlj = fjService.selectRwfj(hashMap);
			} else if (DictEnumUtil.XXLX_QZXX.equals(type)) {

			}

			File file = new File(configInfo.getPicPath() + fjlj); // 附件路径
			if (file.exists() && file.isFile()) {
				InputStream is = new FileInputStream(file);
				OutputStream os = response.getOutputStream();
				try {
					byte[] b = new byte[1024];
					int r = 0;
					while ((r = is.read(b)) > 0) {
						os.write(b, 0, r);
					}
				} catch (IOException ex) {
					throw new IOException(ex.getMessage(), ex);
				} finally {
					if (os != null) {
						os.close();
					}
					if (is != null) {
						is.close();
					}
				}
			}
		} catch (Exception e) {
			return;
		}
	}

}
