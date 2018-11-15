package com.sssr.beike.singleton;

/**
 * double check 懒汉式单例
 */
public class LazySingleton {

    private static volatile LazySingleton singleton;

    private LazySingleton() {

    }

    private static LazySingleton getInstance() {
        if (singleton == null) {
            synchronized (LazySingleton.class) {
                if (singleton == null) {
                    singleton = new LazySingleton();
                }
            }
        }

        return singleton;
    }

}
