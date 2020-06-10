package com.galaxy.learn.util.common;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created on 2018/12/26.
 *
 * @author He Xin
 */
@SuppressWarnings("Duplicates")
public class MapUtils {

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		Map<K, V> result;
		try (Stream<Map.Entry<K, V>> st = map.entrySet().stream()) {
			result = st.sorted(Map.Entry.comparingByValue()).
					collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));
		}
		return result;
	}

	public static <K extends Comparable<? super K>, V> Map<K, V> sortByKey(Map<K, V> map) {
		Map<K, V> result;
		try (Stream<Map.Entry<K, V>> st = map.entrySet().stream()) {
			result = st.sorted(Map.Entry.comparingByKey()).
					collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));
		}
		return result;
	}

}
