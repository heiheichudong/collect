package com.gess.rxjava.core;

public abstract class Observable<T> implements ObservableSource<T> {

    @Override
    public void subscribe(Observer<T> observer) {
        //和谁建立订阅？
        //怎么建立订阅？
        //为了保持拓展性，交给具体的开发人员去实现。这里提供一个抽象方法
        subscribeActual(observer);
    }

    protected abstract void subscribeActual(Observer<T> observer);

    public static <T> Observable<T> create(ObservableOnSubscribe<T> source){
        return new ObservableCreate<>(source);
    }

    public <U> ObservableMap<T,U> map(Function<T,U> function){
        return new ObservableMap<>(this,function);
    }

    public <U> ObservableFlatMap<T,U> flatMap(Function<T,ObservableSource<U>> function){
        return new ObservableFlatMap<>(this,function);
    }
}
