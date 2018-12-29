package com.galaxy.learn.listener;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MessageListenerBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware, Ordered {

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
	}

	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		return arg0;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String arg1) throws BeansException {

		return bean;
	}

}