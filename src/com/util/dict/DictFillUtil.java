package com.util.dict;

import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.model.DictInfo;
import com.util.model.ModelUtil;

/**
 * 字典填充工具
 * @author QingLong
 */
@Component
public class DictFillUtil {
	
	Logger logger = Logger.getLogger(DictFillUtil.class);
	
	@Resource
	private DictListUtil dictListUtil;
	
	/**
	 * 填充枚举类型
	 * @param dictInfo
	 * @throws Exception 
	 */
	public void fillDictInfo(DictInfo dictInfo) throws Exception {
		if (dictInfo == null || StringUtils.isBlank(dictInfo.getDictCode())) {
			return;
		}
		dictListUtil.setDictInfo(dictInfo);
	}
	
	/**
	 * 反射对象,填充枚举类型
	 * @param model
	 * @throws Exception 
	 */
	public void fillDictInfoOfModel(Object model) throws Exception {
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
			if (returnType == DictInfo.class) { //单项字典
				DictInfo dictInfo = (DictInfo) ModelUtil.invokeGetMethod(model, method);
				if (null == dictInfo || StringUtils.isBlank(dictInfo.getDictCode())) {
					continue;
				}
				dictListUtil.setDictInfo(dictInfo);
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
	public void fillDictInfoOfProperty(Object model, String propertyName) throws Exception {
		if (model == null || StringUtils.isBlank(propertyName)) {
			return;
		}
		Method method = ModelUtil.getGetMethod(model.getClass(), propertyName);
		if (method == null) {
			return;
		}
		Class<?> returnType = method.getReturnType();
		if (returnType == DictInfo.class) { //单项字典
			DictInfo dictInfo = (DictInfo) ModelUtil.invokeGetMethod(model, method);
			if (null == dictInfo || StringUtils.isBlank(dictInfo.getDictCode())) {
				return;
			}
			dictListUtil.setDictInfo(dictInfo);
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
	public void fillDictInfoOfProperties(Object model, String...propertyNames) throws Exception {
		if (null == propertyNames || propertyNames.length == 0) {
			return;
		}
		for (String propertyName : propertyNames) {
			fillDictInfoOfProperty(model, propertyName);
		}
	}
}