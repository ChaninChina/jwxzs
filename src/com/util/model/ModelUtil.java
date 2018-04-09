package com.util.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 实体工具类
 * @author QingLong
 */
@SuppressWarnings("rawtypes")
public class ModelUtil {
	
	/**
	 * 是否getter方法
	 * @param method
	 * @return
	 */
	public static Boolean isGetMethod(Method method) {
		if (null == method) {
			return false;
		}
		if (!method.getName().startsWith("get")) {
			return false;
		}
		if (method.getParameterTypes().length > 0) {
			return false;
		}
		if (!Modifier.isPublic(method.getModifiers())) {
			return false;
		}
		return true;
	}
	
	/**
	 * 是否setter方法
	 * @param method
	 * @return
	 */
	public static Boolean isSetMethod(Method method) {
		if (null == method) {
			return false;
		}
		if (!method.getName().startsWith("set")) {
			return false;
		}
		if (method.getParameterTypes().length != 1) {
			return false;
		}
		if (method.getReturnType() != Void.TYPE) {
			return false;
		}
		if (!Modifier.isPublic(method.getModifiers())) {
			return false;
		}
		return true;
	}
	
	/**
	 * 调用getter方法,转换非RuntimeException
	 * @param object
	 * @param method
	 * @return
	 */
	public static Object invokeGetMethod(Object object, Method method) {
		try {
			return method.invoke(object, new Object[0]);
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
			throw new IllegalArgumentException(ex.getMessage(),ex);
		} catch (InvocationTargetException ex) {
			ex.printStackTrace();
			throw new IllegalArgumentException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * 调用setter方法,转换非RuntimeException
	 * @param object
	 * @param method
	 * @param value
	 * @return
	 */
	public static Object invokeSetMethod(Object object, Method method, Object value) {
		try {
			return method.invoke(object, new Object[]{value});
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
			throw new IllegalArgumentException(ex.getMessage(),ex);
		} catch (InvocationTargetException ex) {
			ex.printStackTrace();
			throw new IllegalArgumentException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * 返回属性名称
	 * @param methodName getter、setter方法
	 * @return
	 */
	public static String getPropertyName(String methodName) {
		return methodName.substring(3,4).toLowerCase() + methodName.substring(4);
	}
	
	/**
	 * 返回属性字段
	 * @param clazz
	 * @param propertyName
	 * @return
	 */
	public static Field getFieldByProperty(Class clazz, String propertyName) {
		try {
			return clazz.getDeclaredField(propertyName);
		} catch (SecurityException ex) {
			ex.printStackTrace();
		} catch (NoSuchFieldException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 返回字段注解
	 * @param clazz
	 * @param propertyName
	 * @param annotationClass
	 * @return
	 */
	public static <T extends Annotation> T getFieldAnnotation(Class<?> clazz, String propertyName, Class<T> annotationClass) {
		 Field field = getFieldByProperty(clazz, propertyName);
		 if (field == null) {
			 return null;
		 }
		 return getFieldAnnotation(field, annotationClass);
	}
	
	/**
	 * 返回字段注解
	 * @param field
	 * @param annotationClass
	 * @return
	 */
	public static <T extends Annotation> T getFieldAnnotation(Field field, Class<T> annotationClass) {
		return field.getAnnotation(annotationClass);
	}
	
	/**
	 * 返回getter方法名称
	 * @param propertyName
	 * @return
	 */
	public static String getGetMethodName(String propertyName) {
		return "get"+StringUtils.capitalize(propertyName);
	}
	
	/**
	 * 返回getter方法对象
	 * @param clazz
	 * @param propertyName
	 * @return
	 */
	public static Method getGetMethod(Class<?> clazz, String propertyName) {
		try {
			return clazz.getMethod(getGetMethodName(propertyName));
		} catch (SecurityException ex) {
			ex.printStackTrace();
		} catch (NoSuchMethodException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 是否数据更改
	 * @param presObj 当前对象
	 * @param pastObj 历史对象
	 * @param discardField 弃用属性
	 * @return
	 * @throws Exception
	 */
	public static boolean isModified(Object presObj, Object pastObj, String[] discardField) throws Exception {
		Class<?> presClazz = presObj.getClass();
		Class<?> pastClazz = pastObj.getClass();
		if (!presClazz.getName().equals(pastClazz.getName())) {
			return true;
		}
		List<String> castFieldList = new ArrayList<String>();
		if (null != discardField && discardField.length > 0) {
			castFieldList = Arrays.asList(discardField);
		}
		Field[] presFields = presClazz.getDeclaredFields();
		StringBuilder presSb = new StringBuilder();
		for (Field presField : presFields) {
			String presFieldName = presField.getName();
			if (castFieldList.contains(presFieldName)) {
				continue;
			}
			Method presMethod = presClazz.getMethod("get" + (presFieldName.substring(0, 1).toUpperCase() + presFieldName.substring(1)));
			Object presValue = invokeGetMethod(presObj, presMethod);
			if (null != presValue) {
				String presStr = presValue.toString();
				if (!"".equals(presStr)) {
					presSb.append(",");
					presSb.append(presStr);
				}
			}
		}
		Field[] pastFields = pastClazz.getDeclaredFields();
		StringBuilder pastSb = new StringBuilder();
		for (Field pastField : pastFields) {
			String pastFieldName = pastField.getName();
			if (castFieldList.contains(pastFieldName)) {
				continue;
			}
			Method pastMethod = pastClazz.getMethod("get" + (pastFieldName.substring(0, 1).toUpperCase() + pastFieldName.substring(1)));
			Object pastValue = invokeGetMethod(pastObj, pastMethod);
			if (null != pastValue) {
				String pastStr = pastValue.toString();
				if (!"".equals(pastStr)) {
					pastSb.append(",");
					pastSb.append(pastStr);
				}
			}
		}
		if (!presSb.toString().replace(" ", "").toLowerCase().equals(pastSb.toString().replace(" ", "").toLowerCase())) {
			return true;
		}
		return false;
	}
}