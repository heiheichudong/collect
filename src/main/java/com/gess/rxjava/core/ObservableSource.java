package com.gess.rxjava.core;

/**
 * 被观察者
 * @param <T>
 */
public interface ObservableSource<T> {
    void subscribe(Observer<T> observer);
}
