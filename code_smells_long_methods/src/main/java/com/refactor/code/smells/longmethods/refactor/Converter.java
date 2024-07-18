package com.refactor.code.smells.longmethods.refactor;

import java.util.List;
import java.util.stream.Collectors;

public interface Converter<S, T> {
    T convert(S source);

    default List<T> convert(List<S> source){
        return source.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

}
