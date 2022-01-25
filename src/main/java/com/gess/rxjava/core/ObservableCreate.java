package com.gess.rxjava.core;

public class ObservableCreate<T> extends Observable<T>{

    final ObservableOnSubscribe<T> source;

    public ObservableCreate(ObservableOnSubscribe<T> source) {
        this.source = source;
    }

    @Override
    protected void subscribeActual(Observer<T> observer) {
        observer.onSubscribe();
        CreateEmitter<T> createEmitter = new CreateEmitter<T>(observer);
        this.source.subscribe(createEmitter);
    }

    static class CreateEmitter<T> implements Emitter<T>{
        Observer<T> observer;
        boolean done;

        public CreateEmitter(Observer<T> observer) {
            this.observer = observer;
        }

        @Override
        public void onNext(T t) {
            if (done) return;
            observer.onNext(t);
        }

        @Override
        public void onError(Throwable throwable) {
            observer.onError(throwable);
        }

        @Override
        public void onComplete() {
            observer.onComplete();
        }
    }
}
