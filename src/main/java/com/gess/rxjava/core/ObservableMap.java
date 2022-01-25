package com.gess.rxjava.core;

public class ObservableMap<T,U> extends AbstractObservableWithUpStream<T,U>{

    private Function<T,U> function;

    public ObservableMap(ObservableSource<T> source, Function<T, U> function) {
        super(source);
        this.function = function;
    }

    @Override
    protected void subscribeActual(Observer<U> observer) {
        observer.onSubscribe();
        MapObserver mapObserver = new MapObserver(observer,function);
        source.subscribe(mapObserver);
    }

    static class MapObserver<T,U> implements Observer<T> {

        Observer<U> downObserver;

        Function<T,U> function;

        public MapObserver(Observer<U> downObserver, Function<T, U> function) {
            this.downObserver = downObserver;
            this.function = function;
        }

        @Override
        public void onSubscribe() {

        }

        @Override
        public void onNext(T t) {
            U u = function.apply(t);
            this.downObserver.onNext(u);
        }

        @Override
        public void onError(Throwable throwable) {

        }

        @Override
        public void onComplete() {
            this.downObserver.onComplete();
        }
    }
}
