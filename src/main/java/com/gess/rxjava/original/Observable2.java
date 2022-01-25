package com.gess.rxjava.original;

import com.gess.rxjava.core.ObservableSource;
import com.gess.rxjava.core.Observer;

public abstract class Observable2<T> implements ObservableSource<T> {

    @Override
    public void subscribe(Observer<T> observer) {
        //和谁建立订阅？
        //怎么建立订阅？
        //为了保持拓展性，交给具体的开发人员去实现。这里提供一个抽象方法
        subscribeActual(observer);
    }

    protected abstract void subscribeActual(Observer<T> observer);

    public static <T> Observable2<T> create(Observer<T> observer){
        return new ObservableCreate2<>(observer);
    }

}
