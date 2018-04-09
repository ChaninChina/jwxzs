package com.util.jg;

import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.model.OrgnInfo;
import com.util.model.ModelUtil;

/**
 * 机构填充工具
 * @author QingLong
 */
@Component
public class OrgnFillUtil {
	
	Logger logger = Logger.getLogger(OrgnFillUtil.class);
	
	@Resource
	private OrgnListUtil orgnListUtil;
	
	/**
	 * 填充机构类型
	 * @param orgnInfo
	 * @throws Exception 
	 */
	public void fillOrgnInfo(OrgnInfo orgnInfo) throws Exception {
		if (null == orgnInfo || StringUtils.isBlank(orgnInfo.getOrgnId())) {
			return;
		}
		orgnListUtil.setOrgnInfo(orgnInfo);
	}
	
	/**
	 * 反射对象,填充枚举类型
	 * @param model
	 * @throws Exception 
	 */
	public void fillOrgnInfoOfModel(Object model) throws Exception {
		if (null == model) {
			return;
		}
		Method[] methods = model.getClass().getMethods();
		for (int i=0;i<methods.length;i++) {
			Method method = methods[i];
			if (method.getName().equals("getClass")) {
				continue;
			}
			if (!ModelUtil.isGetMethod(method)) {
				continue;
			}
			Class<?> returnType = method.getReturnType();
			if (returnType == OrgnInfo.class) {
				OrgnInfo orgnInfo = (OrgnInfo) ModelUtil.invokeGetMethod(model, method);
				if (null == orgnInfo || StringUtils.isBlank(orgnInfo.getOrgnId())) {
					continue;
				}
				orgnListUtil.setOrgnInfo(orgnInfo);
			} else {
				continue;
			}
		}
	}
	
	/**
	 * 反射对象,填充枚举类型
	 * @param model
	 * @param propertyName
	 * @throws Exception 
	 */
	public void fillOrgnInfoOfProperty(Object model, String propertyName) throws Exception {
		if (model == null || StringUtils.isBlank(propertyName)) {
			return;
		}
		Method method = ModelUtil.getGetMethod(model.getClass(), propertyName);
		if (method == null) {
			return;
		}
		Class<?> returnType = method.getReturnType();
		if (returnType == OrgnInfo.class) { //机构类型
			OrgnInfo orgnInfo = (OrgnInfo) ModelUtil.invokeGetMethod(model, method);
			if (null == orgnInfo || StringUtils.isBlank(orgnInfo.getOrgnId())) {
				return;
			}
			orgnListUtil.setOrgnInfo(orgnInfo);
		} else {
			return;
		}
	}
	
	/**
	 * 反射对象,填充枚举类型
	 * @param model
	 * @param propertyNames
	 * @throws Exception 
	 */
	public void fillOrgnInfoOfProperties(Object model, String...propertyNames) throws Exception {
		if (null == propertyNames || propertyNames.length == 0) {
			return;
		}
		for (String propertyName : propertyNames) {
			fillOrgnInfoOfProperty(model, propertyName);
		}
	}
}