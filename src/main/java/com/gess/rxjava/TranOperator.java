package com.gess.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;

import java.io.Serializable;

/**
 * 转换操作
 */
public class TranOperator {
    public static void main(String[] args) {
        System.out.println("===testCreate===");
        testMap();
//        System.out.println("===testCreate===");
//        testJust();
    }

    private static Observer mObserver = new Observer<Object>() {
        @Override
        public void onSubscribe(@NonNull Disposable d) {
            System.out.println("onSubscribe === " + d);
        }

        @Override
        public void onNext(@NonNull Object o) {
            System.out.println("onNext === " + o);
        }

        @Override
        public void onError(@NonNull Throwable e) {
            System.out.println("onError === " + e);
        }

        @Override
        public void onComplete() {
            System.out.println("onComplete === ");
        }
    };

    public static void testMap() {
        Observable.create(emitter -> {
                    emitter.onNext("1");
                    emitter.onNext(2);
                    emitter.onNext(true);
                    emitter.onError(new Throwable("自定义的错误"));
                    emitter.onComplete();
                })
                .map(o -> {
                    if (o == "1") {
                        return "2";
                    }
                    if (o instanceof Integer){
                        return 9;
                    }
                    if (o instanceof Boolean){
                        return false;
                    }
                    return null;
                })
                .flatMap(new Function<Serializable, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(Serializable serializable) throws Throwable {
                        return Observable.just("3",6,true);
                    }
                })
                .concatMap(new Function<Object, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(Object o) throws Throwable {
                        return Observable.just("5",7,false);
                    }
                })
                .doOnNext(o -> {
                    System.out.println("doOnNext === " + o);
                })
                .doOnError(throwable -> {
                    System.out.println("doOnError === " + throwable);
                })
                .doOnComplete(() -> System.out.println("doOnComplete === "))
//                .subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.io())
                .subscribe(mObserver);
    }

    public static void testJust() {
        Observable.just("1", 2, true).subscribe(mObserver);
        Observable.fromArray("1", 2, true).subscribe(mObserver);
    }
}
