package br.rogerio.backend.controller;

import java.util.List;
import java.util.Map;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.stream.Collectors;

public class Util {

	public static <R, T> Map<R, T> reduceInto(Map<R, T> reduceInto, Map<R, T> valuesToAdd) {
    reduceInto.putAll(valuesToAdd);
    return reduceInto;
}

public static <K, V> Map<V, List<K>> invertGroupByMap(final Map<K, List<V>> src)
{
    return src.entrySet().stream()
            .flatMap(e -> e.getValue().stream().map(a -> new SimpleImmutableEntry<>(a, e.getKey())))
            .collect(Collectors.groupingBy(Map.Entry::getKey,
                    Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
}
	
}
