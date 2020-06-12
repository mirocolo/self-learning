package com.galaxy.learn.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Function：
 *
 * @author HeXin
 * @date 2020年06月11日 14:33
 * @since JDK 1.8
 */
@Data
public class Vo {
	@JsonProperty("bb")
	private int a;
	private String b;
//	private Map<String,Object> mapT;
}
