package com.galaxy.learn.listener;

import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ListenerManager {


	private Map<String, Method> signature2Handler = new HashMap<>();


	public void registerEventListener(Object listener, EventType eventType, Method method) {
		signature2Handler.put(getKey(listener, eventType), method);
	}

	private String getKey(Object handler, EventType eventType) {
		return handler.getClass().getName() + "-" + eventType.toString();
	}


	/**
	 * 分发给具体监听器执行
	 */
	public void fireEvent(Object handler, BaseEvent event) {
		try {
			Method method = signature2Handler.get(getKey(handler, event.getEventType()));
			method.invoke(handler, event);
		} catch (Exception e) {
			log.error("", e);
		}
	}

}
