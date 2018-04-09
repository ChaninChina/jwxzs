package com.util;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.AnnotationUtils;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class JsonUtil {
	
	private static ObjectMapper objMapper = null;
	
	static {
		objMapper = new ObjectMapper();
		objMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		objMapper.setFilters(new SimpleFilterProvider().setFailOnUnknownId(false));
	}
	
	public static String stringify(Object obj) throws JsonProcessingException {
		return objMapper.writeValueAsString(obj);
	}
	
	public static String stringify(Object obj, String... properties) throws JsonProcessingException {
		return objMapper.writer(new SimpleFilterProvider().addFilter(AnnotationUtils.getValue(AnnotationUtils.findAnnotation(obj.getClass(), JsonFilter.class)).toString(), SimpleBeanPropertyFilter.filterOutAllExcept(properties))).writeValueAsString(obj);
	}
	
	public static void stringify(OutputStream out, Object obj) throws IOException {
		objMapper.writeValue(out, obj);
	}
	
	public static void stringify(OutputStream out, Object obj, String... properties) throws IOException {
		objMapper.writer(new SimpleFilterProvider().addFilter(AnnotationUtils.getValue(AnnotationUtils.findAnnotation(obj.getClass(), JsonFilter.class)).toString(), SimpleBeanPropertyFilter.filterOutAllExcept(properties))).writeValue(out, obj);
	}
	
	public static <T> T parse(String json, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
		if (StringUtils.isBlank(json)) {
			return null;
		}
		return objMapper.readValue(json, clazz);
	}
	
	public static <T> T parse(String json, TypeReference<T> type) throws JsonParseException, JsonMappingException, IOException {
		if (StringUtils.isBlank(json)) {
			return null;
		}
		return objMapper.readValue(json, type);
	}
}