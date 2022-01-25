package com.gess.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * 创建操作
 */
public class CreateOperator {
    public static void main(String[] args) {
        System.out.println("===testCreate===");
        testCreate();
//        System.out.println("===testCreate===");
//        testJust();testJust
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

    public static void testCreate() {
        Observable.create(emitter -> {
                    emitter.onNext("1");
                    emitter.onNext(2);
                    emitter.onNext(true);
                    emitter.onError(new Throwable("自定义的错误"));
                    emitter.onComplete();
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
