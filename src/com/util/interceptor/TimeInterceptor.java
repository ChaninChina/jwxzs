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
public class TimeInterceptor implements HandlerInterceptor {

	Logger logger = Logger.getLogger(TimeInterceptor.class);
	private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("StopWatch-StartTime");

	@Resource
	private IYhxxService yhXxService;
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception exception) throws Exception {
		long endTime = System.currentTimeMillis();// 2、结束时间
		long beginTime = startTimeThreadLocal.get();// 得到线程绑定的局部变量（开始时间）
		long consumeTime = endTime - beginTime;// 3、消耗的时间
		logger.debug("============" + request.getRequestURI() + " spendTime: " + consumeTime);
		response.addHeader("spendTime", consumeTime+"");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView arg3)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {

		long beginTime = System.currentTimeMillis();// 1、开始时间
		startTimeThreadLocal.set(beginTime);// 线程绑定变量（该数据只有当前请求的线程可见）
		return true;
	}
}