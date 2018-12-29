package com.galaxy.learn.aop.aspect;

import com.galaxy.learn.util.common.MapUtils;
import com.galaxy.learn.util.log.Loggers;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

/**
 * Created on 2018/12/26.
 *
 * @author He Xin
 */
@Slf4j
@Component
@Aspect
public class MethodMeasureAspect {

	private Map<String, Integer> methodCount = new ConcurrentHashMap<>();

	private Map<String, List<Integer>> methodCost = new ConcurrentHashMap<>();

	@SuppressWarnings(value = "unchecked")
	@Around("@annotation(com.galaxy.learn.aop.annotation.MethodMonitorAnnotation)")
	public Object process(ProceedingJoinPoint joinPoint) {
		Object obj = null;
		String className = joinPoint.getTarget().getClass().getSimpleName();
		String methodName = getMethodName(joinPoint);
		long startTime = System.currentTimeMillis();
		try {
			obj = joinPoint.proceed();
		} catch (Throwable t) {
			Loggers.errorLogger.error(t.getMessage(), t);
		} finally {
			long costTime = System.currentTimeMillis() - startTime;
			log.info("class={}, method={}, cost_time={}ms", className, methodName, costTime);
			String key = className + "-" + methodName;
			methodCount.put(key, methodCount.getOrDefault(key, 0) + 1);
			List<Integer> costList = methodCost.getOrDefault(key, new ArrayList<>());
			costList.add((int) costTime);
			methodCost.put(key, costList);
		}
		return obj;
	}

	public String getMethodName(ProceedingJoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();
		return method.getName();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("MethodCount:\n");
		Map<String, Integer> sorted = MapUtils.sortByValue(methodCount);
		sorted.forEach(
				(method, count) -> {
					sb.append("method=" + method + ", " + "count=" + count + '\n');
				}
		);
		sb.append('\n');
		sb.append("MethodCosts:\n");
		methodCost = MapUtils.sortByKey(methodCost);
		methodCost.forEach(
				(method, costList) -> {
					IntSummaryStatistics stat = costList.stream().collect(Collectors.summarizingInt(x -> x));
					String info = String.format("method=%sms, sum=%d, avg=%dms, max=%dms, min=%dms, count=%d", method,
							(int) stat.getSum(), (int) stat.getAverage(), stat.getMax(), stat.getMin(), (int) stat.getCount());
					sb.append(info).append('\n');
				}
		);

		sb.append('\n');
//		sb.append("DetailOfMethodCosts:\n");
//		methodCost.forEach(
//				(method, costList) -> {
//					String info = String.format("method=%s, cost=%s", method, costList);
//					sb.append(info).append('\n');
//				}
//		);
		return sb.toString();
	}
}
