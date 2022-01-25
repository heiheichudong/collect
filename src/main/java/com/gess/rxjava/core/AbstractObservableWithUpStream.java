package com.gess.rxjava.core;

public abstract class AbstractObservableWithUpStream<T,U> extends Observable<U>{
    protected ObservableSource<T> source;

    public AbstractObservableWithUpStream(ObservableSource<T> source) {
        this.source = source;
    }
}
