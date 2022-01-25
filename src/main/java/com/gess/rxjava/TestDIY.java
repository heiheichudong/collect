package com.gess.rxjava;

import com.gess.rxjava.core.*;


public class TestDIY {
    public static void main(String[] args) {
        Observable.create(emitter -> {
                    emitter.onNext(111);
                    emitter.onNext(222);
                    emitter.onNext(333);
                    emitter.onComplete();
                })
                .map((Function<Object, Object>) o -> "sss").subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe() {
                        System.out.println("onSubscribe");
                    }

                    @Override
                    public void onNext(Object o) {
                        System.out.println("onNext === " + o);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError === " + throwable);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete === ");
                    }
                });

    }
}
