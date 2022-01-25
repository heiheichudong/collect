package com.gess.rxjava.core;

/**
 * 观察者
 * @param <T>
 */
public interface Observer<T> {

    void onSubscribe();

    void onNext(T t);

    void onError(Throwable throwable);

    void onComplete();
}
