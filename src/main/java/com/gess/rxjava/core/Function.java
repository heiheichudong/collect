package com.gess.rxjava.core;

public interface Function<T, U> {
    U apply(T t);
}
