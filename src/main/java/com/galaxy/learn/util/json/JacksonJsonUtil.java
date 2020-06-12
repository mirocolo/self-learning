package com.galaxy.learn.util.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.galaxy.learn.bean.Vo;

/**
 * Function：
 *
 * @author HeXin
 * @date 2020年06月11日 14:03
 * @since JDK 1.8
 */
public class JacksonJsonUtil {
	private final ObjectMapper jacksonMapper;

	private JacksonJsonUtil() {
		jacksonMapper = new ObjectMapper();
		//todo 研究MapperFeature.DEFAULT_VIEW_INCLUSION 默认为true 自动序列化所有属性，false 的话只有带jsonview才会序列化
		jacksonMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false)
				// 美化输出
				// .enable(SerializationFeature.INDENT_OUTPUT);
				// 允许序列化空的POJO类（否则会抛出异常）
				.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
				// 把java.util.Date, Calendar输出为数字（时间戳）
				.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
				// 在遇到未知属性的时候不抛出异常
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				// 强制JSON 空字符串("")转换为null对象值:
//				.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true)
				.setSerializationInclusion(JsonInclude.Include.NON_NULL)
				.registerModule(new JavaTimeModule())
				.registerModule(new ParameterNamesModule())
				.registerModule(new Jdk8Module());
//		jacksonMapper.findAndRegisterModules();
	}

	public static JacksonJsonUtil getInstance() {
		return JacksonJsonUtil.SingletonHolder.instance;
	}

	public static void main(String[] args) throws JsonProcessingException {
		Vo vo = new Vo();
		vo.setA(1);
		vo.setB("2");

		ObjectMapper jacksonMapper = JacksonJsonUtil.getInstance().jacksonMapper;
		String x = jacksonMapper.writeValueAsString(vo);
		System.out.println(x);
		System.out.println(jacksonMapper.readValue(x, Vo.class));
//		System.out.println(JSON.toJSONString(vo));
	}

	private static class SingletonHolder {
		private static final JacksonJsonUtil instance = new JacksonJsonUtil();
	}
}
