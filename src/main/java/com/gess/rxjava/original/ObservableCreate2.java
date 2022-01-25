package com.gess.rxjava.original;

import com.gess.rxjava.core.Observer;

public class ObservableCreate2<T> extends Observable2<T> {

    private Observer<T> observer;

    public ObservableCreate2(Observer<T> observer) {
        this.observer = observer;
    }

    @Override
    protected void subscribeActual(Observer<T> observer) {
        observer.onSubscribe();
    }

}
