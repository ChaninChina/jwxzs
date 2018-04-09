package com.util.qy;

import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.model.AreaInfo;
import com.util.model.ModelUtil;

/**
 * 区域填充工具
 * @author QingLong
 */
@Component
public class AreaFillUtil {
	
	Logger logger = Logger.getLogger(AreaFillUtil.class);
	
	@Resource
	private AreaListUtil areaListUtil;
	
	/**
	 * 填充区域类型
	 * @param areaInfo
	 * @throws Exception 
	 */
	public void fillAreaInfo(AreaInfo areaInfo) throws Exception {
		if (null == areaInfo || StringUtils.isBlank(areaInfo.getAreaId())) {
			return;
		}
		areaListUtil.setAreaInfo(areaInfo);
	}
	
	/**
	 * 反射对象,填充枚举类型
	 * @param model
	 * @throws Exception 
	 */
	public void fillAreaInfoOfModel(Object model) throws Exception {
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
			if (returnType == AreaInfo.class) {
				AreaInfo areaInfo = (AreaInfo) ModelUtil.invokeGetMethod(model, method);
				if (null == areaInfo || StringUtils.isBlank(areaInfo.getAreaId())) {
					continue;
				}
				areaListUtil.setAreaInfo(areaInfo);
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
	public void fillAreaInfoOfProperty(Object model, String propertyName) throws Exception {
		if (model == null || StringUtils.isBlank(propertyName)) {
			return;
		}
		Method method = ModelUtil.getGetMethod(model.getClass(), propertyName);
		if (method == null) {
			return;
		}
		Class<?> returnType = method.getReturnType();
		if (returnType == AreaInfo.class) { //区域类型
			AreaInfo areaInfo = (AreaInfo) ModelUtil.invokeGetMethod(model, method);
			if (null == areaInfo || StringUtils.isBlank(areaInfo.getAreaId())) {
				return;
			}
			areaListUtil.setAreaInfo(areaInfo);
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
	public void fillAreaInfoOfProperties(Object model, String...propertyNames) throws Exception {
		if (null == propertyNames || propertyNames.length == 0) {
			return;
		}
		for (String propertyName : propertyNames) {
			fillAreaInfoOfProperty(model, propertyName);
		}
	}
}