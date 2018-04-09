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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.Yhxx;
import com.service.IYhxxService;
import com.util.JsonUtil;
import com.util.SignUtil;
import com.util.exception.AuthException;

/**
 * 会话拦截器
 * 
 * @author QingLong
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

	Logger logger = Logger.getLogger(TokenInterceptor.class);

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

		try {
			String token = request.getHeader("token");
			if (StringUtils.isEmpty(token)) {
				token = request.getParameter("token");
			}
			if (StringUtils.isEmpty(token)) {
				throw new Exception("token未空，非法请求！");
			}

			Yhxx yhxx = yhXxService.getYhxxByToken(token);

			if (null == yhxx) {
				throw new AuthException("token无效或过期");
			}

			request.setAttribute("yhxx", yhxx);
			//throw new AuthException("token无效或过期");
		} catch (Exception e) {
			
			System.out.println("Token =====" + e.getMessage());
			if (e instanceof AuthException) {
				response.sendRedirect(request.getContextPath() + "/data/error/token");
			} else {
				response.sendRedirect(request.getContextPath() + "/data/error/sign");
			}
			return false;
		}

		return true;
	}
}