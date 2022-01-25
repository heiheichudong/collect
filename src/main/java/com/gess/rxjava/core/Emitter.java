package com.gess.rxjava.core;


/**
 * 事件发射器
 * @param <T>
 */
public interface Emitter<T> {

    void onNext(T t);

    void onError(Throwable throwable);

    void onComplete();
}
