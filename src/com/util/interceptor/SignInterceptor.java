package com.util.interceptor;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.model.Yhxx;
import com.service.IYhxxService;
import com.util.JsonUtil;
import com.util.SignUtil;

/**
 * 会话拦截器
 * 
 * @author QingLong
 */
@Component
public class SignInterceptor implements HandlerInterceptor {

	Logger logger = Logger.getLogger(SignInterceptor.class);


	@Resource
	private IYhxxService yhXxService;
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception exception) throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView arg3)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {

		MultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		// 判断 request 是否有文件上传,即多部分请求
		if (!multipartResolver.isMultipart(request)) {
			Map<String, String[]> params = request.getParameterMap();
			String sign = SignUtil.signParams(params);
			String[] values = params.get("sign");
			if (values == null || values.length < 1 || !values[0].equals(sign)) {
				response.sendRedirect(request.getContextPath() + "/data/error/sign");
				return false;
			}
		}

		return true;
	}



}