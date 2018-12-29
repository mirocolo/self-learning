package com.galaxy.learn.util.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created on 2018/12/27.
 *
 * @author He Xin
 */
public class Loggers {

	public static final Logger monitorLogger = LoggerFactory.getLogger("monitorLogger");

	public static final Logger runLogger = LoggerFactory.getLogger("runLogger");

	public static final Logger errorLogger = LoggerFactory.getLogger("commonErrorLogger");

	private Loggers() {
	}
}
